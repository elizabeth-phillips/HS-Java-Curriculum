import java.util.ArrayList;

/**
 * Displays the items in a store in a sorted order
 * @author:  [place your name]
 * @version:  [place today's date]
 *
 */

public class Search{
    public static void searchStore(ArrayList<Item> myStore, int idToFind){
        int invReturn;
        int index;

        System.out.println("Testing search algorithm\n");

        //non recursive version call
        //index = bsearch(myStore, new Item(idToFind, 0));
        //recursive version call
        //index = bsearch (myStore, new Item(idToFind, 0), 0, myStore.size()-1);
        System.out.print("Id # " + idToFind);
        if (index == -1){
            System.out.println("     No such part in stock");
        }else{
            System.out.println("     Inventory = " + myStore.get(index).getInv());
        }

    }

    /**
     *  Searches the myStore ArrayList of Item Objects for the specified
     *  item object using a iterative binary search algorithm
     *
     * @param  idToSearch  Item object containing id value being searched for
     * @return             index of Item if found, -1 if not found
     */

    private static int bsearch(ArrayList<Item> myStore, Item idToSearch){
        ///todo: implement bsearch without recursion
        int min = 0;
        int max = myStore.size() - 1;
        int mid = (max - min) / 2;
        while(min <= max){
            if (idToSearch.equals(myStore.get(mid))){
                return mid;
            }
            else if(idToSearch.compareTo(FIGURE THIS OUT)>0){
                FIGURE THIS OUT
            }
            else{
                FIGURE THIS OUT
            }
        }
        return -1;
    }

    /**
     *  Searches the specified ArrayList of Item Objects for the specified
     *  id using a recursive binary search algorithm
     *
     * @param  idToSearch  Id value being search for
     * @param  first       Starting index of search range
     * @param  last        Ending index of search range
     * @return             index of Item if found, -1 if not found
     */

    private static int bsearch(ArrayList<Item> myStore,Item idToSearch, int first, int last){
        ///todo: implement bsearch without recursion
        return -1;
    }

}