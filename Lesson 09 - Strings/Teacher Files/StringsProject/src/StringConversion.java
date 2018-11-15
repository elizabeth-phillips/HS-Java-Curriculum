import javax.security.auth.Subject;

public class StringConversion {
    public static String shortHand(String s){

        s = s.toLowerCase();
        s = s.replaceAll("with","&");
        s = s.replaceAll("to","2");
        s = s.replaceAll("you","U");
        s = s.replaceAll("for","4");
        s = s.replaceAll("a","");
        s = s.replaceAll("e","");
        s = s.replaceAll("o","");
        s = s.replaceAll("i","");
        s = s.replaceAll("u","");

        return s;
    }

    public static boolean isVowel(char input){
        if(input == 'A') return true;
        else if(input == 'a') return true;
        else if(input == 'E') return true;
        else if(input == 'e') return true;
        else if(input == 'I') return true;
        else if(input == 'i') return true;
        else if(input =='O') return true;
        else if (input=='o') return true;
        else if (input=='U')return true;
        else if (input=='u')return true;



        else return false;
    }

    public static boolean isVowelInWord(String input){
        boolean letter=false;
        for (int i = 0; i<input.length(); i+=1){
            if (isVowel(input.charAt(i))){
                letter=true;
            }
        }
        return letter;
    }

    public static String pigLatin(String input){
        if (!isVowelInWord(input)){
            return input+"ay";
        }
        else if(isVowel(input.charAt(0))){
            return input+"yay";
        }
        else{
            int psn = 0;
            for (int i = 0; i<input.length(); i+=1){
                if (isVowel(input.charAt(i))){
                    psn = i;
                    break;
                }
            }

            String start = input.substring(0,psn);
            String end = input.substring(psn);
            return  end + start + "ay";
        }
    }
}
