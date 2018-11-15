
import gpdraw.*;
import java.awt.Color;
public class Background
{
    private DrawingTool pen;
    /**
     * Constructor for objects of class Background
     */
    public Background(SketchPad sp)
    {
        pen = new DrawingTool(sp);
    }

    public void drawBackground(){
        //Bottom half
        pen.up();
        pen.move(0,-225);
        pen.down();
        pen.setColor(new Color(29,129,52));
        pen.fillRect(600,300);
        
        //Top half
        pen.up();
        pen.move(0,125);
        pen.down();
        pen.setColor(new Color(58,169,233));
        pen.fillRect(600,400);
    }
}
