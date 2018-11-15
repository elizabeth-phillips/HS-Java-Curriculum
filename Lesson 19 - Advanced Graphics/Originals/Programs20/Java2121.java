// Java2121.java
// This program draws a straight line from the point where the mouse is clicked
// to the point where the mouse is released.  Additionally, the program stores the
// lines coordinate information in arrays so that all the lines are visible.


import java.applet.Applet;
import java.awt.*;


public class Java2121 extends Applet
{

	int[] startX,startY,endX,endY;
	int currentStartX,currentStartY,currentEndX,currentEndY;
	int lineCount;

	public void init()
	{
		startX = new int[100];
		startY = new int[100];
		endX = new int[100];
		endY = new int[100];
		lineCount = 0;
	}

	public void paint(Graphics g)
	{
		for (int k = 0; k < lineCount; k++)
			g.drawLine(startX[k],startY[k],endX[k],endY[k]);
		g.drawLine(currentStartX,currentStartY,currentEndX,currentEndY);
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		currentStartX = x;
		currentStartY = y;
		return true;
	}

	public boolean mouseDrag(Event e, int x, int y)
	{
		currentEndX = x;
		currentEndY = y;
		repaint();
		return true;
	}

	public boolean mouseUp(Event e, int x, int y)
	{
		startX[lineCount] = currentStartX;
		startY[lineCount] = currentStartY;
		endX[lineCount] = x;
		endY[lineCount] = y;
		lineCount++;
		repaint();
		return true;
	}

}




