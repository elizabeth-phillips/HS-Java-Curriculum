/**
 *  CheckMail class.  Will print out the amount of federal tax owed 
 *  depending on marital status and taxable income.
 */
 
 import java.util.Scanner;

public class CheckMail{
   private int myWeight, myLength, myWidth, myHeight;
    
   public CheckMail (){  
      myWeight = myLength = myWidth = myHeight = 1;
   }

   public CheckMail(int weight, int length, int width, int height){
      myWeight = weight;
      myLength = length;
      myWidth = width;
      myHeight = height;
   }

   public void dataInput(){
      Scanner keyboard = new Scanner(System.in);
      int temp = 0;
      
      System.out.print("Enter the weight --> ");
      myWeight = keyboard.nextInt();

      System.out.print("Enter 3 dimensions separated by spaces --> ");
      myLength = keyboard.nextInt();
      myWidth = keyboard.nextInt();
      myHeight = keyboard.nextInt();
      
      if (myWidth > myLength)
      {
		// swapping values of myWidth and myLength, using third
          // variable temp
         temp = myWidth;  myWidth = myLength;   myLength = temp;
      }
      if (myHeight > myLength){
	     // swapping values of myHeight and myLength, using 
          //third variable temp
         temp = myHeight;  myHeight = myLength;   myLength = temp;
      }
      System.out.println();
   }
   
   /**
    *  Prints out the answers.
    */
   public void printAnswer(){ 
      int total = myLength + (myWidth*2) + (myHeight*2);
      boolean tooLarge = (total > 100);
      boolean tooHeavy = (myWeight > 70);
      
      System.out.println("Weight = " + myWeight + " lbs");
      System.out.println("Length = " + myLength);
      System.out.print("Other two dimensions = ");
      System.out.println(myWidth + "   " + myHeight);
      System.out.println();
      System.out.print("  Package is - ");

      if (tooLarge && tooHeavy)
         System.out.println("too large and too heavy");
      else if (tooLarge && !tooHeavy)
         System.out.println("too large");
      else if (!tooLarge && tooHeavy)
         System.out.println("too heavy");
      else
         System.out.println("acceptable");
         
      System.out.println();
   }
}
