/**
 *  DrawSquare: This class will create a piece of paper and a pencil,
 *  place the pencil on the paper, and then draw a square.
 *
 */

import gpdraw.*;

public class DrawShapes{

    private DrawingTool pencil;
    private SketchPad paper;

    /**
     *  Basic constructor for DrawSquare.
     *  Instantiates paper and pencil to basic
     *  values.
     */
    public DrawShapes(){
        paper = new SketchPad(300, 300);
        pencil = new DrawingTool(paper);
    }

    /**
     *  The draw method for the DrawSquare class.
     *  This method will run all of the
     *  commands necessary to draw the square.
     */

    public void draw(){

        // draw the square
        pencil.forward(100);
        pencil.turnLeft(90);
        pencil.forward(100);
        pencil.turnLeft(90);
        pencil.forward(100);
        pencil.turnLeft(90);
        pencil.forward(100);

    }
}

