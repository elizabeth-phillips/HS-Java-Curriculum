// SudokoSweeper

import java.applet.Applet;
import java.awt.*;
import javax.swing.JOptionPane;
import  sun.audio.*;
import  java.io.*;

public class SudokoSweeper extends java.applet.Applet
{
	Matrix matrix;
	int size;
	Rectangle rectangle[][];
	boolean flippedUp[][];
	int necessities[][];
	boolean flagged[][];
	boolean gameOver;
	boolean zeroClicked;
	int win;
    long score;
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;
    boolean clicked;
    boolean firstClick;
    int rowClicked;
    int colClicked;

	public void init()
	{
		win = 0;
		String temp = JOptionPane.showInputDialog("Enter Difficulty (2-6):");
		size = Integer.parseInt(temp);
		matrix = new Matrix(size);
		rectangle = new Rectangle[size][size];
		flippedUp = new boolean[size][size];
		flagged = new boolean[size][size];
		necessities = new int[size][size];
		gameOver = false;
		zeroClicked = false;


		if (size < 2 || size > 6)
		{
			System.out.println("ERROR: Invalid Matrix Size (Only >=2 and <=6 are allowed)");
			gameOver = true;
		}
		firstClick = false;

		for(int r = 0; r < size; r++)
			for(int c = 0; c < size; c++)
			{
				flippedUp[r][c] = false;
				flagged[r][c] = false;
				if(matrix.matrix[r][c] == 2 || matrix.matrix[r][c] == 3)
				{
					necessities[r][c] = 1;
				}
			}
		score = 0;
		this.startTime = System.currentTimeMillis();
        this.running = true;
	}

	public void paint(Graphics g)
	{
		displayTimer(g);
		setFont(g);
		drawBoard(g);
		matrix.displayRowSums(g);
		matrix.displayColSums(g);
		matrix.displayRowZeros(g);
		matrix.displayColZeros(g);
		matrix.displayCredits(g);
		createRectangles();
		showFlipped(g);
		showFlagged(g);
	}

	public long getElapsedTimeSecs()
	{
        long elapsed;
        if (running)
        {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        }
        else
        {
            elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
    }


	public void displayTimer(Graphics g)
	{
		if(clicked)
		{
			g.setFont(new Font("Kristen ITC",Font.PLAIN,60));
			g.setColor(Color.white);
			g.drawString("" + score,75+(90*size),110+(90*size));
			score = (getElapsedTimeSecs());
			g.setColor(Color.black);
			g.drawString("" + score,75+(90*size),110+(90*size));
			clicked = false;
		}
	}

	public void checkWin(Graphics g)
	{
		g.setFont(new Font("Kristen ITC",Font.PLAIN,30));
		win = 0;
		for(int r = 0; r < size; r++)
			for(int c = 0; c < size; c++)
			{
				win = win + necessities[r][c];
			}
		if(win == 0)
		{
			g.setColor(Color.GREEN);
			g.drawString("You Win!",45+(90*size),150+(90*size));
			System.out.println("You Win!!!");
			gameOver = true;
		}
		else if (zeroClicked)
		{
			g.setColor(Color.RED);
			g.drawString("You Lose!",45+(90*size),150+(90*size));
			System.out.println("You Lose!");
			gameOver = true;
		}
		repaint();
	}

	public void showFlagged(Graphics g)
	{
		if (!gameOver)
		{
			if (firstClick)
			{
				if (flagged[rowClicked][colClicked])
				{
					g.setColor(Color.white);
					g.fillRect(40+(90*colClicked),65+(90*rowClicked),25,15);
					g.fillRect(35+(90*colClicked),60+(90*rowClicked),5,30);
				}
				else if (!flippedUp[rowClicked][colClicked])
				{
					g.setColor(Color.red);
					g.fillRect(40+(90*colClicked),65+(90*rowClicked),25,15);
					g.setColor(Color.black);
					g.fillRect(35+(90*colClicked),60+(90*rowClicked),5,30);
				}

				firstClick = false;
				flagged[rowClicked][colClicked] = !(flagged[rowClicked][colClicked]);
				g.setColor(Color.black);
			}

			/*for(int r = 0; r < size; r++)
			{
				for(int c = 0; c < size; c++)
				{
					g.setColor(Color.white);

					g.fillRect(40+(90*c),55+(90*r),30,15);
					g.fillRect(35+(90*c),50+(90*r),5,40);
					if (flagged[r][c])
					{
						g.setColor(Color.red);
						g.fillRect(40+(90*c),55+(90*r),30,15);
						g.setColor(Color.black);
						g.fillRect(35+(90*c),50+(90*r),5,40);

					}
				}
			}*/
		}

	}

	public void showFlipped(Graphics g)
	{
		for(int r = 0; r < size; r++)
			for(int c = 0; c < size; c++)
			{
				if (gameOver)
				{
					if(win != 0)
						g.setColor(Color.red);
					else
						g.setColor(Color.green);
					if (flippedUp[r][c] == false)
					{
						g.drawString(""+matrix.matrix[r][c],40+(90*c),60+(90*r));
					}
				}
				else if (flippedUp[r][c] == true)
				{
					g.setColor(Color.black);
					g.drawString(""+matrix.matrix[r][c],40+(90*c),60+(90*r));
					if(matrix.matrix[r][c] == 2 || matrix.matrix[r][c] == 3)
					{
						necessities[r][c] = 0;
					}
				}
			}
		checkWin(g);
	}

	public void setFont(Graphics g)
	{
		g.setFont(new Font("Kristen ITC",Font.PLAIN,40));
	}

	public void drawBoard(Graphics g)
	{
		// Grid 100x100 boxes, 10 space increments
		for(int r = 0; r < size; r++)
			for(int c = 0; c < size; c++)
			{
				g.drawRect(10+(90*c),10+(90*r),80,80);
			}
		//Outer Boxes, halved by Line, 30px gap from grid
		for(int k = 0; k < size; k++)
		{
			//To the right of the Grid
			g.drawRect(40+(90*size),10+(90*k),80,80);
			g.drawLine(40+(90*size),50+(90*k),120+(90*size),50+(90*k));
			//At the bottom of the Grid
			g.drawRect(10+(90*k),40+(90*size),80,80);
			g.drawLine(10+(90*k),80+(90*size),90+(90*k),80+(90*size));
		}
		// Win and Score (Timer) Box
		g.drawRect(40+(90*size),40+(90*size),150,120);
		g.drawLine(40+(90*size),120+(90*size),190+(90*size),120+(90*size));
	}

	public void createRectangles()
	{
		for(int r = 0; r < size; r++)
			for(int c = 0; c < size; c++)
			{
				rectangle[r][c] = new Rectangle(10+(80*c+10*c),10+(80*r+10*r),80,80);
			}
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		if(!gameOver)
		{
			for(int r = 0; r < size; r++)
				for(int c = 0; c < size; c++)
				{
					if(rectangle[r][c].inside(x,y))
						if(e.modifiers == 0)
						{
							if (!flagged[r][c])
							{
								if (flippedUp[r][c] == false)
								{
									play(getDocumentBase(), "click.wav");
								}
								flippedUp[r][c] = true;

								if(matrix.matrix[r][c] == 0)
								{
									//Lose Procedure HERE.
									flippedUp[r][c] = false;
									gameOver = true;
									zeroClicked = true;
								}

							}
						}
						else if(e.modifiers == 4)
						{
							System.out.println("Right Mouse Clicked");
							System.out.println("" + flagged[r][c]);
							//flagged[r][c] = !(flagged[r][c]);
							System.out.println("" + flagged[r][c]);

							firstClick = true;
							rowClicked = r;
							colClicked = c;
						}
				}
			clicked = true;
			repaint();
		}
		return true;
	}

	public void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
		endDelay = System.currentTimeMillis();
	}

	public void update(Graphics g)
	{
		paint(g);
	}
}
