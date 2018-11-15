import java.util.Scanner;
import java.io.*;

/**
 *  A  class for calculating Statistics on a set of numbers.  
 *
 */
 
public class Statistics{
  private int[] myData = new int[1000];
  private int myHowMany;

  public Statistics(String fileName){
    myHowMany = 0;
    loadFile(fileName); 
  }

  public void loadFile (String fileName){
  /* Loads text file numbers.txt into vector data.  Values are stored from
  positions 0..howMany-1.  Returns the number of data values as howMany */
  
    int  index=0;
    Scanner inFile;
    
    try{
    	inFile = new Scanner(new File(fileName));
    
    	while (inFile.hasNext()){
      		myData[index] = inFile.nextInt();
      		index++;
    	}
    }catch(IOException i){
    	System.out.println("Error: " + i.getMessage());
    }
    myHowMany = index;
  }

  private double square (double n){
    return (n * n);
  }

  public double average (){
  // returns average of values in vector data
  
    int index=0;
    long total=0;
    
    while (index < myHowMany){
      total += myData[index];
      index++;
    }
    return ((double)total/myHowMany);
  }

  public double stdDev (){
   // finds standard deviation of values in vector data
  
    double avg, sum=0, temp;
    int index;
    
    avg = average();
    for (index=0; index < myHowMany; index++)
      sum += square(myData[index] - avg);
    temp = (double)sum/(myHowMany - 1);
    return (Math.sqrt(temp));
  }

  private int findLargest (int[] scores){
  /* finds the largest integer in vector scores.  This vector is sized from
    0..100, with each element storing the quantity of each number from
    0..100. */
  
    int tempBig=scores[0], index;
    
    for (index=0; index<=100; index++)
      if (scores[index] > tempBig)
        tempBig = scores[index];
      return (tempBig);
  }

  public void findMode (){
  /* The vector data is analyzed and transferred into a smaller vector
    smallList (0..100).  For each occurrence of n in vector data,
    smallList[n] is incremented +1.  function Largest is then called
    to find the largest quantity in vector smallList.  The mode(s)
    is/are printed out. */
  
    int loop, largest;
    int[] smallList = new int[101];
    
    for (loop=0; loop < myHowMany; loop++)
      smallList[myData[loop]]++;
    largest = findLargest(smallList);
    System.out.print("The mode is(are) --> ");
    for (loop=0; loop<=100; loop++){
      if (smallList[loop] == largest){
        System.out.print(loop + "   ");
      }
    }
      System.out.println();
      System.out.println();
  }
}
