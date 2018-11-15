// Java2138.java
// This program attempts to display multiple pages of graphics output.
// While adding the "Graphics g" in the mouseDown parameter list allows
// the program to compile, it also makes it no longer the mouseDown EVENT.
// Now you have a mouseDown METHOD that has no way of being called.


import java.awt.*;

public class Java2138 extends java.applet.Applet
{

	int numClicks;

	public void init()
	{
		numClicks = 0;
	}

	public void paint(Graphics g)
	{

	}

	public boolean mouseDown(Event e, int x, int y, Graphics g)
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


