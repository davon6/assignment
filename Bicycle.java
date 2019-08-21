package parkingManagementSystem;

/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:01 PM
 */
public class Bicycle extends Vehicle {

	private static final double INITREGFEE = 50.0;
	private String engravedID; // user may optionally provide an individual ID that they have engraved on their bicycle
	private static int nextRegistrationID = 0;
	private boolean motorised = false;

	
	public Bicycle(int _age){
		super("Bicycle", _age); // presume bicycle has no model name, just use "Bicycle" as model name
		this.engravedID = " ";
		this.motorised = false;
	}

	public Bicycle(int _age, String _engravedID){
		super("Bicycle", _age);
		this.engravedID = _engravedID;
		this.motorised = false;
	}
	
	public Bicycle(int _age, String _engravedID, boolean _motorised){
		super("Bicycle", _age);
		this.engravedID = _engravedID;
		this.motorised = _motorised;
	}
	

	
	private void assignRegistrationID(){
		// calculate a unique registration ID  for each bicycle
		String numString ="";
		int num = Bicycle.nextRegistrationID++;  // get next available bicycle registration id
		//create the student ID with the 2019 and if necessary a leading 0, need to convert num to a string object
		if (num < 10) 
			numString = "000" + String.valueOf(num);  // add leading 000 if bicycle registration id is 0..9
		else if (num < 100)
			numString = "00" + String.valueOf(num);   // add leading 00 if bicycle registration id is 10..99
		else if (num < 1000)
			numString = "0" + String.valueOf(num);    // add leading 0 if bicycle registration id is 100..999
		else 
			numString = String.valueOf(num); 
		super.assignRegistrationID("BK" + numString);
	}
	
	@Override
	protected void checkIsValid() { // override this from the Vehicle class so that for bicycles - no need to have age < 5 years 
		super.setValid(true);
	}

	public double getFee(){
		double fee;
		fee = Bicycle.INITREGFEE;
		if (this.isMotorised() )  // add surcharge if bicycle is motorised
			; // add code to update fee to add surcharge
		return fee;
	}
	
	


	private boolean isMotorised() {
		// TODO finish this method - will bicycle ever be motorised?
		return false;  // look up motorised status on this object and return it
	}

	@Override
	public boolean isValid() {
		// TODO complete the code here
		boolean result = false;
		return result;
	}
}//end Bicycle