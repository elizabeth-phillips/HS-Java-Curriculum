
/**
 *  Create a regular polygon and calculate various
 *  polygon properties
 *
 */
public class RegularPolygon{
  private double myNumSides;    // # of sides
  private double mySideLength;  // length of side
  private double myR;           // radius of circumscribed circle
  private double myr;           // radius of inscribed circle

  /**
   *  Default Constructor for the RegularPolygon object
   *  Constructs a triangle
   */
  public RegularPolygon(){
    myNumSides = 3;
    mySideLength = 1;
    calcR();
    calcr();
  }

  /**
   *  Constructs a regular polygon with numSides sides
   *  with sideLength length.
   *
   * @param  numSides    number of sides of the regular polygon
   * @param  sideLength  length of a side
   */
  public RegularPolygon(int numSides, double sideLength){
    myNumSides = (double) numSides;
    mySideLength = sideLength;
    calcR();
    calcr();
  }

  /**
   *  Gets the numside attribute of the RegularPolygon object
   *
   * @return    The number of sides of the polygon
   */
  public int getNumside(){
    return (int) myNumSides;
  }

  /**
   *  Gets the sideLength attribute of the RegularPolygon object
   *
   * @return    The length of a side
   */
  public double getSideLength(){
    return mySideLength;
  }

  /**
   *  Gets the circumscribed circle radius attribute of the
   *  RegularPolygon object
   *
   * @return    the radius of the circumscribed circle
   */
  public double getR(){
    return myR;
  }

  /**
   *  Gets the inscribed circle radius attribute of the
   *  RegularPolygon object
   *
   * @return    radius of the the inscribed circle
   */
  public double getr(){
    return myr;
  }

  /**
   *  Calculates the vertex angle
   *
   * @return    vertex angle
   */
  public double vertexAngle(){
    return (myNumSides - 2.0) / myNumSides * 180.0;
  }

  /**
   *  Calculates the number of diagonals in this polygon
   *
   * @return    number of diagonals in this polygon
   */
  public int numDiagonals(){
    return (int) (myNumSides * (myNumSides - 3) / 2);
  }

  /**
   *  Calculates the perimeter of the polygon
   *
   * @return    perimeter of this polygon
   */
  public double perimeter(){
    return myNumSides * mySideLength;
  }

  /**
   *  Calculates the area of the polygon
   *
   * @return    area of this polygon
   */
  public double area(){
    return myNumSides * Math.sin(Math.toRadians(360 / myNumSides)) * myR * myR / 2;
  }

  /**
   *  Calculates the radius of the inscribed circle
   */
  private void calcr(){
    myr = (mySideLength / 2) * (1 / (Math.tan(Math.toRadians(180.0 / myNumSides))));
  }

  /**
   *  Calculates the radius of the circumscribed circle
   */
  private void calcR(){
    myR = (mySideLength / 2) * (1 / (Math.sin(Math.toRadians(180.0 / myNumSides))));
  }

  /**
   *  Displays the output of all methods of a regular polygon
   *
   * @param  poly  regular polygon object to displays
   */
  public void printPoly(){
    System.out.println("number of sides = " + getNumside());
    System.out.println("length of side = " + getSideLength());
    System.out.println("radius of circumscribed circle = " + getR());
    System.out.println("radius of inscribed circle = " + getr());
    System.out.println("angel of vertex = " + vertexAngle());
    System.out.println("number of diagonals  = " + numDiagonals());
    System.out.println("perimeter = " + perimeter());
    System.out.println("area = " + area());
    System.out.println();
  }

}

