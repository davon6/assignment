/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Apr-2018  
 */
package parkingManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kkeogh
 *
 */
public class MenuDriverClass {
	Scanner console;
	boolean stillRunning;
	Student s1, s2, s3; // for prototype version 1, hardcode 3 students who are created by option 1 and not yet enrolled
	College myCollege = new College();
	
	public MenuDriverClass() {

		this.console = new Scanner(System.in);
		stillRunning = true;		// in order to commence program
		
	}

	// PURPOSE: To start the menu running its pseudo-infinite loop of showing the menu, getting user's chosen option 
		//          and dealing with the chosen option's task. 
		public void start()
		{
			int choice;
				
			
			while (stillRunning)
			{
				showMainMenu();
				choice = getUserSelection(0,13);
				if (choice == 0) stillRunning = false;
				processChoiceMainMenu(choice);
			}
			
		}
		
		// METHOD:  showMainMenu
		// PURPOSE: To present a menu/list of options to the user.
		// PASSED:  nothing
		// RETURNS: nothing
		// EFFECTS: A list of options is displayed on the screen.
		/**
		 * College would like a simple prototype information system designed, with a text based menu that
			provides a number of options as follows:
			1. Add a new student
			2. Register a vehicle to a student
			3. Create a new course offering
			4. Enrol a student in a course
			5. List details of a particular available course
			6. Calculate registration parking renewal notice for a particular student who has previously
			registered a vehicle
			7. Run system tests
		 */
		public void showMainMenu()
		{
			System.out.println();		// ensure a break between previous output and the menu
			System.out.println("What would you like to do?");
			System.out.println("1.  Add a new student");
			System.out.println("2.  Register a vehicle to a student");
			System.out.println("3.  Create a new course offering");
			System.out.println("4.  Enrol a student in a course");
			System.out.println("5.  List details of a particular available course");
			System.out.println("6.  Calculate registration renewal notice for a particular student who has previously\r\n" + 
					"			registered a vehicle");
			System.out.println("7.  Run system tests");
			System.out.println("0.  Exit Program");
		}

		// METHOD:  processChoiceMainMenu
		// PURPOSE: To dispatch control to a relevant method which handles the user's selected choice.
		// PASSED:
		//     choice - the code of the menu option selected by the user.
		// RETURNS: nothing
		// EFFECT:  Some action will be performed based on the user's choice. An invalid choice
		//     will result in an error message being displayed to the screen.
		// NOTE: This method will invoke a range of other methods to actually achieve the user's choice.
		public void processChoiceMainMenu(int choice)
		{
			String givenFileName;		
			switch (choice)
			{
				case 1:
				 ArrayList<parkingManagementSystem.Student> arry1 = new ArrayList<>();
				Student newS = createANewStudent(arry1); // menu option 1 create a new student
					
					// save this student in one of s1, s2 or s3 test student objects in this class
					if (s1==null) s1 = newS;
					else if (s2==null) s2 = newS;
					else s3 = newS;  // if this is used more than 3 times, it will always save the new student to s3.
					break;
				case 2:
					registerVehicleToStudent(); // menu option 2 register vehicle to a student
					break;
				case 3:
					Course c = createNewCourse(); // menu option 3 create a new course
					saveCourse(c);
					break;
				case 4:
					enrolANewStudentInACourse(); 
					// menu option 4 enrol a student in a course
					// this will allow user to add one of the 3 test student objects to an existing course
					
					break;
				case 5:
					String courseString = getDetailsOfACourse(); // menu option 3 list details of a course
					System.out.println(courseString);
					break;
				case 6:
					createRegistrationInvoices();// menu option 3 calculate and display registration invoice
					break;
				case 7:
					runRegressionTests(); // menu option 3 run system tests
					break;
				
				case 0:
					this.stillRunning = false;				// causes the main loop of program to end (i.e. quits)
					break;
				default:
					System.out.println("Unexpected selection made. Doing nothing.");
					break;
			}
		}


			
		private void registerVehicleToStudent() {
			// register a Vehicle to a particular Student who is enrolled in a course at the college
			// ask user for vehicle details and create new vehicle object
			Vehicle a = this.createANewVehicle();
			// ask which student to register this vehicle to
			if (this.myCollege.getCourseCount() ==0)
				System.out.println("No Courses set up yet. Students must enrol first");
			else {
				this.myCollege.showAllStudents();
				String studentName = this.getAMultiwordString("Enter student's name : ");
				if (studentName.contains("\n")) System.out.println("something went wrong ");
				Student s = this.findStudent(studentName);
				// then add the vehicle to associate with that student
				if (s!=null)    { // check we have a valid non null student object
					s.registerVehicle(a);  // if the vehicle is valid and permitted for parking, associate this vehicle with the student
					System.out.println("Student " + s.toString());
				}
			}
		}

		private Vehicle createANewTestVehicle() {  // could be used for testing, eventually put this in unit tests
			Vehicle v = new Car("Baojun 560", 3, "AQB350"); // hardcode a test vehicle
			return v;
		}

		private void saveCourse(Course c) {
			if (c!=null) 
				myCollege.saveCourse(c);
			
		}

		private void enrolANewStudentInACourse() {
			// initially for first prototype, presume that there are 3 test student objects s1,s2,s3.
			// in next version for assignment 2, we will have an array or arrayList of students
			Student astudent=null;
			// select from existing students. Get details of a student 
			int ans = this.getANumber("Enter 1 to use an existing student, Enter 2 to create a new student");
			if (ans == 2) // create a new student 
				astudent = this.createANewStudent(null);
			else { 
			    if (s1!=null) System.out.println("student s1: " + s1.toString());
			    if (s2!=null) System.out.println("student s2: " + s2.toString());
			    if (s3!=null) System.out.println("student s3: " + s3.toString());
				int ans2 = this.getANumber("Enter 1, 2 or 3 for existing students. One of s1, s2, or s3 ");
				switch (ans2) {
					case 1 : astudent = s1;
							 break;
					case 2 : astudent = s2;
							 break;
					case 3 : astudent = s3;
							 break;
				}
			}
			// enrol the student into a course
			if (astudent!=null) 
				enrolAStudentInACourse(astudent);
			
		}

		private String createRegistrationInvoices() {
			String invoices="";
			// for all the known students, generate payment registration invoices
			if (s1!=null) {
				invoices += s1.generateRegistrationInvoice();
			}
			if (s2!=null) {
				invoices += s2.generateRegistrationInvoice();
			}
			if (s3!=null) {
				invoices += s3.generateRegistrationInvoice();
			}
			
			
			return invoices;
		}

		private void runRegressionTests() {
			// TODO create an object of Test type in order to run all Junit tests
			// update this to run a number of tests
			CourseTest myTestObject = new CourseTest();
			myTestObject.testCourse();
			
		}

		private void listAllCourses() {
			Course[] c;
			if (this.myCollege.getCourseCount() >0) {
				c = this.myCollege.getAllCourses();
				for (int index=0; index < this.myCollege.getCourseCount(); index ++)
					System.out.println(c[index].toString());
				}
			else 
				System.out.println("No Courses offered in college at the moment");
		}
		
		private String getDetailsOfACourse() {
			if (this.myCollege.getCourseCount() >0) {
				listAllCourses();
				// then ask user which course they want details about
				String cname = this.getAMultiwordString("Enter name of course: ");
				// then output to console all known details about that course
				Course c = this.findACourse(cname);
				if (c!=null) 
					return c.toString();
				else 
					return " Course "+ cname + " not found";
			}
			else return " " ;
			
		}

		private Student createANewStudent(ArrayList<Student> arry) {
			// create a new student
			Student s;
			String sname, saddress, spostcode, sphoneNo;
						
			sname = this.getAMultiwordString("Please enter Student Name: ");
			saddress = this.getAMultiwordString("Please enter Student Address: <nn street suburb>");
			spostcode = this.getAString("Please enter Student postcode: ");
			sphoneNo = this.getAString("Please enter student phone number (no spaces) : ");
						
			s = new Student(sname, saddress, spostcode, sphoneNo);
			arry.add(s);
			//debug messsage
			System.out.println("just created student " + s.toString());
			return s;
		}
		
	
			
		
		private Student findStudent(String studentName) {
			
			Student[][] allStudentsList = myCollege.getAllStudentsLists(); // get list of all students in each course in 2D array
			for (int courseNumber=0; courseNumber < this.myCollege.getCourseCount(); courseNumber++)  // for each course
				for (Student s: allStudentsList[courseNumber]) {  //  in that course, for each student
					if (s!=null && s.getName().equalsIgnoreCase(studentName))  // is this the student we are looking for?
						return s;
				}
			// if get to here, we didn't find the student
			System.out.println("Failed to find student " + studentName);
			return null;
			
		}

		private void enrolAStudentInACourse(Student _aStudent) {
			// given the student _aStudent
			// then enrol that student in a known course
			if (myCollege.getCourseCount() >0)  {
				String cname = this.getAMultiwordString("Please enter Course Name: ");
				Course aCourse = findACourse(cname);
				if (aCourse!=null && _aStudent!=null) _aStudent.enrolInCourse(aCourse);
			}
			else {  // force user to create a course first to enrol this student into
				Course c = createNewCourse();
				saveCourse(c);
				if (c!=null && _aStudent!=null) _aStudent.enrolInCourse(c);
			}
			
		}

		private Course findACourse(String cname) {
			if (myCollege.getCourseCount() >0)  {
			// find the course that matches cname
			for (Course c: myCollege.getAllCourses())
				if (c!=null && c.getName().equalsIgnoreCase(cname))  // found a match
					return c;
			}
			// if not found or course count is 0, return null
			return null;
		}

		private Course createNewCourse() {
			// create a new course offering - must be either shortCourse or EveningCourse
			String cname, ans;
			boolean ashortCourse;
			Course cnew;
			int clength;
			ShortCourse cnewShortCourse;
			EveningCourse cnewEveningCourse;
			
			
			cname = this.getAMultiwordString("Please enter Course Name : ");
			clength = Integer.valueOf(this.getAString("Please enter Course Length (number of days) : "));
			ans = this.getAString("Short Course (s) or Evening Course (e)? : ");
			if (ans.equalsIgnoreCase("s"))
				ashortCourse = true;
			else
				ashortCourse = false;
			
			if (ashortCourse) {
				cnewShortCourse = new ShortCourse(cname, clength);
				cnew = cnewShortCourse;
			}
			else  {// must be evening Course
				double budgetStaff =  Double.valueOf(this.getAString("Please enter budget for Staffing: "));
				double budgetRefreshments =  Double.valueOf(this.getAString("Please enter budget for Refreshments: "));
				cnewEveningCourse = new EveningCourse(cname, clength, budgetRefreshments, budgetStaff);
				cnew = cnewEveningCourse;
			}
		
			return cnew;
		}

	

		private boolean getABoolean(String _prompt) {
			String ans = this.getAString(_prompt);
			if ((ans.contains("Y")) || (ans.contains("y")))
					return true;
			else
					return false;
		}
		
		private Vehicle createANewVehicle() {  // TODO update so that can create Motorbike and Bicycle vehicles also
			// create a new vehicle 
			// in first version, only create cars
			Vehicle v=null;
			String aname, model, roadRegistrationID;
			int age;
			String vehicleType = this.getAMultiwordString("What type of vehicle is this? (Car, Bicycle or Motorbike): ");
			model = this.getAMultiwordString("What model is this "+ vehicleType);
			aname = this.getAString("Enter "+ vehicleType + " name : ");
			age = this.getANumber("Enter age of " + aname + " : ");
			roadRegistrationID = this.getAString("Enter road authority registration ID ");
			if (vehicleType.equalsIgnoreCase("Car")) {
				Car c = new Car(model, age, roadRegistrationID);
				v=c;
				}
			else 
				System.out.println("Only possible to create Cars in this release.");
			
			return v;
		}

		
		// METHOD:  getUserSelection
		// PURPOSE: To obtain from the user a selection (an integer) from a range of values
		// PASSED:
		//    lower - the Lowest permissible value the user can enter as their selection.
		//    upper - the Highest permissible value the user can enter
		// RETURNS:
		//    The value entered by the user, unless the "lower" parameter was higher
		//    than the "upper" parameter, in which case 0 is returned.
		// EFFECTS:
		//    A prompt is displayed on the screen to ask the user for a value in the range.
		//    Input is sought from the user via the keyboard (System.in)

		public int getUserSelection(int lower, int upper)
		{
			int userInput;
			
			if (lower > upper)
				return 0;
			
			do {
				System.out.print("Enter a number ("+lower + "-" + upper+"):");
				userInput = console.nextInt();		// obtain the input
				console.nextLine();					// gets rid of the newline after the number we just read
				
				if (userInput < lower || userInput > upper)
					System.out.println("Invalid choice.");
			} while (userInput < lower || userInput > upper);
			System.out.println();		// put a space before the next output
			
			return userInput; 
		}
	
		
	/**
	 * get a string input from the user
	 */
	public String getAString(String _prompt) {
		System.out.println(_prompt);
		String reply = this.console.next();
		if (this.console.hasNextLine()) this.console.nextLine(); //absorb an eoln
		return reply;
	}
	
	public String getAMultiwordString(String _prompt) {
		System.out.println(_prompt);
		String ans = this.console.nextLine();
		return ans;
	}
	
	public int getANumber(String _prompt) {
		System.out.print(_prompt);
		int userInput = console.nextInt();		// obtain the input
		console.nextLine();					// gets rid of the newline after the number we just read
		return userInput;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MenuDriverClass m = new MenuDriverClass();
		m.start();
	}

}