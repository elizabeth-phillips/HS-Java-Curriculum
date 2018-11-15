import java.util.*;


/**
 *  Produces random permutations of the numbers 1 to N
 */
class PermutationGenerator{
  ArrayList <Integer> intList;
  ArrayList <Integer> randPermutation;
  Random randSelection;
  int listSize;

  /**
   *  Constructor for the PermutationGenerator object
   *
   * @param  lSize  Number of integers in the permutation list
   */
  public PermutationGenerator(int lSize){
    randSelection = new Random();
    listSize = lSize;
  }

  /**
   *  Constructor for the PermutationGenerator object. Sets default
   *  permutation list size to 10
   */
  public PermutationGenerator(){
    this(10);
  }

  /**
   *  Generates a random permutation. Fills an ArrayList with the
   *  numbers 1 to listSize so that no two entries of the array have
   *  the same contents. Makes a second ArrayList and fills it with
   *  the numbers 1 to listSize. Then picks one of those at random
   *  (using Random.nextInt(int), removes it, and appends it to the
   *  permutation ArrayList. This operation is repeated listSize times.
   *
   * @return    Random permutation ArrayList
   */
  ArrayList<Integer> nextPermutation(){
    intList = new ArrayList <Integer>(listSize);
    randPermutation = new ArrayList <Integer>(listSize);

    for (int num = 1; num <= listSize; num++){
      intList.add(num);
    }
    for (int num = listSize; num > 0; num--){
      randPermutation.add(intList.remove(randSelection.nextInt(num)));
    }
    return randPermutation;
  }
}

