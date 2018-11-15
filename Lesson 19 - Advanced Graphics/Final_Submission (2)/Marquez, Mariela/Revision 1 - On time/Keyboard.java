import java.awt.*;
import java.applet.Applet;

    public class Keyboard extends Applet {
        Rectangle black, white;

        int numColor;

        public void paint(Graphics g)
        {
            g.setColor(Color.black);
            //row 1
            g.drawRect(10, 35, 25, 20); //q
            g.fillRect(10, 35, 25, 20);

            g.drawRect(40, 35, 25, 20); //w
            g.fillRect(40, 35, 25, 20);

            g.drawRect(70, 35, 25, 20); //e
            g.fillRect(70, 35, 25, 20);

            g.drawRect(100, 35, 25, 20); //r
            g.fillRect(100, 35, 25, 20);

            g.drawRect(130, 35, 25, 20); //t
            g.fillRect(130, 35, 25, 20);

            g.drawRect(160, 35, 25, 20); //y
            g.fillRect(160, 35, 25, 20);


            g.drawRect(190, 35, 25, 20); //u
            g.fillRect(190, 35, 25, 20);

            g.drawRect(220, 35, 25, 20); //i
            g.fillRect(220, 35, 25, 20);

            g.drawRect(250, 35, 25, 20); //o
            g.fillRect(250, 35, 25, 20);

            g.drawRect(280, 35, 25, 20);  //p
            g.fillRect(280, 35, 25, 20);

            //row 2

            g.drawRect(20, 75, 25, 20); //a
            g.fillRect(20, 75, 25, 20);

            g.drawRect(50, 75, 25, 20); //s
            g.fillRect(50, 75, 25, 20);

            g.drawRect(80, 75, 25, 20); //d
            g.fillRect(80, 75, 25, 20);

            g.drawRect(110, 75, 25, 20); //f
            g.fillRect(110, 75, 25, 20);

            g.drawRect(140, 75, 25, 20);  //g
            g.fillRect(140, 75, 25, 20);

            g.drawRect(170, 75, 25, 20);  //h
            g.fillRect(170, 75, 25, 20);

            g.drawRect(200, 75, 25, 20); //j
            g.fillRect(200, 75, 25, 20);

            g.drawRect(230, 75, 25, 20); //k
            g.fillRect(230, 75, 25, 20);

            g.drawRect(260, 75, 25, 20); //l
            g.fillRect(260, 75, 25, 20);


            //row 3

            g.drawRect(40, 120, 25, 20); //z
            g.fillRect(40, 120, 25, 20);

            g.drawRect(70, 120, 25, 20); //x
            g.fillRect(70, 120, 25, 20);

            g.drawRect(100, 120, 25, 20); //c
            g.fillRect(100, 120, 25, 20);

            g.drawRect(130, 120, 25, 20); //v
            g.fillRect(130, 120, 25, 20);

            g.drawRect(160, 120, 25, 20); //b
            g.fillRect(160, 120, 25, 20);

            g.drawRect(190, 120, 25, 20); //n
            g.fillRect(190, 120, 25, 20);

            g.drawRect(220, 120, 25, 20); //m
            g.fillRect(220, 120, 25, 20);
            //row 4

            g.setColor(Color.BLACK);
            g.drawRect(85, 150, 120, 20);  //SpaceBar
            g.fillRect(85, 150, 120, 20);

            // NumberKeypad








            //draw letters
            g.setColor(Color.white);
            g.drawString("Q", 13, 50);
            g.drawString("W", 45, 50);
            g.drawString("E", 75, 50);
            g.drawString("R", 105, 50);
            g.drawString("T", 135, 50);
            g.drawString("Y", 165, 50);
            g.drawString("U", 195, 50);
            g.drawString("I", 225, 50);
            g.drawString("O", 255, 50);
            g.drawString("P", 285, 50);
            //row 2
            g.drawString("A", 23, 90);
            g.drawString("S", 55, 90);
            g.drawString("D", 85, 90);
            g.drawString("F", 115, 90);
            g.drawString("G", 145, 90);
            g.drawString("H", 175, 90);
            g.drawString("J", 205, 90);
            g.drawString("K", 235, 90);
            g.drawString("L", 265, 90);
            //row 3
            g.drawString("Z", 45, 135);
            g.drawString("X", 75, 135);
            g.drawString("C", 105, 135);
            g.drawString("V", 135, 135);
            g.drawString("B", 165, 135);
            g.drawString("N", 195, 135);
            g.drawString("M", 225, 135);

            //row4
            //g.drawString("SpaceBar", 325, 175);

            StartAnimation(g);
        }

        private void StartAnimation(Graphics g)
        {
            TypeLetter(g, "H", 175, 90, 170, 75, 25, 20);
            TypeLetter(g, "I", 225, 50, 220, 35, 25, 20);
            TypeLetter(g, "M", 225, 135, 220, 120, 25, 20);
            TypeLetter(g, "S", 55, 90, 50, 75, 25, 20);
            TypeLetter(g, "P", 285, 50, 280, 35, 25, 20);
            TypeLetter(g, "H", 175, 90, 170, 75, 25, 20);
            TypeLetter(g, "I", 225, 50, 220, 35, 25, 20);
            TypeLetter(g, "L", 265, 90, 260, 75, 25, 20);
            TypeLetter(g, "L", 265, 90, 260, 75, 25, 20);
            TypeLetter(g, "I", 225, 50, 220, 35, 25, 20);
            TypeLetter(g, "P", 285, 50, 280, 35, 25, 20);
            TypeLetter(g, "S", 55, 90, 50, 75, 25, 20);
        }

        private void TypeLetter(Graphics g, String letter, int letterX, int letterY, int r1, int r2, int r3, int r4)
        {
            try
            {
                g.setColor(GetRandomColor());
                g.drawRect(r1, r2, r3, r4);  //h
                g.fillRect(r1, r2, r3, r4);
                g.setColor(Color.white);
                g.drawString(letter, letterX, letterY);
                Thread.sleep(500);
                g.setColor(Color.black);
                g.drawRect(r1, r2, r3, r4);  //h
                g.fillRect(r1, r2, r3, r4);
                g.setColor(Color.white);
                g.drawString(letter, letterX, letterY);
            }
            catch(InterruptedException e)
            {

            }
        }

        private Color GetRandomColor()
        {
            int random = (int) (Math.random() * 7);
            switch(random)
            {
                case 1:
                {
                    return Color.CYAN;
                }
                case 2:
                {
                    return Color.magenta;
                }
                case 3:
                {
                    return new Color(153, 255,255);
                }
                case 4:
                {
                    return new Color(153, 153, 255);
                }
                case 5:
                {
                    return new Color (255, 153,153);
                }
                case 6:
                {
                    return new Color(102, 178, 255);
                }

                case 7:
                {
                    return new Color(133, 232, 97);
                }
            }
            return new Color(255, 102, 102 );
        }
    }


