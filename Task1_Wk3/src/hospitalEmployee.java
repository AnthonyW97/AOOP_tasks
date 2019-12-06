/* *************************
 * Author: 1716208         /*
 * Task: 1				   /*
 * Description: create an  /*
 * employee superclass with /*
 * several subclasses      /*
 * Date: 15/10/2019        /* 
 * ************************/

//this is the hospitalEmployee subclass that inherits from the Employee superclass
public class hospitalEmployee extends Employee{
	
	//create a method to show the hospital employee nursing
	public void nursing() {
		//print a message to the screen showing the nurse nursing
		System.out.println("I nurse patients!");
	}
	
	//create a method to implement the abstract method from Employee superclass
	public String writing() {
		//the hospital employee is writing a prescription
		String write = "Writing a prescription";
		return write;
	}
	
	//create a class to override the takeBreak() method in Employee class
	public String takeBreak() {
		//the hospital employee goes to the canteen on their break
		String empBreak = "Go to hospital's canteen!";
		return empBreak;
	}

}

