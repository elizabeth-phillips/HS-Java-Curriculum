// Lab11bv100.java
// This is the 100-point solution of the <Deck> class lab assignment.
// This version is implemented with "Dynamic Arrays"
// This version includes:
//    A constructor that assigns all 52 cards to the <cards> array.
//    A <toString> method that displays all 52 cards.
//    A <shuffle> method that randomizes the <cards> array with swapping.


public class Deck 
{
	private Card[] cards;
   private String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
   private String[] ranks = {"Two","Three","Four","Five","Six","Seven","Eight","Nine",
                             "Ten","Jack","Queen","King","Ace"};
   private int[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11};
   
	private int size;

	public Deck() 
   {
      size = 52;
		cards = new Card[size];
      int count = 0;
      for (int suitIndex = 0; suitIndex < 4; suitIndex++)
      {
         for (int rankIndex = 0; rankIndex < 13; rankIndex++)
         {
            cards[count] = new Card(suits[suitIndex],ranks[rankIndex],values[rankIndex]);
            count++;
         }
      }
      shuffle();
	}
   
   private void shuffle()
   {  
      for (int k = 1; k < 1000; k++)
      {
         int random1 = (int) (Math.random() * 52);
         int random2 = (int) (Math.random() * 52);
         Card temp = cards[random1];
         cards[random1] = cards[random2];
         cards[random2] = temp;
      }
   }
     
   public String toString()
   {
      String temp = "";
      for (int k = 0; k < size; k++)
         temp = temp + cards[k].toString() + "\n";
      return temp;   
   }
}
