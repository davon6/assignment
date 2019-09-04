package parkingManagementSystem;

/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:01 PM
 */
public class Bicycle extends Vehicle {

	private static final double INITREGFEE = 0.0;
	private String engravedID; // user may optionally provide an individual ID that they have engraved on their bicycle
	private boolean motorised = false;
	private static int nextRegistrationID = 0;

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
		// calculate a unique registration ID  

	}
	
	@Override
	protected void checkIsValid() { // override this for bicycles - no need to have age < 5 years 
		super.setValid(true);
	}

	public double getFee(){
		return Bicycle.INITREGFEE;
	}
	
	


	@Override
	public boolean isValid() {
		// TODO copmlete the code here
		boolean result = false;
		return result;
	}
}//end Bicycle