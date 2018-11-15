// Java2114.java
// This program displays the position of the mouse every time it moves
// using the <mouseMove> method.


import java.applet.Applet;
import java.awt.*;


public class Java2114 extends Applet
{
	int xCoord, yCoord;

	public void paint(Graphics g)
	{
		g.drawString("Mouse is located at (" + xCoord + "," + yCoord + ")",20,20);
	}

	public boolean mouseMove(Event e, int x, int y)
	{
		xCoord = x;
		yCoord = y;
		repaint();
		return true;
	}

}


