// Java2101.java
// This program draws a series of pixels with the <drawLine> method.
// This is accomplished by using the same start and end coordinates.


import java.awt.*;

public class Java2101 extends java.applet.Applet
{
	public void paint(Graphics g)
	{
		for (int x=100, y=100; x <= 500; x+=5, y+=5)
			g.drawLine(x,y,x,y);
	}

}

