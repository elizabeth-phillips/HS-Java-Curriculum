import java.util.*;
import java.io.*;


/**
 *  Store class solution.
 */
 
public class Store{
  private ArrayList <Item> myStore = new ArrayList <Item>();

  public Store(String fName){
    loadFile(fName);
  }

  public Store(){
    this("file50.txt");
  }

  /**
   *  Reads a file containing id/inv data pairs one pair per line. 
   *
   * @param  inFileName  name of file containing id/inv pairs of data
   */
  private void loadFile(String inFileName){
    
    int id,inv;
    
    try{
    	Scanner inFile = new Scanner(new File(inFileName));
	 	while(inFile.hasNext()){
      		id = inFile.nextInt();
      		inv = inFile.nextInt();
      		myStore.add(new Item(id, inv));
    	}
    }catch(IOException i){
    	System.out.println("Error: " + i.getMessage());
    }
  }

  /**
   *  prints out all available Items contained in the Store
   */
  public void displayStore(){
    int lineNum = 1;
	Iterator <Item> itr = myStore.iterator();
	Item tempItem;
    System.out.printf("%12s%10s", "Id", "Inv");
    System.out.println();
    System.out.println();
    while(itr.hasNext()){
      tempItem = itr.next();	
      System.out.printf("%2d%10d%10d",lineNum++,tempItem.getId(),tempItem.getInv());
      System.out.println();
      if ((lineNum - 1) % 10 == 0){
        System.out.println();
      }
    }
  }

  public String toString(){
      return "" + myStore;
  }
  
  public void Sort(){
  	mergeSort(myStore, 0,myStore.size()-1);
  }
  
  private void merge(ArrayList <Item> a, int first, int mid, int last){
    int aPtr = first;
    int bPtr = mid + 1;
    int cPtr = first;
    int total = last - first + 1;
    int loop;
    boolean doneA = false;
    boolean doneB = false;
    ArrayList <Item> c = new ArrayList <Item>(a);

    for (loop = 1; loop <= total; loop++){
      if (doneA){
        c.set(cPtr, a.get(bPtr));
        bPtr++;
      } else if (doneB){
        c.set(cPtr, a.get(aPtr));
        aPtr++;
      } else if (a.get(aPtr).compareTo(a.get(bPtr)) < 0){
        // ok to compare, valid data in each sublist
        c.set(cPtr, a.get(aPtr));
        aPtr++;
      } else {
        c.set(cPtr, a.get(bPtr));
        bPtr++;
      }
      cPtr++;
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
   *  Recursive mergesort of an ArrayList of Items
   *
   * @param  a      reference to an ArrayList of Items to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
   
  public void mergeSort(ArrayList <Item> a, int first, int last){
    int mid;
    int temp;

    if (first == last){		// empty case, only 1 value, do nothing
    
    }else{
      if (first + 1 == last){
        // list of 2 values, swap if necessary
        if (a.get(first).compareTo(a.get(last)) > 0){
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
   *  Interchanges two elements in the ArrayList
   *
   * @param  list  reference to an ArrayList of Items
   * @param  a     index of integer to be swapped
   * @param  b     index of integer to be swapped
   */
   
  private void swap(ArrayList <Item> list, int a, int b){
    Item c = list.get(a);
    list.set(a, list.get(b));
    list.set(b, c);
  }
  
  /**
   *  Interface method for testing the binary search methods
   *  Note this method has the code for both searches.  A menu for hte client
   * to choose between them would be quite nice.
   */
   
  public void testSearch(){
  	int idToFind;
  	int invReturn;
  	int index;
	Scanner in = new Scanner(System.in);
	
	System.out.println("Testing search algorithm\n");
	do{
	  System.out.println();
	  System.out.print("Enter Id value to search for (-1 to quit) ---> ");
	  idToFind = in.nextInt();
	  //index = bsearch(new Item(idToFind, 0));
	  //recursive version call
	  index = bsearch (new Item(idToFind, 0), 0, myStore.size()-1);
	  System.out.print("Id # " + idToFind);
	  if (index == -1){
	    System.out.println("     No such part in stock");
	  }else{
	    System.out.println("     Inventory = " + myStore.get(index).getInv());
	  }
	} while (idToFind >= 0);
  }
  
  /**
   *  Searches the myStore ArrayList of Item objects for the specified
   *  item object using a iterative binary search algorithm
   *
   * @param  idToSearch  Item object containing id value being search for
   * @return             index of Item if found, -1 if not found
   */
   
  private int bsearch(Item idToSearch){
    int low = 0;
    int high = myStore.size() - 1;
    int mid;
    while (low <= high){
      mid = (low + high) / 2;
      if (myStore.get(mid).equals(idToSearch)){
        return mid;
      }
      else if (myStore.get(mid).compareTo(idToSearch) > 0){
        high = mid - 1;
      }
      else{
        low = mid + 1;
      }
    }
    return -1;// did not find idToSearch
  }
  
  /**
   *  Searches the specified ArrayList of Item objects for the specified
   *  id using a recursive binary search algorithm
   *
   * @param  idToSearch  id value being search for
   * @param  first       Starting index of search range
   * @param  last        Ending index of search range
   * @return             index of Item if found, -1 if not found
   */
   
  private int bsearch(Item idToSearch, int first, int last){
    int mid;

    if (last < first){
      return -1;
    }
    else{
      mid = (first + last) / 2;
      if (idToSearch.equals(myStore.get(mid))){
        return mid;
      }
      else if (idToSearch.compareTo(myStore.get(mid)) <= 0){
        return bsearch(idToSearch, first, mid - 1);
      }
      else{
        return bsearch(idToSearch, mid + 1, last);
      }
    }
  }
}

