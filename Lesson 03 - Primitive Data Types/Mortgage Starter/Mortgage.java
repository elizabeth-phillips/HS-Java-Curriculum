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
        return 0.0;
    }
    
    public double calcNumYears(){
        //todo: Calculate the number of years it would take to pay off
        return 0.0;
    }
    
    public double calcTotalPayment(){
        //todo: Calculate the total payment
        return 0.0;
    }
    
    public double calcInterest(){
        //todo: Calculate the total interest
        return 0.0;
    }
}
