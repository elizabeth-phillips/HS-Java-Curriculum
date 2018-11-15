// Java2124.java
// This program introduces the <drawSnowman> method.


import java.awt.*;
import java.applet.*;


public class Java2124 extends Applet
{
	int appletWidth;		//  width of the Applet window
	int appletHeight;		//  height of the Applet window

	public void init()
    {
    	appletWidth = getWidth();
		appletHeight = getHeight();
    }

 	public void paint(Graphics g)
	{
	    g.setColor(Color.BLACK);
    	g.fillRect(0,0,appletWidth,appletHeight);
    	drawSnowman(g,20,200);
	}

	public void drawSnowman(Graphics g, int x, int y)
	{
		g.setColor(Color.WHITE);
        g.fillOval(x+20,y,40,40);
        g.fillOval(x+10,y+35,60,60);
        g.fillOval(x,y+90,80,80);
	}

}





