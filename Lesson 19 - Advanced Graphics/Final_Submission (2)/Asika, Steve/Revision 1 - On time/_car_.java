import java.applet.Applet;
import java.awt.*;
import java.util.Random;

import static java.lang.Math.random;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class _car_ extends Applet {
    int appletWidth;
    int appletHeight;
    Image virtualMem;
    Graphics gBuffer;

    public void init() {
        appletWidth = getWidth();
        appletHeight = getHeight();
        virtualMem = createImage(appletWidth, appletHeight);
        gBuffer = virtualMem.getGraphics();
        setBackground(new Color(0, 0, 0));
    }

    public void paint(Graphics g) {
        for (int x = 20; x < 700; x += 5) {
            drawCar(g, x, 200);
            delay(100);
            eraseCar(g,x,200);
        }
    }

    public void drawCar(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        int[] xValues = {543+x, 1350+x, 543+x, 543+x, 543+x, 646+x, 646+x, 692+x, 692+x, 1131+x, 1131+x, 1187+x, 1187+x, 1354+x, 1354+x, 1354+x};
        int[] yValues = {750+y, 750+y, 750+y, 620+y, 620+y, 555+y, 555+y, 485+y, 485+y, 485+y, 485+y, 555+y, 555+y, 620+y, 620+y, 750+y};
        g.fillPolygon(xValues, yValues, yValues.length);
        g.setColor(new Color(30, 30, 30));
        g.fillOval(650+x, 706+y, 120, 120);
        g.fillOval(1098+x, 706+y, 120, 120);

        g.setColor(new Color(255, 255, 255));
        g.fillOval(672+x, 730+y, 70, 70);
        g.fillOval(1122+x, 730+y, 70, 70);

        g.setColor(new Color(255, 255, 255));
        g.fillOval(40, 40, 150, 150);

        int a = (int )(Math.random() * 2000 + 1);
        int b = (int )(Math.random() * 400 + 1);
        g.setColor(new Color(255, 255, 255));
        g.fillOval(a, b, 5,  5);
    }

    public void drawSun(Graphics g, int x, int y){


        }
    public void eraseCar(Graphics g, int x, int y) {
        g.setColor(new Color(0, 0, 0));
        int[] xValues = {543+x, 1350+x, 543+x, 543+x, 543+x, 646+x, 646+x, 692+x, 692+x, 1131+x, 1131+x, 1187+x, 1187+x, 1354+x, 1354+x, 1354+x};
        int[] yValues = {750+y, 750+y, 750+y, 620+y, 620+y, 555+y, 555+y, 485+y, 485+y, 485+y, 485+y, 555+y, 555+y, 620+y, 620+y, 750+y};
        g.fillPolygon(xValues, yValues, yValues.length);
        g.fillOval(650+x, 706+y, 120, 120);
        g.fillOval(1098+x, 706+y, 120, 120);
        g.fillOval(672+x, 730+y, 70, 70);
        g.fillOval(1122+x, 730+y, 70, 70);
    }

    public void delay(int n) {
        long startDelay = System.currentTimeMillis();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.currentTimeMillis();
    }
}