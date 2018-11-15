import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.Random;

public class Matrix
{
	Random rand = new Random();
	int size;
	int matrix[][];
	int zeroCount;
	int zeroMin;
	int zeroMax;
	int fontSize;
	int creditSize = 30;
	
	public Matrix(int matrixSize)
	{
		size = matrixSize;
		
		switch(size)
		{
			case 2: zeroMin = 0; zeroMax = 2; fontSize = 25; break;
			case 3: zeroMin = 2; zeroMax = 4; fontSize = 25; break;
			case 4: zeroMin = 4; zeroMax = 5; fontSize = 25; break;
			case 5: zeroMin = 6; zeroMax = 8; fontSize = 25; break;
			case 6: zeroMin = 7; zeroMax = 10; fontSize = 25; break;
			/*case 7: zeroMin = 15; zeroMax = 25; break;
			case 8: zeroMin = 20; zeroMax = 32; break;
			case 9: zeroMin = 28; zeroMax = 40; break;
			case 10: zeroMin = 35; zeroMax = 55; break;*/
		}
		
		matrix = new int[matrixSize][matrixSize];
		for (int row = 0; row < size; row++)
			for (int col = 0; col < size; col++)
				matrix[row][col] = 99;
		
		zeroCount = 0;
		int tempRand;
		int tempRow;
		int tempCol;
		boolean full = false;
		
		while(!full)
		{
			boolean randFound = false;
			
			while(!randFound)
			{
				tempRow = rand.nextInt(size);
				tempCol = rand.nextInt(size);
				tempRand = rand.nextInt(4);
				
				if (matrix[tempRow][tempCol] == 99)
				{
					if (tempRand != 0 && zeroCount > zeroMin) // Needs to be modified so that the zeroCount is greater than zeroMin
					{
						matrix[tempRow][tempCol] = tempRand;
						randFound = true;
					}
					else if (tempRand == 0 && zeroCount < zeroMax)
					{
						//if (zeroCount < zeroMin)
						//{
							matrix[tempRow][tempCol] = tempRand;
							zeroCount++;
							randFound = true;
						//}
						//else
						//{
							
						//}			
							
					}
				}
				
			}
			
			full = true;
			for (int row = 0; row < size; row++)
				for (int col = 0; col < size; col++)
					if (matrix[row][col] == 99)
						full = false;
							
		}
			
		System.out.println(zeroMin + " - " + zeroCount + " - " + zeroMax);
		

	}
	
	
	/*public Matrix(int matrixSize)
	{
		size = matrixSize;
		
		switch(size)
		{
			case 2: zeroMin = 0; zeroMax = 2; break;
			case 3: zeroMin = 2; zeroMax = 6; break;
			case 4: zeroMin = 4; zeroMax = 10; break;
			case 5: zeroMin = 9; zeroMax = 20; break;
			case 6: zeroMin = 13; zeroMax = 25; break;
			case 7: zeroMin = 15; zeroMax = 35; break;
			case 8: zeroMin = 20; zeroMax = 50; break;
			case 9: zeroMin = 28; zeroMax = 65; break;
			case 10: zeroMin = 35; zeroMax = 75; break;
		}
		
		matrix = new int[matrixSize][matrixSize];
		
		zeroCount = 0;
		int tempRand;
		
		for (int rowCount = 0; rowCount < size; rowCount++)
		{
			for (int colCount = 0; colCount < size; colCount++)
			{
				
				boolean randFound = false;
				
				while(!randFound)
				{
					tempRand = rand.nextInt(4);
					if (tempRand != 0) // Needs to be modified so that the zeroCount is greater than zeroMin
					{
						matrix[rowCount][colCount] = tempRand;
						randFound = true;
					}
					else if (tempRand == 0)
					{
						if (zeroCount < zeroMax)
						{
							matrix[rowCount][colCount] = tempRand;
							zeroCount++;
							randFound = true;
						}
						else
						{
							/* It will just produce random numbers over and over until 
							 * it fills the rest with non-zero numbers.
						}			
							
					}
				}				
				
			}
		}
		
		System.out.println(zeroMin + " - " + zeroCount + " - " + zeroMax);
		
		/*for (int rowCount = 0; rowCount < size; rowCount++)
			for (int colCount = 0; colCount < size; colCount++)
			{
				matrix[rowCount][colCount] = rand.nextInt(4);
			}
		
	}*/
	
	public void displayCredits(Graphics g)
	{
		g.setFont(new Font("Kristen ITC",Font.BOLD,creditSize));
		g.drawString("Sudoko Sweeper",175+(size*90)+(6-size)*(90),75);
		g.setFont(new Font("Kristen ITC",Font.PLAIN,creditSize-(size)));
		g.drawString("Created by:",200+(size*90)+(6-size)*(90),120);
		g.drawString("Ryan Burke,",175+(size*90)+(6-size)*(90),185);
		g.drawString("Tim McDonald,",175+(size*90)+(6-size)*(90),220);
		g.drawString("Jim Templeton,",175+(size*90)+(6-size)*(90),255);
		g.drawString("Cameron Skidmore",175+(size*90)+(6-size)*(90),290);
		g.drawString("& Michael Petri",175+(size*90)+(6-size)*(90),325);
		g.drawString("JPIIHS, May, 2010",175+(size*90)+(6-size)*(90),400);
		g.setFont(new Font("Kristen ITC",Font.PLAIN,40));
	}
	
	public void displayMatrix(Graphics g)
	{
		for (int rowCount = 0; rowCount < size; rowCount++)
			for (int colCount = 0; colCount < size; colCount++)
			{
				int tempNum = matrix[rowCount][colCount];
				g.drawString(""+tempNum,50+(110*colCount),70+(110*rowCount));
			}
	}
	
	public void displayRowZeros(Graphics g)
	{
		int zeroCount = 0;
		int count = 0;
		for (int rowCount = 0; rowCount < size; rowCount++)
			for (int colCount = 0; colCount < size; colCount++)
			{
				count++;
				if(matrix[rowCount][colCount] == 0)
					zeroCount++;
				if(count == size)
				{
					g.setColor(getColorCode(zeroCount));
					g.drawString("" + zeroCount, 70+(size*90),85+(90*rowCount));
					count = 0;
					zeroCount = 0;
				}
			} 
	}
	
	public void displayColZeros(Graphics g)
	{
		int zeroCount = 0;
		int count = 0;
		for (int rowCount = 0; rowCount < size; rowCount++)
			for (int colCount = 0; colCount < size; colCount++)
			{
				count++;
				if(matrix[colCount][rowCount] == 0)
					zeroCount++;
				if(count == size)
				{
					g.setColor(getColorCode(zeroCount));
					g.drawString("" + zeroCount,40+(rowCount*90),115+(90*size));
					count = 0;
					zeroCount = 0;
				}
			}
	}
	
	public void displayRowSums(Graphics g)
	{
		int count = 0;
		int sum = 0;
		for (int rowCount = 0; rowCount < size; rowCount++)
			for (int colCount = 0; colCount < size; colCount++)
			{
				count++;
				sum  = sum + matrix[rowCount][colCount];
				if(count == size)
				{
					g.drawString("" + sum, 70+(size*90),45+(90*rowCount));
					count = 0;
					sum = 0;
				}
			}
	}
	
	public void displayColSums(Graphics g)
	{
		int count = 0;
		int sum = 0;
		for (int rowCount = 0; rowCount < size; rowCount++)
			for (int colCount = 0; colCount < size; colCount++)
			{
				count++;
				sum  = sum + matrix[colCount][rowCount];
				if(count == size)
				{
					g.drawString("" + sum,40+(rowCount*90),75+(90*size));
					count = 0;
					sum = 0;
				}
			}
	}
	
	public Color getColorCode(int code)
	{
		Color color = Color.BLACK;
		switch (code)
		{
			case 0: color = Color.BLUE; break;
			case 1: color = Color.GREEN; break;
			case 2: color = Color.RED; break;
			case 3: color = Color.MAGENTA; break;
			case 4: color = Color.ORANGE; break;
			case 5: color = Color.CYAN; break;
			case 6: color = Color.DARK_GRAY; break;
			case 7: color = Color.BLACK; break;
		}
		return color;
	}
}

