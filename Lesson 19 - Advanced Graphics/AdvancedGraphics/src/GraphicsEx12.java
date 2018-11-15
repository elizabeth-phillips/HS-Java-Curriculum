import java.applet.Applet;
import java.awt.*;

public class GraphicsEx12 extends Applet{
    boolean insideApplet;
    public void paint(Graphics g) {
        if (insideApplet)
            g.drawString("Mouse is inside applet",20,20);
        else
            g.drawString("Mouse is outside applet",20,20);
    }
    public boolean mouseEnter(Event e, int x, int y) {
        insideApplet = true;
        repaint();
        return true;
    }
    public boolean mouseExit(Event e, int x, int y) {
        insideApplet = false;
        repaint();
        return true;
    }

}
