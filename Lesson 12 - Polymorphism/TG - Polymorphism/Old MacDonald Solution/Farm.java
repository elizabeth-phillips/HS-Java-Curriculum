import java.util.*;

public class Farm {
	private ArrayList <Animal> myFarm;
	/**
	 * Method Farm
	 *
	 *
	 */
	public Farm() {
		myFarm = new ArrayList <Animal>();
		myFarm.add(new Cow("cow" ,"moo moo"));
		myFarm.add(new Chick("chick" ,"cluck cluck"));
		myFarm.add(new Pig("pig" ,"oink oink"));
		myFarm.add(new Chick("chick" ,"cluckity cluck","cheep"));
		myFarm.add(new NamedCow("cow" ,"moo moo", "Elsie"));		
	}
	
	public void animalSounds(){
		for(Animal temp : myFarm){
			System.out.println(temp.getType() + " goes " + temp.getSound());
		}
		NamedCow named = (NamedCow)myFarm.get(4);
		System.out.println(named.getName());
		
	}	
}
