package parkingManagementSystem;

public abstract class Vehicle {

	private String model;  // e.g. 
	private int age;
	private String registrationID;
	private double fee;
	private boolean valid;
	private static final double PERCENTDISCOUNTPERYEAR = 0.01;
	
	public Vehicle(String _model, int _age) {
		
		this.setModel(_model); // save model for the vehicle
		this.setAge(_age); // save age of the vehicle 
		this.checkIsValid();
		
	}

	/*
	 * Validate if this vehicle is permitted to be registered for parking on campus
	 */
	public abstract boolean isValid() ; // override this in each particular vehicle type class
	
	/*
	 * get the default fee for parking registration for this vehicle
	 */
	protected abstract double getFee(); // override this in each particular vehicle type class
	
	private void setModel(String _model) {
		this.model = _model;
	}
	
	protected void checkIsValid() {  // valid vehicles must in most cases be younger than 5 years old and not be on restricted vehicle list (car)
		if (this.isValid() && age < 5)
			setValid(true);
		else
			setValid(false);
			
	}
	
	protected void setValid (boolean myswitch) { // this might be overridden in sub classes for some types of vehicle
		valid = myswitch;
	}
	
	private void setAge(int _age) {
		this.age = _age;
		if (this.age >5) // a car over 5 years in age is not allowed to be registered for parking
			valid = false;
	}

	public double calcRegistrationFee(int yearNo){  // the public interface to allow other objects to calculate the registration fee (including any discounts)
		/* The college will apply a discount of 1% for each year of registration. The discount accumulates and is applied to last year's fee.
		 * So, if a vehicle has been registered for 3 years in 2018, the fee is calculated with a discount of 3% of the fee for 2017.
		 *      the fee is 2017 is calculated as a discount of 2% on the fee for 2016 and the fee is 2016 is calculated as 1% discount on the fee in 2015 (init fee)
		 * If first year of registration :
		    fee = INITFEE
		   else : 
		    initialise last year's fee = INITFEE
		    repeat this Loop for each year since first registration :  
		            percentageDiscount = 0.01  (one percent) * number of years registered  (so this increases each year)
		            calculate discount as:  last year's fee * percentageDiscount
		            calculate fee as:  last year's fee less discount
		            update last year's fee to equal fee ready for next iteration through loop
		 */		
		//return getFee();
		double regoFeeCurrentYear=0.0, lastYearsFee=0.0, discount;
		double percentageDiscount = 0.01;
if (yearNo ==0) // currentYear is first registration 
regoFeeCurrentYear = getFee();
else {
lastYearsFee = getFee(); // first time through, the previous year's fee is the default fee
for (int i=0;i<=yearNo;i++) {  // loop for the number of years registration has been held
	percentageDiscount = PERCENTDISCOUNTPERYEAR * i;  // each year, the percentage increases by another 0.01 
	discount = lastYearsFee * percentageDiscount;  // calculate this year's discount  
	regoFeeCurrentYear = lastYearsFee - discount;  // apply discount to get this year's fee
	lastYearsFee = regoFeeCurrentYear; // save this for next time through loop
   
}
}
return regoFeeCurrentYear;

	}
	
	public String getModel() {
		// get the model of this vehicle
		return this.model;
	}
	
	public int getAge() {
		return this.age;
	}

	protected void assignRegistrationID(String _regoString) {
		this.registrationID = _regoString;
	}
	
}
