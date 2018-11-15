// Java2105.java
// This program draws a regular hexagon using the <cos> and <sin>
// methods of the <Math> class.


import java.awt.*;

public class Java2105 extends java.applet.Applet
{

	public void paint(Graphics g)
	{
		int radius = 100;
		int centerX = 200;
		int centerY = 200;
		double twoPI = 2 * Math.PI;
		g.setColor(Color.blue);
		int x1 = (int) Math.round(Math.cos(twoPI * 1/6) * radius) + centerX;
		int y1 = (int) Math.round(Math.sin(twoPI * 1/6) * radius) + centerY;
		int x2 = (int) Math.round(Math.cos(twoPI * 2/6) * radius) + centerX;
		int y2 = (int) Math.round(Math.sin(twoPI * 2/6) * radius) + centerY;
		int x3 = (int) Math.round(Math.cos(twoPI * 3/6) * radius) + centerX;
		int y3 = (int) Math.round(Math.sin(twoPI * 3/6) * radius) + centerY;
		int x4 = (int) Math.round(Math.cos(twoPI * 4/6) * radius) + centerX;
		int y4 = (int) Math.round(Math.sin(twoPI * 4/6) * radius) + centerY;
		int x5 = (int) Math.round(Math.cos(twoPI * 5/6) * radius) + centerX;
		int y5 = (int) Math.round(Math.sin(twoPI * 5/6) * radius) + centerY;
		int x6 = (int) Math.round(Math.cos(twoPI) * radius) + centerX;
		int y6 = (int) Math.round(Math.sin(twoPI) * radius) + centerY;

		Polygon hex = new Polygon();
		hex.addPoint(x1,y1);
		hex.addPoint(x2,y2);
		hex.addPoint(x3,y3);
		hex.addPoint(x4,y4);
		hex.addPoint(x5,y5);
		hex.addPoint(x6,y6);
		g.fillPolygon(hex);
	}

}

