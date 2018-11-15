import java.applet.Applet;
import java.awt.*;

public class GraphicsEx17 extends Applet {
    Rectangle red, green, blue;
    int numColor;

    public void init()
    {
        red = new Rectangle(50,50,100,100);
        green = new Rectangle(50,200,100,100);
        blue = new Rectangle(50,350,100,100);
        numColor = 0;
    }

    public boolean mouseDown(Event e, int x, int y)
    {
        if(red.inside(x,y))
            numColor = 1;
        else if(green.inside(x,y))
            numColor = 2;
        else if(blue.inside(x,y))
            numColor = 3;
        else
            numColor = 4;
        repaint();
        return true;
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(50,50,100,100);
        g.setColor(Color.green);
        g.fillRect(50,200,100,100);
        g.setColor(Color.blue);
        g.fillRect(50,350,100,100);
        switch (numColor)
        {
            case 1:
                g.setColor(Color.red);
                g.drawString("Mouse clicked inside red", 200,75);
                break;
            case 2:
                g.setColor(Color.green);
                g.drawString("Mouse clicked inside green", 200,225);
                break;
            case 3:
                g.setColor(Color.blue);
                g.drawString("Mouse clicked inside blue", 200,375);
                break;
            case 4:
                g.setColor(Color.black);
                g.drawString(
                        "Mouse is clicked outside the colored squares",
                        50,20);
                break;
        }
    }

}
