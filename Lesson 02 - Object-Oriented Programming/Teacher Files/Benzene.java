/**
 *  Benzene: This class will create a pencil and then draw a 
 *  benzene ring.
 */

     import gpdraw.*;
     public class Benzene{
    	private DrawingTool pencil;
  	private SketchPad paper;
  
	/**
      *  A basic constructor for Benzene that initializes paper *  and pencil to basic values.
	 */  
  	public Benzene(){
  		paper = new SketchPad(300, 300);
  		pencil = new DrawingTool(paper);
  	}
  	
  	/**
   	 *  The draw method for the Benzene class
     *
     */
  	public void draw(){
   
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

