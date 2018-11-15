/** A class to draw an optical illusion of parallel lines.
 *
 */

import java.awt.*;
import gpdraw.*;

public class ParallelLines{

    private DrawingTool pen = new DrawingTool(new SketchPad(600, 480, 0));
    private final int OFFSET = 12;
    private final int BLOCKSIZE = 40;

    private int startX = -260;
    private int startY = 150;

    private int sign = -1;
    private int inset = 0;

 	public void drawLines(){
  	
    	for (int row = 0; row < 8; row++){
    		
			// position to draw the squares
			pen.up();
			pen.move(startX, startY - row * BLOCKSIZE);
			pen.setDirection(0);
			
			// calculate a horizontal offset
			pen.move(inset);
			if (row % 2 == 0)
			sign = -sign;
			inset = inset + sign*OFFSET;
			pen.down();
			
			//System.out.println(pen.getPosition());
			for (int col = 0; col < 7; col++){
			pen.fillRect(BLOCKSIZE, BLOCKSIZE);
			pen.up();
			pen.move(2*BLOCKSIZE);
			pen.down();
			}
			
			// calculate the location and draw the line
			pen.up();
			pen.move(startX - BLOCKSIZE/2, startY - (row * BLOCKSIZE) - BLOCKSIZE/2);
			pen.setDirection(0);
			pen.down();
			pen.move(BLOCKSIZE*14);
	    }
  	}
}
