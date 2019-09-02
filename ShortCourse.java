package parkingManagementSystem;

/**
 * @author David mignot
 * @version 1.0
 * @created 20-Aug-2019 
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