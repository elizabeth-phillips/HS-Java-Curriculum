import java.applet.Applet;
import java.awt.*;

public class GraphicsEx19 extends Applet {
    int startX,startY,endX,endY;

    public void paint(Graphics g)
    {
        g.drawLine(startX,startY,endX,endY);
    }

    public boolean mouseDown(Event e, int x, int y)
    {
        startX = x;
        startY = y;
        return true;
    }

    public boolean mouseDrag(Event e, int x, int y)
    {
        endX = x;
        endY = y;
        repaint();
        return true;
    }

}
