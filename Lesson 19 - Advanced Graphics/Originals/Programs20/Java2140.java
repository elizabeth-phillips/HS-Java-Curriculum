// Java2140.java
// This program introduces GUI program input/output using Swing dialog boxes.


import javax.swing.JOptionPane;


public class Java2140
{
	public static void main (String args[])
	{
		String firstName = JOptionPane.showInputDialog("Enter First Name");
		String lastName = JOptionPane.showInputDialog("Enter Last Name");
		String fullName = firstName + " " + lastName;

		JOptionPane.showMessageDialog(null,"Your name is " + fullName);

		System.exit(0);
	}
}
