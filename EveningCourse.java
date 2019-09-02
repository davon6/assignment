package parkingManagementSystem;


/**
 * @author David mignot
 * @version 1.0
 * @created 19-Aug-2019 
 */
public class EveningCourse extends Course {

	private static final int MAXDAYS = 8; // Evening courses may run over 8 evenings
	private double budgetForRefreshments, budgetForCasualStaff;
	
	public EveningCourse(String _name, int _numDaysRunning, double _budgetForRefreshments, double _budgetForCasualStaff) {
		super(_name, _numDaysRunning);
		setBudgetForRefreshments(_budgetForRefreshments);
		setBudgetForCasualStaff(_budgetForCasualStaff);
	}

	private void setBudgetForCasualStaff(double _budgetForCasualStaff) {
		this.budgetForCasualStaff = _budgetForCasualStaff;
		
	}

	private void setBudgetForRefreshments(double _budgetForRefreshments) {
		this.budgetForRefreshments = _budgetForRefreshments;
		
	}

	private Double getBudgetForCasualStaff() {
		return this.budgetForCasualStaff;
	}

	private Double getBudgetForRefreshments() {
		return this.budgetForRefreshments;
	}
	
	@Override 
	public int getMaxDays() {
		// The maximum number of days that an evening course may run 
		return MAXDAYS;
	}
	
	@Override
	public String toString() {
		String result = "Evening Course : " + super.toString();
		result += "Budget for refreshments $" + this.getBudgetForRefreshments() + " Budget for Casual Staff $" + this.getBudgetForCasualStaff() + "\n";
		return result;
	}

	
}
