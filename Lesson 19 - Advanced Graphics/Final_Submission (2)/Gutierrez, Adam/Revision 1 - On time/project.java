import java.applet.Applet;
import java.awt.*;

public class project extends Applet {
    Image virtualMem;
    int appletWidth;
    int appletHeight;
    Graphics gBuffer;
    int oldX, oldY, newX, newY;

    public void init() {
        setBackground(Color.blue);
        appletWidth = getWidth();
        appletHeight = getHeight();
    }

    public void drawBall(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillOval(x + 14, y + 13, 60, 60);
        g.setColor(Color.red);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        int[] xCoords = {x + 30, x + 35, x + 35, x + 30};
        int[] yCoords = {y + 20, y + 35, y + 50, y + 65};
        g.drawPolyline(xCoords, yCoords, yCoords.length);

        g2.setStroke(new BasicStroke(3));
        int[] x1Coords = {x + 60, x + 55, x + 55, x + 60};
        int[] y1Coords = {y + 20, y + 35, y + 50, y + 65};
        g.drawPolyline(x1Coords, y1Coords, y1Coords.length);
    }

    public void paint(Graphics g) {
            for (int x = 0; x < 450; x += 20) {
                drawBall(g, x, 200);
                delay(150);
                eraseBall(g, x, 200);
            }
            for (int y = 200; y >= 0; y -= 20) {
                drawBall(g, 440, y);
                delay(150);
                eraseBall(g, 440, y);
            }
            for (int x = 440; x >= 0; x -= 20) {
                drawBall(g, x, 0);
                delay(150);
                eraseBall(g, x, 0);
            }
            for (int y = 00; y <= 200; y += 20) {
                drawBall(g, 0, y);
                delay(150);
                eraseBall(g, 0, y);
            }
            String[] akins = {"A","K","I","N","S"};
            for(int i = 0; i < 5; i++){
                g.setFont(new Font("Serif",Font.BOLD,20));
                g.drawString(akins[i],(i * 80) + 80, 150);
            }
    }

    public void eraseBall(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillOval(x + 14, y + 13, 60, 60);
    }

    public void delay(int n) {
        long startDelay = System.currentTimeMillis();
        long endDelay = 20;
        while (endDelay - startDelay < n)
            endDelay = System.currentTimeMillis();
    }

}

