
/**
 *  PiggyBank: This class represents a piggy bank and its actions.
 */


public class PiggyBank {
  	// instance variables
  	private int myPennies;
  	private int myNickels;
  	private int myDimes;
  	private int myQuarters;
  
  	// Constructor
  	public PiggyBank(int pennies, int nickels, int dimes, int quarters){
   		myPennies = pennies;
   		myNickels = nickels;
   		myDimes = dimes;
   		myQuarters = quarters;
  	}
  	
  	public PiggyBank(){
  		myPennies = myNickels = myDimes = myQuarters = 0;
  	}
  
  	// methods
  	int getNumPennies(){
    	return myPennies;
  	}
  
  	int getNumNickels(){
    	return myNickels;
  	}
  
  	int getNumDimes(){
   		return myDimes;
  	}
  
  	int getNumQuarters(){
   		return myQuarters;
  	}
  
  	double calculateBankTotal(){
		double value = (myPennies + myNickels * 5 + myDimes * 10 + myQuarters * 25) / 100.0;
   		return value;
  	}

	void addMoney(int pennies, int nickels, int dimes, int quarters){
   		myPennies += pennies;
   		myNickels += nickels;
   		myDimes += dimes;
   		myQuarters += quarters;
	}
}	
