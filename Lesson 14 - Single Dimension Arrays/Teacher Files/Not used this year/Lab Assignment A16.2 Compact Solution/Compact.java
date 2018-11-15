import java.util.Scanner;
import java.io.*;

/**
 *  A class for removing zeros from a list.  
 *
 */


public class Compact{
  private int[] myList = new int[100];
  private int myHowMany;

  public Compact(String fileName){
    readFile(fileName);
  }

  public void readFile(String fileName){
  /* Loads text file numbers.txt into myList.  Values are stored from
    positions 0..myHowMany-1.  Returns the number of data values as howMany */
  
    int  index=0;
    Scanner inFile;
    
    try{
    	inFile = new Scanner(new File(fileName));
		while (inFile.hasNext()){
      		myList[index] = inFile.nextInt();
      		index++;
    	}
    }catch(IOException i){
    	System.out.println("Error: " + i.getMessage());
    }
    myHowMany = index;
  }

  public void printList ()
  {
    for (int loop = 0; loop < myHowMany; ++loop)
      System.out.print(myList[loop] + "  ");

    System.out.println();
    System.out.println();
  }

  public void compact ()
  /*  Logic of algorithm.  Each value in the list is examined.  If a
    non-zero element is found, it is moved to position pos, then pos
    is incremented +1. */
  {
    int pos=0;

    for (int loop = 0; loop < myHowMany; loop++)
      if (myList[loop] != 0)
      {
        myList[pos] = myList[loop];
        pos++;
      }
    myHowMany = pos;
  }

  
}

/*
List before compact

0  6  13  0  0  75  33  0  0  0  4  29  21  0  86  0  32  66  0  0

List after compact

6  13  75  33  4  29  21  86  32  66
*/