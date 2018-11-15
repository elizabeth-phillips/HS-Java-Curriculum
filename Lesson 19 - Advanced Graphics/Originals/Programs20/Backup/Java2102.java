// Java2102.java
// This program draws a series of pixels with the <drawRect> method.
// This approach may be better if large pixels are necessary.


import java.awt.*;

public class Java2102 extends java.applet.Applet
{
	public void paint(Graphics g)
	{
		for (int x=100, y=100; x <= 500; x+=5, y+=5)
			g.fillRect(x,y,2,2);
	}

}

