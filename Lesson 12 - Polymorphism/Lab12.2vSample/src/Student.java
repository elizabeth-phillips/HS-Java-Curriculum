


public class Student
{
   private String name;
   private String birthDate;
   private String math;
   private String english;
   
   public Student(String name, String birthDate, String math, String english)
   {
      this.name = name;
      this.birthDate = birthDate;
      this.math = math;
      this.english = english;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String getBirthDate()
   {
      return birthDate;
   }

   public String getMath() { return math; }

   public String getEnglish() { return english; }

   public void setMath(String m)    { math = m; }

   public void setEnglish(String e) { english = e; }

   public String toString()
   {
      String temp = "[";
      temp = temp + name + ", " + birthDate + ", " + math + ", " + english;
      temp = temp + "]";
      return temp;
   }
}
