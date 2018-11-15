import java.applet.Applet;
import java.awt.*;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class GraphicsExCont14 extends java.applet.Applet{
    int numClicks;
    public void init()   {   numClicks = 0;   }
    public void paint(Graphics g){
        switch (numClicks){
            case 0: page1(g); break;
            case 1: page2(g); break;
            case 2: page3(g); break;
        }
    }

    public boolean mouseDown(Event e, int x, int y){
        numClicks++;
        repaint();
        return true;
    }
    public void page1(Graphics g)
    {
        g.setFont(new Font("Arial",Font.BOLD,100));
        g.drawString("TITLE PAGE",200,100);
        g.setColor(Color.red);
        g.fillRect(300,300,200,200);
        g.setFont(new Font("Times Roman",Font.PLAIN,20));
        g.drawString("Click once to continue",100,500);
    }

    public void page2(Graphics g)
    {
        g.setFont(new Font("Arial",Font.BOLD,100));
        g.drawString("PAGE 2",200,300);
        g.setColor(Color.blue);
        g.fillRect(0,0,100,100);
        g.setFont(new Font("Times Roman",Font.PLAIN,20));
        g.drawString("Click once to continue",100,500);
    }

    public void page3(Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(100,100,300,300);
        g.setFont(new Font("Arial",Font.BOLD,100));
        g.drawString("PAGE 3",200,500);
        g.setFont(new Font("Times Roman",Font.PLAIN,20));
        g.drawString("Click to exit",400,600);
    }
}