import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class GraphicsExCont15 extends Applet{
    public static void main (String args[]){
        String firstName =
                JOptionPane.showInputDialog("Enter First Name");
        String lastName = JOptionPane.showInputDialog("Enter Last Name");
        String fullName = firstName + " " + lastName;

        JOptionPane.showMessageDialog(null,"Your name is " + fullName);

        System.exit(0);
    }

}