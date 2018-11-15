import java.awt.*;

public class GraphicsEx9 extends java.applet.Applet{
    public void paint(Graphics g) {
        int sides = 5;
        for (int y = 100; y <= 500; y+=120) {
            for (int x = 100; x <= 800; x+=120)
                regPolygon(g,50,x,y,sides);
            sides++;
        }
    }
    public void regPolygon(Graphics g, int radius, int centerX, int centerY,int sides) {
        double twoPI = 2 * Math.PI;
        int xCoord[] = new int[sides];
        int yCoord[] = new int[sides];
        g.setColor(Color.blue);
        for (int k = 0; k < sides; k++) {
            xCoord[k] = (int) Math.round(Math.cos(twoPI * k/sides) * radius) + centerX;
            yCoord[k] = (int) Math.round(Math.sin(twoPI * k/sides) * radius) + centerY;
        }
        g.fillPolygon(xCoord,yCoord,sides);
    }
}
