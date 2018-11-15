/**
 *  Circle: This class models a circle.  It can calculate the surface area
 *  and the circumference as well as drawing a representation of the    
 *  circle to the screen.
 */

import gpdraw.*;

public class Circle {

	private double PI = 3.14;
	private double myRadius;
	private int myX;
	private int myY;
	private DrawingTool pen;

	public Circle(){
		myRadius = 0;
		pen = new DrawingTool(new SketchPad(300,300));
	}
	
	public Circle(int x, int y, double r){
		myRadius = r;
		myX = x;
		myY = y;
		pen = new DrawingTool(new SketchPad(300,300));
	}
	
	public double calcCircumference(){
		return PI * 2 * myRadius;
	}
	
	public double calcArea(){
		return PI * myRadius * myRadius;
	}
	
	public void draw(){
		pen.up();
		pen.move(myX,myY);
		pen.down();
		pen.drawCircle(myRadius);
		pen.up();
	}
	
	public double getRadius(){
		return myRadius;
	}
	
	public int getX(){
		return myX;
	}
	
	public int getY(){
		return myY;
	}

}
