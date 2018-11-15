/* Purpose- Create For Loops that behave per specifications
*/
public class ForLoops2 {
    public static void main(String args[]) {

        // #0 This is an example
        System.out.print("\n#0 prints from 0 to 9\n");
        for (int i = 0; i <= 9; i++)
            System.out.print(i + " ");

        // #1
        System.out.print("\n\n#1 Prints from 3 to 9 by 1's\n");
        for (int i = 3; i <= 9; i++)
            System.out.print(i + " ");

        // #2
        System.out.print("\n\n#2 Prints from 9 to -3 by 1's\n");
        for (int i = 9; i >= -3; i--)
            System.out.print(i + " ");

        // #3
        System.out.print("\n\n#3 Prints LHS seven times\n");
        for (int i = 0; i <= 6; i++)
            System.out.print(i + "LHS");

        // #4
        System.out.print("\n\n#4 Prints from 3 to 27 by 3's\n");
        for (int i = 3; i <= 27; i+=3)
            System.out.print(i + " ");

        // #5
        System.out.print("\n\n#5 Prints from 27 to -3 by 3's\n");
        for (int i = 27; i >= -3; i-=3)
            System.out.print(i + " ");

        // #6
        System.out.print("\n\n#6 Prints from 2 to 128, increasing by double each time\n");
        for (int i = 2; i <= 128; i*=2)
            System.out.print(i + " ");


        // #7
        System.out.print("\n\n#7 Create variables START, STOP, & STEP that you will use in a for loop instead of numbers \n");
        System.out.print("#7 Print from  3 to 21 by 6's\n");
        int START = 3;
        int STOP = 21;
        int STEP = 6;
        for (int i = START; i <= STOP; i+=STEP)
            System.out.print(i + " ");

        // #8
        System.out.print("\n\n#8 Print from 120 to 15 by dividing in half each time\n");
        for (int i = 120; i >= 15; i/=2)
            System.out.print(i + " ");

        // #9
        System.out.print("\n\n#9 Print from 3 to 6561 by multiplying the value by itself each time\n");
        for (int i = 3; i <= 6561; i*=i)
            System.out.print(i + " ");

    }
}

