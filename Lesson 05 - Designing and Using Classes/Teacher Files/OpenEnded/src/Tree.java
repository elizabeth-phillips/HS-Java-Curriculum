
import gpdraw.*;
import java.awt.Color;
public class Tree
{
    private DrawingTool pen;
    /**
     * Constructor for objects of class House
     */
    public Tree(SketchPad sp)
    {
        pen = new DrawingTool(sp);
    }

    public void drawTrunk(){
        pen.up();
        pen.move(200,0);
        pen.down();
        pen.setColor(new Color(174,132,16));
        pen.fillRect(30,150);
    }
    
    public void drawLeaves(){
        pen.up();
        pen.move(200,30);
        pen.down();
        pen.setColor(new Color(58,233,111));
        pen.fillCircle(50);
    }

    public void drawKnot(){
        pen.up();
        pen.move(200,-40);
        pen.down();
        pen.setColor(new Color(61, 33, 23));
        pen.fillOval(10,20);
    }
}
