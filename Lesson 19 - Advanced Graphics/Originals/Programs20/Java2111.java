// Java2111.java
// This program displays the position of the mouse every time it is clicked
// using the <mouseDown> method.


import java.applet.Applet;
import java.awt.*;


public class Java2111 extends Applet
{
	int xCoord, yCoord;

	public void paint(Graphics g)
	{
		g.drawString("Mouse clicked at (" + xCoord + "," + yCoord + ")",20,20);
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		xCoord = x;
		yCoord = y;
		repaint();
		return true;
	}

}


