import java.awt.*;

public class GraphicsEx4 extends java.applet.Applet
{
    public void paint(Graphics g)
    {
        int x,y;
        int radius = 100;
        int centerX = 200;
        int centerY = 200;
        g.setColor(Color.blue);
        for (double radian = 0; radian <= 2 * Math.PI; radian += 0.01)
        {
            x = (int) Math.round(Math.cos(radian) * radius) + centerX;
            y = (int) Math.round(Math.sin(radian) * radius) + centerY;
            g.drawLine(x,y,x,y);
        }
    }
}
