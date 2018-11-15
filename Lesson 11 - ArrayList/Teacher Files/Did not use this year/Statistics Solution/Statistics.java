import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
 
public class Statistics{
  private ArrayList <Integer> myData;
 
  public Statistics(String fileName){
  	myData = new ArrayList <Integer> ();
    loadFile(fileName);
  }

  public void loadFile (String fileName){
  	Scanner in;
  	try{
  		in = new Scanner(new File(fileName));
    	while (in.hasNext()){
      		myData.add(in.nextInt());
      	}
    }catch(IOException i){
    	System.out.println("Error: " + i.getMessage());
    }
    	
  }

  public double average (){
  // returns average of values in ArrayList myData
    long total=0;
    
    for (Integer i : myData){
      total += i;
    }
    return ((double)total/myData.size());
  }

  public double stdDev ()
   // finds standard deviation of values in ArrayList myData
  {
    double avg, sum=0, temp;
    
    avg = average();
    for (Integer i : myData){
      sum += Math.pow(i - avg,2);
    }
    temp = (double)sum/(myData.size() - 1);
    return (Math.sqrt(temp)); 
  }

  private int findLargest (ArrayList <Integer> freq){
  /* finds the largest integer in ArrayList freq.  This ArrayList is sized from
    0..100, with each element storing the quantity of each number from
    0..100. */ 
  
    int tempBig=freq.get(0), index;
    
    for (index = 0; index < freq.size(); index ++){
      if (freq.get(index) > tempBig)
        tempBig = freq.get(index);
    }
      return tempBig;
  }

  public void findMode (){
   /*The ArrayList myData is analyzed and transferred into a smaller ArrayList
    smallList (0..100).  For each occurrence of n in vector data,
    smallList[n] is incremented +1.  function Largest is then called
    to find the largest quantity in ArayList smallList.  The mode(s)
    is/are printed out.*/ 
    int largestValue = 101;
    int loop, largest, temp;
    ArrayList <Integer> smallList = new ArrayList <Integer>() ;
    
    for (loop=0; loop < largestValue; loop++){
      smallList.add(0);
    }
   
    for (int d = 0; d < myData.size(); d++){
    	temp = myData.get(d);
      	smallList.set(temp, smallList.get(temp)+1);
    }
    
    largest = findLargest(smallList);
    System.out.print("The mode is(are) --> ");
    
    ArrayList <Integer> modes = new ArrayList <Integer>();
    for (loop = 0; loop < smallList.size(); loop++)
      if (smallList.get(loop) == largest)
        modes.add(loop);
    
    if(modes.size() == 0)
      System.out.println("There is no mode in this data set");
    else if (modes.size() == 1)
      System.out.println("There is one mode in this data set" + modes.get(0));
    else if (modes.size() == 2){
      System.out.println("There are two modes in this data set");
      System.out.println(modes.get(0) + " and  " + modes.get(1));
    }else 
      System.out.println("There is no statistical mode in this data set");
  }
}
