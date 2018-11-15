import java.applet.Applet;
import java.awt.*;

public class GraphicsEx20 extends Applet {
    int[] startX,startY,endX,endY;
    int currentStartX,currentStartY;
    int currentEndX,currentEndY;
    boolean currentLineDone;
    int lineCount;

    public void init()
    {
        startX = new int[100];
        startY = new int[100];
        endX = new int[100];
        endY = new int[100];
        lineCount = 0;
        currentLineDone = false;
    }

    public void paint(Graphics g)   {
        for (int k = 0; k < lineCount; k++)
            g.drawLine(startX[k],startY[k],endX[k],endY[k]);
        if (!currentLineDone)
            g.drawLine(currentStartX,currentStartY,currentEndX,currentEndY);
        currentLineDone = false;
    }
    public boolean mouseDown(Event e, int x, int y)   {
        currentStartX = x;   currentStartY = y;
        return true;
    }
    public boolean mouseDrag(Event e, int x, int y)   {
        currentEndX = x;   currentEndY = y;
        repaint();
        return true;
    }
    public boolean mouseUp(Event e, int x, int y)   {
        addLine(x,y);
        currentLineDone = true;
        return true;
    }
    public void addLine(int x, int y)   {
        startX[lineCount] = currentStartX;
        startY[lineCount] = currentStartY;
        endX[lineCount] = x;
        endY[lineCount] = y;
        lineCount++;
        repaint();
    }
}
