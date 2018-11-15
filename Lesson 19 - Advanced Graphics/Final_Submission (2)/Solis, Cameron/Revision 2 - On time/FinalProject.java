import java.applet.Applet;
import java.awt.*;
import java.util.Random;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class FinalProject  extends Applet{
    int appletWidth;
    int appletHeight;
    Image virtualMem;
    Graphics gBuffer;
    Color background;
    Color hill;
    Color stem;
    public void init(){
        background = new Color(131, 186, 255);
        hill = new Color(0, 102,0);
        stem = new Color(0x0B9418);
        setBackground(background);
        appletWidth = getWidth();
        appletHeight = getHeight();
        virtualMem = createImage(appletWidth,
                appletHeight);
        gBuffer = virtualMem.getGraphics();
    }
    public void paint(Graphics g) {
        for (int x = 20; x < 700; x += 5) {
            drawCar(g, x, 300);
            delay(30);
            eraseCar(g, x, 300);
        }
        for (int x = 00; x <= 800; x += 20) {
            drawCar(g, x, 0);
            delay(40);
            eraseCar(g, x, 0);
        }
    }



    public void drawCar(Graphics g, int x, int y)
    {
        createBackGround();
        gBuffer.setColor(Color.BLACK);
        gBuffer.fillRect(x+25,y-5,100,90);
        gBuffer.fillRect(x,y+30,150,60);
        gBuffer.setColor(Color.GRAY);
        gBuffer.fillOval( x+85,y+75,60,60);
        gBuffer.fillOval(x+5,y+75,60,60);

        g.drawImage (virtualMem,0,0, this);
    }

    public void eraseCar(Graphics g, int x, int y)
    {
        createBackGround();
        gBuffer.setColor(background);
        //car
        gBuffer.fillRect(x+25,y-5,100,90);
        gBuffer.fillRect(x,y+30,150,60);
        gBuffer.fillOval( x+85,y+75,60,60);
        gBuffer.fillOval(x+5,y+75,60,60);


    }

    public void createBackGround() {
        gBuffer.setColor(hill);
        gBuffer.fillOval(500, 200, 300, 900);
        gBuffer.fillOval(300, 200, 300, 700);
        gBuffer.fillOval(100, 200, 300, 900);
        gBuffer.fillOval(-100, 200, 300, 700);
        gBuffer.setColor(stem);
        gBuffer.fillRect(200, 375, 10,25);
        gBuffer.fillRect(240, 370, 10,30);
        gBuffer.fillRect(285, 380, 10,20);
        gBuffer.fillRect(335, 380, 10,20);
        gBuffer.fillRect(550, 380, 10,20);
        gBuffer.fillRect(675, 380, 10,20);
        gBuffer.fillRect(730, 375, 10,25);
        gBuffer.fillRect(80, 380, 10,20);
        gBuffer.fillRect(30, 380, 10,20);
        gBuffer.fillRect(5, 380, 10,20);
        gBuffer.setColor(Color.RED);
        gBuffer.fillOval(195, 355, 20,20);
        gBuffer.fillOval(230, 340, 30,30);
        gBuffer.fillOval(280, 360, 20,20);
        gBuffer.fillOval(330, 360, 20,20);
        gBuffer.fillOval(545, 360, 20,20);
        gBuffer.fillOval(670, 360, 20,20);
        gBuffer.fillOval(75, 360, 20,20);
        gBuffer.fillOval(25, 360, 20,20);
        gBuffer.fillOval(0, 360, 20,20);


        gBuffer.setColor(Color.DARK_GRAY);
        gBuffer.fillRect(0,400,appletWidth,100);
        gBuffer.setColor(Color.YELLOW);
        gBuffer.fillOval(0,0, 150,150);



    }


    public void delay(int n){
        long startDelay = System.currentTimeMillis();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.currentTimeMillis();
    }
}
