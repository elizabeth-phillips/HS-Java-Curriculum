import java.awt.*;

public class GraphicsEx2 extends java.applet.Applet
{
    public void paint(Graphics g)
    {
        for (int x=100, y=100; x <= 500; x+=5, y+=5)
            g.fillRect(x,y,2,2);
    }
}
