package parkingManagementSystem;

/**
 * @author David mignot
 * @version 1.0
 * @created 29-Aug-2019 
 */
public class Course {

	
	private Student[] studentList;
	private int numStudents;
	private int numDaysRunning;
	private double price;
	private String name;
	private final int MAXDAYS = 10;   // constant - maximum length of course in days
	private final int MAXNOSTUS = 3; // constant - maximum number of students allowed in a course

	public Course(String _name, int _numDaysRunning){
		this.setName(_name);
		this.setNumDaysRunning(_numDaysRunning);
		this.studentList = new Student[MAXNOSTUS];
		this.numStudents=0;
	}

	private void setName(String _name) {
		this.name = _name;
		
	}

	private void setNumDaysRunning(int _numDaysRunning) {
		if (_numDaysRunning < getMaxDays())
			this.numDaysRunning = _numDaysRunning;
		else {
			this.numDaysRunning = getMaxDays();
			System.out.println("Max number of days for course : "+this.numDaysRunning);
		}
		
	}

	public int getMaxDays() {
		// The maximum number of days that a course may run (could override this method in subclasses if desired
		return MAXDAYS;
	}

	public boolean enrolInCourse(Student s){  // add a student to this course
	
		boolean ok = false;
		if (this.getStudentCount() < this.getClassSize()) {
			this.studentList[this.numStudents++] = s; // can only add student to class if it is not full
			ok = true;
		}
		return ok;  // return true if all was fine to add this student, false otherwise (if class is full)
	}

	public int getClassSize() {
		// how many students can fit in class
		return MAXNOSTUS;
	}

	public int getStudentCount() {
		// how many students are already enrolled in class
		return this.numStudents;
	}
	
	public String getName() {  // get the name of the course
		return this.name;
	}
	
	public int getNumDaysRunning() {  // get the length of the course
		return this.numDaysRunning;
	}
	
	public String getAllStudents () {  // get a list (Names only) of all students enrolled as a String 
		String result="Student List for Course " + this.getName() +"\n";
		Student s=null;
		for (int i =0; i< this.getStudentCount(); i++) {
				s = this.studentList[i];
				result = result + s.getName();
			}
		result = result + "\n";
		return result;
	}
	
	public Student[] getAllStudentLists() {  // produce a copy of the array of students in the class list
		Student[] copyStudentList = new Student[MAXNOSTUS];
		for (int i=0; i < this.getStudentCount(); i++)  
			copyStudentList[i] = this.studentList[i];
		return copyStudentList;
	}
	
	@Override
	public String toString() {
		return "Course " + this.getName() + " Class size : " + this.getClassSize() + " Num days " + this.getNumDaysRunning() + " No. students enrolled " + this.getStudentCount() + "\n" + this.getAllStudents();
	}

	
		
}//end Course