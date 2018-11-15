// Java2110.java
// This program counts the number of times a mouse is clicked.
// Both left-clicks and right-clicks are counted.
// using the <mouseDown> method. Ignore the "deprecated API" warning.


import java.applet.Applet;
import java.awt.*;


public class Java2110 extends Applet
{
	int numClicks;

	public void init()
	{
		numClicks = 0;
	}

	public void paint(Graphics g)
	{
		g.drawString("Mouse is clicked " + numClicks + " times.",20,20);
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		numClicks++;
		repaint();
		return true;
	}

}


