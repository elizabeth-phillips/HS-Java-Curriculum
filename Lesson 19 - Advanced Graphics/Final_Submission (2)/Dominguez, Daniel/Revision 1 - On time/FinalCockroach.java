/**
 * Created by E157813 on 5/19/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class FinalCockroach extends JPanel {
    static boolean stop = false;
    int appletWidth;
    int appletHeight;
    Rectangle rect;
    boolean squish;
    int roachX;
    int roachY;
    int lastX;
    int lastY;
    static int x = 0;
    static int y = 0;
    boolean firstDraw= true;

    public FinalCockroach() {
        //KeyListener listener = new MyKeyListener();
        //addKeyListener(listener);
        //setFocusable(true);
        MouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        setFocusable(true);
        appletHeight = getHeight();
        appletWidth = getWidth();
        lastX = 0;
        lastY = 0;
        rect = new Rectangle(30,235,100,60);
    }

    //draws the cockroach
    private void drawCockroach(Graphics2D g, int x, int y) {
        g.setColor(new Color(102, 67, 32));
        //body
        g.fillOval((x)%700,y+35,100,60);
        //head & back
        g.fillOval((x-5)%700,y+55,20,20);
        g.fillOval((x+75)%700,y+45,30,40);
        //legs
        g.fillRect((x + 25)%700, y + 35, 5,60);
        g.fillRect((x + 50)%700, y + 30, 5,70);
        g.fillRect((x + 75)%700, y + 32, 5,65);
        g.fillRect((x + 95)%700, y + 55, 65,2);
        g.fillRect((x + 95)%700, y + 75, 65,2);
        //invisible rect for muoseClicked
        rect.setLocation((x+10)%700,y+35);
    }

    //Draws the splatter cockroach makes after it is clicked on
    public void drawSplatter(Graphics2D g, int x, int y){
        g.setColor(new Color(182,181,162));
        g.fillRect(x,y,700,100);
        g.setColor(new Color(76,153,0));
        g.fillOval(x - 25,y + 35,80,60);
        g.fillOval(x - 30,y + 40,40,40);
        g.fillOval(x,y + 20,40,40);
        g.fillOval(x - 15,y + 65,40,40);
        g.fillOval(x + 25,y + 40,40,40);
        g.fillOval(x - 40,y + 40,30,30);
        g.fillOval(x + 12,y + 8,30,30);
        g.fillOval(x + 25,y + 80,20,20);
        g.fillOval(x - 45,y + 30,30,30);
        ///////
        g.fillOval(x + 25,y + 120,5,5);
        g.fillOval(x - 40,y + 5,5,5);
        g.fillOval(x - 25,y + 10,5,5);
        g.fillOval(x + 75,y + 15,5,5);
        ///
        g.setColor(new Color(102,67,32));
        g.fillOval(x - 25,y + 45,5,5);
        g.fillOval(x + 10,y + 50,5,5);
        g.fillOval(x + 30 ,y + 55,5,5);
        g.fillOval(x - 5,y + 65,5,5);
        g.fillOval(x + 25,y + 75,5,5);
    }
    public void drawBathroom(Graphics2D g){
        //draws toilet
        g.setColor(Color.WHITE);
        g.fillOval(50,50, 75,50);
        g.fillRect(62,50,50,50);
        g.fillRect(50,20,75,40);
        g.setColor(Color.GRAY);
        g.fillOval(62,60,50,25);
        g.fillOval(55,30,10,5);
        //draws sink
        g.setColor(Color.WHITE);
        g.fillRoundRect(550,50,75,40,33,33);
        g.setColor(Color.GRAY);
        g.fillRoundRect(562,55,50,26,33,33);
    }


    @Override
    public void paint(Graphics g) {
        //draws on the things on the window
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        setBackground(new Color(182,181,162));
        drawBathroom(g2d);
        if(firstDraw){
            y = (int)(Math.random() * 300) + 100;
            firstDraw = false;
        }

        drawCockroach(g2d,x, y);
        x++;
        if(stop){
            x+=20;
            drawSplatter(g2d,x, y);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //sets up the frame with the methods from the class
        JFrame frame = new JFrame("Cockroach");
        FinalCockroach roach = new FinalCockroach();
        frame.add(roach);
        frame.setSize(700, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //makes the cockroach move and tells it when to stop
        while (!stop && x < 600) {
            //roach.moveBall();
            roach.repaint();
            Thread.sleep(5);
        }
        roach.repaint();
    }
    public class MyMouseListener implements MouseListener {
        //method to check wether the mous ehas been clicked or not
        public void mouseClicked(MouseEvent e) {
            if(rect.inside(e.getX(),e.getY())){
                stop = true;
            }
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
}