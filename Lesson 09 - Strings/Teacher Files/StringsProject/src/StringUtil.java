public class StringUtil {
    public static String stringReversal(String input) {
        String reversal = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversal += input.charAt(i) ;

        }
        return reversal.toString();

    }
    public static String casePunctWord(String input) {
        input = input.replaceAll("'", "");
        String input1 = input.replaceAll(" ", "");
        String input2 = input1.replaceAll(",","");
        String input3 = input2.toLowerCase();
        return input3;


    }
    public static boolean palindrome(String input){
        String reversal = stringReversal(casePunctWord(input));
        if (reversal.equals(casePunctWord(input))){
            return true;
        }
        return false;
    }
}
