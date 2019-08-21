package parkingManagementSystem;



/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:33 PM
 */
public class Motorbike extends Vehicle {

	private static final double INITREGFEE = 175.0;

	public Motorbike(String _model, int _age){
		super(_model, _age);
	}

	public double getFee(){
		return Motorbike.INITREGFEE;
	}
	
	private void assignRegistrationID(){

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