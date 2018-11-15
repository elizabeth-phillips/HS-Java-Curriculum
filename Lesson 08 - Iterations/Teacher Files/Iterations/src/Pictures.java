import java.awt.*;
import java.util.Random;
import gpdraw.*;

public class Pictures {
    public static void pyramid (int n){
        int line, blanks, stars, temp;

        System.out.println();
        for (line=1; line<=n; line++){
            blanks = n-line;
            stars = line*2-1;
            for (temp=1; temp<=blanks; temp++){
                System.out.print(" ");
            }

            for (temp=1; temp<=stars; temp++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
    public static void rainboxBurst(){
        int max = 500;
        DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
        Random die = new Random();

        pen.down();

        // Draw 120 lines from center of drawing area to edge
        for (int line = 0; line < 360; line++){
            pen.setColor(new Color(die.nextInt(256), die.nextInt(256), die.nextInt(256)));

            pen.forward(max/2 - 30);
            pen.backward(max/2 - 30);
            pen.turnRight(1);
        }
    }
}
