
/**
 *  GraphicPolygon represents a RegularPolygon using a DrawingTool object.
 */

import gpdraw.*;

public class GraphicPolygon extends RegularPolygon{
	
	//Adds the new attributes we will need to represent the picture
	
private DrawingTool pen = new DrawingTool(new SketchPad(400,400));
	private double xPosition, yPosition;
	
	public GraphicPolygon(int numSides, double sideLength){
		super(numSides, sideLength);
		xPosition = 0;
		yPosition = 0;
	}
	
	public GraphicPolygon(int numSides, double sideLength, double x, double y){
		super(numSides, sideLength);
		xPosition = x;
		yPosition = y;
	}
	
	/** moveTo can change the location of a polygon to x, y
	 */
	public void moveTo(double x, double y){
		xPosition = x;
		yPosition = y;
	}
	
	/** Draw the polygon
	 */
	public void draw(){
		pen.up();
		pen.move(xPosition, yPosition);
		pen.setDirection(90);
		pen.move(getr());
		pen.turnRight(90);
		pen.move(getSideLength()/2);
		pen.turnRight(180-vertexAngle());
		
		pen.down();
		
		drawSides(getNumside());
	}
	
	//Recursively draw each side
	private void drawSides(int n){
		pen.move(getSideLength());
		pen.turnRight(180-vertexAngle());
		
		if(n > 0){
			drawSides(n-1);
		}
	}
	
}
