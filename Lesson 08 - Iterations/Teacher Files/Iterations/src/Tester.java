public class Tester {
    public static void main(String[] args){
        String s = "Howdy";
        String pigString;
        pigString = s.substring(1, s.length()) + s.substring(0,1) + "ay";
        System.out.println(pigString);


        /*System.out.println(x.length());
        System.out.println(x.indexOf ("ll"));
        System.out.println(x.indexOf("he"));
        System.out.println("x.substring(\"Hel\")");
        System.out.println(x.substring(2));
        System.out.println(x.substring(2, 4));
        System.out.println("x.length");
        System.out.println(x.substring(2,3));
        System.out.println(x.equals("ELLO"));
        System.out.println(x.substring(3));*/
    }
    public static void mystery(int z) {
            int x = 1;
            int y = 3;
            while (z > x + y) {
                x = y + z;
                y = x + z;
                z = x - y;
            }
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            System.out.println("z = " + z);
    }




}
