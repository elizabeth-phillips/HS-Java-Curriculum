/**
 * Created by Elizabeth on 1/16/2018.
 */
public class Driver {
    public static void main(String[] args){
        for(int i = 1; i < 11; i++){
            System.out.print("Line " + i );
            Permutation.nextPermutation();
            System.out.println();
        }

    }
}
