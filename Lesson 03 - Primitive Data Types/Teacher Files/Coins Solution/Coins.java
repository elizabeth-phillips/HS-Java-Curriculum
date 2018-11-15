
public class Coins {
	
	/**
	 * Coins: This class accepts a certain number of monetary change.
	 * The output is a list of the number of quarters, dimes, nickels,
	 * and pennies that will make that amount of change
      *  with the least number of coins possible
    */
	
	private int myChange;
	
	public Coins(int change) {
		myChange = change;
	}	
	
	public void calculate(){
		int leftover;
		int quarter, dime, nickel, penny;
		quarter = myChange / 25;
		leftover = myChange % 25;
		dime = leftover / 10;
		leftover %= 10;
		nickel = leftover / 5;
		penny = leftover % 5;
		
		System.out.println(myChange + " cents =>");
		System.out.println("  Quarter(s)  " + quarter);
		System.out.println("  Dime(s)     " + dime);
		System.out.println("  Nickel(s)   " + nickel);
		System.out.println("  Penny(s)    " + penny);
		System.out.println();
		
		 
	}
}
