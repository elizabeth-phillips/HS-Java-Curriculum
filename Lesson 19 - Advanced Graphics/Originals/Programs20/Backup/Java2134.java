// Java2134.java
// This program demonstrates displaying different images of different types.
// It also shows that gif, jpg and png files can be displayed.
// The bmp file will not display.


import java.awt.*;

public class Java2134 extends java.applet.Applet
{

	Image picture1, picture2, picture3, picture4;

	public void init()
	{
		picture1 = getImage(getDocumentBase(),"LSchram.gif");
		picture2 = getImage(getDocumentBase(),"JSchram.jpg");
		picture3 = getImage(getDocumentBase(),"ShortCircuit.bmp");
		picture4 = getImage(getDocumentBase(),"bunny.png");
	}

	public void paint(Graphics g)
	{
		g.drawImage(picture1,0,0,this);
		g.drawImage(picture2,300,0,this);
		g.drawImage(picture3,50,300,this);
		g.drawImage(picture4,400,400,this);
	}


}


