import java.util.ArrayList;
import java.util.Random;

public class Permutation
{
    public static void nextPermutation()
    {
        ArrayList<Integer> list = new ArrayList<>(10);
        for (int i = 1; i <= 10;i++)
        {
            list.add(i);
        }

        Random random = new Random();
        while(list.size() != 0)
        {
            int index = random.nextInt(list.size());
            System.out.print(list.get(index) + " ");
            list.remove(index);
        }

        System.out.println();
    }
}