import java.applet.Applet;
import java.awt.*;

public class GraphicsEx16 extends Applet {
    int xCoord[];
    int yCoord[];
    int numSquare;
    boolean firstPaint;

    public void init() {
        xCoord = new int[100];
        yCoord = new int[100];
        numSquare = 0;
        firstPaint = true;
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        for (int k = 0; k < numSquare; k++)
            g.fillRect(xCoord[k],yCoord[k],15,15);
    }

    public boolean mouseDown(Event e, int x, int y) {
        xCoord[numSquare] = x;
        yCoord[numSquare] = y;
        numSquare++;
        repaint();
        return true;
    }
}
