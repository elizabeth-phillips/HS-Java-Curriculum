public class Farm{
  private ArrayList <Animal> myFarm = new ArrayList <Animal>();

  public Farm(){
    myFarm.add(new Cow());
    myFarm.add(new Chick());
    myFarm.add(new Pig());
  }

  public void animalSounds(){
    Animal temp;
    for (int i = 0; i < myFarm.size(); i++){
      temp = myFarm.get(i);
      System.out.println(temp.getType() + " goes " + temp.getSound());
    }
  }
}