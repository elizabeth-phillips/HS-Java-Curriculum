
/**
 *  IRS class.  Will print out the amount of federal tax owed depending on
 *  marital status and taxable income.
 *
 *  
 */

import java.util.Scanner;

public class IRS {
	
	private Scanner in;
	private int maritalStatus;
	private double income;
	
	public IRS(){
		maritalStatus = 1;
		income = 0;
		in = new Scanner(System.in);
	}
	
	public IRS(int m, double i){
		maritalStatus = m;
		income = i;
		in = new Scanner(System.in);
	}
	
	/**
	 *  Retrieves data from the keyboard.  Returns true if data is valid,
	 *  false if any of the values are out of range.
	 */
	public boolean inputData(){
		boolean valid = false;
		System.out.print("Enter marital status (1=single, 2=married): ");
		maritalStatus = in.nextInt();
		if(maritalStatus == 1 || maritalStatus == 2){
			valid = true;
		}
		System.out.print("Enter taxable income: ");
		income = in.nextDouble();
		if(income < 0){
			valid = false;
		}
		return valid;
	}
	
	/**
	 *  Returns amount of tax.
	 *  preconditions: maritalStatus is 1 or 2, income > 0
	 */
	public double calcTax(){
		
		if(maritalStatus == 1){
			if(income <= 27050){
				return income * 0.15;
			}else if(income <= 65550){
				return (income - 27050) * 0.275 + 4057.5;
			}else if(income <= 136750){
				return (income - 65550) * 0.305 + 14645;
			}else if(income <= 297350){
				return (income - 136750) * 0.355 + 36361;
			}else{
				return (income - 297350) * 0.391 + 93374;
			}
		}else{
			if(income <= 45200){
				return income * 0.15;
			}else if(income <= 109250){
				return (income - 45200) * 0.275 + 6780;
			}else if(income <= 166500){
				return (income - 109250) * 0.305 + 24393.75;
			}else if(income <= 297350){
				return (income - 166500) * 0.355 + 41855;
			}else{
				return (income - 297350) * 0.391 + 88306;
			}
		}
	}
	
	public void printData(){
		System.out.print("Your Federal tax = ");
		System.out.printf("$%.2f", calcTax());
		System.out.println();
	}
}
