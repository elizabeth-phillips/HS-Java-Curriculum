
public class Chick implements Animal{
	private String myType;
	private String mySound;
	private String myChildishSound;
	
	public Chick(){
		myType = "Chick";
		mySound = "cluck";
		myChildishSound = "";
	}
	
	public Chick(boolean twoSounds){
		this();
		myChildishSound = "cluckity";
	}
	
	public String getSound(){
		if(!twoSounds || (int)(Math.random()*2) == 0){
			return mySound;
		}else{
			return myChildishSound;
		}		
	}
	
	public String getType(){
		return myType;
	}
}
