public class MagicSquares {
    public static boolean perfectSquare(int num){
        double result = Math.sqrt(num);
        return (int)result == result;
    }
    public static boolean sumOfSeq(int num){
        int c = 1;
        int total = 0;
        while(total < num){
            total += c;
            c++;
        }
        return total == num;
    }
    public static void magicSquare(int n){
        int c = 1;
        while(n > 0){
            if(perfectSquare(c) && sumOfSeq(c)){
                n--;
                System.out.println(c);
            }
            c++;
        }
    }
}
