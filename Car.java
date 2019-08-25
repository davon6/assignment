package parkingManagementSystem;

/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:05 PM
 */
public class Car extends Vehicle {

	private static final double INITREGFEE = 0.0;
	// add attribute to store this Car's unique vehicle on-road registration ID
	
	private static String[] restrictedVehicleList = {"Truck", "Van"}; // update list of restricted vehicles
	
	public Car(String _model, int _age){
		super(_model, _age);
	}

	
	public double getFee(){
		return Car.INITREGFEE;
	}
	
	private void assignRegistrationID(){ // assign a unique ID for each Car
		String numString ="";
		int num = this.nextRegistrationID++;  // get next available car registration id
		//create the student ID with the 2019 and if necessary a leading 0, need to convert num to a string object
		if (num < 10) 
			numString = "000" + String.valueOf(num);  // add 000 if id is 0..9
		else if (num < 100)
			numString = "00" + String.valueOf(num);   // add 00 if id is 10..99
		else if (num < 1000)
			numString = "0" + String.valueOf(num);    // add 0 if id is 100..999
		else 
			numString = String.valueOf(num); 
		super.assignRegistrationID("CAR" + numString);

	}

	
	
	@Override 
	public boolean isValid() {// check if the car is valid for registration - must not be in restrictedVehicleList
		//loop through the restrictedVehicleList and if find this car model, then return false, otherwise return true
		return true;
	}


	
	
	public String toString() {
		return "Car ";
	}
	
}//end Car