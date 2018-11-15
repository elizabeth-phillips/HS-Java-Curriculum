import java.awt.*;
import java.applet.Applet;

public class GraphicsEx11 extends Applet{
    int xCoord, yCoord;

    public void paint(Graphics g){
        g.drawString("Mouse clicked at (" + xCoord + "," + yCoord + ")",20,20);
    }

    public boolean mouseDown(Event e, int x, int y){
        xCoord = x;
        yCoord = y;
        repaint();
        return true;
    }
}
