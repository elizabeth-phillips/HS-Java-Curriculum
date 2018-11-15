/**
 *
 * A CollegeStudent, is a Student with a class standing
 * and a major
 *
 */

public class CollegeStudent extends Student{
  static final int FROSH = 1;
  static final int SOPH = 2;
  static final int JUNIOR = 3;
  static final int SENIOR = 4;

  private int myYear;          // FROSH, SOPH, ...
  private String myMajor;

  // constructor
  public CollegeStudent(String name, int age, String gender,
                 String idNum, double gpa, int year, String major){
    // use the super class' constructor
    super(name, age, gender, idNum, gpa);

    // initialize what's new to CollegeStudent
    myYear = year;
    myMajor = major;
  }

  public int getYear(){
    return myYear;
  }

  public String getMajor(){
    return myMajor;
  }

  public void setYear(int year){
    myYear = year;
  }

  public void setMajor(String major){
    myMajor = major;
  }

  public String toString(){
    return super.toString() +
           ", year: " + myYear + ", major: " + myMajor;
  }
}
