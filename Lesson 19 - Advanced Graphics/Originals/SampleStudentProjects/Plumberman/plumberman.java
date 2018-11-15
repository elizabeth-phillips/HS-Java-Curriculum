import java.applet.Applet;
import java.awt.*;
import java.util.Random;

public class plumberman extends Applet
{
	int appletWidth;
	int appletHeight;
	Image virtualMem;
	Graphics gBuffer;
	Rectangle[][] matrix;
	Rectangle start;
	Rectangle flood;
	boolean flooded;
	boolean started;
	boolean stopped;
	boolean f;
	int row;
	int col;
	Pipes p;
	Time t;

	public void init()
	{
		appletWidth = size().width;
		appletHeight = size().height;
		virtualMem = createImage(appletWidth,appletHeight);
		gBuffer = virtualMem.getGraphics();
		p = new Pipes();
		flooded = false;
		started = false;
		stopped = false;
		f = false;
		start = new Rectangle(700,150,250,50);
		flood = new Rectangle(700,225,250,50);
		matrix = new Rectangle[6][6];
		t = new Time();
		int x, y, r, c;
		for (y = 51, r = 0; r < 6; y += 100, r++)
			for (x = 51, c = 0; c < 6; x += 100, c++)
				matrix[r][c] = new Rectangle(x,y,99,99);
	}

	public void update(Graphics g)
	{
		paint(g);
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		if (start.inside(x,y) && !started)
		{
			started = true;
			t.startClock();
			repaint();
		}
		else if (started && flood.inside(x,y))
		{
			f = true;
			repaint();
		}
		else if (started)
		{
			for (int r = 0; r < 6; r++)
				for (int c = 0; c < 6; c++)
					if (matrix[r][c].inside(x,y) && !flooded)
					{
						row = r;
						col = c;
						if (((Math.abs(r - p.nullR) == 1) && c == p.nullC) ||
							((Math.abs(c - p.nullC) == 1) && r == p.nullR))
							repaint();
						break;
					}
		}
		return true;
	}

	public void paint(Graphics g)
	{
		if (f || !flooded && (started && System.currentTimeMillis() - t.startTicks >= 120000))
		{
			play(getCodeBase(),"flush.wav");
			p.flood(g);
			flooded = true;
		}
		else if (started && !flooded)
		{
			play(getCodeBase(),"slide.wav");
			p.movePipe(g,row,col);
		}
		else if (!flooded)
		{
			p.background(gBuffer);
			p.displayPipes(gBuffer);
			g.drawImage(virtualMem,0,0,this);
		}
		if (started)
		{
			g.setColor(Color.black);
			g.setFont(new Font("Arial",20,20));
			g.drawString("GO! You have two",720,320);
			g.drawString("minutes to finish!",750,345);
		}
	}
}

class Pipes
{
	private Pipe[][] matrix;
	int nullR;
	int nullC;
	private int floodR;
	private int floodC;
	private int dir;

	public Pipes()
	{
		matrix = new Pipe[6][6];
		Random rand = new Random();
		int x, y, r, c;
		for (y = 50, r = 0; r < 6; y += 100, r++)
			for (x = 50, c = 0; c < 6; x += 100, c++)
				matrix[r][c] = new Pipe(x,y,rand.nextInt(7) + 1);
		matrix[0][0] = new Pipe(50,50,0);
		nullR = 0;
		nullC = 0;
		floodR = -1;
		floodC = 0;
		dir = 2;
	}

	public static void delay(double n)
	{
		for (double x = 0; x <= n; x += .01);
	}

	public void displayPipes(Graphics g)
	{
		int r, c;
		for (r = 0; r < 6; r++)
			for (c = 0; c < 6; c++)
				matrix[r][c].displayPipe(g,matrix[r][c].xCoord,matrix[r][c].yCoord);
		g.setColor(Color.black);
		g.drawRect(50,50,600,600);
		g.setColor(Color.white);
		g.drawLine(86,50,114,50);
		g.drawLine(586,650,614,650);
	}

	public void background(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(new GradientPaint(0,0,new Color(225,225,225),1000,700,Color.lightGray,true));
		g2.fillRect(0,0,1000,700);
		g.setColor(Color.white);
		g.fillRect(85,0,30,51);
		g.fillRect(585,650,30,51);
		g.setColor(Color.black);
		g.drawLine(85,0,85,50);
		g.drawLine(115,0,115,50);
		g.drawLine(585,650,585,700);
		g.drawLine(615,650,615,700);
		g.drawLine(100,10,100,40);
		g.drawLine(95,35,100,40);
		g.drawLine(105,35,100,40);
		g.drawLine(600,660,600,690);
		g.drawLine(595,685,600,690);
		g.drawLine(605,685,600,690);
		g.setColor(Color.black);
		g.setFont(new Font("Arial" + "BOLD",50,50));
		g.drawString("Plumberman",685,60);
		g.setFont(new Font("Arial",25,25));
		g.drawString("by: Andrew Dittman",710,100);
		g.setFont(new Font("Arial",10,10));
		g.drawString("AP Computer Science, May, 2005",785,125);
		Graphics2D g3 = (Graphics2D) g;
		g3.setPaint(new GradientPaint(700,0,Color.lightGray,1000,700,Color.gray,true));
		g3.fillRect(700,150,250,50);
		g3.fillRect(700,225,250,50);
		g.setColor(Color.black);
		g.drawRect(700,150,250,50);
		g.drawRect(700,225,250,50);
		g.setFont(new Font("Arial",40,40));
		g.drawString("START",760,190);
		g.drawString("FLOOD",760,265);
	}

	public void movePipe(Graphics g, int r, int c)
	{
		if ((Math.abs(r - nullR) == 1) && c == nullC)
		{
			int yInt = nullR - r;
			for (int y = matrix[r][c].yCoord; y != matrix[nullR][nullC].yCoord; y += yInt)
			{
				matrix[r][c].displayPipe(g,matrix[r][c].xCoord,y);
				g.setColor(Color.white);
				if (nullR > r)
					g.drawLine(matrix[r][c].xCoord + 1,y,matrix[r][c].xCoord + 99,y);
				else
					g.drawLine(matrix[r][c].xCoord + 1,y + 100,matrix[r][c].xCoord + 99,y + 100);
				delay(2000);
			}
			swapPipes(r,c);
		}
		else if ((Math.abs(c - nullC) == 1) && r == nullR)
		{
			int xInt = nullC - c;
			for (int x = matrix[r][c].xCoord; x != matrix[nullR][nullC].xCoord; x += xInt)
			{
				matrix[r][c].displayPipe(g,x,matrix[r][c].yCoord);
				g.setColor(Color.white);
				if (nullC > c)
					g.drawLine(x,matrix[r][c].yCoord + 1,x,matrix[r][c].yCoord + 99);
				else
					g.drawLine(x + 100,matrix[r][c].yCoord + 1,x + 100,matrix[r][c].yCoord + 99);
				delay(2000);
			}
			swapPipes(r,c);
		}
		displayPipes(g);
	}

	public void swapPipes(int r, int c)
	{
		int tempX = matrix[nullR][nullC].xCoord;
		int tempY = matrix[nullR][nullC].yCoord;
		Pipe temp = matrix[nullR][nullC];
		matrix[nullR][nullC].xCoord = matrix[r][c].xCoord;
		matrix[nullR][nullC].yCoord = matrix[r][c].yCoord;
		matrix[nullR][nullC] = matrix[r][c];
		matrix[r][c].xCoord = tempX;
		matrix[r][c].yCoord = tempY;
		matrix[r][c] = temp;
		nullR = r;
		nullC = c;
	}

	public void flood(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(new GradientPaint(50,50,Color.green,600,600,new Color(0,200,0),true));
		for (int y = 0; y <= 50; y++)
		{
			g2.drawLine(86,y,114,y);
			delay(2000);
		}
		while (floodNext())
		{
			matrix[floodR][floodC].floodStraightPipe(g2,dir);
			matrix[floodR][floodC].floodCurvedPipe(g2,dir);
			changeDirection();
			matrix[floodR][floodC].floodCurvedPipe2(g2,dir);
		}
		if (floodR == 5 && floodC == 5 && dir == 2)
		{
			for (int y = 650; y <= 700; y++)
			{
				g2.drawLine(586,y,614,y);
				delay(2000);
			}
			g.setColor(Color.black);
			g.setFont(new Font("Arial",Font.BOLD,72));
			g.drawString("You",280,340);
			g.drawString("Win",285,410);
		}
		else
		{
			int c, s;
			for (c = 350, s = 0; c >= 50; c-=2, s += 2)
				for (int k = 0; k <= s * 2; k += 2)
				{
					g.drawLine(c+k,c,c+k,c);
					g.drawLine(c+k,700 - c,c+k,700 - c);
					g.drawLine(c,c+k,c,c+k);
					g.drawLine(700 - c,c+k,700 - c,c+k);
				}
			g.setColor(Color.black);
			g.setFont(new Font("Arial",Font.BOLD,72));
			g.drawString("Game",253,340);
			g.drawString("Over",268,410);
		}
	}

	public boolean floodNext()
	{
		int pipe;
		boolean floodNext = false;
		if (dir == 1 && floodR - 1 >= 0)
		{
			pipe = matrix[floodR - 1][floodC].pipe;
			if (pipe == 2 || pipe == 3 || pipe == 5 || pipe == 6)
			{
				floodNext = true;
				floodR--;
			}
		}
		else if (dir == 2 && floodR + 1 < 6)
		{
			pipe = matrix[floodR + 1][floodC].pipe;
			if (pipe == 2 || pipe == 3 || pipe == 4 || pipe == 7)
			{
				floodNext = true;
				floodR++;
			}
		}
		else if (dir == 3 && floodC + 1 < 6)
		{
			pipe = matrix[floodR][floodC + 1].pipe;
			if (pipe == 1 || pipe == 3 || pipe == 6 || pipe == 7)
			{
				floodNext = true;
				floodC++;
			}
		}
		else if (dir == 4 && floodC - 1 >= 0)
		{
			pipe = matrix[floodR][floodC - 1].pipe;
			if (pipe == 1 || pipe == 3 || pipe == 4 || pipe == 5)
			{
				floodNext = true;
				floodC--;
			}
		}
		return floodNext;
	}

	public void changeDirection()
	{
		int pipe = matrix[floodR][floodC].pipe;
		if (pipe == 4 && dir == 4)
			dir = 1;
		else if (pipe == 4 && dir == 2)
			dir = 3;
		else if (pipe == 5 && dir == 1)
			dir = 3;
		else if (pipe == 5 && dir == 4)
			dir = 2;
		else if (pipe == 6 && dir == 3)
			dir = 2;
		else if (pipe == 6 && dir == 1)
			dir = 4;
		else if (pipe == 7 && dir == 3)
			dir = 1;
		else if (pipe == 7 && dir == 2)
			dir = 4;
	}
}

class Pipe
{
	int xCoord;
	int yCoord;
	int pipe;

	public Pipe(int x, int y, int p)
	{
		xCoord = x;
		yCoord = y;
		pipe = p;
	}

	public void displayPipe(Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(new GradientPaint(50,50,Color.lightGray,600,600,new Color(225,225,225),true));
		if (pipe == 0)
			{
				g.setColor(Color.white);
				g.fillRect(x + 1,y + 1,99,99);
			}
			else if (pipe == 1)
				hPipe(g,x,y);
			else if (pipe == 2)
				vPipe(g,x,y);
			else if (pipe == 3)
				cPipe(g,x,y);
			else if (pipe == 4)
				ne90Pipe(g,x,y);
			else if (pipe == 5)
				se90Pipe(g,x,y);
			else if (pipe == 6)
				sw90Pipe(g,x,y);
			else if (pipe == 7)
				nw90Pipe(g,x,y);
	}

	private void hPipe(Graphics g, int x, int y)
	{
		g.setColor(Color.lightGray);
		g.fillRect(x,y,100,100);
		g.setColor(Color.white);
		g.fillRect(x,y + 35,100,30);
		g.setColor(Color.gray);
		g.drawRect(x,y,100,35);
		g.drawRect(x,y + 65,100,35);
	}

	private void vPipe(Graphics g, int x, int y)
	{
		g.setColor(Color.lightGray);
		g.fillRect(x,y,100,100);
		g.setColor(Color.white);
		g.fillRect(x + 35,y,30,100);
		g.setColor(Color.gray);
		g.drawRect(x,y,35,100);
		g.drawRect(x + 65,y,35,100);
	}

	private void cPipe(Graphics g, int x, int y)
	{
		g.setColor(Color.lightGray);
		g.fillRect(x,y,100,100);
		g.setColor(Color.white);
		g.fillRect(x,y + 35,100,30);
		g.fillRect(x + 35,y,30,100);
		g.setColor(Color.gray);
		g.drawRect(x,y,35,35);
		g.drawRect(x + 65,y,35,35);
		g.drawRect(x,y + 65,35,35);
		g.drawRect(x + 65,y + 65,35,35);
		g.drawLine(x + 35,y,x + 35,y + 100);
		g.drawLine(x + 65,y,x + 65,y + 100);
	}

	private void ne90Pipe(Graphics g, int x, int y)
	{
		g.setColor(Color.lightGray);
		g.fillRect(x,y,100,100);
		g.setColor(Color.white);
		g.fillRect(x + 35,y,30,65);
		g.fillRect(x + 35,y + 35,65,30);
		g.setColor(Color.gray);
		g.drawRect(x + 65,y,35,35);
		Polygon p = new Polygon();
		p.addPoint(x,y);
		p.addPoint(x,y + 100);
		p.addPoint(x + 100,y + 100);
		p.addPoint(x + 100,y + 65);
		p.addPoint(x + 35,y + 65);
		p.addPoint(x + 35,y);
		g.drawPolygon(p);
	}

	private void se90Pipe(Graphics g, int x, int y)
	{
		g.setColor(Color.lightGray);
		g.fillRect(x,y,100,100);
		g.setColor(Color.white);
		g.fillRect(x + 35,y + 35,65,30);
		g.fillRect(x + 35,y + 35,30,65);
		g.setColor(Color.gray);
		g.drawRect(x + 65,y + 65,35,35);
		Polygon p = new Polygon();
		p.addPoint(x,y);
		p.addPoint(x,y + 100);
		p.addPoint(x + 35,y + 100);
		p.addPoint(x + 35,y + 35);
		p.addPoint(x + 100,y + 35);
		p.addPoint(x + 100,y);
		g.drawPolygon(p);
	}

	private void sw90Pipe(Graphics g, int x, int y)
	{
		g.setColor(Color.lightGray);
		g.fillRect(x,y,100,100);
		g.setColor(Color.white);
		g.fillRect(x,y + 35,65,30);
		g.fillRect(x + 35,y + 35,30,65);
		g.setColor(Color.gray);
		g.drawRect(x,y + 65,35,35);
		Polygon p = new Polygon();
		p.addPoint(x,y);
		p.addPoint(x + 100,y);
		p.addPoint(x + 100,y + 100);
		p.addPoint(x + 65,y + 100);
		p.addPoint(x + 65,y + 35);
		p.addPoint(x,y + 35);
		g.drawPolygon(p);
	}

	private void nw90Pipe(Graphics g, int x, int y)
	{
		g.setColor(Color.lightGray);
		g.fillRect(x,y,100,100);
		g.setColor(Color.white);
		g.fillRect(x,y + 35,65,30);
		g.fillRect(x + 35,y,30,65);
		g.setColor(Color.gray);
		g.drawRect(x,y,35,35);
		Polygon p = new Polygon();
		p.addPoint(x + 100,y + 100);
		p.addPoint(x + 100,y);
		p.addPoint(x + 65,y);
		p.addPoint(x + 65,y + 65);
		p.addPoint(x,y + 65);
		p.addPoint(x,y + 100);
		g.drawPolygon(p);
	}

	public void floodStraightPipe(Graphics2D g, int dir)
	{
		if (pipe < 4)
		{
			if (dir == 1)
			{
				for (int y = yCoord + 100; y >= yCoord; y--)
				{
					g.drawLine(xCoord + 36,y,xCoord + 64,y);
					delay(2000);
				}
			}
			else if (dir == 2)
			{
				for (int y = yCoord; y <= yCoord + 100; y++)
				{
					g.drawLine(xCoord + 36,y,xCoord + 64,y);
					delay(2000);
				}
			}
			else if (dir == 3)
			{
				for (int x = xCoord; x <= xCoord + 100; x++)
				{
					if (pipe != 3 || x < xCoord + 35 || x > xCoord + 65)
						g.drawLine(x,yCoord + 36,x,yCoord + 64);
					delay(2000);
				}
			}
			else if (dir == 4)
			{
				for (int x = xCoord + 100; x >= xCoord; x--)
				{
					if (pipe != 3 || x < xCoord + 35 || x > xCoord + 65)
						g.drawLine(x,yCoord + 36,x,yCoord + 64);
					delay(2000);
				}
			}
		}
	}

	public void floodCurvedPipe(Graphics2D g, int dir)
	{
		if (pipe > 3)
		{
			if (dir == 1)
			{
				for (int y = yCoord + 100; y >= yCoord + 36; y--)
				{
					g.drawLine(xCoord + 36,y,xCoord + 64,y);
					delay(2000);
				}
			}
			else if (dir == 2)
			{
				for (int y = yCoord; y <= yCoord + 64; y++)
				{
					g.drawLine(xCoord + 36,y,xCoord + 64,y);
					delay(2000);
				}
			}
			else if (dir == 3)
			{
				for (int x = xCoord; x <= xCoord + 64; x++)
				{
					g.drawLine(x,yCoord + 36,x,yCoord + 64);
					delay(2000);
				}
			}
			else if (dir == 4)
			{
				for (int x = xCoord + 100; x >= xCoord + 36; x--)
				{
					g.drawLine(x,yCoord + 36,x,yCoord + 64);
					delay(2000);
				}
			}
		}
	}

	public void floodCurvedPipe2(Graphics2D g, int dir)
	{
		if (pipe > 3)
		{
			if (dir == 1)
			{
				for (int y = yCoord + 36; y >= yCoord; y--)
				{
					g.drawLine(xCoord + 36,y,xCoord + 64,y);
					delay(2000);
				}
			}
			else if (dir == 2)
			{
				for (int y = yCoord + 64; y <= yCoord + 100; y++)
				{
					g.drawLine(xCoord + 36,y,xCoord + 64,y);
					delay(2000);
				}
			}
			else if (dir == 3)
			{
				for (int x = xCoord + 64; x <= xCoord + 100; x++)
				{
					g.drawLine(x,yCoord + 36,x,yCoord + 64);
					delay(2000);
				}
			}
			else if (dir == 4)
			{
				for (int x = xCoord + 36; x >= xCoord; x--)
				{
					g.drawLine(x,yCoord + 36,x,yCoord + 64);
					delay(2000);
				}
			}
		}
	}

	public static void delay(double n)
	{
		for (double x = 0; x <= n; x += .01);
	}
}

class Time
{
	long startTicks;
	long endTicks;

	public Time()
	{
		startTicks = 0;
		endTicks = 0;
	}

	public void startClock()
	{
		startTicks = System.currentTimeMillis();
	}

	public void stopClock()
	{
		endTicks = System.currentTimeMillis();
	}
}