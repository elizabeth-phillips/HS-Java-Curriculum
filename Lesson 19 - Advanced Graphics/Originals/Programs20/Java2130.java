// Java2130.java
// This program adds the <update> methods which stabilizes the flicker of the
// Java1329.java program.


import java.applet.Applet;
import java.awt.*;


public class Java2130 extends Applet
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

	public void update(Graphics g)
	{
		paint(g);
	}

}






