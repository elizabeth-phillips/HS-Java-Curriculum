// Java2137.java
// This program attempts to display multiple pages of graphics output.
// The program does not compile because there is no access to the graphics object g.


import java.awt.*;

public class Java2137 extends java.applet.Applet
{

	int numClicks;

	public void init()
	{
		numClicks = 0;
	}

	public void paint(Graphics g)
	{

	}

	public boolean mouseDown(Event e, int x, int y)
	{
		numClicks++;

		switch (numClicks)
		{
			case 0:	g.drawString("TITLE PAGE",200,100); break;
			case 1: g.drawString("PAGE 2",200,300); break;
			case 2: g.drawString("PAGE 3",200,500); break;
		}
		repaint();
		return true;
	}
}


