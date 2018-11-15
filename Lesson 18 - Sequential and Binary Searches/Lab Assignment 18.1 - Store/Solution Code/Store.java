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
            tempInv = (int)(Math.random() * 100) + 1;
            myStore.add(new Item(tempId,tempInv));
        }
        ///todo: Use your Sort classes' sortList() to sort myStore
        Sort.sortList(myStore);
    }
    public void displayStore(){
        System.out.printf("%5s%10s","Id","Inv");
        System.out.println();
        ///todo: Display the Items in myStore (each on their own line)
        for(int i = 0; i < myStore.size(); i++){
            System.out.printf("%5d%10d",myStore.get(i).getId(),myStore.get(i).getInv());
            System.out.println();
        }
    }
}
