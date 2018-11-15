import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by E157813 on 4/10/2017.
 */
public class MergeSort{
    private ArrayList<Comparable> list;

    public MergeSort(int numInts, int largestInt){
        list = fillArray(numInts,largestInt);
        System.out.println("============Before============");
        screenOutput();

        System.out.println("============After============");
        mergeSort(list, 0, list.size()-1);
        screenOutput();
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
        //todo: place your merge algorithm from the previous assignment and modify
    }

    /**
     *  Recursive mergesort of an array of integers
     *
     * @param  a      reference to an array of integers to be sorted
     * @param  first  starting index of range of values to be sorted
     * @param  last   ending index of range of values to be sorted
     */
    public void mergeSort(ArrayList <Comparable> a, int first, int last){
        // todo: mergesort
    }

    /**
     *  Initializes and returns list with random integers in the range
     *  1 to largestInt
     */
    public ArrayList<Comparable> fillArray(int numInts, int largestInt){
        Random randGen = new Random();
        ArrayList<Comparable> temp = new ArrayList<>();
        for (int loop = 0; loop < numInts; loop++){
            temp.add(randGen.nextInt(largestInt) + 1);
        }
        return temp;
    }

    /**
     *  Prints out the contents of the array in tabular form, 15columns
     */
    public void screenOutput(){
        for (int loop = 0; loop < list.size(); loop++){
            if (loop % 15 == 0){
                System.out.println();
            }
            System.out.printf("%5d",list.get(loop));
        }
        System.out.println();
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

    public ArrayList<Comparable> getList() {
        return list;
    }
}

