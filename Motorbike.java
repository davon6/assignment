package parkingManagementSystem;



/**
 * @author David mignot
 * @version 1.0
 * @created 20-Aug-2019 
 */
public class Motorbike extends Vehicle {

	private static final double INITREGFEE = 175.0;
	private static int nextRegistrationID=0;

	public Motorbike(String _model, int _age){
		super(_model, _age);
	}

	public double getFee(){
		return Motorbike.INITREGFEE;
	}
	
	private void assignRegistrationID(){

		String numString ="";
		int num = this.nextRegistrationID++;  // get next available motorbike registration id
		//create the student ID with the 2019 and if necessary a leading 0, need to convert num to a string object
		if (num < 10) 
			numString = "000" + String.valueOf(num);  // add 000 if Motorbike id is 0..9
		else if (num < 100)
			numString = "00" + String.valueOf(num);   // add 00 if Motorbike id is 10..99
		else if (num < 1000)
			numString = "0" + String.valueOf(num);    // add 0 if Motorbike id is 100..999
		else 
			numString = String.valueOf(num); 
		super.assignRegistrationID("MB" + numString);
	}

	public double calcRegistrationFee(){
		return 0;
	}

	@Override
	public boolean isValid() {
		// TODO complete the code here
		boolean result = false;
		return result;
	}
}//end Motorbike