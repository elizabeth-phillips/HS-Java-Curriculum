// Java2113.java
// This program determines if a mouse is clicked once or twice using the
// <clickCount> method.  This method works for the left or right botton.


import java.applet.Applet;
import java.awt.*;


public class Java2113 extends Applet
{
	boolean singleClick,doubleClick;

	public void paint(Graphics g)
	{
		if (singleClick)
			g.drawString("Mouse was clicked once",20,20);
		if (doubleClick)
			g.drawString("Mouse was clicked twice",20,20);
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		switch (e.clickCount)
		{
			case 1:
				singleClick = true; doubleClick = false;
				break;
			case 2:
				doubleClick = true; singleClick = false;
		}
		repaint();
		return true;
    }


}


