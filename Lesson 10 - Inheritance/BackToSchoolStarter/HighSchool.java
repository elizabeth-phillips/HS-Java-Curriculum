public class HighSchool{
     public static void main (String args[]){
          Person bob = new Person("Coach Bob", 27, "M");
          Student lynne = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
          System.out.println(bob);
          System.out.println(lynne);
          // The previous two lines could have been written as:
          // System.out.println(bob.toString());
          // System.out.println(lynne.toString());
     }
}
