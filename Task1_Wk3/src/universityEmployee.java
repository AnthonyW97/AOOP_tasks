/* *************************
 * Author: 1716208         /*
 * Task: 1				   /*
 * Description: create an  /*
 * employee superclass with /*
 * several subclasses      /*
 * Date: 15/10/2019        /* 
 * ************************/

//this is the universityEmployee subclass, it inherits from the Employee class
public class universityEmployee extends Employee{
	
	//create a method to show the university employee teaching
	public void teachStudents() {
		//print a message to the screen showing the university employee teaching
		System.out.println("I am teaching!");
	}
	
	//create a writing method to implement the abstract method from employee superclass
	public String writing() {
		//the university employee writes teaching notes
		String write = "Writing teaching notes";
		return write;
	}
	
	//create a takeBreak() method to override the generic method in the Employee class
	public String takeBreak() {
		//the university employee goes to the university restaurant on their break
		String empBreak = "Go to university's restaurant!";
		return empBreak;
	}

}
