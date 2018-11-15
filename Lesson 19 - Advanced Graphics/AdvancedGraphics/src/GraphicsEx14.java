import java.awt.*;
import java.applet.Applet;

public class GraphicsEx14 extends Applet{
    int xCoord, yCoord;

    public void paint(Graphics g){
        g.drawString("Mouse is located at (" + xCoord + "," + yCoord + ")",20,20);
    }

    public boolean mouseMove(Event e, int x, int y){
        xCoord = x;
        yCoord = y;
        repaint();
        return true;
    }
}
