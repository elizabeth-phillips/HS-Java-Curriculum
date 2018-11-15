
public class NamedCow extends Cow{
	private String myName;
	
	/**
	 * Method NamedCow
	 *
	 *
	 */
	public NamedCow() {
		super();
	}
	
	public NamedCow(String name) {
		super();
		myName = name;
	}
	
	public String getName(){
		return myName;
	}	
}
