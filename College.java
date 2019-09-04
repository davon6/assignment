package parkingManagementSystem;

/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:20 PM
 */
public class College {

	private static final int MAXNOCOURSES = 10; // constant: maximum number of courses available at the College
	static final int MAXSTUDENTS = 20;  // constant: maximum number of students in each course
	private String name;
	private Course[] listOfCourses = new Course[MAXNOCOURSES];  // create memory for an array of courses
	private int courseCount=0;
	
	public College(){

	}

	/**
	 * 
	 * @param aCourse
	 * Add a new course to the list of courses on offer at the college
	 */
	private void addACourse(Course aCourse){
		if (aCourse!=null && courseCount<MAXNOCOURSES) {  // only add a course if you have one and it will fit in list
			listOfCourses[courseCount++] = aCourse;
		}
	}
		

	public void saveCourse(Course c) {
		addACourse(c);
		
	}
	
	public String showAllStudents() {
		String result =" ";
		if (this.courseCount >0)
			for (Course c : listOfCourses) {
				if (c!=null)
					result += c.getAllStudents();
		}
		return result;
	}

	public Student[][] getAllStudentsLists() {
		// return an array of student lists including all the students for each courses in the college, 
		Student[][] allStudents  = new Student[College.MAXNOCOURSES][College.MAXSTUDENTS];
		int index=0;
		
		for (Course c : listOfCourses) {
			if (c!=null) allStudents[index++] = c.getAllStudentLists();
		}
			
		return allStudents;
	}
	
	public Course[] getAllCourses() {
		// return a collection containing all the courses offered by College
		Course[] myList = new Course[College.MAXNOCOURSES];
		int index = 0;
		for (Course c : listOfCourses) // build an array with details of each Course 
			myList[index++] = c;
		return myList;
	}
	
	
	public int getCourseCount() {
		return this.courseCount;
	}

	
	public String toString () {
		String allCoursesString = "";
		for (Course c : listOfCourses) // build a string with details of each Course in the array of courses
			allCoursesString += c.toString() + "\n";
		return ("College offers the following courses : \n" + allCoursesString);
	}

	}//end College