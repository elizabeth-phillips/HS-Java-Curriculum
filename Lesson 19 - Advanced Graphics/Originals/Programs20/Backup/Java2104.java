// Java2104.java
// This program draws a circle using the <cos> and <sin> methods of the
// <Math> class.  It is simpler to use the <drawOval> method.
// This program will help to explain the next program.


import java.awt.*;

public class Java2104 extends java.applet.Applet
{
	public void paint(Graphics g)
	{
		int x,y;
		int radius = 100;
		int centerX = 200;
		int centerY = 200;
		g.setColor(Color.blue);
		for (double radian = 0; radian <= 2 * Math.PI; radian += 0.01)
		{
			x = (int) Math.round(Math.cos(radian) * radius) + centerX;
			y = (int) Math.round(Math.sin(radian) * radius) + centerY;
			g.drawLine(x,y,x,y);
		}
	}
}


