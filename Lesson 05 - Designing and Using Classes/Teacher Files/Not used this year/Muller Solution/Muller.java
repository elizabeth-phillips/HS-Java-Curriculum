/**
 *  Muller: Visually displays the Muller and Ponzo illusions.
 */

import gpdraw.*;

public class Muller {
	
	private DrawingTool pen = new DrawingTool(new SketchPad(300,300));
	
	public Muller(){}
		
	//Draws a line in any given direction and any length starting at x, y

	public void drawLine(int x, int y, int length, int direction){
		pen.up();
		pen.move(x,y);
		pen.down();
		pen.setDirection(direction);
		pen.forward(length);
		pen.up();
	}
	
	//Draws an arrow pointing in the specified direction
	public void drawArrow(int x, int y, int direction){
		int length = 15;
		pen.up();
		pen.move(x,y);
		pen.setDirection(direction - 15);
		pen.down();
		pen.forward(length);
		pen.move(x,y);
		pen.setDirection(direction + 15);
		pen.forward(length);
		pen.up();
	}
	
	//Draws the Muller illusion
	public void drawMuller(int x, int y, int length){
		drawMullerIn(x,y,length);
		drawMullerOut(x,y,length);
	}
	
	//Draws the Muller line with both arrows pointing in
	public void drawMullerIn(int x, int y, int length){
		drawLine(x,y,length,180);
		drawArrow(x,y,180);
		drawArrow(x-length,y,0);
	}
	
	//Draws the Muller line with both arrows pointing out
	public void drawMullerOut(int x, int y, int length){
		drawLine(x,y-length,length,180);
		drawArrow(x,y-length,0);
		drawArrow(x-length,y-length,180);
	}
	
	//Adds the vertical lines to break the Muller illusion.  This will draw 
	//the whole thing.  A separate call to drawMuller is not needed.
	public void drawVerticals(int x, int y, int distance){
		drawMuller(x,y,distance);
		
		drawLine(x,y,distance,270);
		drawLine(x-distance,y,distance,270);
		
	}
	
	//Draws the Ponzo illusion
	public void drawPonzo(){
		pen.setWidth(3);
		drawLine(-20,50,100,270);
		drawLine(30,50,100,270);
		pen.setWidth(1);
		
		int y = -25;
		int x = -300;
		drawLine(x,y,500,20);
		drawLine(x,y+5,500,16);
		drawLine(x,y+10,500,12);
		drawLine(x,y+15,500,8);
		drawLine(x,y+20,500,4);
		drawLine(x,y+25,500,0);
		drawLine(x,y+30,500,-4);
		drawLine(x,y+35,500,-8);
		drawLine(x,y+40,500,-12);
		drawLine(x,y+45,500,-16);
		drawLine(x,y+50,500,-20);
		
	}
}
