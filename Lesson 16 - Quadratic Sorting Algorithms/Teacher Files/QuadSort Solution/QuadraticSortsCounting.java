import java.util.*;

/**
 *  Description of the Class
 *
 * @author     Your Name Here
 * @created    Month Day, Year
 */
public class QuadraticSorts{
  private long steps;

  /**
   *  Description of Constructor
   *
   * @param  list  Description of Parameter
   */
  public QuadraticSorts(){
    steps = 0;
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void bubbleSort(ArrayList <Comparable> list){
  	steps = 0;
    for (int outer = 0; outer < list.size() - 1; outer++){
	    for (int inner = 0; inner < list.size()-outer-1; inner++){
	   	  steps += 3;//count one compare and 2 gets
	      if (list.get(inner).compareTo(list.get(inner + 1)) > 0){
	        steps += 4;//count 2 gets and 2 sets
	        Comparable temp = list.get(inner);
	        list.set(inner,list.get(inner + 1));
	        list.set(inner + 1,temp);
	      }
	    }
  	}
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void selectionSort(ArrayList <Comparable> list){
      Comparable temp;
      int min;
      steps = 0;
  
	  for (int outer = 0; outer < list.size() - 1; outer++){
	    min = outer;
	    for (int inner = outer + 1; inner < list.size(); inner++){
	      steps += 3; //count one compare and 2 gets
	      if (list.get(inner).compareTo(list.get(min)) < 0){
	        min = inner;  // a new smallest item is found
	      }
	    }
	    steps += 4;//count 2 gets and 2 sets
	    temp = list.get(outer);
	    list.set(outer,list.get(min));
	    list.set(min,temp);
	  }

  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void insertionSort(ArrayList <Comparable> list){
  	  steps = 0;
      for (int outer = 1; outer < list.size(); outer++){
    	int position = outer;
    	steps++; //count one get
    	Comparable key = list.get(position);
    
    	// Shift larger values to the right
    	steps += 2;//the get and compare in the loop conditional
    	           //are executed one more time than the loop body
    	while (position > 0 && list.get(position - 1).compareTo(key) > 0){
    		steps += 4; //count one compare, 2 gets, and 1 set
      		list.set(position,list.get(position - 1));
      		position--;
    	}
    	steps++; //count one set
    	list.set(position,key);
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
  
}
