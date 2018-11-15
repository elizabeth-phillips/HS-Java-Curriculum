// Java2127.java
// This program demonstrates that the "draw and erase" animation approach
// does not work on a multi-colored background.


import java.awt.*;
import java.applet.*;
import java.util.*;



public class Java2127 extends Applet
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
	    createBackGround(g);
       	for (int x = 20; x < 700; x += 10)
    	{
    		drawSnowman(g,x,200);
			delay(50);
    		eraseSnowman(g,x,200);
    	}
	}

	public void createBackGround(Graphics g)
	{
	 	Random rnd = new Random(12345);
	 	for (int k = 1; k <= 1000; k++)
	 	{
	 		int rndX = rnd.nextInt(750);
	 		int rndY = rnd.nextInt(550);
	 		g.setColor(new Color(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)));
	 		g.fillRect(rndX,rndY,50,50);
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
        g.fillOval(x+20,y,40,40);
        g.fillOval(x+10,y+35,60,60);
        g.fillOval(x,y+90,80,80);
	}

	public void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.currentTimeMillis();
	}
}





