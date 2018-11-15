public class Accountant {
    public static void main(String[] args){
        IRS irs = new IRS(1,15500);
        //irs.output();
        System.out.println(irs.output());
        IRS irs2 = new IRS(1,100000);
        //irs2.output();
        System.out.println(irs2.output());
        IRS irs3 = new IRS(1,480000);
        //irs3.output();
        System.out.println(irs3.output());
        IRS irs4 = new IRS(2,50000);
        //irs4.output();
        System.out.println(irs4.output());
        IRS irs5 = new IRS(2,125000);
        //irs5.output();
        System.out.println(irs5.output());
        IRS irs6 = new IRS(2,400000);
        //irs6.output();
        System.out.println(irs6.output());
        /*
            Single, $15,500   2325.00
            Single, $100,000 25152.25
            Single, $480,000 164790.15
            Married, $50,000 8100
            Married, $125,000 29197.5
            Married, $ 400,000 128442.15
         */
    }
}
