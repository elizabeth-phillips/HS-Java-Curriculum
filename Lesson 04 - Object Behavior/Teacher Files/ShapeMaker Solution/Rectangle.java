import gpdraw.*;

public class Rectangle {
	
	private double myX;
	private double myY;
	private double myWidth;
	private double myHeight;
	private static DrawingTool pen;
	
	public Rectangle() {
		myX = 0;
		myY = 0;
		myWidth = 0;
		myHeight = 0;
		pen = new DrawingTool(new SketchPad(500,500));
	}
	
	public Rectangle(double x, double y, double width, double height) {
		myX = x;
		myY = y;
		myWidth = width;
		myHeight = height;
		pen = new DrawingTool(new SketchPad(500,500));
	}
	
	public double calcPerimeter(){
		return (2 * myWidth) + (2 * myHeight);
	}
	
	public double calcArea(){
		return myWidth * myHeight;
	}
	
	public void draw(){
		pen.up();
		pen.move(myX,myY);
		pen.down();
		pen.setDirection(0);
		pen.forward(myWidth);
		pen.setDirection(90);
		pen.forward(myHeight);
		pen.setDirection(180);
		pen.forward(myWidth);
		pen.setDirection(270);
		pen.forward(myHeight);
	}
	
	public double getX(){
		return myX;
	}
	
	public double getY(){
		return myY;
	}
	
	public double getWidth(){
		return myWidth;
	}
	
	public double getHeight(){
		return myHeight;
	}
}
