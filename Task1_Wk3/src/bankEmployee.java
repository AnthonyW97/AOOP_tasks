/* *************************
 * Author: 1716208         /*
 * Task: 1				   /*
 * Description: create an  /*
 * employee superclass with /*
 * several subclasses      /*
 * Date: 15/10/2019        /* 
 * ************************/

//this is the bankEmployee subclass it inherits from the Employee class
public class bankEmployee extends Employee{
	
	//this class has a method for counting money
	public void countsMoney() {
		//print a message to the screen showing the employee counting cash
		System.out.println("I am counting cash!");
	}
	
	//create a method to implement the abstract method from Employee superclass
	public String writing() {
		//the bank employee writes a cheque 
		String write = "Writing a check";
		return write;
	}
	
	//create a method to override the takeBreak() method in the Employee class
	public String takeBreak() {
		//the bank employee goes to the pub on their break
		String empBreak = "Go to pub!";
		return empBreak;
	}
	
}
