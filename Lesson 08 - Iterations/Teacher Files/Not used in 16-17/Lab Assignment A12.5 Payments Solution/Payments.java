
/**
 * A class to represent a loan and keep track of the interest paid.
 */

import java.util.Scanner;

public class Payments{
  private double myPrincipal;      // loan principal
  private double myRate;           // annual interest rate
  private double myPayment;        // monthly payments
  private double myMonthlyRate;    // monthly interest rate
  private double myTotalInterest;  // monthly interest rate

	public Payments(){
		getData();
	    myMonthlyRate = myRate/12.0/100;
	}

  public Payments(double principal, double rate, double payment){
    myPrincipal = principal;
    myRate = rate;
    myPayment = payment;
    myMonthlyRate = myRate/12.0/100;
  }

  public void loanTable(){
    int month = 1;
    double interest;

	System.out.printf("%-10s", "Month");
	System.out.printf("%-15s", "Principal");
	System.out.printf("%-15s", "Interest");
	System.out.printf("%-15s", "Payment");
	System.out.printf("%-15s", "New Balance");
    System.out.println();
    System.out.println();

    do{
       interest = myPrincipal * myMonthlyRate;
       myTotalInterest += interest;

		System.out.printf("%7d", month);
		System.out.printf("%15.2f", myPrincipal);
		System.out.printf("%15.2f", interest);
		System.out.printf("%14.2f", myPayment);

       myPrincipal = myPrincipal + interest - myPayment;

       System.out.printf("%16.2f", myPrincipal);
       System.out.println();

       ++month;
    }while (myPrincipal > myPayment);

    System.out.println();
    System.out.printf("Total interest = %25.2f", myTotalInterest);

  }

  public double getPrincipal(){
    return myPrincipal;
  }

  public void getData(){
    Scanner in = new Scanner(System.in);

    System.out.println();
    System.out.print("Enter principal --> ");
    myPrincipal = in.nextDouble();
    System.out.print("Enter annual interest rate (%) --> ");
    myRate = in.nextDouble();
    System.out.print("Enter monthly payment --> ");
    myPayment = in.nextDouble();
    System.out.println();
  }
  
}

