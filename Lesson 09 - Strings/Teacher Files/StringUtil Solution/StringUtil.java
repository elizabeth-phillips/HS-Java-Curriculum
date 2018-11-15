
/**
 *  A utility class for Strings.  
 */


public class StringUtil {
	
	/**
	 *  Returns String s converted into Pig Latin.
	 */
	public static String PigLatin(String s){
		return deWord(s);
	}
	
	//Recursively splits the String into individual words and
     //calls latinate.

	private static String deWord(String s){
		
		String front, back;
		
		if(s.indexOf(' ') > -1){
			front = s.substring(0, s.indexOf(' '));
			back = s.substring(s.indexOf(' ') + 1);
			return latinate(front) + " " + deWord(back);
		}else{
			return latinate(s);
		}
	}
	
	//Applies the rules for Pig Latin to the String.
	//precondition: s is a single word with no spaces
	private static String latinate(String s){

		//Check first case: if no vowels, return word + "ay"
		boolean vowels = false;
		if(s.indexOf('a') > -1){
			vowels = true;
		}
		if(s.indexOf('e') > -1){
			vowels = true;
		}
		if(s.indexOf('i') > -1){
			vowels = true;
		}
		if(s.indexOf('o') > -1){
			vowels = true;
		}
		if(s.indexOf('u') > -1){
			vowels = true;
		}
		if(!vowels){
			return s + "ay";
		}
		
		//Check second case: if first letter is a vowel, return word + "yay"
		String temp = s.toLowerCase();
		char first = temp.charAt(0);
		if(first == 'a' || first == 'e' || first == 'i' 
		              || first == 'o' || first == 'u'){
		    return s + "yay";
		}
		
		//Otherwise, place front consonants on the back + "ay"
		String start, end, trans;
		int decide;
		char it;
		char capital;
		decide = s.indexOf('a');
		it = 'a';
		if(decide > s.indexOf('e') && s.indexOf('e') != -1 || decide == -1){
			decide = s.indexOf('e');
			it = 'e';
		} 
		if(decide > s.indexOf('i') && s.indexOf('i') != -1 || decide == -1){
			decide = s.indexOf('i');
			it = 'i';
		} 
		if(decide > s.indexOf('o') && s.indexOf('o') != -1 || decide == -1){
			decide = s.indexOf('o');
			it = 'o';
		} 
		if(decide > s.indexOf('u') && s.indexOf('u') != -1 || decide == -1){
			decide = s.indexOf('u');
			it = 'u';
		} 
		
		start = s.substring(0, s.indexOf(it));
		end = s.substring(s.indexOf(it));
		
		//Checks for capitalization
		if(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z'){
			start = start.toLowerCase();
			capital = end.charAt(0);
			trans = Character.toString(capital).toUpperCase();
			trans += end.substring(1);
			end = trans;
		}
		
		return end + start + "ay";
	}
	
	
	/**
	 *  Returns true if s is a palindrome, false if not.
	 */
	 public static boolean palindrome(String s){
	 	s = compress(s);
	 	return match(s);
	 }
	 
	 //Removes all punctuation and converts s to lower case.
	 private static String compress(String s){
	 	s = removeChar(' ', s);
	 	s = removeChar('\'', s);
	 	s = removeChar('\"', s);
	 	s = removeChar('.', s);
	 	s = removeChar(',', s);
	 	s = removeChar('!', s);
	 	s = removeChar('?', s);
	 	s = removeChar(';', s);
	 	s = removeChar(':', s);
		s = s.toLowerCase();
		return s;
	 }
	 
	 //Returns a String with the specified char removed from s
	 private static String removeChar(char c, String s){
	 	String one, two;
	 	if(s.indexOf(c) > -1){
	 		one = s.substring(0, s.indexOf(c));
	 		two = s.substring(s.indexOf(c) + 1);
	 		return one + removeChar(c, two);
	 	}else{
	 		return s;
	 	}
	 	
	 }
	 
	 //Compares front and end values.  If they match, remove them
	 //and call the method again with the ends removed.  If they 
	 //ever don't match, return false.  If we reach 0 or 1 length, return true.
	 private static boolean match(String s){
	 	String reduce;
	 	int length = s.length();
	 	
	 	//If length is 1, we've reduced as far as possible.
	 	if(length == 1){
	 		return true;
	 	}
	 	
	 	//If length is 2, we can't reduce anymore so evaluate here
	 	if(length == 2){
	 		if(s.charAt(0) == s.charAt(1)){
	 			return true;
	 		}else{
	 			return false;
	 		}
	 	}
	 	
	 	//Otherwise, remove ends and call match again
	 	if(s.charAt(0) == s.charAt(length-1)){
	 		reduce = s.substring(1, length-1);
	 		return match(reduce);
	 	}else{
	 		return false;
	 	}
	 }
	
	
	/**
	 *  Returns a String that is s in reverse.
	 */
	 public static String reverse(String s){
	 	int length = s.length();
	 	String front, back;
	 	if(length == 1){
	 		return s;
	 	}else{
	 		front = s.substring(0, 1);
	 		back = s.substring(1);
	 		return reverse(back) + front;
	 	}
	 }
	 
	 /**
	  *  Returns a String that is s converted into shorthand
	  */
	  public static String shorthand(String s){
	  	
		s = replace("and", "&", s);
		//Because 'U' would be replaced at the removeChar call below,
		//replace "you" with a large number for now.  A number this large
		//would be nearly impossible to encounter on accident, so no
		//accidental replacements should occur (such as could happen by
		//using something like "***" instead)
		s = replace("you", "12305987237894098612398559872398671029769345", s);
		s = replace("to", "2", s);
		s = replace("for", "4", s);
		
		s = removeChar('a', s);
		s = removeChar('A', s);
		s = removeChar('e', s);
		s = removeChar('E', s);
		s = removeChar('i', s);
		s = removeChar('I', s);
		s = removeChar('o', s);
		s = removeChar('O', s);
		s = removeChar('u', s);
		s = removeChar('U', s);
		
		//correct for U error
		s = replace("12305987237894098612398559872398671029769345", "U", s);

	  	return s;
	  }
	 
	 //Replaces all occurrences of x in s with y
	 private static String replace(String x, String y, String s){
	 	String convert;
	 	if(s.indexOf(x) > -1){
	 		convert = s.substring(0, s.indexOf(x));
	 		convert += y;
	 		convert += s.substring(s.indexOf(x) + x.length());
	 		return replace(x, y, convert);
	 	}else{
	 		return s;
	 	}
	 }
	 
	
}
