public class MortgageCalculator
{
    public static void main(String[] args)
    {
        System.out.println("Mortgage Calculator");
        double principal  = 250000;
        double annualRate = 4.85;
        double numYears   = 30;
        Mortgage myMortgage1 = new Mortgage(principal, annualRate, numYears);
        //Code to print the calculated values
        System.out.println("Principal: $" + principal);
        System.out.println("Annual Rate: " + annualRate + "%");
        System.out.println("Number of Years: " + numYears);
        System.out.println("Monthly Payment: $" + myMortgage1.calcMonthly());
        System.out.println("Total Payments: $" + myMortgage1.calcTotalPayment());
        System.out.println("Total Interest: $" + myMortgage1.calcInterest());
        System.out.println();
    }
}
