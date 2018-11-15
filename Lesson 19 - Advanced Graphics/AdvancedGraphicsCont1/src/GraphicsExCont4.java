import java.applet.Applet;
import java.awt.*;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class GraphicsExCont4 extends Applet{
    int appletWidth;
    int appletHeight;
    public void init(){
        appletWidth = getWidth();
        appletHeight = getHeight();
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,appletWidth,appletHeight);
        for (int x = 20; x < 700; x += 100) {
            drawSnowman(g,x,200);
            delay(50);
            eraseSnowman(g,x,200);
        }
    }
    public void drawSnowman(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        g.fillOval(x+20,y,40,40);
        g.fillOval(x+10,y+35,60,60);
        g.fillOval(x,y+90,80,80);
    }
    public void eraseSnowman(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.fillRect(x,y,80,170);
    }
    public void delay(int n){
        long startDelay = System.currentTimeMillis();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.currentTimeMillis();
    }
}
