import java.awt.*;
import java.applet.Applet;

public class GraphicsEx10 extends Applet{
    int numClicks;

    public void init()  {  numClicks = 0;  }

    public void paint(Graphics g) {
        g.drawString("Mouse is clicked " + numClicks + " times.",20,20);
    }

    public boolean mouseDown(Event e, int x, int y) {
        numClicks++;
        repaint();
        return true;
    }
}
