import gpdraw.*;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

/*
  This program will start the knight chess piece at a corner of the
  board and attempt to move to all 64 squares.  This first program
  will use a random number generator to attempt a move of type 1-8.
  The possible moves are categorized as follows:

  move 1:  +1 to the right, -2 up, a negative move to go up in the grid
  move 2:  +2 to the right, -1 up
  move 3:  +2 to the right, +1 down
  move 4:  +1 to the right, +2 down
  move 5:  -1 to the left, +2 down
  move 6:  -2 to the left, +1 down
  move 7:  -2 to the left, -1 up
  move 8:  -1 to the left, -2 up

  The program will move the knight until all 64 squares have been
  hit (extremely rare), or the piece gets stuck.  The program will
  print out the board, with numbers ranging from 1-64 for the order
  in which the squares were visited.
*/
public class KnightsTour2 extends KnightsTour1{
  int[][] myAccessGrid;

  public KnightsTour2(int startRow, int startCol){
    super(startRow, startCol);

    myAccessGrid = new int[9][9];

    initAccessGrid();
    upDateAccess (getRow(), getCol());
  }

  protected void initAccessGrid(){
  /* Read initial access data from disk */
	try{
	    Scanner inFile = new Scanner(new File("access.txt"));
	
	    for (int row = 1; row <= 8; row++){
	      for (int col = 1; col <= 8; col++){
	        myAccessGrid[row][col] = inFile.nextInt();
	      }
	    }
	 }catch(IOException e){
	 	System.out.println("Cannot Init. Error: " + e.getMessage());
	 }
  }

  /*  takes in access grid, row and col are the coordinates of the latest
     square to be marked.  We now need to check all 8 moves and decrease
     any appropriate accessibility numbers by -1.  As we check all 8 moves
     we must first check for a valid move (on the grid).  This algorithm
     will allow accessibility numbers to go negative.
   */
  private void upDateAccess(int row, int col){
    int newRow, newCol;

    for (int move = 1; move <= 8; ++move){
      newRow = row + getVertMove()[move];
      newCol = col + getHorizMove()[move];

      if (!((newRow < 1) || (newRow > 8) || (newCol < 1) || (newCol > 8))){
        myAccessGrid[newRow][newCol]--;
      }
    }
  }

  /* Takes in current row/col position and board.  list is uninitialized.
     Will return the list of 8 accessibility values which are potential moves.
     If a move(1..8) is available, that value in list[1..8] will return the
     accessibility of the cell that would be moved to.  If the move is not valid,
     that value if list[1..8] will be 0.
   */
  private int[] getAccessList(int row, int col){
    int move, newRow, newCol;
    int[] list = new int[9];

    initCheckList(list);
    for (move = 1; move <= 8; ++move){
      if (validMove (row,col,move)){
        newRow = row + getVertMove()[move];
        newCol = col + getHorizMove()[move];
        list[move] = myAccessGrid[newRow][newCol];
      }
    }
    return list;
  }

  /* uses info in list, containing access values for each direction
     (1..8).  Determines out of the potential moves which one
     moves toward a square with the lowest accessibility.  It will return
     the lowest first move. If there is a tie, it will return the smaller
     move value.  If all values in the list are <= 0, the function
     returns 0
   */
  private int getBestMove(int[] list){
    int lowestMove, lowestAccess;

    lowestMove = 0;   // set to no move, initially
    lowestAccess = 10;  // set to arbitrarily high state
    for (int move = 1; move <= 8; ++move){
      if ((0 < list[move]) && (list[move] < lowestAccess)){
        lowestMove = move;
        lowestAccess = list[move];
      }
    }
    return lowestMove;
  }

  /* This last function is needed to place the 64th number.  The
     accessibility of the last square reads 0 after numbers 1-63 have
     been placed.  Returns 1 if successful, 0 if unsuccessful
   */
  private boolean finishOff(int row, int col){
    boolean success = false;

    for (int move = 1; move <= 8; ++move){
      if (validMove(row,col,move)){
        row += getVertMove()[move];
        col += getHorizMove()[move];
        getBoard()[row][col] = 64; // Hooray!  10/12/95
        success = true;
      }
    }
    return success;
  }

  /* Precondition:  myBoard has been initialized to all 0's.
     Will attempt a knight's tour around the board.  The piece will start
     at rowStart, colStart.  The function will return the last numbered
     position reached on the board.
   */
  public void doTour(){
    int  move;
    int[] list = new int[9];    // initialized to all 0's
    boolean done = false;

    while (!done){
      list = getAccessList(getRow(),getCol());
      move = getBestMove (list);
      if (move > 0){  // this is a possible move
        setMoveNumber(getMoveNumber() + 1);
        setRow(getRow() + getVertMove()[move]);
        setCol(getCol() + getHorizMove()[move]);
        getBoard()[getRow()][getCol()] = getMoveNumber();
        upDateAccess(getRow(), getCol());
        if (getMoveNumber() == 63){
          done = true;  // not 64 as you would expect, see finishOff
        }
      }else{
        done = true;
      }
    }

    if (getMoveNumber() == 63){
      if (finishOff(getRow(), getCol())){
        setMoveNumber(64);
      }
    }
  }

}