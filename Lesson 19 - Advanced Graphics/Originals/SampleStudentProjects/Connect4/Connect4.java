import java.applet.Applet;
import java.awt.*;

public class Connect4 extends Applet
{
	Rectangle c1, c2, c3, c4, c5, c6, c7;
	int column;
	Board b;
	int player;
	
	public void init()
	{
		c1 = new Rectangle(0,0,114,798);
		c2 = new Rectangle(115,0,114,789);
		c3 = new Rectangle(229,0,114,798);
		c4 = new Rectangle(343,0,114,798);
		c5 = new Rectangle(458,0,114,798);
		c6 = new Rectangle(572,0,114,798);
		c7 = new Rectangle(686,0,114,798);
		b = new Board();
		player = 1;
	}
			
	public boolean mouseDown(Event e, int x, int y)
	{
		if(c1.inside(x,y))
			column = 1;
		else if(c2.inside(x,y))
			column = 2;
		else if(c3.inside(x,y))
			column = 3;
		else if(c4.inside(x,y))
			column = 4;
		else if(c5.inside(x,y))
			column = 5;
		else if(c6.inside(x,y))
			column = 6;
		else if(c7.inside(x,y))
			column = 7;
		else
			column = 0;
		repaint();
		return true;
	}

	public void paint(Graphics g)
	{
		if (b.titleScreen())
			b.displayTitleScreen(g);
		b.displayBoard(g);
		if (!b.isWon() && !b.check4Tie())
		{
			b.go(g, column, player);
			if (b.nextPlayer())
			{
				if (player == 1)
					player = 2;
				else
					player = 1;
			}
		}
		if (b.isWon() || b.check4Tie())
			b.winScreen(g);
	}
}

class Board
{
	private int board[][];
	private boolean win;
	private boolean tied;
	private boolean titleScreen;
	private boolean nextPlayer;
	private int winner;
	
	public Board()
	{
		board = new int[7][7];
		for (int r = 0; r < 7; r++)
			for (int c = 0; c < 7; c++)
				board[r][c] = 0;
		titleScreen = true;
	}
	
	public boolean isWon()
	{
		return win;
	}
	
	public boolean nextPlayer()
	{
		return nextPlayer;
	}
	
	public boolean titleScreen()
	{
		return titleScreen;
	}
	
	public void delay(double x)
	{
		for (double k = 0; k <= x; k += .05)
			k += .05;
	}
	
	public void displayTitleScreen(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0,0,800,600);
		g.setFont(new Font("Arial", Font.BOLD, 100));
		for (int k = 0; k <= 255; k++)
		{
			g.setColor(new Color(0,0,k));
			g.drawString("Connect 4",160,300);
			delay(10000);
		}
		g.setFont(new Font("Arial", Font.BOLD, 40));
		for (int k = 0; k <= 255; k++)
		{
			g.setColor(new Color(0,0,k));
			g.drawString("by: Andrew Dittman, 2004",160,375);
			delay(10000);
		}
		delay(2000000);
		g.setFont(new Font("Arial", Font.BOLD, 100));
		for (int k = 255; k >= 0; k--)
		{
			g.setColor(new Color(0,0,k));
			g.drawString("Connect 4",160,300);
			delay(10000);
		}
		g.setFont(new Font("Arial", Font.BOLD, 40));
		for (int k = 255; k >= 0; k--)
		{
			g.setColor(new Color(0,0,k));
			g.drawString("by: Andrew Dittman, 2004",160,375);
			delay(10000);
		}
		for (int k = 0; k <= 255; k++)
		{
			g.setColor(new Color(0,0,k));
			g.fillRect(0,0,800,600);
			delay(10000);
		}
		for (int k = 255; k >= 0; k--)
		{
			g.setColor(new Color(0,0,k));
			for (int q = 0; q <= 7; q++)
			{
				int x = (int)(Math.round(800.0 * (q / 7.0)));
				g.drawLine(x,0,x,600);
				int y = (int)(Math.round(600.0 * (q / 7.0)));
				g.drawLine(0,y,800,y);
			}
			delay(10000);
		}
		titleScreen = false;
	}
	
	public void displayBoard(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect(0,0,800,600);
		g.setColor(Color.black);
		for (int k = 0; k <= 7; k++)
		{
			int x = (int)(Math.round(800.0 * (k / 7.0)));
			g.drawLine(x,0,x,600);
			int y = (int)(Math.round(600.0 * (k / 7.0)));
			g.drawLine(0,y,800,y);
		}
		for (int row = 0; row < 7; row++)
			for (int col = 0; col < 7; col++)
			{
				if (board[row][col] == 1)
				{
					double r = (double)(row);
					double c = (double)(col);
					g.setColor(Color.red);
					g.fillOval((int)(Math.round(800 * c / 7 + 23)),(int)(600 * r / 7 + 7),70,70);
				}
				if (board[row][col] == 2)
				{
					double r = (double)(row);
					double c = (double)(col);
					g.setColor(Color.yellow);
					g.fillOval((int)(Math.round(800 * c / 7 + 23)),(int)(600 * r / 7 + 7),70,70);
				}
			}
	}
	
	public void go(Graphics g, int c, int p)
	{
		if ((1 <= c) && (c <= 7) && (board[0][c - 1] == 0))
		{
			c--;
			int r = 6;
			boolean dropped = false;
			do
			{
				if (board[r][c] == 0)
				{
					dropped = true;
					board[r][c] = p;
				}
				else
					r--;
			}
			while ((r >= 0) && (!dropped));
			drop(g, p, r, c);
			if (r >= 0)
				checkBoard();
		}
		else
			nextPlayer = false;
	}
	
	public void drop(Graphics g, int p, double r, double c)
	{
		nextPlayer = true;
		int k;
		for (k = -70; k <= (int)(600 * r / 7 + 7); k++)
		{
			if (p == 1)
				g.setColor(Color.red);
			else
				g.setColor(Color.yellow);
			g.fillOval((int)(Math.round(800 * c / 7 + 23)),k,70,70);
			delay(1500);
			g.setColor(Color.blue);
			g.fillOval((int)(Math.round(800 * c / 7 + 23)),k,70,70);
			g.setColor(Color.black);
			for (int q = 0; q <= 7; q++)
			{
				int x = (int)(Math.round(800.0 * (q / 7.0)));
				g.drawLine(x,0,x,600);
				int y = (int)(Math.round(600.0 * (q / 7.0)));
				g.drawLine(0,y,800,y);
			}
		}
		if (p == 1)
			g.setColor(Color.red);
		else
			g.setColor(Color.yellow);
		g.fillOval((int)(Math.round(800 * c / 7 + 23)),k,70,70);
	}
	
	public void winScreen(Graphics g)
	{
		delay(2000000);
		g.setColor(Color.black);
		double k;
		double x;
		int y;
		for (k = 0, x = 400, y = 300; x >= 0; k++, x -= 4.0 / 3.0, y--)
		{
			g.fillRect((int)(Math.round(x)),y,(int)(Math.round(k * 8.0 / 3.0)),(int)(k * 2));
			delay(10000);
		}
		g.setFont(new Font("Arial", Font.BOLD, 100));
		int color;
		if (win && (winner == 1))
		{
			for (color = 0; color <= 255; color++)
			{
				g.setColor(new Color(color,0,0));
				g.drawString("Player 1 Wins!",65,325);
				delay(10000);
			}
		}
		else if (win && (winner == 2))
		{
			for (color = 0; color <= 255; color++)
			{
				g.setColor(new Color(color,color,0));
				g.drawString("Player 2 Wins!",65,325);
				delay(10000);
			}
		}
		else
		{
			for (color = 0; color <= 255; color++)
			{
				g.setColor(new Color(0,0,color));
				g.drawString("It's a Tie!",190,325);
				delay(10000);
			}
		}
	}
	
	public boolean check4Tie()
	{
		int c = 0;
		tied = true;
		while (tied && c < 7)
		{
			if (board[0][c] == 0)
				tied = false;
			else
				c++;
		}
		return tied;
	}
	
	public void checkBoard()
	{
		for (int r = 0; r < 7; r++)
			for (int c = 1; c < 7; c++)
			{
				if (board[r][c] != 0)
				{
					if ((r - 3 >= 0) && (!win))
						checkN(r, c);
					if ((r + 3 <= 6) && (!win))
						checkS(r, c);
					if ((c - 3 >= 0) && (!win))
						checkE(r, c);
					if ((c + 3 <= 6) && (!win))
						checkW(r, c);
					if ((r - 3 >= 0) && (c - 3 >= 0) && (!win))
						checkNE(r, c);
					if ((r - 3 >= 0) && (c + 3 <= 6) && (!win))
						checkNW(r, c);
					if ((r + 3 <= 6) && (c - 3 >= 0) && (!win))
						checkSE(r, c);
					if ((r + 3 <= 6) && (c + 3 <= 6) && (!win))
						checkSW(r, c);
				}
			}
	}
	
	public void checkN(int r, int c)
	{
		if ((board[r][c] == board[r - 1][c]) && (board[r][c] == board[r - 2][c])
		&& (board[r][c] == board[r - 3][c]))
		{
			win = true;
			winner = board[r][c];
		}
	}
	
	public void checkS(int r, int c)
	{
		if ((board[r][c] == board[r + 1][c]) && (board[r][c] == board[r + 2][c])
		&& (board[r][c] == board[r + 3][c]))
		{
			win = true;
			winner = board[r][c];
		}
	}
	
	public void checkE(int r, int c)
	{
		if ((board[r][c] == board[r][c - 1]) && (board[r][c] == board[r][c - 2])
		&& (board[r][c] == board[r][c - 3]))
		{
			win = true;
			winner = board[r][c];
		}
	}
	
	public void checkW(int r, int c)
	{
		if ((board[r][c] == board[r][c + 1]) && (board[r][c] == board[r][c + 2])
		&& (board[r][c] == board[r][c + 3]))
		{
			win = true;
			winner = board[r][c];
		}
	}
	
	public void checkNE(int r, int c)
	{
		if ((board[r][c] == board[r - 1][c - 1]) && (board[r][c] == board[r - 2][c - 2])
		&& (board[r][c] == board[r - 3][c - 3]))
		{
			win = true;
			winner = board[r][c];
		}
	}
	
	public void checkNW(int r, int c)
	{
		if ((board[r][c] == board[r - 1][c + 1]) && (board[r][c] == board[r - 2][c + 2])
		&& (board[r][c] == board[r - 3][c + 3]))
		{
			win = true;
			winner = board[r][c];
		}
	}
	
	public void checkSE(int r, int c)
	{
		if ((board[r][c] == board[r + 1][c - 1]) && (board[r][c] == board[r + 2][c - 2])
		&& (board[r][c] == board[r + 3][c - 3]))
		{
			win = true;
			winner = board[r][c];
		}
	}
	
	public void checkSW(int r, int c)
	{
		if ((board[r][c] == board[r + 1][c + 1]) && (board[r][c] == board[r + 2][c + 2])
		&& (board[r][c] == board[r + 3][c + 3]))
		{
			win = true;
			winner = board[r][c];
		}
	}
}