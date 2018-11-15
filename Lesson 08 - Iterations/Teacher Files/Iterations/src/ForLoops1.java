/* Purpose- make adjustments to for loops per instructions
 *
 * Instructions- create a for loop to print what the statement says
*/
public class ForLoops1 {
    public static void main(String args[]) {

        // #0
        System.out.print("\n#0 prints from 0 to 9\n");
        for (int i = 0; i <= 9; i++){
            System.out.print(i + " ");
        }

        // #1
        System.out.print("\n\n#1 prints from 5 to 15\n");
        for (int i = 0;i <= 9; i++) {
            System.out.print(i + " ");
        }
        // #2
        System.out.print("\n\n#2 prints from 12 to 2\n");
        for (int i = 0;i <=15; i--) {
            System.out.print(i + " ");
        }
        // #3
        System.out.print("\n\n#3 prints your real name 3 times\n");
        for (int i = 1;i <=3; i++) {
            System.out.print("Sade");
        }
            // #4
            System.out.print("\n\n#4 prints from 8 to -3\n");
            for (int i = 8;i >= -3; i--) {
                System.out.print(i + " ");
            }

            // #5
            System.out.print("\n\n#5 prints from 2 to 14 by 2's\n");
            for (int i = 2;i >= -14; i+= 2) {
                System.out.print(i + " ");
            }
                // #6
                System.out.print("\n\n#6 prints from 50 to -20 by 10's\n");
                for (int i = 50;i >= -20; i-=10)  {
            System.out.print(i + " ");
        }
                    // #7
                    int START = 1;
                    int AGE = 1;
                    final int INCR = 2;
                    System.out.print("\n\n#7 Count each year of your life up to your current age\n");
                    for (int i = START; i <= AGE ; i+=INCR){
                        System.out.print(i + " ");
                    }

                    // #8
                    System.out.print("\n\n#8 Create a for loop that counts down from 21 to 0 by 3's\n");



                }
            }

