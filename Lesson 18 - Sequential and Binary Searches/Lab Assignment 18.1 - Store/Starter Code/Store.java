import java.util.ArrayList;

/**
 * Displays the items in a store in a sorted order
 * @author:  [place your name]
 * @version:  [place today's date]
 *
 */
public class Store {
    private ArrayList <Item> myStore = new ArrayList<Item>();
    public Store(int numItems){
        int tempId = 0;
        int tempInv = 0;

        for(int i = 0; i < numItems; i++){
            tempId = tempId + (int)(Math.random() * 5) + 1;
            ///todo: Store a random value between 1 and 100 in tempInv

            ///todo: Add a new Item to myStore with the new tempId and tempInv

        }
        ///todo: Use your Sort classes' sortList() to sort myStore
        
    }
    public void displayStore(){
        System.out.printf("%5s%10s","Id","Inv");
        System.out.println();
        ///todo: Display the Items in myStore (each on their own line)
        
    }
    public ArrayList<Item> getMyStore() {
        return myStore;
    }

    public void setMyStore(ArrayList<Item> myStore) {
        this.myStore = myStore;
    }
}
