// Java2107.java
// This program draws a sequence of connected lines with the the <drawPolyline> method.


import java.awt.*;
import java.applet.*;


public class Java2107 extends Applet
{
	public void paint(Graphics g)
	{
		g.setColor(Color.blue);
		int xCoord[] = {400,550,500,300,250};
		int yCoord[] = {70,200,350,350,200};
		g.drawPolyline(xCoord,yCoord,5);
	}
}

