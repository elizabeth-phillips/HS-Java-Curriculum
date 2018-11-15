// Java2118.java
// This program proves that objects of the <Rectangle> class are abstract to the viewer and
// not visible.  The three square are intentionally not displayed.  The program still works
// like the previous program, but you must guess at the location of the squares.


import java.applet.Applet;
import java.awt.*;


public class Java2118 extends Applet
{
	Rectangle red, green, blue;
	int numColor;

	public void init()
	{
		red = new Rectangle(50,50,100,100);
		green = new Rectangle(50,200,100,100);
		blue = new Rectangle(50,350,100,100);
		numColor = 0;
	}

	public void paint(Graphics g)
	{
		switch (numColor)
		{
			case 1:
				g.setColor(Color.red);
				g.drawString("Mouse clicked inside red", 200,75);
				break;
			case 2:
				g.setColor(Color.green);
				g.drawString("Mouse clicked inside green", 200,225);
				break;
			case 3:
				g.setColor(Color.blue);
				g.drawString("Mouse clicked inside blue", 200,375);
				break;
			case 4:
				g.setColor(Color.black);
				g.drawString("Mouse is clicked outside the colored squares", 50,20);
				break;
		}

	}


	public boolean mouseDown(Event e, int x, int y)
	{
		if(red.inside(x,y))
			numColor = 1;
		else if(green.inside(x,y))
			numColor = 2;
		else if(blue.inside(x,y))
			numColor = 3;
		else
			numColor = 4;
		repaint();
		return true;
	}

}






