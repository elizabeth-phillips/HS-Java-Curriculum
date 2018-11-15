import java.awt.*;

public class GraphicsEx6 extends java.applet.Applet
{
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        int xCoord[] = {400,550,500,300,250};
        int yCoord[] = {70,200,350,350,200};
        g.fillPolygon(xCoord,yCoord,5);
    }
}
