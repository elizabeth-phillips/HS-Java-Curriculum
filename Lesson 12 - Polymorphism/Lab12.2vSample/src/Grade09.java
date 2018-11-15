import java.util.ArrayList;


public class Grade09 extends CommonHighSchool
{
   private ArrayList<Student> students;
   
   public Grade09()
   {
      students = new ArrayList<>();
   }
    
   public void addStudents(Student[] s) {
      for (int k = 0; k < s.length; k++)
      {
         Student student = new Student(s[k].getName(),s[k].getBirthDate(),s[k].getMath(),s[k].getEnglish());
         students.add(student);
      }
   } 

   public void register()     
   { System.out.println("Register 9TH GRADER"); }  
   
   public void orientation()  
   { System.out.println("Organize 9TH GRADE orientation"); }  
   
   public void fundRaising()  
   { System.out.println("Explain 9TH GRADE fund raising"); }  
   
   public void socialEvents() 
   { System.out.println("Organize 9TH GRADE social events"); }  
   
   public void parking()      
   { System.out.println("9TH GRADE students have no parking lot"); }  
   
   public String toString()
   {
      String temp = "";
      for (Student student : students)
         temp = temp + student + "\n";
      return temp;
   } 
}