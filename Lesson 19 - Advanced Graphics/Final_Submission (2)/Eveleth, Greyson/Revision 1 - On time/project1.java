import java.applet.Applet;
import java.awt.*;

//This program shows a background scene and a dancer leaping over a puddle
public class project1 extends Applet {
    int appletWidth;
    int appletHeight;

    //sets width, height and background
    public void init() {
        appletWidth = getWidth();
        appletHeight = getHeight();
        setBackground(new Color(105, 212, 212));
    }

    //draws the background scene
    public void paint(Graphics g) {
            //grass
            g.setColor(new Color(181, 210, 154));
            g.fillRect(0, 450, 10000, 900);
            //sun
            g.setColor(new Color(255, 237, 6));
            g.fillOval(50, 70, 100, 100);
            //puddle
            g.setColor(new Color(135, 185, 255));
            g.fillOval(150, 450, 600, 100);
            //flower
            g.setColor(new Color(150, 180, 133));
            g.fillRect(812, 500, 3, 50);
            g.setColor(new Color(154, 113, 156));
            g.fillOval(800, 480, 30, 30);
            g.setColor(new Color(63, 146, 146));
            g.fillOval (790,490, 20,20);
            g.fillOval (800,500,20,20);
            g.fillOval (813,500,20,20);
            g.fillOval (820,490,20,20);
            g.fillOval (822,478,20,20);
            g.fillOval (817, 470,20,20);
            g.fillOval (807,465,20,20);
            g.fillOval (795,470,20,20);
            g.fillOval (788, 478,20,20);
            g.setColor(new Color(150, 180, 133));
            g.fillOval (812,530,15,5);
            g.fillOval (800,523,15,5);
            //animal in water (supposed to be a duck)
            g.setColor(new Color(255, 242, 185));
            g.fillOval (350,500,40,15);
            g.fillOval (365,510,5,10);
            g.fillOval (369,510,5,10);
            g.fillOval (350,488,10,20);
            g.fillOval (340,488,20,10);

            //for loop that makes dancer move
            for (int x = 20; x < 700; x += 100) {
                drawDancer(g, x, 200);
                delay(170);
                eraseDancer(g, x, 200);
            }
        }

    //draws the dancer
    public void drawDancer(Graphics g, int x, int y) {
        //head
        g.setColor(new Color(242, 246, 189));
        g.fillOval(x + 130, y, 40, 40);
        //neck
        g.fillRect(x + 145, y + 35, 10, 10);
        //body
        g.setColor(new Color(206, 168, 208));
        g.fillOval(x + 135, y + 40, 30, 60);
        //legs
        g.setColor(new Color(154, 113, 156));
        g.fillRect(x + 95, y + 100, 130, 5);
        //arms
        g.setColor(new Color(206, 168, 208));
        g.fillRect(x + 105, y + 40, 80, 4);
    }

    //erases dancer
    public void eraseDancer(Graphics g, int x, int y) {
        g.setColor(new Color(105, 212, 212));
        g.fillRect(x, y, 230, 170);
    }

    public void delay(int n) {
        long startDelay = System.currentTimeMillis();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.currentTimeMillis();
    }
}