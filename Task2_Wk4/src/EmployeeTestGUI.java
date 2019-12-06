//this is the EmployeeTest class with GUIs implemented

//import the relevant libraries for this class
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EmployeeTestGUI extends Applet{
	
	//create the GUI components to be used within the applet
	
	
	//text field for the user to input their employee type
	public static JTextField inputArea;
	
	//create a label for the textfield
	public static JLabel label1;
	
	//button for the user to select 'writing'
	public static JButton writing;
	
	//button for the user to select 'takeBreak'
	public static JButton takeBreak;
	
	//text area for the output to be displayed within
	public static JTextArea outputArea;
	
	
	//create a font object for the applet to use
	Font font = new Font("Helvetica", Font.BOLD, 20);
	
	//include a status string to show the status of the applet
	String Status;
	
	//create instances of the 3 subclasses to call methods from
	private static bankEmployee bankObj = new bankEmployee();
	private static hospitalEmployee hospObj = new hospitalEmployee();
	private static universityEmployee uniObj = new universityEmployee();
	
	//create a variable to hold the user response
	public static String userTxt;
	

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
			
			//instantiate the GUI components
			 inputArea = new JTextField(12);
			 label1 = new JLabel("Enter the employee...");
			 writing = new JButton("Writing");
			 takeBreak = new JButton("takeBreak");
			 outputArea = new JTextArea();
			 
			 //the text area is not editable 
			 outputArea.setEditable(false);
			 
			 
			 
			 //add the GUI components to the applet container
			 add(label1);
			 add(inputArea);
			 add(writing);
			 add(takeBreak);
			 add(outputArea);
			 
			 
			 //add an action listener for the takeBreak button 
			 takeBreak.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent ag0) {
						
						//save the user input to a variable
						userTxt = inputArea.getText();
						
						//create a nested if else statement to determine what 
						//employee the user has entered
						if(userTxt.equals("bankEmployee")) {
							outputArea.setText(bankObj.takeBreak());
						} else if(userTxt.equals("universityEmployee")) {
							outputArea.setText(uniObj.takeBreak());
						} else if(userTxt.equals("hospitalEmployee")) {
							outputArea.setText(hospObj.takeBreak());
						} else {
							outputArea.setText("invalid employee");
						}
						
					}
			 });
			 
			//add an action listener for the writing button 
			 writing.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent ag0) {
						
						//save the user input to a variable
						userTxt = inputArea.getText();
						
						//create a nested if else statement to determine what
						//employee the user has entered
						if(userTxt.equals("bankEmployee")) {
							outputArea.setText(bankObj.writing());
						}else if(userTxt.equals("universityEmployee")) {
							outputArea.setText(uniObj.writing());
						} else if(userTxt.equals("hospitalEmployee")) {
							outputArea.setText(hospObj.writing());
						} else {
							outputArea.setText("invalid employee");
						}
					}
					});
			 
			
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
	
	
}