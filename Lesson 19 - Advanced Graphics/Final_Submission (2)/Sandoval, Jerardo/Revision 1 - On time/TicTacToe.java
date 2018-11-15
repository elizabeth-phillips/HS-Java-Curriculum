import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/*

Gonna make a tic tac toe game where you can play against computer or someone else

*/

public class TicTacToe extends Applet {
    Rectangle sq1, sq2, sq3, sq4, sq5, sq6, sq7, sq8, sq9, ngame, score, score2;
    int numColor;
    String[][] played;
    ArrayList<Integer> xValues;
    ArrayList<Integer> yValues;
    ArrayList<String> turns;
    boolean xTurn;
    int Xscore;
    int Oscore;

    //Light Gray Background
    public void init() {

        played = new String[3][3];
        xValues = new ArrayList<>();
        yValues = new ArrayList<>();
        turns = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                played[i][j] = "-";
            }
            System.out.println();
        }
        xTurn = true;
        setBackground(Color.LIGHT_GRAY);
        sq1 = new Rectangle(110,110,80,80);
        sq2 = new Rectangle(210,110,80,80);
        sq3 = new Rectangle(310,110,80,80);
        sq4 = new Rectangle(310,210,80,80);
        sq5 = new Rectangle(210,210,80,80);
        sq6 = new Rectangle(110,210,80,80);
        sq7 = new Rectangle(110,310,80,80);
        sq8 = new Rectangle(210,310,80,80);
        sq9 = new Rectangle(310,310,80,80);

        ngame = new Rectangle(510,100,80,25);

        score = new Rectangle(475,200,150,150);
        score2 = new Rectangle(500,200,150,150);

        numColor = 0;

    }

    //Click X's and O's
    public boolean mouseDown(Event e, int x, int y) {
        if(sq1.inside(x,y)) {
            numColor = 1;
        }
        else if(sq2.inside(x,y)) {
            numColor = 2;
        }
        else if(sq3.inside(x,y)){
            numColor = 3;
        }
        else if(sq4.inside(x,y)) {
            numColor = 4;
        }
        else if(sq5.inside(x,y)) {
            numColor = 5;
        }
        else if(sq6.inside(x,y)) {
            numColor = 6;
        }
        else if(sq7.inside(x,y)) {
            numColor = 7;
        }
        else if(sq8.inside(x,y)) {
            numColor = 8;
        }
        else if(sq9.inside(x,y)) {
            numColor = 9;
        }

        else if(ngame.inside(x,y)){
            numColor = 10;
        }

        else if(score.inside(x,y)){
            numColor = 11;
        }
        else if(score2.inside(x,y)){
            numColor = 12;
        }

        repaint();
        return true;
    }

    //Words
    public void words(Graphics g){
        g.setColor(Color.black);

        g.setFont(new Font("Biondi",Font.PLAIN,48));
        g.drawString("Tic-Tac-Toe", 85,60);

        g.setFont(new Font("Biondi",Font.PLAIN,12));
        g.drawString("New Game", 512,118);
    }

    public void paint(Graphics g) {
        drawBoard(g);
        String turn;

        g.setFont(new Font("Biondi", Font.PLAIN, 48));

        if (xTurn)
            turn = "X";
        else
            turn = "O";

        switch (numColor) {
            case 1:
                if (played[0][0].equals("-")) {
                    played[0][0] = turn;
                    g.setColor(Color.black);
                    g.drawString(turn, 125, 160);
                    xValues.add(125);
                    yValues.add(160);

                }
                break;
            case 2:
                if (played[0][1].equals("-")) {
                    played[0][1] = turn;
                    g.setColor(Color.black);
                    g.drawString(turn, 225, 160);
                    xValues.add(225);
                    yValues.add(160);
                }
                break;
            case 3:
                if (played[0][2].equals("-")) {
                    played[0][2] = turn;
                    g.setColor(Color.black);
                    g.drawString(turn, 325, 160);
                    xValues.add(325);
                    yValues.add(160);
                }
                break;
            case 4:
                if (played[1][2].equals("-")) {
                    played[1][2] = turn;
                    g.setColor(Color.black);
                    g.drawString(turn, 325, 260);
                    xValues.add(325);
                    yValues.add(260);
                }
                break;
            case 5:
                if (played[1][1].equals("-")) {
                    played[1][1] = turn;
                    g.setColor(Color.black);
                    g.drawString(turn, 225, 260);
                    xValues.add(225);
                    yValues.add(260);
                }
                break;
            case 6:
                if (played[1][0].equals("-")) {
                    played[1][0] = turn;
                    g.setColor(Color.black);
                    g.drawString(turn, 125, 260);
                    xValues.add(125);
                    yValues.add(260);
                }
                break;
            case 7:
                if (played[2][0].equals("-")) {
                    played[2][0] = turn;
                    g.setColor(Color.black);
                    g.drawString(turn, 125, 360);
                    xValues.add(125);
                    yValues.add(360);
                }
                break;
            case 8:
                if (played[2][1].equals("-")) {
                    played[2][1] = turn;
                    g.setColor(Color.black);
                    g.drawString(turn, 225, 360);
                    xValues.add(225);
                    yValues.add(360);
                }
                break;
            case 9:
                if (played[2][2].equals("-")) {
                    played[2][2] = turn;
                    g.setColor(Color.black);
                    g.drawString(turn, 325, 360);
                    xValues.add(325);
                    yValues.add(360);
                }
                break;
            case 10:
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(110, 110, 80, 80);
                xValues = new ArrayList<>();
                yValues = new ArrayList<>();
                turns = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        played[i][j] = "-";
                    }
                    System.out.println();
                }
                break;

            case 11:
                Xscore += 1;
                g.drawString("" + Xscore, 475, 260);
                break;

            case 12:
                Oscore += 1;
                g.drawString("" + Oscore, 600, 260);
                break;

        }
            turns.add(turn);
            for (int i = 0; i < xValues.size(); i++) {
                g.drawString(turns.get(i), xValues.get(i), yValues.get(i));
            }

            xTurn = !xTurn;
            newGame(g);
            words(g);

    }

    //New game
    public void newGame(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(510,100,80,25);
    }

    //Draw board
    public void drawBoard(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));

        g.setColor(Color.black);
        int xCoord[] = {100, 100, 400, 400};
        int yCoord[] = {100, 400, 400, 100};
        g.drawPolygon(xCoord, yCoord, 4);

        g.drawLine(200,100,200,400);
        g.drawLine(300,100,300,400);
        g.drawLine(100,200,400,200);
        g.drawLine(100,300,400,300);

        g.setFont(new Font("Biondi",Font.PLAIN,36));
        g.drawString("X", 475,200);
        g.drawString("O",600,200);
    }



}