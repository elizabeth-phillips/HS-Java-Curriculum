
import apcslib.Format;
//import chn.util.*;
import java.util.*;
import java.io.*;

/**
 *  Counts the occurrences of words in a text file. Parses the file
 *  and prints out the following statistical results:
 *  - Total number of unique words used in the file.
 *  - Total number of words in a file.
 *  - The top 30 words which occur the most frequently, sorted
 *    in descending order by count.
 */

public class CountWords
{
  ArrayList <WordCount>wordList;
  //FileInput inFile;
  Scanner myScanner;

  /**
   *  Constructor for the CountWords object
   *
   * @param  fName  Description of Parameter
   */
  public CountWords(String fName)
  {
    wordList = new ArrayList<WordCount>();
    try {
	    myScanner = new Scanner(new File(fName));
    }catch (FileNotFoundException e){
    	System.out.println(fName + " not found");
    }
    // see java.util.regex.Pattern
    // p{Punct} is any punctuation mark, which sadly includes ' & -.
    // The &&['-] part says don't include them.
    // \s is any white space character.
    // \d is any digit.
    // | is or.
    // So the delimiter is any punctuation mark (except ' or -)
    // or any white space character or any digit.
    myScanner.useDelimiter("[\\p{Punct}&&[^'-]]|\\s|\\d");
    parseWords();
    qSortByCount(wordList, 0, wordList.size() - 1);
  }

  /**
   *  Constructor for the CountWords object
   */
  public CountWords()
  {
    this("test.txt");
  }

  /**
   *  Gets the size attribute of the CountWords object
   *
   * @return    The size value
   */
  public int getSize()
  {
    return wordList.size();
  }

  /**
   *  Will add nextWord to the wordList. Sequence of events: 1. search
   *  for nextWord in wordList, if found, add one to count field 2. if
   *  nextWord is not in wordList, add to list using an insertion sort
   *  algorithm and update count of words in list by +1.
   *
   * @param  nextWord  Word to be added to wordlist
   */
  public void addWord(String nextWord)
  {
    int index;

    nextWord = nextWord.toLowerCase();
    index = searchForWord(nextWord);
    if (index == -1)
    {
      // nextWord is a new word in list
      wordList.add(new WordCount(nextWord, 1));
      index = wordList.size() - 1;
      while ((index > 0) && 
      	(wordList.get(index - 1).getWord().compareTo(
      		wordList.get(index).getWord()) > 0))
      {
        //Collections.swap(wordList, index, index-1);
        WordCount temp = wordList.get(index - 1);
        wordList.set(index - 1, wordList.get(index));
        wordList.set(index, temp);
        index--;
      }
    }
    else
    {
      // nextWord already present so increment its count
      WordCount temp = wordList.get(index);
      temp.setCount(temp.getCount()+1);
    }
  }

  /**
   *  Searches for target in wordList using a binary search
   *
   * @param  target  any String
   * @return         index of target if found in wordList, otherwise -1
   */
  public int searchForWord(String target)
  {// searches for w1 in list using a binary search

    int low = 0;
    int high = wordList.size() - 1;
    int mid;

    while (low <= high)
    {
      mid = (low + high) / 2;
      if (wordList.get(mid).getWord().equals(target))
      {
        return mid;
      }
      else
      {
        if (target.compareTo(wordList.get(mid).getWord()) < 0)
        {
          high = mid - 1;
        }
        else
        {
          low = mid + 1;
        }
      }
    }
    return -1;
  }

  /**
   *  Sorts wordList in in descending order using a recursive
   *  quicksort algorithm
   *
   * @param  list   list to be sorted
   * @param  first  start index of range to be sorted
   * @param  last   end index of range to be sorted
   */
  public void qSortByCount(ArrayList <WordCount>list, int first, int last)
  {

    int g = first;
    int h = last;
    int midIndex;
    int dividingValue;

    midIndex = (first + last) / 2;
    dividingValue = wordList.get(midIndex).getCount();
    do
    {
      while (wordList.get(g).getCount() > dividingValue)
      {
        g++;
      }
      while (wordList.get(h).getCount() < dividingValue)
      {
        h--;
      }
      if (g <= h)
      {
        WordCount temp = list.get(g);
        list.set(g, list.get(h));
        list.set(h, temp);
        g++;
        h--;
      }
    } while (h > g);

    if (h > first)
    {
      qSortByCount(list, first, h);
    }
    if (g < last)
    {
      qSortByCount(list, g, last);
    }
  }

  /**
   *  Displays the request number of WordCount objects from wordList
   *
   * @param  howMany  number of WordCount objects from
   *         wordList to display
   */
  public void displayTopCount(int howMany)
  {
    int k;
    int line = 1;
    int num = 0;

    for (k = 0; k < wordList.size(); k++)
    {
      num += wordList.get(k).getCount();

      // only output the number requested
      if (k < howMany)
      {
        System.out.print(Format.right(line, 3) +
            Format.right(wordList.get(k).getCount(), 6));
        System.out.println("   " + wordList.get(k).getWord());
        if (line % 5 == 0)
        {
          System.out.println();
        }
        line++;
      }
    }
    System.out.println();
    System.out.println("Number of words used = " + wordList.size());
    System.out.println("Total # of words = " + num);
  }

  /**
   *  Parses word from an input file stream and adds the parsed
   *  to an list. On exit all words in file have been parsed and
   *  added to an ArrayList
   */
  private void parseWords()
  {
    while (myScanner.hasNext())
    {
      String word = myScanner.next();
      while ((0 ==word.length() || word.equals("-")) && myScanner.hasNext())
      {
        word = myScanner.next();
      }
      //System.out.println("word " + word);  //used to test that the delimiter setup is correct
	  if (word.length() > 0 && !word.equals("-")){
      		addWord(word);
	  }
    }
  }
}

