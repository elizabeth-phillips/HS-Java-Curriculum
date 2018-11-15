// Java2103.java
// This program introduces the <setFont(new Font(Type,Style,Size))> method.
// Type is either "Courier","TimesRoman", "Arial", or any other available font.
// Style is either BOLD, ITALIC or PLAIN.
// Size is the point value of the font.


import java.awt.*;

public class Java2103 extends java.applet.Applet
{
	public void paint(Graphics g)
	{
		g.drawString("Default Appearance with drawString",20,20);

		g.setFont(new Font("Courier",Font.PLAIN,20));
		g.drawString("Courier 20-point plain font",20,60);

		g.setFont(new Font("Courier",Font.BOLD,20));
		g.drawString("Courier 20-point bold font",20,100);

		g.setFont(new Font("TimesRoman",Font.PLAIN,36));
		g.drawString("Times Roman 36-point plain font",20,180);

		g.setFont(new Font("TimesRoman",Font.ITALIC,36));
		g.drawString("Times Roman 36-point italic font",20,260);

		g.setFont(new Font("Arial",Font.PLAIN,48));
		g.drawString("Arial 48-point plain font",20,360);

		g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 48));
		g.drawString("Arial 48-point bold and italic font",20,460);

		g.setFont(new Font("Qwerty",Font.PLAIN,24));
		g.drawString("Arial 24-point plain font substituted for non-existent Qwerty font",20,520);

	}
}


