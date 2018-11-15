import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Random;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class GraphicsExCont17 extends Applet {
    int size;		// size of squares to be displayed
    int count;		// the quantity of squares to be displayed
    public void init(){
        String str1 = JOptionPane.showInputDialog("Enter Square Size");
        String str2 = JOptionPane.showInputDialog("Enter Square Count");
        size = Integer.parseInt(str1);
        count = Integer.parseInt(str2);
    }
    public void paint(Graphics g){
        Random rnd = new Random(12345);
        for (int k = 1; k <= count; k++)  {
            int x = rnd.nextInt(800-size);
            int y = rnd.nextInt(600-size);
            int red = rnd.nextInt(256);
            int green = rnd.nextInt(256);
            int blue = rnd.nextInt(256);
            g.setColor(new Color(red,green,blue));
            g.fillRect(x,y,size,size);
        }
    }
}

