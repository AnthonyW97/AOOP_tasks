/* *************************
 * Author: 1716208         /*
 * Task: 1				   /*
 * Description: create an  /*
 * employee superclass with /*
 * several subclasses      /*
 * Date: 15/10/2019        /* 
 * ************************/


//this is the abstract superclass employee that will be the generic archetype for the subclasses
public abstract class Employee {
	
	//create variables for isWorking and company type
	public boolean isWorking = true;
	public String company = "Limited";
	
	//create a working method to show if an employee is working
	public void working() {
		//print to the screen that the employee is working
		System.out.println("Working");
	}
	
	//create a method that shows if an employee is currently on holiday
	public void holiday() {
		//print to screen that the employee is on holiday
		System.out.println("On holidays");
	}
	
	//create a generic writing() method for subclasses to implement
	public abstract String writing();
	
	//create a generic takeBreak() method
	public String takeBreak() {
		//print a generic break message to the screen
		String empBreak = "The employee takes a break";
		return empBreak;
	}

}
