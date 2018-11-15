/**
 * Created by Elizabeth on 8/23/2017.
 */
import gpdraw.*;

public class Benzene
{
    private DrawingTool pencil;
    private SketchPad myPaper;

    public Benzene(){
        myPaper = new SketchPad(1000, 1000);
        pencil= new DrawingTool(myPaper);
    }

    public void draw(){
        //Your code goes under here
        // draw circle first
        pencil.drawCircle(65);
        pencil.turnRight(90);

        // position the lower left corner so
        // the square will be in centered
        pencil.up();

        pencil.forward(87);
        pencil.turnRight(90);

        pencil.down();
        pencil.forward(50);
        pencil.turnRight(60);

        pencil.forward(100);
        pencil.turnRight(60);
        pencil.forward(100);
        pencil.turnRight(60);
        pencil.forward(100);
        pencil.turnRight(60);
        pencil.forward(100);
        pencil.turnRight(60);
        pencil.forward(100);
        pencil.turnRight(60);

        pencil.forward(50);
    }
}
