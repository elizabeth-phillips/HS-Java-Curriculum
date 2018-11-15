// Java2131.java
// This program draws small squares using the <update> method rather than
// using arrays to store coordinate values.


import java.applet.Applet;
import java.awt.*;


public class Java2131 extends Applet
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

	public void update(Graphics g)
	{
		paint(g);
	}

}






