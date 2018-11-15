import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Snowman extends JPanel {
    int appletWidth;
    int appletHeight;
    Image virtualMem;

    int xCoord[];
    int yCoord[];
    int numSquare;
    boolean firstPaint;

    public Snowman(){
        MouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        setFocusable(true);
        appletWidth = getWidth();
        appletHeight = getHeight();

        xCoord = new int[100];
        yCoord = new int[100];
        numSquare = 0;
        firstPaint = true;
    }

    public static void main(String[] args)throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        frame.setBackground(new Color(51, 153, 255));
        Snowman snowman = new Snowman();
        frame.add(snowman);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true) {
            snowman.repaint();
            Thread.sleep(1500);
        }
    }
    @Override
    public void paint(Graphics g) {
        setBackground(new Color(51, 153, 255));
        g.setColor(Color.WHITE);
        g.fillRect(0, 300, 600, 250);
        drawSnowman(g, 150, 150);
        drawHat(g, 175, 150);
        drawClouds(g, 150, 150);
        g.setColor(Color.BLACK);
        //Draw buttons
        for (int k = 0; k < numSquare; k++){
            g.fillRect(xCoord[k], yCoord[k], 5, 5);
        }

        drawSnow(g);
    }

    public void drawSnow(Graphics g){
        g.setColor(Color.white);

        int count = 0;
        ArrayList<Integer> xValues = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            int xVal = (int)(Math.random() * getWidth());
            xValues.add(xVal);
        }
        for (int i = count; i < xValues.size(); i++) {
            g.setColor(Color.white);
            g.fillOval(xValues.get(i), (i+count) % getHeight(), 2, 2);
        }
        count++;
    }

    public void drawSnowman(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        g.fillOval(x+20,y,40,40);
        g.fillOval(x+10,y+35,60,60);
        g.fillOval(x,y+90,80,80);
        g.setColor(new Color(77, 40, 0));
        g.fillRect(115, 200, 50, 3);
        g.fillRect(215, 200, 50, 3);
        g.setColor(new Color(244, 116, 66));
        g.fillRect(187, 163, 7, 7);
        g.drawImage (virtualMem,0,0, this);
    }

    public void drawHat(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.fillRect(164, 150, 50, 5);
        g.fillRect(176, 125, 25, 25);
        g.setColor(Color.RED);
        g.fillRect(171, 147, 35, 3);
        g.drawImage (virtualMem,0,0, this);
    }

    public void drawClouds(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        g.fillOval(142, 5, 100, 25);
        g.fillOval(30, 30, 100, 25);
        g.fillOval(300, 5, 150, 30);
        g.fillOval(175, 55, 100, 25);
        g.fillOval(350, 50, 150, 15);
        g.drawImage (virtualMem,0,0, this);
    }


    public class MyMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            xCoord[numSquare] = e.getX();
            yCoord[numSquare] = e.getY();
            numSquare++;
            repaint();
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
    }

    public void delay(int n){
        long startDelay = System.currentTimeMillis();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.currentTimeMillis();
    }
}
