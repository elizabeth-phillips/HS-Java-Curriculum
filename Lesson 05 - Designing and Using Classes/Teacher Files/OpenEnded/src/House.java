
/**
 * This is the code that creates the house object
 * 
 * @author Elizabeth Phillips
 * @version 1
 */
import gpdraw.*;
import java.awt.Color;
public class House
{
    private DrawingTool pen;
    /**
     * Constructor for objects of class House
     */
    public House(SketchPad sp)
    {
        pen = new DrawingTool(sp);
    }

    public void drawBrick(){
        pen.setColor(new Color(153,0,0));
        pen.fillRect(250,150);
    }

    public void drawRoof(){
        //Rough drawing of the roof
        pen.setColor(new Color(0,0,0));
        pen.setWidth(10);

        //Draw Triangle
        pen.up();
        pen.move(-125,75);
        pen.down();
        pen.move(0,120);
        pen.move(125,75);
        pen.move(-125,75);

        //Fill triangle in the middle with an oval
        pen.up();
        pen.move(0,93);
        pen.down();
        pen.fillOval(120,45);

        //Fill triangle on the right with an oval
        pen.move(75,85);
        pen.fillOval(65,17);

        //Fill triangle on the left with an oval
        pen.move(-75,85);
        pen.fillOval(65,17);
    }

    public void drawDoor(){
        pen.setColor(new Color(96,96,96));
        pen.up();
        pen.move(0, -45);
        pen.down();
        pen.fillRect(30,60);
    }

    public void drawWindows(){
        pen.setColor(new Color(255,255,255));
        pen.up();
        pen.move(-80, 40);
        pen.down();
        pen.fillRect(30,30);

        pen.up();
        pen.move(-80, -30);
        pen.down();
        pen.fillRect(30,30);

        pen.up();
        pen.move(80, 40);
        pen.down();
        pen.fillRect(30,30);

        pen.up();
        pen.move(80, -30);
        pen.down();
        pen.fillRect(30,30);
    }

}
