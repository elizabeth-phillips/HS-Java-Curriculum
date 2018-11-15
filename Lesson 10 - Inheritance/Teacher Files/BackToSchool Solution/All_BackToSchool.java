public class BackToSchool{
  public static void main (String args[]){
    Person bob = new Person("Coach Bob", 27, "M");
    System.out.println(bob);

    Student lynne = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
    System.out.println(lynne);

    Teacher mrJava = new Teacher("Duke Java", 34, "M", "Computer Science", 50000);
    System.out.println(mrJava);

    CollegeStudent ima = new CollegeStudent("Ima Frosh", 18, "F", "UCB123",
                                            4.0, 1, "English");
    System.out.println(ima);
  }
}


/**
 * A CollegeStudent, is a Student with a class standing
 * and a major
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

/**
 * A Person class used to define a very basic person.
 *
 */

public class Person{
  private String myName ;   // name of the person
  private int myAge;        // person's age
  private String myGender;    // 'M' for male, 'F' for female

  // constructor
  public Person(String name, int age, String gender){
    myName = name;
    myAge = age;
    myGender = gender;
  }

  public String getName(){
    return myName;
  }

  public int getAge(){
    return myAge;
  }

  public String getGender(){
    return myGender;
  }

  public void setName(String name){
    myName = name;
  }

  public void setAge(int age){
    myAge = age;
  }

  public void setGender(String gender){
    myGender = gender;
  }

  public String toString(){
    return myName + ", age: " + myAge + ", gender: " + myGender;
  }
}