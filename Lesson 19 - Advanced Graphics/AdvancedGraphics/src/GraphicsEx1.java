import java.awt.*;

public class GraphicsEx1 extends java.applet.Applet
{
    public void paint(Graphics g)
    {
        for (int x=100, y=100; x <= 500; x+=5, y+=5)
            g.drawLine(x,y,x,y);
    }
}
