package parkingManagementSystem;

/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:05 PM
 */
public class Car extends Vehicle {

	private static final double INITREGFEE = 250.0;
	private static int nextRegistrationID = 0;
	private String roadRego;
	
	private static String[] restrictedVehicleList = {"Truck", "Van"};
	
	public Car(String _model, int _age, String _roadRego){
		super(_model, _age);
		this.roadRego = _roadRego;
	}

	
	public double getFee(){
		return Car.INITREGFEE;
	}
	
	private void assignRegistrationID(){
		String numString ="";
		int num = this.nextRegistrationID++;  // get next available car registration id
		//create the student ID with the 2018 and if necessary a leading 0, need to convert num to a string object
		if (num < 10) 
			numString = "000" + String.valueOf(num);  // add leading 000 if car registration id is 0..9
		else if (num < 100)
			numString = "00" + String.valueOf(num);   // add leading 00 if car registration id is 10..99
		else if (num < 1000)
			numString = "0" + String.valueOf(num);    // add leading 0 if car registration id is 100..999
		else 
			numString = String.valueOf(num); 
		super.assignRegistrationID("CAR" + numString);
	}

	
	
	@Override 
	public boolean isValid() {
		String m;
		for (int i=0; i < restrictedVehicleList.length; i++)  {
				m=restrictedVehicleList[i];   // if the car model is the same as any of the models in the restricted vehicle list it is not valid to register
				if (this.getModel().equalsIgnoreCase(m))
					return false;
			}
		return true;
	}


	
	
	public String toString() {
		return "Car ";
	}
	
}//end Car