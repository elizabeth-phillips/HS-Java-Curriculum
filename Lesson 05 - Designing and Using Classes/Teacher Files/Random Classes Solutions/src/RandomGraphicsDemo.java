import gpdraw.*;
public class RandomGraphicsDemo
{
    public static void main(String[] args){
        SketchPad sp= new SketchPad(800,600);
        RandomGraphics rg = new RandomGraphics(sp);
        rg.drawGrid();
        rg.drawString();
        rg.drawRects();
        rg.drawLines();
        rg.drawCircles();
    }
}
