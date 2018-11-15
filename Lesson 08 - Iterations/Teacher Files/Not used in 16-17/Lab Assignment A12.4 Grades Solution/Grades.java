/**
 *  The Grades class to compute the GPA for a given set
 *  of letter grades. It then used the GPA and a set of rules to
 *  determine eligibility for extracurricular activities
 *
 */
 
 import java.util.Scanner;
 
public class Grades{
  boolean hasF;
  private double myGPA;
  private int myTotal;
  private int myCount;
  private Scanner in;

  /**
   *  Constructor for the Grades object
   */
  public Grades(){
    myTotal = 0;
    myCount = 0;
    hasF = false;
    in = new Scanner(System.in); 
  }
  
  /**
   *  Top level method that calls other private methods to compute the
   *  GPA and determine the elegibility status
   */
  public void start(){
   	getInputs();     //get input values from keyboard
    computeGPA();    //compute the mGPA
    displayOutput(); //display the results
  }

  /**
   *  Computes the Grade Point Average.
   *
   * @return   The eligibility value
   */
  private String getEligibility(){
    if (myCount < 4){
      return "Ineligible, taking less than 4 classes";
    }else if (myGPA < 2.0 && !hasF){
      return "Ineligible, gpa below 2.0";
    }else if (myGPA >= 2.0 && hasF){
      return "Ineligible, gpa above 2.0 but has F grade";
    }else if (myGPA < 2.0 && hasF){
      return "Ineligible, gpa below 2.0 and has F grade";
    }else{
      return "Eligible";
    }
  }

  /**
   *  Repeatedly get grade inputs ('A', 'a' - 'F', 'f') and accumulate
   *  grade points until any other value is entered
   */
  private void getInputs(){

    String grade;
    boolean done = false;

    System.out.println();

    while(!done){
      System.out.print("Enter grade (q to quit), then return --> ");
      grade = in.nextLine();

      switch (grade.charAt(0)){
          case 'a':
          case 'A':
            myTotal += 4;
            break;
          case 'b':
          case 'B':
            myTotal += 3;
            break;
          case 'c':
          case 'C':
            myTotal += 2;
            break;
          case 'd':
          case 'D':
            myTotal += 1;
            break;
          case 'f':
          case 'F':
            hasF = true;
            break;
          default:
            done = true;
            --myCount;// don't count this one
            break;
      }
      ++myCount;
    } 
  }

  /**
   *  Computes the Grade Point Average.
   */
  private void computeGPA(){
    myGPA = (double) myTotal / myCount;
  }

  /**
   *  Display the the GPA and eligibility status.
   */
  private void displayOutput(){
    System.out.println();
    System.out.printf("GPA = %.2f", myGPA);
    System.out.println("  " + getEligibility());
    System.out.println();
  }

}

