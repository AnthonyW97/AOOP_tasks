//this is the hospitalEmployee subclass. it will inherit from the Employee superclass
public class hospitalEmployee extends Employee{
	
	//create a method to show the hospital employee working
	public String nursing() {
		//return a message to show the nurse nursing
		return "I nurse patients!";
	}
	
	//modify the takeBreak() method from the Employee superclass
	public String takeBreak() {
		//return a more relevant message tailored for the hospital employee
		return "Go to the hospital's canteen!";
	}
	
	//modify the writing() method from the Employee superclass
	public String writing() {
		return "I am writing prescriptions";
	}

}
