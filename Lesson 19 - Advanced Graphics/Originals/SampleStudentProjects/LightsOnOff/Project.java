import java.applet.*;
import java.lang.*;
import java.awt.*;
import java.net.*;

public class Project extends Applet {

     final int ON  =  1;
     final int OFF = -1;
     final int WIDTH = 200;
     protected int light[][];
     protected int counterOn  = 0;
     protected int counterOff = 0;
     int end = 0;

     public void init() {
          end = 0;
          light = new int[5][5];
          for (int i = 0; i < 5; i++) {
               for (int j = 0; j < 5; j++) {
                    light[i][j] = OFF;
               }
          }
          countLight();
     }

     public void start() {
          setBackground(Color.white);
          init();
     }

     public void paint(Graphics g) {
          g.setColor(Color.blue);
          g.fill3DRect(210, 165, 60, 20, true);
          g.setColor(Color.red);
          g.drawString("RESTART", 214, 180);
          drawBoard(g);
          for (int i = 0; i < 5; i++) {
               for (int j = 0; j < 5; j++) {
                    if (light[i][j]  != 0) {
                         drawLight(i, j, g);
                    }
               }
          }
          drawCountLight(g);
     }

     public void drawBoard(Graphics g) {
          g.setColor(Color.black);
          g.drawLine(0,0, 0,WIDTH);
          g.drawLine(WIDTH,0, WIDTH,WIDTH);
          g.drawLine(0,0, WIDTH,0);
          g.drawLine(0,WIDTH, WIDTH,WIDTH);
          for (int i = 1; i < 5; i++) {
               g.drawLine(WIDTH*i/5,0, WIDTH*i/5,WIDTH);
               g.drawLine(0,WIDTH*i/5, WIDTH,WIDTH*i/5);
          }
     }

     public void drawLight(int column, int row, Graphics g) {
          if (light[column][row] == ON) {
               g.setColor(Color.yellow);
          } else if (light[column][row] == OFF) {
               g.setColor(Color.gray);
          }
          g.fillRect(column * WIDTH / 5 + 2, row * WIDTH / 5 + 2,
                     WIDTH / 5 - 3, WIDTH / 5 - 3);
     }

     void countLight() {
          counterOn = 0;
          counterOff = 0;
          for (int i = 0; i < 5; i++) {
               for (int j = 0; j < 5; j++) {
                    if(light[i][j] == ON) counterOn++;
                    if(light[i][j] == OFF) counterOff++;
               }
          }
          if (counterOn == 25) {
               endGame(getGraphics());
          }
     }

     public void endGame(Graphics g) {
          update(getGraphics());
          for (int i = 0; i < 5; i++) {
               for (int j = 0; j < 5; j++) {
                    light[i][j] = OFF;
                    update(getGraphics());
               }
          }
          for (int i = 0; i < 5; i++) {
               for (int j = 0; j < 5; j++) {
                    light[i][j] = ON;
                    update(getGraphics());
               }
          }
          g.setColor(Color.yellow);
          g.fillRect(65, 98, 80, 10);
          g.setColor(Color.black);
          g.drawString("Congratulations!!", 66, 106);
          g.setColor(Color.red);
          g.drawString("Congratulations!!", 65, 105);
          end = 1;
     }

     void drawCountLight(Graphics g) {
          g.setColor(Color.white);
          g.fill3DRect(WIDTH+15, 50, 30,20, false);
          g.fill3DRect(WIDTH+15, 110, 30,20, false);
          g.setColor(Color.gray);
          g.fill3DRect(WIDTH+5, 85, 20,20, true);
          g.setColor(Color.yellow);
          g.fill3DRect(WIDTH+5, 20, 20,20, true);
          g.setColor(Color.black);
          g.drawString("LightOn", WIDTH+30, 35);
          g.drawString("LightOff", WIDTH+30, 100);
          g.drawString(Integer.toString(counterOn), WIDTH+20, 65);
          g.drawString(Integer.toString(counterOff), WIDTH+20, 125);
     }

     public boolean mouseUp(Event event, int x, int y) {
          if (end == 1) {
               init();
               update(getGraphics());
          } else {
               if (x > 210 && x < 270 && y > 165 && y < 185) {
                    init();
                    update(getGraphics());
               }
               int column = (int)(x / (WIDTH / 5));
               int row    = (int)(y / (WIDTH / 5));
               light[column][row] = -light[column][row];
               try {
                    light[column+1][row] = -light[column+1][row];
               } catch(Exception e) {
               }
               try {
                    light[column-1][row] = -light[column-1][row];
               } catch(Exception e) {
               }
               try {
                    light[column][row+1] = -light[column][row+1];
               } catch(Exception e) {
               }
               try {
                    light[column][row-1] = -light[column][row-1];
               } catch(Exception e) {
               }
               countLight();
               if (end == 0) {
                    update(getGraphics());
               }
          }
          return true;
     }
}
