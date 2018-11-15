// Java2106.java
// This program draws a pentagon with the <fillPolygon> method.
// This example uses arrays of x and y coordinates with the fillPolygon method.


import java.awt.*;
import java.applet.*;


public class Java2106 extends Applet
{
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		int xCoord[] = {400,550,500,300,250};
		int yCoord[] = {70,200,350,350,200};
		g.fillPolygon(xCoord,yCoord,5);
	}
}

