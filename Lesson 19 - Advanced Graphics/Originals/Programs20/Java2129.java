// Java2129.java
// This program uses virtual memory for a simple draw program.
// The program will flicker while drawing.


import java.applet.Applet;
import java.awt.*;


public class Java2129 extends Applet
{

	Image virtualMem;
	Graphics gBuffer;
	int oldX, oldY, newX, newY;
	int appletWidth;
	int appletHeight;

	public void init()
	{
		appletWidth = getWidth();
		appletHeight = getHeight();
		virtualMem = createImage(appletWidth,appletHeight);
		gBuffer = virtualMem.getGraphics();
		gBuffer.setColor(Color.white);
		gBuffer.fillRect(0,0,appletWidth,appletHeight);
	}

	public void paint(Graphics g)
	{
		gBuffer.setColor(Color.black);
		gBuffer.drawString("Move inside the applet to draw", 20,20);
		gBuffer.setColor(Color.blue);
		gBuffer.fillRect(oldX,oldY,2,2);
		g.drawImage(virtualMem,0,0,this);
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		newX = x;
		newY = y;
		oldX = newX;
		oldY = newY;
		repaint();
		return true;
	}

	public boolean mouseDrag(Event e, int x, int y)
	{
		newX = x;
		newY = y;
		oldX = newX;
		oldY = newY;
		repaint();
		return true;
	}

}






