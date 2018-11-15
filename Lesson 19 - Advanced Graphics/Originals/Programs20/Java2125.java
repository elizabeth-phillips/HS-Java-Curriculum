// Java2125.java
// This program adds the <eraseSnowman> method to the <drawSnowman> method.
// The snowman is not visible because it is erased as quickly as it is drawn.


import java.awt.*;
import java.applet.*;



public class Java2125 extends Applet
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
    	for (int x = 20; x < 700; x += 100)
    	{
    		drawSnowman(g,x,200);
    		eraseSnowman(g,x,200);
    	}
	}

	public void drawSnowman(Graphics g, int x, int y)
	{
		g.setColor(Color.WHITE);
        g.fillOval(x+20,y,40,40);
        g.fillOval(x+10,y+35,60,60);
        g.fillOval(x,y+90,80,80);
	}

	public void eraseSnowman(Graphics g, int x, int y)
	{
		g.setColor(Color.BLACK);
		g.fillRect(x,y,80,170);
	}
}





