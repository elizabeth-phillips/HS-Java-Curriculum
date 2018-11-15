import java.util.*;

/**
 *  Driver program for the Sorts class.
 */
public class SortStep{
    private ArrayList<Comparable> myArray;
    private Sorts mySorts;
    private String listType;
    private int numItems;
    private int largestInt;

    /**
     *  Default constructor for the SortStep object
     */
    public SortStep(){
        mySorts = new Sorts();
        myArray = null;
        listType = "String";
        this.numItems = numItems;
        System.out.println("Strings to generate: " + numItems);
    }

    /**
     *  Constructor for the SortStep object
     */
    public SortStep(int numItems, int largestInt){
        mySorts = new Sorts();
        myArray = null;
        listType = "Integer";
        this.numItems = numItems;
        this.largestInt = largestInt;
        System.out.println("Numbers to generate: " + numItems);
        System.out.print("Largest integer to generate: " + largestInt);
    }

    /**
     *  Fills the array with an amount of random integer data, calls
     *  the sorting algorithm, and prints out the data after it has
     *  been sorted.
     */
    public void sortingLists(){
        mySorts.setStepCount(0);

        //===========Bubble Sort===========
        System.out.println("\n\n=========Bubble Sort=========\n");
        resetArray();
        screenOutput("start");
        mySorts.bubbleSort(myArray);
        screenOutput("sorted");
        System.out.println("# steps = " + mySorts.getStepCount() + "\n");

        //===========Selection Sort===========
        System.out.println("\n=========Selection Sort=========\n");
        resetArray();
        screenOutput("start");
        mySorts.selectionSort(myArray);
        screenOutput("sorted");
        System.out.println("# steps = " + mySorts.getStepCount() + "\n");

        //===========Insertion Sort===========
        System.out.println("\n=========Insertion Sort=========\n");
        resetArray();
        screenOutput("start");
        mySorts.insertionSort(myArray);
        screenOutput("sorted");
        System.out.println("# steps = " + mySorts.getStepCount() + "\n");


    }

    /**
     *  Initializes myArray with random integers in the range
     *  1..largestInt
     */
    public void fillArrayWithInts(){
        Random randGen = new Random();
        myArray = new ArrayList <Comparable>();

        for (int loop = 0; loop < numItems; loop++){
            Integer x = new Integer(randGen.nextInt(largestInt) + 1);
            myArray.add(x);
        }
    }

    /**
     *  Initializes myArray with a few hard-coded Strings
     */
    public void fillArrayWithStrings(){
        myArray = new ArrayList <Comparable>();
        myArray.add("eat");
        myArray.add("steaks");
        myArray.add("juicy");
        myArray.add("huge");
        myArray.add("dogs");
        myArray.add("big");
    }

    /**
     *  reset the array for the next sort
     */
    public void resetArray(){
        if (myArray == null || listType.equals("Integer")){
            fillArrayWithInts();
        } else if (listType.equals("String")) {
            fillArrayWithStrings();
        }
    }

    /**
     *  prints out the contents of the array in tabular form, 12 columns
     */
    public void screenOutput(String arrayState){
        System.out.print("Array " + arrayState + ": ");

        for (int loop = 0; loop < myArray.size(); loop++){
            if (loop % 12 == 0){
                System.out.println();
            }
            System.out.print(myArray.get(loop) + "  ");
        }
        System.out.println();
    }


}

