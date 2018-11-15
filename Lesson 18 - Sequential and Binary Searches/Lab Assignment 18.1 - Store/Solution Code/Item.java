/**
 * Creates the template for an Item
 * @author:  [place your name]
 * @version:  [place today's date]
 *
 */
public class Item {
    private int myId;
    private int myInv;

    public Item(int id, int inv){
        myId = id;
        myInv = inv;
    }

    public int getId(){
        return myId;
    }

    public int getInv(){
        return myInv;
    }

    /**
     * Compares 2 Items by their Id number.
     *
     * @param other The other Item to compare the current one to
     * @return the difference of the other's Id number to the current one
     * If there is not a difference the return value should be 0
     */
    public int compareTo(Item other){
        ///todo: create a compareTo method
        return other.getId() - myId;
    }

    /**
     * Checks 2 Items to see if their Id numbers are equivalent
     *
     * @param other The other Item to compare the current one to
     * @return true: if the inventory numbers are the same
     *          false: if the inventory numbers are different
     */
    public boolean equals(Item other){
        ///todo: create an equals method
        return this.compareTo(other) == 0;
    }

    /**
     * Example output:  184    14
     * @return id [then 4 spaces] then inventory
     */
    public String toString(){
        ///todo: create a toString method
        return myId + "    " + myInv;
    }
}
