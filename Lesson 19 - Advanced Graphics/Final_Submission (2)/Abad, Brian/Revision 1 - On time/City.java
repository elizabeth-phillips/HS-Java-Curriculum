import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Random;

public class City  extends java.applet.Applet {
    int count;		// the quantity of stars to be displayed
    public void init() {
        String str1 = JOptionPane.showInputDialog("Enter Star Count");
        count = Integer.parseInt(str1);
    }

    public void paint(Graphics g) {

        setBackground(new Color(0, 10, 144));
        int xCoord27[] = {0, 1000, 1000, 0};
        int yCoord27[] = {105, 105, 650, 650};
        g.setColor(new Color(27, 119, 27));
        g.fillPolygon(xCoord27, yCoord27, xCoord27.length);
        drawStars(g);
        drawBuildings(g);



        //RightRoad
        int xCoord25[] = {900, 375, 475, 900};
        int yCoord25[] = {100, 650, 650, 100};
        g.setColor(Color.black);
        g.fillPolygon(xCoord25, yCoord25, xCoord25.length);
        //LeftRoad
        int xCoord26[] = {100, 625, 525, 100};
        int yCoord26[] = {100, 650, 650, 100};
        g.setColor(Color.black);
        g.fillPolygon(xCoord26, yCoord26, xCoord26.length);

    }

    public void drawStars(Graphics g){
        for(int i = 0; i < count; i++){
            int x = (int)(Math.random() * getWidth());
            int y = (int)(Math.random() * getHeight() - 555);
            g.fillRect(x,y,5,5);
            g.setColor(Color.white);
        }
    }


    public void drawBuildings(Graphics g){
        //Back Building
        int xCoord[] = {450, 500, 500, 450};
        int yCoord[] = {25, 30, 122, 122};
        g.setColor(Color.black);
        g.fillPolygon(xCoord, yCoord, xCoord.length);
        int xCoord1[] = {375, 450, 450, 375};
        int yCoord1[] = {40, 25, 250, 250};
        g.setColor(Color.black);
        g.fillPolygon(xCoord1, yCoord1, xCoord1.length);


        //Left Side Back Building
        int xCoord2[] = {350, 400, 400, 350};
        int yCoord2[] = {50, 55, 178, 178};
        g.setColor(Color.gray);
        g.fillPolygon(xCoord2, yCoord2, xCoord2.length);
        int xCoord3[] = {350, 325, 325, 350};
        int yCoord3[] = {50, 55, 178, 178};
        g.setColor(Color.gray);
        g.fillPolygon(xCoord3, yCoord3, xCoord3.length);


        //Far Left Side Building
        int xCoord4[] = {300, 332, 275, 250};
        int yCoord4[] = {152, 162, 165, 158};
        g.setColor(Color.lightGray);
        g.fillPolygon(xCoord4, yCoord4, xCoord4.length);
        int xCoord5[] = {250, 275, 275, 250};
        int yCoord5[] = {158, 165, 285, 257};
        g.setColor(Color.lightGray);
        g.fillPolygon(xCoord5, yCoord5, xCoord5.length);
        int xCoord6[] = {275, 332, 332, 275};
        int yCoord6[] = {165, 162, 255, 283};
        g.setColor(Color.lightGray);
        g.fillPolygon(xCoord6, yCoord6, xCoord6.length);


        //Right Side Back Building
        int xCoord7[] = {575, 650, 650, 575};
        int yCoord7[] = {50, 63, 275, 275};
        g.setColor(Color.magenta);
        g.fillPolygon(xCoord7, yCoord7, xCoord7.length);
        int xCoord8[] = {575, 525, 525, 575};
        int yCoord8[] = {50, 55, 275, 275};
        g.setColor(Color.magenta);
        g.fillPolygon(xCoord8, yCoord8, xCoord8.length);

        //Center Building
        int xCoord15[] = {425, 475, 525, 525, 425};
        int yCoord15[] = {100, 90, 100, 250, 250};
        g.setColor(Color.red);
        g.fillPolygon(xCoord15, yCoord15, xCoord15.length);


        //Far Right Building
        int xCoord12[] = {700, 750, 725, 700};
        int yCoord12[] = {175, 182, 200, 196};
        g.setColor(Color.orange);
        g.fillPolygon(xCoord12, yCoord12, xCoord12.length);
        int xCoord13[] = {700, 725, 725, 700};
        int yCoord13[] = {196, 200, 285, 280};
        g.setColor(Color.orange);
        g.fillPolygon(xCoord13, yCoord13, xCoord13.length);
        int xCoord14[] = {750, 725, 725, 750};
        int yCoord14[] = {182, 200, 285, 257};
        g.setColor(Color.orange);
        g.fillPolygon(xCoord14, yCoord14, xCoord14.length);


        //Right side Building
        int xCoord9[] = {650, 700, 650, 600};
        int yCoord9[] = {120, 122, 125, 122};
        g.setColor(Color.cyan);
        g.fillPolygon(xCoord9, yCoord9, xCoord9.length);
        int xCoord10[] = {650, 700, 700, 650};
        int yCoord10[] = {125, 122, 312, 362};
        g.setColor(Color.cyan);
        g.fillPolygon(xCoord10, yCoord10, xCoord10.length);
        int xCoord11[] = {650, 600, 600, 650};
        int yCoord11[] = {120, 120, 362, 362};
        g.setColor(Color.cyan);
        g.fillPolygon(xCoord11, yCoord11, xCoord11.length);


        //Right side Building
        int xCoord16[] = {300, 352, 420, 350};
        int yCoord16[] = {175, 165, 180, 195};
        g.setColor(Color.pink);
        g.fillPolygon(xCoord16, yCoord16, xCoord16.length);
        int xCoord17[] = {300, 350, 350, 300};
        int yCoord17[] = {175, 195, 368, 315};
        g.setColor(Color.pink);
        g.fillPolygon(xCoord17, yCoord17, xCoord17.length);
        int xCoord18[] = {350, 420, 420, 350};
        int yCoord18[] = {195, 180, 255, 277};
        g.setColor(Color.pink);
        g.fillPolygon(xCoord18, yCoord18, xCoord18.length);

        //Right Center Building
        int xCoord19[] = {350, 425, 425};
        int yCoord19[] = {275, 250, 325};
        g.setColor(Color.yellow);
        g.fillPolygon(xCoord19, yCoord19, xCoord19.length);
        int xCoord20[] = {350, 425, 425, 350};
        int yCoord20[] = {275, 325, 445, 370};
        g.setColor(Color.yellow);
        g.fillPolygon(xCoord20, yCoord20, xCoord20.length);


        //Left Center Building
        int xCoord21[] = {575, 650, 575};
        int yCoord21[] = {230, 250, 295};
        g.setColor(Color.lightGray);
        g.fillPolygon(xCoord21, yCoord21, xCoord21.length);
        int xCoord22[] = {650, 575, 575, 650};
        int yCoord22[] = {250, 295, 443, 364};
        g.setColor(Color.lightGray);
        g.fillPolygon(xCoord22, yCoord22, xCoord22.length);

        //Front Center Building
        int xCoord23[] = {425, 500, 575, 500};
        int yCoord23[] = {225, 205, 225, 250};
        g.setColor(Color.blue);
        g.fillPolygon(xCoord23, yCoord23, xCoord23.length);
        int xCoord24[] = {425, 500, 575, 575, 500, 425};
        int yCoord24[] = {225, 250, 225, 445, 525, 445};
        g.setColor(Color.blue);
        g.fillPolygon(xCoord24, yCoord24, xCoord24.length);
    }
}