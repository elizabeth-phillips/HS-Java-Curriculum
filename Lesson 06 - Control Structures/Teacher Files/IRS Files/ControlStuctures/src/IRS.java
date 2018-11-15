/***
 * Write a code to calculate the amount of taxes a certain person must pay
 * @author Aimee Ornelas
 * @version October 19, 2017
 */
public class IRS {

    private int status;
    private double income;
    private double taxPercent;

    public IRS(int status, double income){
        this.status = status;
        this.income = income;
    }

    public String findStatus(){
        if(this.status == 1){
            return "Single";
        }
        else{
            return "Married";
        }
    }

    public double fedTax(){
        if(this.status == 1){
            if(0 <= this.income && this.income <= 27049){
                taxPercent = .15 * (income);
            }
            else if(27050 <= income && income <= 65549){
                taxPercent = 4057.50 + .275 * (income - 27050);
            }
            else if(65550 <= income && income <= 136749){
                taxPercent = 14645 + .305 * (income - 65550);
            }
            else if(136750 <= income && income <= 297349){
                taxPercent = 36361 + .355 * (income - 136750);
            }
            else{
                taxPercent = 93374 + .391 * (income - 297350);
            }
        }
        else{
            if(0 <= income && income <= 45199) {
                taxPercent = .15 * income;
            }
            else if(45200 <= income && income <= 109249){
                taxPercent = 6780 + .275 * (income - 45200);
            }
            else if(109250 <= income && income <= 166499){
                taxPercent = 24393.75 + .305 * (income - 109250);
            }
            else if(166500 <= income && income <= 297349){
                taxPercent = 41855 + .355 * (income - 166500);
            }
            else{
                taxPercent = 88306 + .391 * (income - 297350);
            }
        }
        return taxPercent;
    }

    public String output(){
        String out = "Marital Status = " + findStatus()+
                "\nTaxable Income = " + income+
                "\nYour Federal Tax - " + fedTax();
        return out;
    }

}
