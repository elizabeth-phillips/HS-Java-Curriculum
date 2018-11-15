import java.util.*;


/**
 *  A class to study merging.  
 *
 */

public class Merge{
  public void merge (ArrayList <Comparable> a, ArrayList <Comparable> b, ArrayList <Comparable> c){
    int aPtr = 0;
    int bPtr = 0;
  
    int total = a.size() + b.size();
    boolean doneA = false;
    boolean doneB = false;
    

    for (int loop = 0; loop < total; loop++){
      
      if (doneA){ //no more elements in a, take from b
        c.add(loop, b.get(bPtr));
        bPtr++;
      } else if (doneB){ //no more elements in b, take from a
        c.add(loop, a.get(aPtr));
        aPtr++;
      } else if (a.get(aPtr).compareTo(b.get(bPtr)) < 0){ //take smaller element
        // ok to compare, valid data in each sublist
        c.add(loop, a.get(aPtr));
        aPtr++;
      }else{
        c.add(loop, b.get(bPtr));
        bPtr++;
      }
      
      
      if (aPtr >= a.size()){
        doneA = true;
      }
      if (bPtr >= b.size()){
        doneB = true;
      }
    }
  }

  /**
   *  Initializes and returns temp with random integers in the range
   *  1 to largestInt
   *
   * @return  an ArrayList of size specified by the user filled
   *          with random numbers
   */
  public ArrayList <Comparable> fillArray(){
    Random randGen = new Random();
    ArrayList<Comparable> temp = new ArrayList<>();

    for (int loop = 0; loop < numInts; loop++){
        temp.add(randGen.nextInt(largestInt) + 1);
    }
    return temp;
  }

  /**
   *  Prints out the contents of the array in tabular form, 20 columns
   */
  public void screenOutput(ArrayList <Comparable> temp){
    for (int loop = 0; loop < temp.size(); loop++){
      if (loop % 15 == 0){
        System.out.println();
      }
      System.out.printf("%5d",temp.get(loop));
    }
    System.out.println();
  }

}

