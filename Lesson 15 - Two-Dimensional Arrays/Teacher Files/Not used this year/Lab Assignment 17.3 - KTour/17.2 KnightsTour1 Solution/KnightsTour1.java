import gpdraw.*;
import java.util.Random;

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
public class KnightsTour1{
  /*
     The array myHorizMove contains the horizontal movement necessary to move to a new
     location.  These values will ultimately be added to a column location.  Likewise 
     the array myVertMove will be used to make vertical moves, which will adjust the
     row location.
  */
  private int[] myHorizMove = {0, 1, 2, 2, 1, -1, -2, -2, -1};
  private int[] myVertMove = {0, -2, -1, 1, 2, 2, 1, -1, -2};
  
  private int[] myCheckList;
  private int[][] myBoard;
  private int myMoveNumber, myRow, myCol;
  private Random myRandomMove;


  public KnightsTour1(){
    this(1, 1);
  }
  
  public int[] getHorizMove(){
  	return myHorizMove;
  }
  
  public void setHorizMove(int[] move) {
  	myHorizMove = move;
  }
  
  public int[] getVertMove(){
  	return myVertMove;
  }
  
  public void setVertMove(int[] move) {
  	myHorizMove = move;
  }
  
  public int[][] getBoard(){
  	return myBoard;
  }
  
  public void setBoard(int[][] board) {
  	myBoard = board;
  }
  
  public int getRow(){
  	return myRow;
  }
  
  public void setRow(int value) {
  	myRow = value;
  }
  
  public int getCol(){
  	return myCol;
  }
  
  public void setCol(int value) {
  	myCol = value;
  }
  
  public int getMoveNumber(){
  	return myMoveNumber;
  }
  
  public void setMoveNumber(int value) {
  	myMoveNumber = value;
  }
  
  public KnightsTour1(int startRow, int startCol){
    myBoard = new int[9][9];
    myCheckList = new int[9]; // myCheckList initialized with all 0
    myRandomMove = new Random();

    myMoveNumber = 1;
    
    // myRow and myCol start at (1,1)
    myRow = startRow;
    myCol = startCol;
    myBoard[myRow][myCol] = myMoveNumber;  // gets the board started
  }

  /* myRow and myCol are a position on the board, move is the potential move we are
     investigating.  If the move is legal (on the board and not already taken) we
     return true, otherwise false.

     Solves for a valid move with 3 steps:
      1.  finds potential new location
      2.  checks to see if that location is on the board
      3.  if on the board, checks to see if square is empty 
  */
  protected boolean validMove(int row, int col, int move){
    boolean valid = true;  // start out assuming valid state
    int newRow, newCol;
  
    newRow = row + myVertMove[move];  // vertical move changes the row number
    newCol = col + myHorizMove[move]; // horizontal move changes the col number
    if (newRow < 1 || newRow > 8 || newCol < 1 || newCol > 8)
      valid = false;
    else if (myBoard[newRow][newCol] != 0)
      valid = false;
    return valid;
  }

  public void printBoard(){
    int row,col;
  
    System.out.print("     ");  // 5 spaces
    for (col = 1; col <= 8; ++col){
      System.out.print(Format.right(col, 5));
    }
    System.out.println();
    System.out.println();
    for (row = 1; row <= 8; ++row){
      System.out.print(Format.right(row, 5));
      for (col = 1; col <= 8; ++col){
        System.out.print(Format.right(myBoard[row][col], 5));
      }
      System.out.println();
    }
  }

  public void initCheckList(int[] checkList){
    for (int loop = 1; loop <= 8; loop++){
      checkList[loop] = 0;
    }
  }

  /*
     list will contain true/false values in positions 1..8.  list[0] will
     not be used.  If all 8 bits are true, all 8 directions have been
     tried and the function returns true, otherwise it returns false.
   */
  private boolean triedAll8Dir (int[] list){
    boolean tryAll = true; // assume that all 8 bits are true
  
    for (int loop=1; loop<=8; ++loop){
      if (list[loop] == 0){
        tryAll = false;
      }
    }
    return tryAll;
  }

  public boolean doNextMove(){
    boolean stuck = false;
    int possibleMove;
    
    possibleMove = myRandomMove.nextInt(8) + 1;
    if (validMove(myRow, myCol, possibleMove)){
      myMoveNumber++;
      myRow = myRow + myVertMove[possibleMove];  // go to new row
      myCol = myCol + myHorizMove[possibleMove]; // go to new col
      myBoard[myRow][myCol] = myMoveNumber;
      initCheckList(myCheckList);   // clean off list, start over
      if (64 == myMoveNumber){
        stuck = true;
      }
    }else{
      myCheckList[possibleMove] = 1;
      if (triedAll8Dir(myCheckList)){
        stuck = true;
      }
    }
    
    return stuck;
  }
   
  /*
    Precondition:  myBoard has been initialized to all 0's.
    Will attempt a knight's tour around the board.  The piece will start
    at row 1, col 1.
   */
  public void doTour(){
    boolean done = false;
  
    while (!done){
      done = doNextMove();
    } 
  }


}