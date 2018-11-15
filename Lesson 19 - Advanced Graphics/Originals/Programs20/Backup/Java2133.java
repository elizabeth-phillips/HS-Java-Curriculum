// Java2133.java
// This program demonstrates how display to a graphics image from a gif file
// at any x,y location on the screen.


import java.awt.*;

public class Java2133 extends java.applet.Applet
{

	Image picture;

	public void init()
	{
		picture = getImage(getDocumentBase(),"LSchram.gif");
	}

	public void paint(Graphics g)
	{
		g.drawImage(picture,0,0,this);
		g.drawImage(picture,600,150,this);
		g.drawImage(picture,300,400,this);
	}


}


