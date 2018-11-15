// Java2115.java
// This program draws a small square at every mouse click position.


import java.applet.Applet;
import java.awt.*;


public class Java2115 extends Applet
{
	int xCoord;
	int yCoord;
	boolean firstPaint;

	public void init()
	{
		firstPaint = true;
	}

	public void paint(Graphics g)
	{
		if (firstPaint)
			firstPaint = false;
		else
		{
			g.setColor(Color.red);
			g.fillRect(xCoord,yCoord,15,15);
		}
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		xCoord = x;
		yCoord = y;
		repaint();
		return true;
	}

}






