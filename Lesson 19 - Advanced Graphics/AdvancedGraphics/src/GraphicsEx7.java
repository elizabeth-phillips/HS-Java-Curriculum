import java.awt.*;

public class GraphicsEx7 extends java.applet.Applet
{
    public void paint(Graphics g)
    {
        g.setColor(Color.blue);
        int xCoord[] = {400,550,500,300,250};
        int yCoord[] = {70,200,350,350,200};
        g.drawPolyline(xCoord,yCoord,5);
    }
}
