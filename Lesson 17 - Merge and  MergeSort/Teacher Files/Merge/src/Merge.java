import java.util.*;


/**
 *  A class to study merging.
 *
 */

public class Merge{
    /**
     * Takes in values for the number of ints and max int value in list a and b
     * @param listAQuant the number of integers in list a
     * @param listALarge the largest number in list a
     * @param listBQuant the number of integers in list b
     * @param listBLarge the largest number in list b
     */
    public Merge(int listAQuant, int listALarge, int listBQuant, int listBLarge){
        System.out.println("===========A List===========");
        ArrayList <Comparable> a = fillArray(listAQuant, listALarge);
        screenOutput(a);

        System.out.println("===========B List===========");
        ArrayList <Comparable> b = fillArray(listBQuant, listBLarge);
        screenOutput(b);

        System.out.println("===========Combined List===========");
        ArrayList<Comparable> c = mergeList(a,b);
        screenOutput(c);
    }

    /**
     *  Combines the two lists to create one large sorted Arraylist.
     * @param a first sorted list
     * @param b second sorted list
     * @return the sorted combination of each of the lists
     */
    public ArrayList <Comparable> mergeList (ArrayList <Comparable> a, ArrayList <Comparable> b){
        int aPtr = 0;
        int bPtr = 0;

        int total = a.size() + b.size();
        int loop;
        boolean doneA = false;
        boolean doneB = false;
        ArrayList <Comparable> c = new ArrayList<>();


        for (loop = 0; loop < total; loop++){

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
        return c;
    }

    /**
     *  Initializes and returns temp with random integers in the range
     *  1 to largestInt
     *
     * @return  an ArrayList of size specified by the user filled
     *          with random numbers
     */
    public ArrayList <Comparable> fillArray(int numInts, int largestInt){
        Random randGen = new Random();
        ArrayList<Comparable> temp = new ArrayList<>();

        for (int loop = 0; loop < numInts; loop++){
            temp.add(randGen.nextInt(largestInt) + 1);
        }
        sortList(temp);
        return temp;
    }

    /**
     *  Sorts the list in ascending order
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void sortList(ArrayList <Comparable> list){
        //todo: place any sorting algorithm from your previous assignment here
        Comparable temp;
        int min;

        for (int outer = 0; outer < list.size() - 1; outer++){
            min = outer;
            for (int inner = outer + 1; inner < list.size(); inner++){
                if (list.get(inner).compareTo(list.get(min)) < 0){
                    min = inner;  // a new smallest item is found
                }
            }
            temp = list.get(outer);
            list.set(outer,list.get(min));
            list.set(min,temp);
        }
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

