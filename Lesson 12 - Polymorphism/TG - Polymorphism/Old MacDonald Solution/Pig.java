
public class Pig implements Animal{
	private String myType;
	private String mySound;
	
	/**
	 *  Pig Constructor
	 *
	 *
	 */
	 
	public Pig() {
		myType = "Pig";
		mySound = "oink";
	}
	
	public String getSound(){
		return mySound;
	}
	
	public String getType(){
		return myType;
	}	
}
