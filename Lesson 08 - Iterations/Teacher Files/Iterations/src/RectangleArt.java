/**
 * Created by E157813 on 1/11/2017.
 */

import gpdraw.*;

import gpdraw.*;
import java.util.Random;
import java.awt.Color;

public class RectangleArt{
    public static void drawLine(SketchPad paper, int x1, int y1, int x2, int y2){
        DrawingTool pen = new DrawingTool(paper);
        pen.up();
        pen.move(x1, y1);
        pen.down();
        pen.move(x2, y2);
    }
    public static void rectangleArt(){
        int width = 500;
        int height = 315;
        int x1 = 0;
        int y1 = 315;
        int x2 = 500;
        int y2 = 315;
        SketchPad paper = new SketchPad(1100,750);
        DrawingTool pen = new DrawingTool(paper);
        pen.drawRect(1000,630);

        // Draw top-right corner
        for (int lines = 0; lines <= 50; lines++)
        {
            drawLine(paper,x1,y1,x2,y2);
            x1 += width/50;
            y2 -= height/50;
        }

        // Draw top-left corner
        x1 = 0;
        y2 = 315;
        for (int lines = 0; lines <= 50; lines++)
        {
            drawLine(paper,x1,y1,x2,y2);
            x2 -= width/50;
            y1 -= height/50;
        }

        // Draw bottom-right corner
        x1 = 0;
        y1 = 0;
        x2 = 500;
        y2 = 0;
        for (int lines = 0; lines <= 50; lines++)
        {
            drawLine(paper,x1,y1,x2,y2);
            x1 += width/50;
            y2 += height/50;
        }

        // Draw bottom-left corner
        x1 = 0;
        y2 = 0;
        for (int lines = 0; lines <= 50; lines++)
        {
            drawLine(paper,x1,y1,x2,y2);
            x2 -= width/50;
            y1 += height/50;
        }
    }
}
