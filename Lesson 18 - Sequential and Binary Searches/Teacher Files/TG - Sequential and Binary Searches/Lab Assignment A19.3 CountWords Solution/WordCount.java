/**
 *  Word and frequency of occurrence data type
 */

public class WordCount
{
  private String myWord;
  private int myCount;  // occurrences of word

  public WordCount(String word, int count)
  {
    myWord = word;
    myCount = count;
  }
  
  public int getCount(){
  	return myCount;
  }
  
  public void setCount(int count){
  	myCount = count;
  }
  
  public String getWord(){
  	return myWord;
  }
  
  public void setWord(String word) {
  	myWord = word;
  }
}
