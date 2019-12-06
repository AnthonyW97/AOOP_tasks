//this is the bankEmployee subclass. It will inherit from the Employee superclass
public class bankEmployee extends Employee{
	
	//create a method to show the bank employee counting money
	public String countsMoney() {
		//return a message showing the money being counted
		return "I am counting cash!";
	}
	
	//modify the generic takeBreak() method from the Employee class
	public String takeBreak() {
		//return a more relevant message specific to the bank employee
		return "Go to the pub!";
	}
	
	//modify the writing() method from the Employee superclass
	public String writing() {
		return "I am writing cheques";
	}

}
