
public class driver {
	
	/**
	 * Method main
	 *
	 *
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		Statistics fileStats = new Statistics("numbers.txt");
		
		System.out.printf("%s%.2f","The average = " ,fileStats.average());
    	System.out.println();
    	
    	System.out.printf("%s%.2f","Standard deviation = ", fileStats.stdDev());
    	System.out.println();
    	fileStats.findMode ();
		
	}	
}


/*******************sample run*************************
 *The average = 49.92
Standard deviation = 29.45
The mode is(are) --> 10   48

Press any key to continue...
******************************************************/
