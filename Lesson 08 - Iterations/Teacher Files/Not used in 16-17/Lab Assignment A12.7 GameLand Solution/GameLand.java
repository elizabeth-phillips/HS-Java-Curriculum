
/** GameLand class to run the GameLand game!
 *
 */

import java.util.Random;

public class GameLand {
	
	final int boardSize = 100;
	final int backMove = 7;
	final int loseTurn1 = 2;
	final int loseTurn2 = 12;
	int one, two;
	
	Random die1, die2;
	
	public GameLand(){
		one = two = 1;
		die1 = new Random();
		die2 = new Random();
	}
	
	public void play(boolean print){
		int roll;
		
		if(print){
			System.out.printf("%20s%20s\n", "Player One", "Player Two");
		}
		
		do{
			roll = rollDice();
			one += spacesToMove(roll);
			if(one < 1){
				one = 1;
			}
			if(one == two){
				two = 1;
			}
			
			if(print){
				System.out.printf("%10d", one);
				System.out.printf(" roll = %2d", roll);
			}
			
			if (isWinner(one)) {
				break;
			}
		
			
			roll = rollDice();
			two += spacesToMove(roll);
			if(two < 1){
				two = 1;
			}
			if(two == one){
				one = 1;
			}
			
			if(print){
				System.out.printf("%10d", two);
				System.out.printf(" roll = %2d", roll);
			}
		
			if (isWinner(two)) {
				break;
			}
			System.out.println();

		}while(true);
		
		System.out.println();
		System.out.print("And the winner is player ");
		if(one > two){
			System.out.println("one!!");
		}else{
			System.out.println("two!!");
		}
		
	}
	
	private int spacesToMove(int roll) {
		if(roll == backMove){
			return -backMove;
		}
		if(roll == loseTurn1 || roll == loseTurn2) {
			return 0;
		}
		return roll;
	}
	
	private boolean isWinner(int player){
		return player >= boardSize;
	}
	
	private int rollDice(){
		return die1.nextInt(6) + 1 + die2.nextInt(6) + 1;
	}
	
}
