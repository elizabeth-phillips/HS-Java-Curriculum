import javax.swing.*;
import java.applet.Applet;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class GraphicsExCont16{
    public static void main (String args[]){
        String strNbr1 =
                JOptionPane.showInputDialog("Enter Number 1");
        String strNbr2 =
                JOptionPane.showInputDialog("Enter Number 2");
        int intNbr1 = Integer.parseInt(strNbr1);
        int intNbr2 = Integer.parseInt(strNbr2);
        int sum = intNbr1 + intNbr2;
        JOptionPane.showMessageDialog(null,intNbr1 + " + " + intNbr2 +
                " = " + sum);
        System.exit(0);
    }
}
