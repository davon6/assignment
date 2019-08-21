package parkingManagementSystem;


public class CourseResults {

	Course theCourse;
	double finalResult=0.0;
	Student theStudent;
	
	public CourseResults(Course _course, Student _student, double _finalResult) {
		this.setCourse(_course);
		this.setResult(_finalResult);
		this.setStudent(_student);
	}

	private void setStudent(Student _student) {
		this.theStudent = _student;
		
	}

	private void setResult(double _finalResult) {
		this.finalResult = _finalResult;
		
	}

	private void setCourse(Course _course) {
		this.theCourse = _course;
		
	}
	
	@Override
	public String toString() {
		if (this.theCourse !=null && this.theStudent!=null)
			return "Course : "+ this.theCourse.getName() + " Student : " + this.theStudent.getName() + " Result : " + this.finalResult;
		return ""; // otherwise return empty string.
	}

}

