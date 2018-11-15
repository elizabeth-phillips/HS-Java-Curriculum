import java.util.ArrayList;

public class HighSchoolMain
{
   public static void main(String[] args)
   {
      Student[] temp = {new Student("Sue","01-23-2001","Algebra 1","English 1"),
                        new Student("Bob","07-21-2000","Algebra 1","PreAP English 1"),
                        new Student("Ann","03-15-2002","PreAP Geometry","English 1"),
                        new Student("Joe","08-01-2001","Geometry","PreAP English 1" )};
      Grade09 g9 = new Grade09();
      g9.addStudents(temp);
      System.out.println(g9);
   }
}