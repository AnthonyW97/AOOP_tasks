//this is the java applet class EmployeeTest

//import the relevant libraries to create and run applets
import java.awt.*;
import java.applet.Applet;
import javax.swing.*;

//the class EmployeeTest must extend Applet to work correctly
public class EmployeeTest extends Applet{
	
	//create instances of the 3 subclasses
	bankEmployee bankEmp = new bankEmployee();
	universityEmployee uniEmp = new universityEmployee();
	hospitalEmployee hospEmp = new hospitalEmployee();
	
	//create a font object for the applet to use
	Font font = new Font("Helvetica", Font.BOLD, 20);
	
	//include a status string to show the status of the applet
	String Status;
	
	//create an initialisation method to initialise the applet
	public void init() {
		//show that the applet is initialising
		Status = "Initialising";
		showStatus("The applet is initialising");
		//present the user with a window displaying the status
		JOptionPane.showMessageDialog(this, Status);
		repaint();
	}
	
	//create a method to start the applet
	public void start() {
		//add an update to the status to show the applet starting
		Status += "--Starting";
		showStatus("The applet is starting");
		//present the user with a window displaying the status
		JOptionPane.showMessageDialog(this, Status);
		repaint();
	}
	
	//create a method to stop the applet
	public void stop() {
		Status += "--Stopping!";
		showStatus("The applet is stopping!");
		//present the user with a window displaying the status
		JOptionPane.showMessageDialog(this, Status);
		repaint();
	}
	
	//create a method to destroy the applet after it has finished
	public void destroy() {
		Status += "--Destroyed!";
		showStatus("The applet is being destroyed!");
		//present the user with a window displaying the status
		JOptionPane.showMessageDialog(this, Status);
		repaint();
	}
	
	
	//create a paint method to draw to screen the required information
	public void paint(Graphics g) {
		
		//present the user with a window displaying the status each time a new line 
		//is painted
		Status += "--painting";
		
		Dimension d = getSize();
		
		//set the background colour
		g.setColor(Color.black);
		//fill the background with that colour
		g.fillRect(0, 0, d.width, d.height);
		
		//set the font as defined earlier
		g.setFont(font);
		
		//set the colour of the font
		g.setColor(Color.white);
		
		//call the methods from the appropriate objects and draw them
		//into the window
		
//		g.drawString("bankEmployee: " + bankEmp.countsMoney(), 50, 50);
//		g.drawString("bankEmployee: "+bankEmp.working(), 50, 100);
//		g.drawString("hospitalEmployee: "+ hospEmp.holiday(), 50, 150);
//		g.drawString("universityEmployee: "+uniEmp.working(), 50, 200);
		
		g.drawString("bankEmployee: " + bankEmp.takeBreak(), 50, 50);
		g.drawString("hospitalEmployee: " + hospEmp.takeBreak(), 50, 100);
		g.drawString("universityEmployee: " + uniEmp.takeBreak(), 50, 150);
		
		
		
		
		//show the status of the applet as it runs
		showStatus("The applet is painting");
		
	}
	
	

}
