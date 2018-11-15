import java.applet.Applet;
import java.awt.*;

public class fishbowl extends Applet {
    Rectangle fishFood;
    boolean dropFood;
    public void init(){
        dropFood = false;
        fishFood = new Rectangle(225,0,225,75);
    }
    public void bowl (Graphics g) {
        //setBackground(new Color(0, 0, 255));
        g.setColor(new Color(231, 247, 247));
        g.fillOval(200,100,500,500);
         /*int xCoord[] = {};
         int yCoord[] = {};
         g.fillPolygon(xCoord, yCoord, xCoord.length);
         */

    }
    public void fish (Graphics g){

        //dorsal fin
        int xCoord1[] = {445, 435, 420, 450, 470, 510};
        int yCoord1[] = {330, 315, 300, 303, 310, 330};
        g.setColor(Color.ORANGE);
        g.fillPolygon(xCoord1, yCoord1, xCoord1.length);

        //fishtail

        int xCoord[] = {427, 400, 375, 348, 318, 340, 325, 300, 340, 375, 370, 400, 435};
        int yCoord[] = {340, 328, 325, 335, 360, 363, 375, 400, 385, 380, 400, 390, 365};
        g.setColor(Color.ORANGE);
        g.fillPolygon(xCoord, yCoord, xCoord.length);

        //bottom fin

        int xCoord2 [] = {480, 452, 515};
        int yCoord2 [] = {365, 405, 365};
        g.setColor(Color. ORANGE);
        g.fillPolygon(xCoord2, yCoord2, xCoord2.length);


        //fish body
        g.setColor(new Color(27, 243, 193));
        g.fillOval(425,325, 110,50);

        //fish fin
        int xCoord3 [] = {455, 490, 490};
        int yCoord3 [] = {350, 340, 360};
        g.setColor(Color. ORANGE);
        g.fillPolygon(xCoord3, yCoord3, xCoord3.length);


        //fish eye
        //white part
        g.setColor(Color.WHITE);
        g.fillOval(508, 340, 11,11);

        //black part
        g.setColor(Color.BLACK);
        g.fillOval(508, 340, 8,8);

        //fish mouth
        g.setColor(Color.MAGENTA);
        g.fillOval(515, 355, 12,9);

        //fish bowl outline

        int x,y;
        int radius = 250;
        int centerX = 450;
        int centerY = 350;
        g.setColor(Color.darkGray);
        for (double radian = 0; radian <= 4 * Math.PI; radian += 0.01)
        {
            x = (int) Math.round(Math.cos(radian) * radius) + centerX;
            y = (int) Math.round(Math.sin(radian) * radius) + centerY;
            g.drawLine(x,y,x,y);
        }

        g.setColor(Color.WHITE);
        int xCoord4 [] = {350, 350, 550, 550};
        int yCoord4 [] ={125, 95, 95, 125};
        g.fillPolygon(xCoord4, yCoord4, xCoord4.length);

        g.setColor(Color.darkGray);
        g.drawLine( 350, 123, 350, 90);
        g.drawLine(350, 90, 550, 90);
        g.drawLine(550, 90, 550, 123);

        //fish food

        g.setColor(new Color(208, 117, 37));
        int xCoord5[] ={225, 390, 450};
        int yCoord5[] ={1, 75, 1};
        g.fillPolygon(xCoord5, yCoord5, xCoord5.length);

        g.setColor(new Color(204, 0, 0));
        int xCoord6[] ={275, 300, 400, 350};
        int yCoord6[] ={25, 1, 1, 60};
        g.fillPolygon(xCoord6, yCoord6, xCoord6.length);

    }
    public void foodDrop(Graphics g){

        for(int i = 30; i < 325; i++){
            g.setColor(new Color(100,100,100));
            g.fillRect(430, i, 10,10);

            delay(50);
            g.setColor(Color.white);
            g.fillRect(0,0,getWidth(),getHeight());
            bowl(g);
            fish(g);
        }
    }
    public boolean mouseDown(Event e, int x, int y){
        if(fishFood.inside(x,y)){
            dropFood = true;
            repaint();
        }

        return true;
    }
    public void delay(int n){
        long startDelay = System.currentTimeMillis();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.currentTimeMillis();
    }
    public void paint(Graphics g){

        bowl(g);
        fish(g);
        if(dropFood){
            foodDrop(g);
        }
    }
}
