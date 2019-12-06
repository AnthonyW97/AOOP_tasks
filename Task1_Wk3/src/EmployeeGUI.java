//import the relevant packages/libraries
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//this class will use methods from the Employee() class but implement them through GUIs
public class EmployeeGUI {
	
	//create instances of the subclasses to Employee
	//keep them private to prevent modification from other classes
	private static bankEmployee bankObj = new bankEmployee();
	private static universityEmployee uniObj = new universityEmployee();
	private static hospitalEmployee hospObj = new hospitalEmployee();
	
	//create a variable to hold the user's input
	String userTxt;
	
		EmployeeGUI(){
		
			//create the frame that will hold the text field and buttons
			JFrame frame = new JFrame("Employee test");
		
			//create the writing button
			JButton writingButton = new JButton("Writing");
		
			//set the bounds for the writingButton
			writingButton.setBounds(50,150,100,20);
		
			//create the break button
			JButton breakButton = new JButton("Break");
			
			//set the bounds for the break button
			breakButton.setBounds(160,150,100,20);
			
			//create label to instruct user to enter text
			JLabel label1 = new JLabel();
		
			//add text to the label 
			label1.setText("Enter employee type (bank, university, or hospital)");
			label1.setBounds(40,10,300,100);
			
			//create empty label for the result after button is clicked
			JLabel label2 = new JLabel();
			label2.setBounds(10,5,100,100);
			
			//create a textfield for the user to enter text
			JTextField textField = new JTextField();
			textField.setBounds(110,90,130,30);
			
			
			//add all the elements to the frame
			frame.add(label1);
			frame.add(textField);
			frame.add(label2);
			frame.add(writingButton);
			frame.add(breakButton);
			frame.setSize(350,250);
			frame.setLayout(null);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			//Add an action listener for when the writing button is clicked
			
			writingButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent ag0) {
					
					//save the user input to a variable
					userTxt = textField.getText();
					
					//user input needs to be either bankEmployee, universityEmployee
					//, or hotelEmployee
					
					//if the user input is "bankEmployee" then show the bank object writing 
					if(userTxt.equals("bankEmployee")){
						JOptionPane.showMessageDialog(null, bankObj.writing());
					} 
					//if the user input is "universityEmployee" then show the uni object writing
					else if(userTxt.equals("universityEmployee")) {
						JOptionPane.showMessageDialog(null, uniObj.writing());
					}
					//if the user input is "hospitalEmployee" then show the hospital object writing
					else if(userTxt.equals("hospitalEmployee")) {
						JOptionPane.showMessageDialog(null, hospObj.writing());
					}
					//if the user doesn't enter a valid keyword return an error
					else {
						JOptionPane.showMessageDialog(null, "Invalid. Enter bankEmployee, universityEmployee, or hospitalEmployee");
					}
				}
				
			});
			
			
			//Add an action listener for when the break button is clicked
			
			breakButton.addActionListener(new ActionListener() {
						
				public void actionPerformed(ActionEvent ag0) {
					
					//save the user input to a variable
					userTxt = textField.getText();
					
					//the user can only input one of three possibilities
					//if the user enters anything but bank, university, or hospital
					//an error will be returned
					
					
					//if the user input is "bankEmployee" then show the bank object writing 
					if(userTxt.equals("bankEmployee")){
						JOptionPane.showMessageDialog(null, bankObj.takeBreak());
					} 
					//if the user input is "universityEmployee" then show the uni object writing
					else if(userTxt.equals("universityEmployee")) {
						JOptionPane.showMessageDialog(null, uniObj.takeBreak());
					}
					//if the user input is "hospitalEmployee" then show the hospital object writing
					else if(userTxt.equals("hospitalEmployee")) {
						JOptionPane.showMessageDialog(null, hospObj.takeBreak());
					}
					//if the user doesn't enter a valid keyword return an error
					else {
						JOptionPane.showMessageDialog(null, "Invalid. Enter bankEmployee, universityEmployee, or hospitalEmployee");
					}
					
					
					
				}
						
			});
		}
		
		//create a main method to call the GUI
			
		public static void main (String args[]) {
			
			new EmployeeGUI();
				
		}

}
