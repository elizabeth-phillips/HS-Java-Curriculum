// Java2136.java
// This program attempts to cure the flickering caused by the
// ANIMATED gifs by using the update method.
// The output shows that for some animated gifs this will work,
// and for others it will make things worse.

// NOTE: Do not expect to get any "animation bonus points"
// for using ANIMATED gifs in any graphics project.
// You will lose points instead!


import java.awt.*;

public class Java2136 extends java.applet.Applet
{

	Image picture1, picture2, picture3, picture4, picture5, picture6;

	public void init()
	{
		picture1 = getImage(getDocumentBase(),"space.gif");
		picture2 = getImage(getDocumentBase(),"computer.gif");
		picture3 = getImage(getDocumentBase(),"gears.gif");
		picture4 = getImage(getDocumentBase(),"butterfly.gif");
		picture5 = getImage(getDocumentBase(),"pizza.gif");
		picture6 = getImage(getDocumentBase(),"jet.gif");
	}

	public void paint(Graphics g)
	{
		g.drawImage(picture1,100,100,this);
		g.drawImage(picture2,450,100,this);
		g.drawImage(picture3,700,100,this);
		g.drawImage(picture4,100,400,this);
		g.drawImage(picture5,400,350,this);
		g.drawImage(picture6,700,400,this);
	}

	public void update(Graphics g)
	{
		paint(g);
	}
}


