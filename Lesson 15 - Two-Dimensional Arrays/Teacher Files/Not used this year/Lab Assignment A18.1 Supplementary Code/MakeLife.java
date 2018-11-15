import gpdraw.*;
import java.io.*;
import java.util.Random;

public class MakeLife{
  public static final int MAX = 20;

  public static void inoculate(int[][] table, int howMany){
    int count = 0, row, col;
    Random die = new Random();

    while (count < howMany){
      row = die.nextInt(MAX) + 1;
      col = die.nextInt(MAX) + 1;
      if (0 == table[row][col]){
        table[row][col] = 1;
        count ++;
      }
    }
  }

  public static void saveFile (int[][] table, int howMany){
 
 	FileWriter outFile;
 	try{
	    outFile = new FileWriter("lifeData.txt");
	
		String howM = "";
		howM += howMany;
		howM += "\n";
		String r = "";
		String c = "";
	    outFile.write(howM, 0, howM.length());
	    
	    for (int row = 1; row <= MAX; row++){
	      for (int col = 1; col <= MAX; col++){
	        if (table[row][col] == 1){
	          r = "" + row;
	          while(r.length() < 4){
	          	r += " ";
	          }
	          c = "" + col;
	          while(c.length() < 4){
	          	c += " ";
	          }
	          outFile.write(r, 0, 4);
	          outFile.write(c, 0, 4);
	          outFile.write("\n", 0, 1);
	        }
	      }
	    }

 	    outFile.close();
 	 }catch(IOException e){
 	 	System.out.println("Could not make Life! Error: " + e.getMessage());
 	 }
 	 
  }

}
