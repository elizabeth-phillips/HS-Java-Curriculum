import java.util.*;

/**
 *  Description of the Class
 *
 *  @author Jason Quesenberry and Nancy Quesenberry
 *  @created January 16, 2006
 */
public class Sorts{
  private long steps;

  /**
   *  Description of Constructor
   *
   * @param  list  Description of Parameter
   */
  public Sorts(){
    steps = 0;
  }


 /**
   *  Takes in entire vector, but will merge the following sections
   *  together:  Left sublist from a[first]..a[mid], right sublist from
   *  a[mid+1]..a[last].  Precondition:  each sublist is already in
   *  ascending order
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  mid    midpoint index of range of values to be sorted
   * @param  last   last index of range of values to be sorted
   */
  private void merge(ArrayList <Comparable> a, int first, int mid, int last){
    int aPtr = first;
    int bPtr = mid + 1;
    int total = last - first + 1;
    int loop;
    boolean doneA = false;
    boolean doneB = false;
    ArrayList <Comparable> c = new ArrayList <Comparable>(a);

    for (loop = 1; loop <= total; loop++){
      if (doneA){
        c.add(a.get(bPtr));
        bPtr++;
      } else if (doneB){
        c.add(a.get(aPtr));
        aPtr++;
      } else if (a.get(aPtr).compareTo(a.get(bPtr)) < 0){
        // ok to compare, valid data in each sublist
        c.add(a.get(aPtr));
        aPtr++;
      } else {
        c.add(a.get(bPtr));
        bPtr++;
      }
      if (aPtr > mid){
        doneA = true;
      }
      if (bPtr > last){
        doneB = true;
      }
    }
                                     
    for (loop = first; loop <= last; loop++){
      a.set(loop,c.get(loop));
    }
  }

  /**
   *  Recursive mergesort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void mergeSort(ArrayList <Comparable> a, int first, int last){
    // Replace these lines with your code
    int mid;

    if (first == last){		// empty case, only 1 value, do nothing
    
    }else{
      if (first + 1 == last){
        // list of 2 values, swap if necessary
        if (a.get(first).compareTo(a.get(last)) < 0){
          swap(a, first, last);
        }
      } else {
        // general case
        mid = (first + last) / 2;
        mergeSort(a, first, mid);
        mergeSort(a, mid + 1, last);
        merge(a, first, mid, last);

      }
    }
  }

 
  /**
   *  Accessor method to return the current value of steps
   *
   */
  public long getStepCount(){
    return steps;
  }

  /**
   *  Modifier method to set or reset the step count. Usually called
   *  prior to invocation of a sort method.
   *
   * @param  stepCount   value assigned to steps
   */
  public void setStepCount(long stepCount){
    steps = stepCount;
  }
  
   /**
   *  Interchanges two elements in an ArrayList
   *
   * @param  list  reference to an array of integers
   * @param  a     index of integer to be swapped
   * @param  b     index of integer to be swapped
   */
  public void swap(ArrayList <Comparable> list, int a, int b){
    Comparable c = list.get(a);
    list.set(a, list.get(b));
    list.set(b, c);
  }
}
