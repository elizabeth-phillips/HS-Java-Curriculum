// Java2128.java
// This program cures the animation problem on multi-colored backgrounds with
// virtual memory, buffer methods.


import java.awt.*;
import java.applet.*;
import java.util.*;



public class Java2128 extends Applet
{

	int appletWidth;		//  width of the Applet window
	int appletHeight;		//  height of the Applet window

    Image virtualMem;
	Graphics gBuffer;

	public void init()
	{
    	appletWidth = getWidth();
		appletHeight = getHeight();
		virtualMem = createImage(appletWidth,appletHeight);
		gBuffer = virtualMem.getGraphics();
	}

 	public void paint(Graphics g)
	{
    	for (int x = 20; x < 700; x += 5)
    	{
    		drawSnowman(g,x,200);
			delay(10);
		}
	}

	public void drawSnowman(Graphics g, int x, int y)
	{
		createBackGround();
		gBuffer.setColor(Color.WHITE);
        gBuffer.fillOval(x+20,y,40,40);
        gBuffer.fillOval(x+10,y+35,60,60);
        gBuffer.fillOval(x,y+90,80,80);
        g.drawImage (virtualMem,0,0, this);
	}

	public void createBackGround()
	{
	 	Random rnd = new Random(12345);
	 	for (int k = 1; k <= 1000; k++)
	 	{
	 		int rndX = rnd.nextInt(750);
	 		int rndY = rnd.nextInt(550);
	 		gBuffer.setColor(new Color(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)));
	 		gBuffer.fillRect(rndX,rndY,50,50);
	 	}
	}

	public void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.currentTimeMillis();
	}


}

