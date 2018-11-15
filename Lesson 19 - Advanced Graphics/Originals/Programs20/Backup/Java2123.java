// Java2123.java
// This program creates an applet window with a black background.


import java.awt.*;
import java.applet.Applet;



public class Java2123 extends Applet
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
	}

}

