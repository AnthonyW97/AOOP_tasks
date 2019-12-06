//this is the university employee class subclass. it will also inherit from the 
//Employee superclass
public class universityEmployee extends Employee{
	
	//create a method to show the university employee teaching 
	public String teachStudents() {
		//return a message to show the uni employee teaching
		return "I am teaching";
	}
	
	//modify and override the generic takeBreak() method from the Employee superclass
	public String takeBreak() {
		//return a more relevant message than the default message
		return "Go to university's restaurant!";
	}
	
	//modify the writing() method from the Employee superclass
	public String writing() {
		return "I am writing teaching notes";
	}

}
