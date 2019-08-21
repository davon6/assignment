package parkingManagementSystem;

/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:42 PM
 */
public class ShortCourse extends Course {

	public ShortCourse(String _name, int _numDaysRunning){
		super(_name, _numDaysRunning);
	}

	@Override
	public String toString() {
		return ("Short " + super.toString());
	}
}//end ShortCourse