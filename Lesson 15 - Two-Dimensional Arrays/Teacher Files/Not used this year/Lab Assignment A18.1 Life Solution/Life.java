import gpdraw.*;
import java.io.*;
import java.util.Scanner;

/** life.java
 *
 * This program will simulate the game of Life as described in the
 * mathematical model by Conway.  The program will read a text file
 * containing the initial grid of bacteria.  The program will then
 * proceed for 5 generations and print answers.
 *
 * The identifiers used in this program are taken from the bacteriology
 * lab room.  A petri dish is used to culture and study bacteria growth.
 * To inoculate means to expose a sterile petri dish to bacteria.
 */
public class Life{
  public Life(int[][] dish){
    Scanner inFile;
    
    try{
    	inFile = new Scanner(new File("life100.txt"));
	    int loop, howmany, r, c;
	
	    howmany = inFile.nextInt();
	    for (loop = 1; loop <= howmany; loop++){
	      r = inFile.nextInt();
        System.out.println(r);
	      c = inFile.nextInt();
	      dish[r][c] = 1;
	    }
	}catch(IOException e){
		System.out.println("Could not create Life! Error: " + e.getMessage());
	}
  }

  public void screenDump (int[][] temp){
    int row, col;

    System.out.println("       12345678901234567890");
    System.out.println();

    for (row = 1; row <= 20; row++){
      System.out.print(Format.right(row, 2) + "     ");  // 5 blanks
      for (col = 1; col <= 20; col++){
        if (temp[row][col] > 0){
          System.out.print("*");
        }else{
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public int countLiving (int[][] temp){
    int  row, col, count = 0;

    for (row = 1; row <= 20; row++){
      for (col = 1; col <= 20; col++){
        if (temp[row][col] > 0){
          count++;
        }
      }
    }
    return count;
  }

  public int countRow (int[][] temp, int row){
    int col, count = 0;

    for (col = 1; col <= 20; col++){
      if (temp[row][col] > 0){
        count++;
      }
    }
    return count;
  }

  public int countCol (int[][] temp, int col){
    int row, count=0;

    for (row = 1; row <= 20; row++){
      if (temp[row][col] > 0){
        count++;
      }
    }
    return count;
  }

  /*
     adds 1 to each neighbor in all 8 directions.
     This will put numbers in the border area
     but the lifeOrDeath function will clean them up.
  */
  private void addNeighbors(int[][] temp, int r, int c){
    int  row,col;

    for (row = r - 1; row <= r + 1; row++){
      for (col = c - 1; col <= c + 1; col++){
        temp[row][col]++;
      }
    }
    temp[r][c]--; // take away the 1 added to the middle cell
  }

  /*
     dataDish has data to create next generation.  mainDish has previous
     generation, will create next generation from dataDish.
     If a value in dataDish == 3, then that location was empty, it
     has 3 neighbors, bring it to life.
     If a value in dataDish == 102 or 103, keep it alive.
     All other values result in a dead spot.
  */
  private void lifeOrDeath (int[][] mainDish, int[][] dataDish){
    int r, c;

    for (r = 1; r <= 20; r++){
      for (c = 1; c <= 20; c++){
        if (3 == dataDish[r][c]){
          mainDish[r][c] = 1;
        }else if ((102 == dataDish[r][c]) || (103 == dataDish[r][c])){
          mainDish[r][c] = 1;
        }else{
          mainDish[r][c] = 0;
        }
      }
    }
  }

  /*
     mainDish will be an alias for petriDish in function main.
     A local dataDish will be created within nextGen.  Every cell in
     mainDish will be analyzed for life(1) or death(0).  If a cell is
     alive, a 100 will be assigned to the corresponding cell in dataDish
     and all 8 of its neighbors will be incremented +1 in tempDish.  The
     data in dataDish will be studied in lifeOrDeath to determine who
     lives or dies in the next mainDish.
  */
  public void nextGen(int[][] mainDish){
    int[][] dataDish = new int[mainDish.length][mainDish[0].length];
    int row, col;

    for (row = 1; row <= 20; row++){
      for (col = 1; col <= 20; col++){
        if (mainDish[row][col] > 0){
          addNeighbors (dataDish,row,col);
          dataDish[row][col] += 100;
        }
      }
    }
    lifeOrDeath(mainDish, dataDish);
  }

}
