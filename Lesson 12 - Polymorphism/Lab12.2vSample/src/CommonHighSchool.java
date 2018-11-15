// AbstractClass04
// This is the <CommonHighSchool> abstract class implementation 
// of the <HighSchool> interface. All methods that are are not 
// implemented are not shown, as they were in Stage #3.


public abstract class CommonHighSchool implements HighSchool
{
	public void information()  
   { System.out.println("Process STUDENT information"); }    
   
	public void test()         
   { System.out.println("Administer pre-enrollment STUDENT testing"); }  
   
	public void emergency()    
   { System.out.println("Gather STUDENT emergency forms"); }  
   
	public void computeGPA()   
   { System.out.println("Compute STUDENT GPA "); }  
   
   public void progress()     
   { System.out.println("Mail STUDENT progress report"); }  
      
   public void attendance()   
   { System.out.println("Take STUDENT attendance"); }  
   
   public void dressCode()    
   { System.out.println("Pass out STUDENT dresscode policies"); }     
   
   public void residence()    
   { System.out.println("Process STUDENT residence proof"); }

}
