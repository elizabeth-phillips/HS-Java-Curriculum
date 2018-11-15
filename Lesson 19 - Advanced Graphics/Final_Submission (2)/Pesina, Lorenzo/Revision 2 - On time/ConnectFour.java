
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created by s2037940 on 5/15/2017.
 *
 */


// Connect Four Game (Using Graphics g - extending from applet)

// Establishes the variables that will be used /to be initialized
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

        //The Turns and Played account for the turns by each player for the game, while the played variable accounts for the chips
        turns = new ArrayList<>();
        played = new ArrayList<>();

        //Color Plays is the 5 by 5 array
        colorPlays = new Color[5][5];

        numChip = 0;
        xCoord = new int[100];
        yCoord = new int[100];
        numSquare = 0;
        firstPaint = true;
        xNow =true;

        //Creates the slots for the game board , which is done using a 5 by 5 array
        for(int x = 105;x < 600; x+=100){
            for(int y = 105; y < 600; y+=100){
                played.add(new Rectangle(x,y,95,95));
            }
        }
    }


    //The method below allows for the visuals to be displayed
    public void paint(Graphics g) {
        title(g);
        board(g);

        //Draws the board
        for(int x = 105;x < 600; x+=100){
            for(int y = 105; y < 600; y+=100){
                g.drawRect(x,y,95,95);
            }
        }



        /*Creates the chips that the players will use
        ** The for loop and if statement are to allow for each alternative turns for the players to have alternating color chips to signal which players turns are which.
        */
        for (int k = 0; k < turns.size(); k++) {
            if(turns.get(k)) g.setColor(Color.red);
            else g.setColor(Color.blue);
            g.fillOval(xCoord[k], yCoord[k], 60, 60);
        }

        Start(g);
        Player(g);

    }

    /* The method established where the chips are placed and just how the chips are oriented in each slot.
    **
     */
    public boolean mouseDown(Event e, int x, int y) {
        for(int i = 0; i < played.size(); i++) {
            if(played.get(i).inside(x,y)) {
                xCoord[numSquare] = (int)played.get(i).getX() + 20 ;
                yCoord[numSquare] = (int)played.get(i).getY() + 15 ;
                turns.add(xNow);
                xNow = !xNow;
                numSquare++;

                //Was used to test the distance/count of the array with the string "Hello" and i
                System.out.println("here" + i);
                repaint();
            }
        }
        return true;


    }

    /* The method below creates the actual board for the Connect Four game
    **
     */
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

    /* The methods below (Player and Start) create the labels of The Start Block and the Player 1 and Player 2 Block, to allow the users to know which color they will be using.
    ** Both the next two methods
     */
    public void Start(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(700,50,80,50);
        g.setColor(Color.red);
        g.drawString("Start",700,50);}

        //Visual for Player 1
    public void Player(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Courier",Font.PLAIN,30));
        g.drawString("Player 1",10,50);

        //Visual for Player 2
        g.setFont(new Font("Courier",Font.PLAIN,30));
        g.setColor(Color.blue);
        g.drawString("Player 2",10,650);
    }



    // The method below creates the title for the game Connect Four
    public void title(Graphics g) {
        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("Connect Four", 230, 50);
    }

}





