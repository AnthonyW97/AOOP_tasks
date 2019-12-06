/* *************************
 * Author: 1716208         /*
 * Task: 1				   /*
 * Description: create an  /*
 * employee superclass with /*
 * several subclasses      /*
 * Date: 15/10/2019        /* 
 * ************************/

//this is the class used to test the methods in the various other classes in this task
public class EmployeeTest {
	
	//create instances of the subclass objects
	//make the objects private so they cant be modified by other classes
	private static bankEmployee bankEmp = new bankEmployee();
	private static universityEmployee uniEmp = new universityEmployee();
	private static hospitalEmployee hospEmp = new hospitalEmployee();
	
	//include a main method to test call the appropriate methods from the objects created
	public static void main(String args[]) {
		//use the instantiated objects to call relevant methods
		
		//the bank employee counts money
		bankEmp.countsMoney();
		
		//the bank employee is working
		bankEmp.working();
		
		//the hospital employee is on holiday
		hospEmp.holiday();
		
		//university employee is teaching
		uniEmp.teachStudents();
		
		//the university employee is also working
		uniEmp.working();
		
		//separate the abstract method calls from the non abstract method calls
		System.out.println("******************************************");
		
		//call the writing method from the bank employee object
		bankEmp.writing();
		
		//call the writing method from the university employee object
		uniEmp.writing();
		
		//call the writing method from the hospital employee object
		hospEmp.writing();
		
		//separate the abtract method calls from the overriding polymorphism example
		System.out.println("******************************************");
		
		//call takeBreak() from the bank employee object
		bankEmp.takeBreak();
		
		//call takeBreak() from the university employee object
		uniEmp.takeBreak();
		
		//call takeBreak() from the hospital employee object
		hospEmp.takeBreak();
	}
}
