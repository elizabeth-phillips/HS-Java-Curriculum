// Beau yoder and Clayton Anderson
// The Awesome Graphics Project of Uberness
// Version 1.01
// Made slower by Mr. John Schram 06-10-10 to account for faster computers and slower parents.


import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet;
import java.awt.image.*;
import java.util.*;
import java.net.*;

public class Frogger extends Applet implements KeyListener, FocusListener
{
	public int x = 400;
	public int y = 575;
	public int Logx = -250;
	public int Logy = 100;
	public int Logx2 = 1000;
	public int Logy2 = 150;
	public int Logx3 = -150;
	public int Logy3 = 200;
	public int Logx4 = 150;
	public int Logy4 = 250;
	public int Logx1a = 300;
	public int Logy1a = 100;
	public int Logx2a = 350;
	public int Logy2a = 150;
	public int Logx3a = 300;
	public int Logy3a = 200;
	public int Logx4a = 750;
	public int Logy4a = 250;
	boolean home1 = false; boolean home2 = false;
	boolean home3 = false; boolean home4 = false;
	boolean home5 = false;
	boolean focus = false;
	boolean isit = false;
	public int face = 1;
	Graphics gBuffer;
	Image virtualMem;
	public int carx = -200; public int cary = 502;
	public int carx2= 400;  public int cary2= 502;
	public int carx3 = 900; public int cary3 = 452;
	public int carx4 = 500; public int cary4 = 452;
	public int carx5 = 150; public int cary5 = 402;
	public int carx6 = 600; public int cary6 = 402;
	public int carx7 = 850; public int cary7 = 352;
	public int carx8 = 200; public int cary8 = 352;
	Random rnd = new Random();
	public int speed = -3;
	public int lives = 7;

	public void init()
	{
		System.out.println("Created by Clayton Anderson & Beau yoder- version 1.0");
		System.out.println();
		virtualMem = createImage(800,600);
		gBuffer = virtualMem.getGraphics();
		addKeyListener(this);
		addFocusListener(this);
		play(getCodeBase(), "frog.wav");
	//	play(getCodeBase(), "froggermedley.mid");
	}

	public void update(Graphics g)
	{
		virtualMem = createImage(800,600);
		gBuffer = virtualMem.getGraphics();
		paint(gBuffer);
		g.drawImage(virtualMem,0,0,this);
		move(g);
	}
	public void paint(Graphics g)
	{
		drawBackground(g);
		g.setColor(Color.black);
		if (!focus) g.drawString("Click in the window to begin.",320,325);
		g.drawString("Lives: " + lives, 5,580);
		drawCar(g,carx,cary);
		drawCar(g,carx2,cary2);
		drawCar2(g,carx3,cary3);
		drawCar2(g,carx4,cary4);
		drawCar3(g,carx5,cary5);
		drawCar3(g,carx6,cary6);
		drawCar4(g,carx7,cary7);
		drawCar4(g,carx8,cary8);
		drawLog(g,Logx,Logy);
		drawLog(g,Logx1a,Logy1a);
		drawLog(g,Logx2,Logy2);
		drawLog(g,Logx2a,Logy2a);
		drawLog(g,Logx3,Logy3);
		drawLog(g,Logx3a,Logy3a);
		drawLog(g,Logx4,Logy4);
		drawLog(g,Logx4a,Logy4a);
		drawFrog(g,x,y);
		checkHome(g);
		delay(30);
		repaint();
	}

	public void drawBackground(Graphics g)
	{
		gBuffer.setColor(new Color(147,73,0));
		gBuffer.fillRect(0,0,800,100);
		gBuffer.setColor(new Color(36,70,232));
		gBuffer.fillRect(0,100,800,200);
		gBuffer.setColor(Color.green);
		gBuffer.fillRect(0,300,800,50);
		gBuffer.setColor(Color.gray);
		gBuffer.fillRect(0,350,800,200);
		gBuffer.setColor(Color.green);
		gBuffer.fillRect(0,550,800,50);
		gBuffer.setColor(new Color(247,222,49));
		gBuffer.fillRect(0,444,800,5);
		gBuffer.fillRect(0,451,800,5);
		for(int x=0;x<=800;x+=50)
		{

			gBuffer.fillRect(x,400,25,1);
			gBuffer.fillRect(x,500,25,1);
		}
		gBuffer.setColor(new Color(30,30,30));
		for(int x=0;x<800;x+=150)
		{
			gBuffer.fillRect(x+75,50,50,50);
		}
		drawHome(g,home1,80);
		drawHome(g,home2,230);
		drawHome(g,home3,380);
		drawHome(g,home4,530);
		drawHome(g,home5,680);
		g.drawImage (virtualMem,0,0, this);
	}

	public void drawFrog(Graphics g, int x, int y)
	{
		gBuffer.setColor(new Color(0,120,0));
		if (face == 1)
		{
			gBuffer.fillRect(x,y,5,10);
			gBuffer.fillRect(x+10,y,5,5);
			gBuffer.fillRect(x+5,y+5,15,15);
			gBuffer.fillRect(x+20,y,5,10);
			gBuffer.fillRect(x,y+15,5,10);
			gBuffer.fillRect(x+20,y+15,5,10);
		}
		if (face == 2)
		{
			gBuffer.fillRect(x,y,10,5);
			gBuffer.fillRect(x+15,y,10,5);
			gBuffer.fillRect(x+5,y+5,15,15);
			gBuffer.fillRect(x+15,y+20,10,5);
			gBuffer.fillRect(x,y+10,5,5);
			gBuffer.fillRect(x,y+20,10,5);
		}
		if (face == 3)
		{
			gBuffer.fillRect(x,y,5,10);
			gBuffer.fillRect(x+5,y+5,15,15);
			gBuffer.fillRect(x,y+15,5,10);
			gBuffer.fillRect(x+20,y,5,10);
			gBuffer.fillRect(x+10,y+20,5,5);
			gBuffer.fillRect(x+20,y+15,5,10);
		}
		if (face == 4)
		{
			gBuffer.fillRect(x,y,10,5);
			gBuffer.fillRect(x+15,y,10,5);
			gBuffer.fillRect(x+5,y+5,15,15);
			gBuffer.fillRect(x+20,y+10,5,5);
			gBuffer.fillRect(x,y+20,10,5);
			gBuffer.fillRect(x+15,y+20,10,5);
		}

	}

	public void drawLog(Graphics g, int Logx, int Logy)
	{
		g.setColor(Color.black);
		g.drawRect(Logx-1,Logy-1,149,49);
		g.setColor(new Color(204,102,0));
		g.fillRect(Logx,Logy,148,48);
	}

	public void drawHome(Graphics g, boolean homeX, int a)
	{
		g.setColor(new Color(255,255,0));
		if (homeX==true)
		{
			g.fillOval(a,55,40,40);
			g.setColor(Color.black);
			g.fillOval(a+10,62,7,15);
			g.fillOval(a+23,62,7,15);
			g.fillArc(a+12,80,16,7,170,210);
		}
	}

	public void drawCar(Graphics g, int x, int y)
	{
		g.setColor(Color.red);
		g.fillRect(x,y,100,47);
		g.setColor(Color.black);
		g.drawRect(x-1,y-1,100,48);
		g.setColor(Color.blue);
		g.fillRect(x+58,y+8,20,30);
	}

	public void drawCar2(Graphics g, int x, int y)
	{
		g.setColor(new Color(100,100,100));
		g.fillRect(x,y,75,47);
		g.setColor(Color.black);
		g.drawRect(x-1,y-1,75,48);
		g.fillRect(x-25,y+5,25,35);

	}

	public void drawCar3(Graphics g, int x, int y)
	{
		g.setColor(Color.white);
		g.fillRect(x,y,150,47);
		g.setColor(Color.black);
		g.drawRect(x-1,y-1,152,48);
		g.setColor(new Color(150,150,150));
		g.fillRect(x+5,y+5,20,35);
		g.fillRect(x+125,y+5,20,35);
	}

	public void drawCar4(Graphics g, int x, int y)
	{
		g.setColor(new Color(39,174,32));
		g.fillRect(x+5,y+5,75,35);
		g.setColor(Color.black);
		g.drawRect(x+4,y+4,77,37);
		g.setColor(new Color(100,100,100));
		g.fillRect(x+10,y+10,10,25);

	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {x-=25; face = 2;}
		if (key == KeyEvent.VK_DOWN && y<575) {y+=25; face = 3;}
		if (key == KeyEvent.VK_RIGHT) {x+=25; face = 4;}
		if (key == KeyEvent.VK_UP && y>50) {y-=25; face = 1;}
	}

	public void focusGained(FocusEvent evt) {focus = true;}
	public void focusLost(FocusEvent evt) {focus = false;}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e) {}
	public void restart(Graphics g)
	{
		play(getCodeBase(), "squish.wav");
		x = 400;
		y = 575;
		lives--;
		if (lives == 0)
		{
			play(getCodeBase(), "boo.wav");
			abc(g,"LOSE");
			startOver(g);
		}
		face = 1;
	}

	public void abc(Graphics g, String wl)
	{
			g.setColor(Color.red);
			g.fillRect(0,0,800,600);
			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("YOU "+wl, 200, 300);
			delay(2000);
			startOver(g);
	}

	public void restartWater(Graphics g)
	{
		play(getCodeBase(), "splash.wav");
		x = 400;
		y = 575;
		lives--;
		if (lives == 0)
		{
			play(getCodeBase(), "boo.wav");
			abc(g,"LOSE");
		//	delay(2000);
			startOver(g);
		}
		face = 1;
	}

	public void restartYay(Graphics g)
	{
		play(getCodeBase(), "pop.wav");
		x = 400;
		y = 575;
		face = 1;
	}
	public void checkWater(Graphics g)
	{
		if (x>=0 && x<=775 && y>=100 && y<=275 && !(x>Logx&&x<Logx+125&&y>=Logy&&y<=Logy+25)
		  && !(x>=Logx2&&x<=Logx2+125&&y>=Logy2&&y<=Logy2+25) && !(x>=Logx3&&x<=Logx3+125&&y>=Logy3&&y<=Logy3+25)
		   && !(x>Logx1a&&x<Logx1a+125&&y>=Logy1a&&y<=Logy1a+25) && !(x>Logx2a&&x<Logx2a+125&&y>=Logy2a&&y<=Logy2a+25)
			&& !(x>Logx3a&&x<Logx3a+125&&y>=Logy3a&&y<=Logy3a+25) && !(x>Logx4&&x<Logx4+125&&y>=Logy4&&y<=Logy4+25)
			 && !(x>Logx4a&&x<Logx4a+125&&y>=Logy4a&&y<=Logy4a+25))
			restartWater(g);
	}
	public void checkHome(Graphics g)
	{
		if (x>=75&&x<=115&&y>=50&&y<=75) {home1 = true; drawHome(g,home1,80);restartYay(g);}
		if (x>=225&&x<=265&&y>=50&&y<=75) {home2 = true; drawHome(g,home2,230);restartYay(g);}
		if (x>=375&&x<=415&&y>=50&&y<=75) {home3 = true; drawHome(g,home3,380);restartYay(g);}
		if (x>=525&&x<=565&&y>=50&&y<=75) {home4 = true; drawHome(g,home4,530);restartYay(g);}
		if (x>=675&&x<=715&&y>=50&&y<=75) {home5 = true; drawHome(g,home5,680);restartYay(g);}

	}

	public void startOver(Graphics g)
	{
		x = 400;
		y = 575;
		home1 = false;
		home2 = false;
		home3 = false;
		home4 = false;
		home5 = false;
		lives = 5;
		face = 1;
	}

	public void move(Graphics g)
	{
		checkWater(g);

		if (x<0)
			restart(g);
		if (x>775)
			restart(g);
		if (y<50)
			restart(g);
		if (x<75 && y<100)
			restart(g);
		if (x>100 && x<225 && y<100)
			restart(g);
		if (x>250 && x<375 && y<100)
			restart(g);
		if (x>400 && x<525 && y<100)
			restart(g);
		if (x>550 && x<675 && y<100)
			restart(g);
		if (x>700 && y<100)
			restart(g);


		if(Logx >= 800)
			Logx=-200;
		if(x>=Logx && x<=Logx+125 && y>=Logy && y<=Logy+25)
			x+=speed + 5;
		Logx += speed + 5;

		if(Logx2 <= -200)
			Logx2=1000;
		if(x>=Logx2 && x<=Logx2+125 && y>=Logy2 && y<=Logy2+25)
			x-=speed + 10-4;
		Logx2 -=speed +10-4;

		if(Logx3 >= 850)
			Logx3=-200;
		if(x>=Logx3 && x<=Logx3+125 && y>=Logy3 && y<=Logy3+25)
			x+=speed +5;
		Logx3 +=speed +5;

		if(Logx1a >= 800)
			Logx1a=-200;
		if(x>=Logx1a && x<=Logx1a+125 && y>=Logy1a && y<=Logy1a+25)
			x+=speed + 5;
		Logx1a +=speed + 5;

		if(Logx2a <= -200)
			Logx2a=1000;
		if(x>=Logx2a && x<=Logx2a+125 && y>=Logy2a && y<=Logy2a+25)
			x-=speed +10-4;
		Logx2a -=speed +10-4;

		if(Logx3a >= 850)
			Logx3a=-200;
		if(x>=Logx3a && x<=Logx3a+125 && y>=Logy3a && y<=Logy3a+25)
			x+=speed + 5;
		Logx3a +=speed + 5;

		if(Logx4 <= -200)
			Logx4=1000;
		if(x>=Logx4 && x<=Logx4+125 && y>=Logy4 && y<=Logy4+25)
			x-=speed + 15-6;
		Logx4 -=speed + 15-6;

		if(Logx4a <= -200)
			Logx4a=1000;
		if(x>=Logx4a && x<=Logx4a+125 && y>=Logy4a && y<=Logy4a+25)
			x-=speed + 15-6;
		Logx4a -=speed + 15-6;

		if(carx >=850)
			carx=-200;
		if(x>=carx && x<=carx+100 && y>=cary-2 && y<=cary+45)
			restart(g);
		carx+=speed + 10-4;

		if(carx2 >=850)
			carx2=-200;
		if(x>=carx2 && x<=carx2+100 && y>=cary2-2 && y<=cary2+45)
			restart(g);
		carx2+=speed + 10-4;

		if(carx3 <=-150)
			carx3=900;
		if(x>=carx3-50 && x<=carx3+75 && y>=cary3-2 && y<=cary3+45)
			restart(g);
		carx3-=speed + 8;

		if(carx4 <=-150)
			carx4=900;
		if(x>=carx4-50 && x<=carx4+75 && y>=cary4-2 && y<=cary4+45)
			restart(g);
		carx4-=speed + 8;

		if(carx5 >=850)
			carx5=-200;
		if(x>=carx5 && x<=carx5+150 && y>=cary5-2 && y<=cary5+45)
			restart(g);
		carx5+= speed + 20-10;

		if(carx6 >=850)
			carx6=-200;
		if(x>=carx6 && x<=carx6+150 && y>=cary6-2 && y<=cary6+45)
			restart(g);
		carx6+=speed + 20-10;

		if(carx7 <=-150)
			carx7=900;
		if(x>=carx7 && x<=carx7+75 && y>=cary7-2 && y<=cary7+45)
			restart(g);
		carx7-=speed + 15-4;

		if(carx8 <=-150)
			carx8=900;
		if(x>=carx8 && x<=carx8+75 && y>=cary8-2 && y<=cary8+45)
			restart(g);
		carx8-=speed + 15-4;

		if(home1==true&&home2==true&&home3==true&&home4==true&&home5==true)
		{
	//		play(getCodeBase(), "win.wav");
			abc(g,"WIN");
			speed+=1;
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