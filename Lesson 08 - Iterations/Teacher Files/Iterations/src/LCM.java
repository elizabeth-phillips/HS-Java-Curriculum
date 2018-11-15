public class LCM {
    public static int leastCommonMultiple(int a, int b){
        int small, big, temp;

        if (a<b){
            small = a;
            big = b;
        }else{
            small = b;
            big = a;
        }
        temp = big;
        while (temp % small != 0){
            temp += big;
        }
        return (temp);
    }
}
