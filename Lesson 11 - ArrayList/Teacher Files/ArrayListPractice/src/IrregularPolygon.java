import java.awt.geom.*;
import java.util.ArrayList;      // for ArrayList
import gpdraw.*;        // for DrawingTool

public class IrregularPolygon{
  private ArrayList <Point2D.Double> myPolygon;

  // constructors
  public IrregularPolygon() {
    myPolygon = new ArrayList<>();
  }
  SketchPad paper = new SketchPad(500,500);
  DrawingTool pen = new DrawingTool(paper);
  // public methods
  public void add(Point2D.Double aPoint) {
    myPolygon.add(aPoint);
  }

  public void draw(){
    Point2D.Double pnt = myPolygon.get(0);
    pen.up();
    pen.move(pnt.getX(), pnt.getY());
    pen.down();
    for (int i = 1; i < myPolygon.size(); i++){
      pnt = myPolygon.get(i);
      pen.move(pnt.getX(), pnt.getY());
    }
    pnt = myPolygon.get(0);
    pen.move(pnt.getX(), pnt.getY());
  }

  public double perimeter() {
    int sum = 0;
    Point2D.Double pnt;
    Point2D.Double pnt2;
    for (int i = 0; i < myPolygon.size(); i++ ){
      if (i == myPolygon.size()-1){
        pnt = myPolygon.get(i);
        pnt2 = myPolygon.get(0);
      }
      else {
        pnt = myPolygon.get(i);
        pnt2 = myPolygon.get(i + 1);
      }
      sum += pnt.distance(pnt2);
    }
    return sum;
  }
  public double area(){
    /**
     * you better believe i figured this method out!
     * i couldn't have done it without your outstanding teaching
     */
    Point2D.Double pnt;
    Point2D.Double pnt2;
    double pt1;
    double pt2;
    double area = 0;
    for (int i = 0; i < myPolygon.size()-1; i++){
      pnt = myPolygon.get(i);
      pnt2 = myPolygon.get(i+1);
      pt1 = Math.abs(pnt.getX()) * Math.abs(pnt2.getY());
      pt2 = Math.abs(pnt2.getX()) * Math.abs(pnt.getY());
      area += pt1 - pt2;
    }
    pnt = myPolygon.get(myPolygon.size()-1);
    pnt2 = myPolygon.get(0);
    pt1 = Math.abs(pnt.getX()) * Math.abs(pnt2.getY());
    pt2 = Math.abs(pnt2.getX()) * Math.abs(pnt.getY());
    area += pt1 - pt2;
    area = area/2;
    if (area < 0){
      area -= (area*2);
    }
    return area;
  }
}
