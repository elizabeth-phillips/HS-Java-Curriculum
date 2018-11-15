import java.awt.*;

public class GraphicsEx8 extends java.applet.Applet{
    public void paint(Graphics g){
        int centerX = 400;
        int centerY = 300;
        int radius = 200;
        double twoPI = 2 * Math.PI;
        int xCoord[] = new int[6];
        int yCoord[] = new int[6];
        g.setColor(Color.blue);
        for (int k = 0; k < 6; k++)
        {
            xCoord[k] = (int) Math.round(Math.cos(twoPI * k/6) * radius) + centerX;
            yCoord[k] = (int) Math.round(Math.sin(twoPI * k/6) * radius) + centerY;
        }
        g.fillPolygon(xCoord,yCoord,6);
    }
}
