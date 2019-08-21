package parkingManagementSystem;

/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:46 PM
 */
public class Student  {

	private String name;  // name of person
	private String address; // address of person
	private String postcode; // postcode of person's address
	private String studentID; // unique student ID
	private Course courseEnrolledIn; // course this student is enrolled in
	private Vehicle myVehicle;  // vehicle owned by this student
	private static int nextstudentNum = 0;  // static variable on class that will be used to generate unique student number for each student instance 
	
	/**
	 * 
	 * @param _name
	 * @param _address
	 * @param _postcode
	 * @param _courseEnrolledIn
	 * @param _phoneNo
	 * @param _myRatePayer
	 */	
	public Student(String _name, String _address, String _postcode, Course _courseEnrolledIn, Vehicle _myVehicle ){
		this.setName(_name);
		this.setAddress(_address);
		this.setPostcode(_postcode);
		this.enrolInCourse(_courseEnrolledIn);
		this.myVehicle = _myVehicle;
		this.setStudentID();
	}

	


	/**
	 * 
	 * @param _name
	 * @param _address
	 * @param _postcode
	 * @param _phoneNo
	 * @param _myRatePayer
	 * @param _myVehicle
	 */
	public Student(String _name, String _address, String _postcode, String _phoneNo, Vehicle _myVehicle){
		this.setName(_name);
		this.setAddress(_address);
		this.setPostcode(_postcode);
		this.courseEnrolledIn = null;
		this.myVehicle = _myVehicle;
		this.setStudentID();

	}
	
	/**
	 * 
	 * @param _name
	 * @param _address
	 * @param _postcode
	 * @param _phoneNo
	 * @param _myRatePayer
	 */
	public Student(String _name, String _address, String _postcode, String _phoneNo){
		this.setName(_name);
		this.setAddress(_address);
		this.setPostcode(_postcode);
		this.courseEnrolledIn = null;
		this.myVehicle = null;
		this.setStudentID();
	}
	

	private void setStudentID() {  // generate next valid unique student ID based on format 2018nn where nn is 0 for first student and increments for subsequent students
		// get next student number available, num for unique ID
		
		//create the student ID with the 2019 and if necessary a leading 0, need to convert num to a string object numString
		
		this.studentID = ""; // "2019" + numString;
		
	}



	private void setPostcode(String _postcode) {
		// save _postcode to the postcode attribute on this Student
		this.postcode = _postcode;
	}


	private void setAddress(String _address) {
		// save _address to the address attribute on this Student
		this.address = _address;
	}


	private void setName(String _name) {
		// save _name to the name attribute on this Student
		this.name = _name;
	}

	public String getName() {
		// get the name of this student
		return this.name;
	}
	
	public void enrolInCourse(Course _aCourse){
		// enrol this student in the given course: _aCourse
		// tell the course object to add this student to the student list
		// if all was fine with enrolment in the course,
		// save the course object in this student's courseEnrolledIn attribute

	}

	public String generateCourseInvoice(){
		return "";
	}

	
	private boolean hasRegisteredVehicle() {
		return (this.myVehicle!=null);
	}
	
	boolean registerVehicle(Vehicle _vehicle) {
		if (_vehicle.isValid()) { // validate if this vehicle is permitted to be registered
			this.myVehicle = _vehicle;
			return true;
			}
		else return false;
	
	}



	public String generateRegistrationInvoice() {
		// TODO complete this method - calculate the fees and create an invoice as a string
		return " Invoice for parking registration : \n currently empty ";
	}

	public String toString() {
		String details = "Student " + this.name + " of " + this.address + ", " + this.postcode;
		if (this.courseEnrolledIn != null) 
			details = details + " is enrolled in " + this.courseEnrolledIn.getName();
		if (this.hasRegisteredVehicle()) 
			details = details + " has registered the following vehicle for parking " + this.myVehicle.toString();
		return details;
	}


	
	
	
}//end Student