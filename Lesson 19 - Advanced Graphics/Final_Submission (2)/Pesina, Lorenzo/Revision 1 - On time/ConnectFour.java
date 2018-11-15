
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created by s2037940 on 5/15/2017.
 */
public class ConnectFour extends Applet {
    int numChip;
    int xCoord[];
    int yCoord[];
    ArrayList<Boolean> turns;
    ArrayList<Rectangle> played;
    Color[][] colorPlays;
    int numSquare;
    boolean firstPaint;
    boolean xNow;

    public void init() {
        setBackground(Color.orange);
        turns = new ArrayList<>();
        played = new ArrayList<>();
        colorPlays = new Color[5][5];

        numChip = 0;
        xCoord = new int[100];
        yCoord = new int[100];
        numSquare = 0;
        firstPaint = true;
        xNow =true;
        for(int x = 105;x < 600; x+=100){
            for(int y = 105; y < 600; y+=100){
                played.add(new Rectangle(x,y,95,95));
            }
        }
    }



    public void paint(Graphics g) {
        title(g);
        board(g);

        for(int x = 105;x < 600; x+=100){
            for(int y = 105; y < 600; y+=100){
                g.drawRect(x,y,95,95);
            }
        }




        for (int k = 0; k < turns.size(); k++) {
            if(turns.get(k)) g.setColor(Color.red);
            else g.setColor(Color.blue);
            g.fillOval(xCoord[k], yCoord[k], 60, 60);
        }

        Start(g);
        Player(g);

    }

    public boolean mouseDown(Event e, int x, int y) {
        for(int i = 0; i < played.size(); i++) {
            if(played.get(i).inside(x,y)) {
                xCoord[numSquare] = (int)played.get(i).getX() + 20 ;
                yCoord[numSquare] = (int)played.get(i).getY() + 15 ;
                turns.add(xNow);
                xNow = !xNow;
                numSquare++;
                System.out.println("here" + i);
                repaint();
            }
        }
        return true;


    }

    public void board(Graphics g) {
        Graphics2D board = (Graphics2D) g;
        board.setStroke(new BasicStroke(10));

        g.setColor(Color.black);
        int xCoord[] = {100, 100, 600, 600};
        int yCoord[] = {100, 600, 600, 100};
        g.drawPolygon(xCoord, yCoord, 4);

        //Boundarys or slots for each turn
        g.setColor(Color.black);
        g.drawLine(200, 100, 200, 600);
        g.drawLine(300, 100, 300, 600);
        g.drawLine(400, 100, 400, 600);
        g.drawLine(500, 100, 500, 600);
        g.setColor(Color.black);
        g.drawLine(100, 200, 600, 200);
        g.drawLine(100, 300, 600, 300);
        g.drawLine(100, 400, 600, 400);
        g.drawLine(100, 500, 600, 500);


    }

    public void Start(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(700,50,80,50);
        g.setColor(Color.red);
        g.drawString("Start",700,50);}

    public void Player(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Courier",Font.PLAIN,30));
        g.drawString("Player 1",10,50);

        g.setFont(new Font("Courier",Font.PLAIN,30));
        g.setColor(Color.blue);
        g.drawString("Player 2",10,650);
    }




    public void title(Graphics g) {
        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("Connect Four", 230, 50);
    }

}





