
public class Cow implements Animal{
	
	/**
	 * Class Cow
	 *
	 *
	 */
		
	private String myType; 
	private String mySound;
	
	public Cow() {
		myType = "cow";
		mySound = "moo";
	}
	
	public String getSound(){
		return mySound;
	}
	
	public String getType(){
		return myType;
	}	
}
