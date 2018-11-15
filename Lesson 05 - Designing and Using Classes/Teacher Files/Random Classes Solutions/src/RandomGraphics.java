import gpdraw.*;

import java.awt.*;
import java.util.*;
public class RandomGraphics
{
    private DrawingTool pen;

    public RandomGraphics(SketchPad sp){
        pen = new DrawingTool(sp);
    }

    public void drawGrid(){
        pen.drawRect(730,500);
        pen.up();
        pen.move(365,0);
        pen.down();
        pen.setDirection(180);
        pen.forward(730);
        pen.up();
        pen.move(0,-250);
        pen.down();
        pen.setDirection(90);
        pen.forward(500);
    }

    public void drawString(){
        randomColor();
        pen.up();
        pen.move(100,-100);
        pen.down();
        pen.drawString("Miss Phillips");
        randomColor();
        pen.up();
        pen.move(100,-120);
        pen.down();
        pen.drawString("AP Computer Science A");
    }

    public void drawRects(){
        randomColor();
        int x = (int)(Math.random() * 200);
        int y = (int)(Math.random() * 200) + 50;
        int width = (int)(Math.random() * 50);
        int height = (int)(Math.random() * 50);
        pen.up();
        pen.move(x,y);
        pen.down();
        pen.drawRect(width,height);
        //Rectangle 2
        randomColor();
        x = (int)(Math.random() * 200);
        y = (int)(Math.random() * 200) + 50;
        width = (int)(Math.random() * 50);
        height = (int)(Math.random() * 50);
        pen.up();
        pen.move(x,y);
        pen.down();
        pen.drawRect(width,height);
        //Rectangle 3
        randomColor();
        x = (int)(Math.random() * 200);
        y = (int)(Math.random() * 200) + 50;
        width = (int)(Math.random() * 50);
        height = (int)(Math.random() * 50);
        pen.up();
        pen.move(x,y);
        pen.down();
        pen.drawRect(width,height);
        //Rectangle 4
        randomColor();
        x = (int)(Math.random() * 200);
        y = (int)(Math.random() * 200) + 50;
        width = (int)(Math.random() * 50);
        height = (int)(Math.random() * 50);
        pen.up();
        pen.move(x,y);
        pen.down();
        pen.drawRect(width,height);
    }

    public void drawLine(int x1, int y1, int x2, int y2){
        randomColor();
        pen.up();
        pen.move(x1, y1);
        pen.down();
        pen.move(x2, y2);
    }

    public void drawLines(){
        int x1 = (int)(Math.random() * 200)-325;
        int y1 = (int)(Math.random() * 200);
        int x2 = (int)(Math.random() * 200)-325;
        int y2 = (int)(Math.random() * 200);
        drawLine(x1,y1,x2,y2);

        x1 = (int)(Math.random() * 200)-325;
        y1 = (int)(Math.random() * 200);
        x2 = (int)(Math.random() * 200)-325;
        y2 = (int)(Math.random() * 200);
        drawLine(x1,y1,x2,y2);

        x1 = (int)(Math.random() * 200)-325;
        y1 = (int)(Math.random() * 200);
        x2 = (int)(Math.random() * 200)-325;
        y2 = (int)(Math.random() * 200);
        drawLine(x1,y1,x2,y2);

        x1 = (int)(Math.random() * 200)-325;
        y1 = (int)(Math.random() * 200);
        x2 = (int)(Math.random() * 200)-325;
        y2 = (int)(Math.random() * 200);
        drawLine(x1,y1,x2,y2);
    }
    public void drawCircles(){
        randomColor();
        int x = (int)(Math.random() * 150)-325;
        int y = (int)(Math.random() * 150)-200;
        int radius = (int)(Math.random() * 50);
        pen.up();
        pen.move(x,y);
        pen.down();
        pen.drawCircle(radius);

        randomColor();
        x = (int)(Math.random() * 150)-325;
        y = (int)(Math.random() * 150)-200;
        radius = (int)(Math.random() * 50);
        pen.up();
        pen.move(x,y);
        pen.down();
        pen.drawCircle(radius);

        randomColor();
        x = (int)(Math.random() * 150)-325;
        y = (int)(Math.random() * 150)-200;
        radius = (int)(Math.random() * 50);
        pen.up();
        pen.move(x,y);
        pen.down();
        pen.drawCircle(radius);

        randomColor();
        x = (int)(Math.random() * 150)-325;
        y = (int)(Math.random() * 150)-200;
        radius = (int)(Math.random() * 50);
        pen.up();
        pen.move(x,y);
        pen.down();
        pen.drawCircle(radius);
    }

    public void randomColor(){
        int r = (int)(Math.random() * 255);
        int g = (int)(Math.random() * 255);
        int b = (int)(Math.random() * 255);
        pen.setColor(new Color(r,g,b));
    }
}
