public class HighSchool{
     public static void main (String args[]){
          Person bob = new Person("Coach Bob", 27, "M");
          Student lynne = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
          System.out.println(bob);
          System.out.println(lynne);
          CollegeStudent sue = new CollegeStudent("Sue", 12,"F","123",4.0, "CS",4);
          Teacher teach = new Teacher("Phil", 13, "F","CS", 10);
          System.out.println(sue);
          System.out.println(teach);
     }
}
