import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

/*

making a chess game to play against cpu

 */

public class Checkers extends Applet {
    int appletWidth;		//  width of the Applet window
    int appletHeight;	//  height of the Applet window
    ArrayList<Rectangle> spots;
    int xCoord[];
    int yCoord[];
    int numSquare;
    boolean currTurn;
    ArrayList<Boolean> turns;

    public void init(){
        appletWidth = getWidth();
        appletHeight = getHeight();
        spots = new ArrayList<>();
        turns = new ArrayList<>();
        currTurn = false;
        xCoord = new int[100];
        yCoord = new int[100];
        numSquare = 0;
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                spots.add(new Rectangle(i * 25, j * 25, 25, 25));
            }
        }
    }

    public void paint(Graphics g){
        //g.setColor(new Color(255,204,153));
        //g.fillRect(0,0,appletWidth,appletHeight);
        drawBoard(g);
        drawPieces(g);
    }
    public void drawBoard(Graphics g){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((j%2)==(i%2)) {
                    g.setColor(Color.red);
                }
                else {
                    g.setColor(Color.black);
                }
                g.fillRect(i*25,j*25, 25,25);
            }
        }
    }
    public void drawPieces(Graphics g){
        g.setColor(Color.white);
        for (int k = 0; k < turns.size(); k++) {
            if(turns.get(k)){
                g.setColor(new Color(0,204,204));
            }else{
                g.setColor(new Color(255,255 ,0));
            }
            g.fillRect(xCoord[k], yCoord[k], 15, 15);
        }
    }



    public boolean mouseDown(Event e, int x, int y) {
        for(Rectangle r : spots) {
            if(r.inside(x,y)) {
                xCoord[numSquare] = (int)r.getX() + 5;
                yCoord[numSquare] = (int)r.getY() + 5;
                turns.add(currTurn);
                currTurn = !currTurn;
                numSquare++;
                repaint();
            }
        }
        return true;
    }



}
