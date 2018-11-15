// Game.java
// It will be used to test the Deck class program.
// //////////////////////////////////////////////////////////
// This program is designed to explain the "Elevens" lab created
// by Michael Clancy, Robert Glen Martin and Judith Hromcik.
// Divided into stages and altered August 2014 by Leon Schram.


public class Game
{
   public static void main(String[] args){
      Deck deck = new Deck();
      System.out.println("======================First Shuffle======================");
      System.out.println(deck);
      deck.shuffle();
      System.out.println("======================Second Shuffle======================");
      System.out.println(deck);
   }
}

/*Output will vary since it is random. 
Check to see if the deck is out of order. (Shuffled)
In the second print, it should be in a different random order
Sample Output:

======================First Shuffle======================
[Spades, Four, 4]
[Diamonds, Three, 3]
[Hearts, Ten, 10]
[Clubs, Four, 4]
[Diamonds, Two, 2]
[Hearts, Four, 4]
[Spades, Two, 2]
[Spades, Ten, 10]
[Spades, Queen, 10]
[Hearts, King, 10]
[Hearts, Nine, 9]
[Diamonds, Five, 5]
[Clubs, Six, 6]
[Hearts, Queen, 10]
[Hearts, Six, 6]
[Hearts, Five, 5]
[Spades, Five, 5]
[Hearts, Seven, 7]
[Clubs, Three, 3]
[Hearts, Jack, 10]
[Hearts, Two, 2]
[Clubs, Two, 2]
[Diamonds, Ten, 10]
[Clubs, Ten, 10]
[Hearts, Three, 3]
[Spades, Three, 3]
[Clubs, Ace, 11]
[Spades, Six, 6]
[Diamonds, Four, 4]
[Clubs, Seven, 7]
[Clubs, Nine, 9]
[Diamonds, Seven, 7]
[Diamonds, Jack, 10]
[Diamonds, Nine, 9]
[Clubs, Eight, 8]
[Spades, Jack, 10]
[Diamonds, Six, 6]
[Hearts, Eight, 8]
[Clubs, Jack, 10]
[Spades, Eight, 8]
[Spades, Nine, 9]
[Diamonds, Eight, 8]
[Spades, Ace, 11]
[Diamonds, Queen, 10]
[Hearts, Ace, 11]
[Clubs, King, 10]
[Diamonds, King, 10]
[Spades, Seven, 7]
[Diamonds, Ace, 11]
[Clubs, Five, 5]
[Clubs, Queen, 10]
[Spades, King, 10]
======================Second Shuffle======================
[Spades, Ten, 10]
[Hearts, Jack, 10]
[Diamonds, Jack, 10]
[Hearts, Eight, 8]
[Spades, Ace, 11]
[Diamonds, Five, 5]
[Spades, Five, 5]
[Clubs, Ten, 10]
[Clubs, Queen, 10]
[Hearts, Five, 5]
[Diamonds, Six, 6]
[Hearts, Nine, 9]
[Spades, Four, 4]
[Diamonds, Three, 3]
[Clubs, Six, 6]
[Spades, Eight, 8]
[Diamonds, King, 10]
[Diamonds, Two, 2]
[Clubs, Three, 3]
[Hearts, Three, 3]
[Spades, Jack, 10]
[Clubs, Seven, 7]
[Diamonds, Nine, 9]
[Diamonds, Ace, 11]
[Spades, Nine, 9]
[Diamonds, Eight, 8]
[Clubs, Ace, 11]
[Spades, King, 10]
[Clubs, Jack, 10]
[Diamonds, Four, 4]
[Hearts, Four, 4]
[Hearts, Ten, 10]
[Diamonds, Ten, 10]
[Hearts, Two, 2]
[Spades, Seven, 7]
[Spades, Two, 2]
[Hearts, Queen, 10]
[Clubs, Nine, 9]
[Clubs, King, 10]
[Spades, Three, 3]
[Clubs, Eight, 8]
[Spades, Queen, 10]
[Spades, Six, 6]
[Hearts, Ace, 11]
[Hearts, Seven, 7]
[Diamonds, Queen, 10]
[Clubs, Five, 5]
[Hearts, Six, 6]
[Hearts, King, 10]
[Clubs, Four, 4]
[Diamonds, Seven, 7]
[Clubs, Two, 2]
*/