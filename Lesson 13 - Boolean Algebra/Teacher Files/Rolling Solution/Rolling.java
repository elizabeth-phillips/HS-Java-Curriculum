import java.util.*;

public class Rolling{
	
	private int numSides;
	
	public Rolling(int s){
		numSides = s;
	}
	
	public void rollEm(){
		   Random die = new Random();
	    int a, b, c, count = 0;
	
	    do{
	      a = die.nextInt(numSides) + 1;
	      b = die.nextInt(numSides) + 1;
	      c = die.nextInt(numSides) + 1;
	      System.out.println(a + "  " + b + "  " + c);
	      count++;
	  	} while ((a == b) || (a == c) || (b == c));
	
	  	System.out.println();
	  	System.out.println("count = " + count);
	 	
	}
}
/*
1  3  3
6  6  3
1  5  5
6  1  1
6  6  1
6  6  1
1  5  3

count = 7
*/

/*
Assertion when the loop is done:

(a != b) && (a != c) && (b != c)

Negation of the assertion:

(a == b) || (a == c) || (b == c)
*/
