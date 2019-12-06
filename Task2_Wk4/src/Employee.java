//this is the superclass employee that the other employee types will inherit from
public class Employee {
	
	//create a variable to show if an employee is working
	public boolean isWorking = true;
	
	//create a variable to show the company type
	public String company = "Limited";
	
	//create generic methods that all subclasses will inherit and implement
	public String working() {
		return "working";
	}
	
	public String holiday() {
		return "On holidays";
	}
	
	//create a generic takeBreak() method that the subclasses will inherit and override
	public String takeBreak() {
		//return a generic message that the subclasses will override
		return "The employee takes a break";
	}
	
	//create a generic writing() method that the subclasses will override
	public String writing() {
		//return a generic statement
		return "The employee is writing";
	}

}
