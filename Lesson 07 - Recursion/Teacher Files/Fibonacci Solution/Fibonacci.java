/**
   Fibonacci.java

   This program will solve two algorithms:
   1.  a recursive Fibonacci function
   2.  a recursive multiplication function
 
 */
 
public class Fibonacci{
  
  public Fibonacci(){
  
  }

  /**
   *  Finds the Fibonacci number for n.
   *  precondition: n >= 0
   */
  public int recFib(int n){
    if (0 == n || 1 == n){
      return  n;
    }else{
      return  recFib(n-2) + recFib(n-1);
    }
  }


  /**
   *  Solves for (a * b) recursively, adding a, b times
   *  precondition: 0 <= a <= 10;  0 <= b <= 10;
   */
  public int mult (int a, int b){
      if (0 == a || 0 == b){
        return 0 ;
      }else if(1 == b){
        return a;
      }else{
        return a + mult(a, b - 1);
      }
  }

}
