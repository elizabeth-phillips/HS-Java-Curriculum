import java.util.ArrayList;
import java.util.Comparator;

/**
 * Sorts the Items in a list in ascending order
 * @author:  [place your name]
 * @version:  [place today's date]
 *
 */
public class Sort{
    public static void sortList(ArrayList<Item> list){
        ///todo: use any of your previous sorting methods to sort list a
        //MAKE SURE TO USE THE SWAP METHOD (Points will be deducted if not)
        int min, temp;

        for (int outer = 0; outer < list.size() - 1; outer++){
            min = outer;
            for (int inner = outer + 1; inner < list.size(); inner++){
                if (list.get(inner).compareTo(list.get(min))>0) {
                    min = inner;  // a new smallest item is found
                }
            }
            swap(list, outer,min);
        }
    }
    private static void swap(ArrayList<Item> list, int x, int y){
        ///todo: create a swap method
        Item temp = list.get(x);
        list.set(x,list.get(y));
        list.set(y,temp);
    }
}