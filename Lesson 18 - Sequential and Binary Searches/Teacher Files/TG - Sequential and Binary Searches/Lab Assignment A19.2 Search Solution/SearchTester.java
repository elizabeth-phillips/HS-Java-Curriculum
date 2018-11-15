public class SearchTester{
	public static void main(String[] args){
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
}