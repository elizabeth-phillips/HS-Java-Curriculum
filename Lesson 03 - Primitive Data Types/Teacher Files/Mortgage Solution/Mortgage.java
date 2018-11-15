public class Mortgage
{
    private double principal;
    private double annualRate;
    private double numYears;

    public Mortgage(double principal, double annualRate, double numYears){
        this.principal = principal;
        this.annualRate = annualRate;
        this.numYears = numYears;
    }

    public double calcMonthly(){
        //todo: Calculate the monthly payments
        double monthlyRate = annualRate / 1200;
        double numMonths = numYears * 12;

        double temp = Math.pow(1 + monthlyRate, numMonths);
        double monthlyPayment = ((monthlyRate * temp) / (temp - 1)) * principal;

        monthlyPayment *= 100;
        /* rounds Monthly Payment to the nearest penny
        monthlyPayment = Math.round(monthlyPayment);*/

        return monthlyPayment /= 100;
    }

    public double calcTotalPayment(){
        //todo: Calculate the total payment
        return calcMonthly() * (numYears * 12);
    }

    public double calcInterest(){
        //todo: Calculate the total interest
        return calcTotalPayment() - principal;
    }
}
