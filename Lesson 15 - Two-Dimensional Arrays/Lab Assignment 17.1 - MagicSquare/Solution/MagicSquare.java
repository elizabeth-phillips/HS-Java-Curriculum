// Lab15av100.java
// 02-27-15 by Leon Schram
// The "Odd Magic Square" Program
// This is the 100 Point Version of the Lab15 assignment.


import java.util.Scanner;
import java.text.DecimalFormat;


public class MagicSquare
{
	private int size;
	private int magic[][];
	private DecimalFormat output;

	public MagicSquare(int s)
	{
		size = s;
		magic = new int[size][size];
		output = new DecimalFormat("000");
	}

	public void computeMagicSquare()
	{
		int j;
		int c = size / 2;
		int r = 0;
		magic[r][c] = 1;
		for (j = 2; j <= size*size; j++)
		{
		   if (j % size == 1)
			  r++;
		   else
		   {
			  c++;
			  r--;
		   }
		   if (c == size)
			  c = 0;
		   if (r == size)
			  r = 0;
		   if (r == -1)
			  r = size-1;
		   magic[r][c] = j;
		}
	}

	public void displayMagicSquare()
	{
		System.out.println();
		System.out.println(size + "x" + size + " Magic Square");
		System.out.println("==================");
		System.out.println();

		int r,c;
		for (r = 0; r < size; r++)
		{
		   for (c = 0; c < size; c++)
		      System.out.print(output.format(magic[r][c])+" ");
		   System.out.println();
		}
	}

	public void checkRows()
	{
		System.out.println();
		System.out.println("Checking Rows");
		System.out.println("=============");
		System.out.println();

		int r,c;
		for (r = 0; r < size; r++)
		{
		   int sum = 0;
		   for (c = 0; c < size; c++)
		      sum += magic[r][c];
		   System.out.print(sum + " ");
		}
		System.out.println();
	}

	public void checkColumns()
	{
		System.out.println();
		System.out.println("Checking Columns");
		System.out.println("================");
		System.out.println();

		int r,c;
		for (c = 0; c < size; c++)
		{
		   int sum = 0;
		   for (r = 0; r < size; r++)
		      sum += magic[r][c];
		   System.out.print(sum + " ");
		}
		System.out.println();
	}

	public void checkDiagonals()
	{
		System.out.println();
		System.out.println("Checking Diagonals");
		System.out.println("==================");
		System.out.println();

		int r,c;
	    int sum = 0;
		for (r = 0; r < size; r++)
		   sum += magic[r][r];
		System.out.print(sum + " ");

		sum = 0;
		for (r = 0, c=size-1; r < size; r++, c--)
		   sum += magic[r][c];
		System.out.println(sum);
	}
}

