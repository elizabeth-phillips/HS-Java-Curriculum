/**
 * A Teacher is a Person with a subject
 * and a salary
 */

public class Teacher extends Person{
  private String mySubject;   // subject taught
  private double mySalary;    // income

  // constructor
  public Teacher(String name, int age, String gender,
                 String subject, double salary){
    // use the super class' constructor
    super(name, age, gender);

    // initialize what's new to Student
    mySubject = subject;
    mySalary = salary;
  }

  public String getSubject(){
    return mySubject;
  }

  public double getSalary(){
    return mySalary;
  }

  public void setSubject(String subject){
    mySubject = subject;
  }

  public void setSalary(double salary){
    mySalary = salary;
  }

  public String toString(){
    return super.toString() +
           ", subject: " + mySubject + ", salary: " + mySalary;
  }
}
