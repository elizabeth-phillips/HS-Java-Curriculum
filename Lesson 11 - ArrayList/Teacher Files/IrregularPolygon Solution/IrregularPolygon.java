import java.awt.Color;
import java.awt.geom.*;
import java.util.*;
import gpdraw.*;


/**
 *  Implements a class IrregularPolygon that contains an
 *  array list of Point2D.Double objects.
 * *  
 */
public class IrregularPolygon{
  private DrawingTool pen = new DrawingTool(new SketchPad(300, 300, 0));
  private ArrayList <Point2D.Double> myPolygon;

  /**
   *  Constructor for the IrregularPolygon object
   */
  public IrregularPolygon(){
    myPolygon = new ArrayList <Point2D.Double>();
    pen.setColor(Color.blue);
    pen.setWidth(2);
    //pen.getPadPanel().setDelay(0);
  }

  // public methods

  /**
   *  Adds a point (vertice) to the myPolygon ArrayList
   *
   * @param  aPoint  Description of Parameter
   */
  public void add(Point2D.Double aPoint){
    myPolygon.add(aPoint);
  }

  /**
   *  Computes the perimeter by computing the distance between
   *  adjacent points, and totaling up the distances.
   *
   * @return    perimeter of the polygon
   */
  public double perimeter(){
    Point2D.Double ptStart;
    Point2D.Double ptEnd = new Point2D.Double();

    double p = 0;

    // a legal polygon has as least three vertices
    if (myPolygon.size() < 2){
      return 0.0;
    }

    for (int pt = 0; pt < myPolygon.size() - 1; pt++){
      ptStart = myPolygon.get(pt);
      ptEnd = myPolygon.get(pt + 1);

      // compute and total distance between adjacent points
      p += ptStart.distance(ptEnd);
    }

    // finish it up by adding distance between the end and start points
    p += ptEnd.distance(myPolygon.get(0));
    return p;
  }

  /**
   *  Calculates the area of the polygon. The area of a polygon with corners
   *  (x[0], y[0])...x[n-1], y[n-1]) is given by
   *
   *  (x[0]*y[1] + x[1]*y[2] +...+ x[n-1]*y[0] - y[0]*x[1] - y[1]*x[2] -...- y[n-1]*x[0])/2
   *
   *
   * @return    Area of the polygon
   */
  public double area(){
    Point2D.Double ptStart;
    Point2D.Double ptEnd = new Point2D.Double();

    double a = 0;
    int pt;

    // a legal polygon has as least three vertices
    if (myPolygon.size() < 2){
      return 0.0;
    }

    for (pt = 0; pt < myPolygon.size() - 1; pt++){
     ptStart = myPolygon.get(pt);
      ptEnd = myPolygon.get(pt + 1);

      a += ptStart.getX() * ptEnd.getY() - ptStart.getY() * ptEnd.getX();
    }
    ptStart = myPolygon.get(pt);
    ptEnd = myPolygon.get(0);
    a += ptStart.getX() * ptEnd.getY() - ptStart.getY() * ptEnd.getX();
    return Math.abs(a / 2.0);
  }

  /**
   *  Draw the polygon by joining adjacent points by a line,
   *  and then closing it up by joining the end and start points.
   */
  public void draw(){
    // a legal polygon has as least three vertices
    if (myPolygon.size() < 2){
      return;
    }

    Point2D.Double point = myPolygon.get(0);
    Point2D.Double point0 = point;

    pen.up();
    pen.move(point.getX(), point.getY());
    pen.down();

    for (int pt = 1; pt < myPolygon.size(); pt++){
      point = myPolygon.get(pt);
      pen.move(point.getX(), point.getY());  // join adjacent point with a line
    }

    // closing it up by joining the end and start points
    pen.move(point0.getX(), point0.getY());

  }

 

    


 
}
