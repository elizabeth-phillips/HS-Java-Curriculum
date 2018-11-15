import java.awt.*;
import java.net.*;
import java.util.*;
import java.applet.Applet;


//APCSII Project
//Asteroids
//5/21/2006
//Jack Yen
public class Asteroids extends Applet implements Runnable 
{
  Thread loadThread;
  Thread loopThread;
  static final int delay = 50;             
  static final int shipNum = 4;           
  static final int shotNum =  3;          
  static final int rockNum =  20;          
  static final int scrapNum = 20;
  static final int scrapCounter = 30;        
  static final int hCounter = 60;
  static final int sPause = 30;
  static final int uPasses  =  3;  
  int score;
  int highScore;
  int newShipScore;
  int newUfoScore;
  boolean loaded = false;
  boolean paused;
  boolean playing;
  boolean sound;
  boolean detail;  
  boolean left  = false;
  boolean right = false;
  boolean up    = false;
  boolean down  = false;
  
  SAsteroids   ship;
  SAsteroids   ufo;
  SAsteroids   missle;
  SAsteroids[] photons    = new SAsteroids[shotNum];
  SAsteroids[] asteroids  = new SAsteroids[rockNum];
  SAsteroids[] explosions = new SAsteroids[scrapNum];
  
  static final int bPoints    =  25;     
  static final int sPoints  =  50;
  static final int uPoints    = 250;
  static final int mPoints = 500;
  static final int NSPoints = 5000;  
  static final int NPoints  = 2750;  
  int shipsLeft;       
  int shipCounter;     
  int hyperCounter;
  int[] photonCounter = new int[shotNum];    
  int   photonIndex;
  int ufoPassesLeft;    
  int ufoCounter;
  int missleCounter;
  
  boolean[] asteroidIsSmall = new boolean[rockNum];   
  int       asteroidsCounter;                        
  int       asteroidsSpeed;                      
  int       asteroidsLeft;

  int[] explosionCounter = new int[scrapNum];  
  int   explosionIndex;           


  boolean thrustersPlaying;
  boolean saucerPlaying;
  boolean misslePlaying;


  	Dimension offDimension;
  	Image virtualMem;
  	Graphics gBuffer;
  
  	Image spaceship;	
	int oldX, oldY, newX, newY;
	int appletWidth;		
	int appletHeight;	
	Rectangle startGame,high, instruction, about;	
	int numColor;


  Font font = new Font("Helvetica", Font.BOLD, 12);
  FontMetrics fm;
  int fontWidth;
  int fontHeight;
  
  static final int rockMin =  8;    
  static final int rockMax = 15;
  static final int minRockSize  =  5;
  static final int maxRockSize  = 40;
  static final int rockMinSpeed = 2;
  static final int rockMaxSpeed = 15;

  public void init() 
  {

    Graphics g;
    Dimension d;
    int i;

    // Instructions

    System.out.println("Instructions");
    System.out.println();
    System.out.println("Keyboard Controls");
    System.out.println();  
 	System.out.println("S            - Start Game");
    System.out.println("P            - Pause Game");
    System.out.println("Cursor Left  - Rotate Left");
    System.out.println("Cursor Right - Rotate Right");
    System.out.println("Cursor Up    - Forward");
    System.out.println("Cursor Down  - Backward");    
    System.out.println("Spacebar     - Fire Cannon");     
    System.out.println("H            - Hyperspace");    
    System.out.println();    
    System.out.println("Game Information");
    System.out.println();
    System.out.println("2006 APCSII Final Project");
    g = getGraphics();
    d = size();
    SAsteroids.width = d.width;
    SAsteroids.height = d.height;

  
    // Create shape for the ship sprite.

    ship = new SAsteroids();
    
    ship.shape.addPoint(0, -10);
    ship.shape.addPoint(7, 10);
    ship.shape.addPoint(-7, 10);

    // Create shape for the photon sprites.

    for (i = 0; i < shotNum; i++) 
    {
      photons[i] = new SAsteroids();
      photons[i].shape.addPoint(1, 1);
      photons[i].shape.addPoint(1, -1);
      photons[i].shape.addPoint(-1, 1);
      photons[i].shape.addPoint(-1, -1);
    }
    
    // Shape of UFO


    ufo = new SAsteroids();
    ufo.shape.addPoint(-15, 0);
    ufo.shape.addPoint(-10, -5);
    ufo.shape.addPoint(-5, -5);
    ufo.shape.addPoint(-5, -9);
    ufo.shape.addPoint(5, -9);
    ufo.shape.addPoint(5, -5);
    ufo.shape.addPoint(10, -5);
    ufo.shape.addPoint(15, 0);
    ufo.shape.addPoint(10, 5);
    ufo.shape.addPoint(-10, 5);
    missle = new SAsteroids();
    missle.shape.addPoint(0, -4);
    missle.shape.addPoint(1, -3);
    missle.shape.addPoint(1, 3);
    missle.shape.addPoint(2, 4);
    missle.shape.addPoint(-2, 4);
    missle.shape.addPoint(-1, 3);
    missle.shape.addPoint(-1, -3);


    for (i = 0; i < rockNum; i++)
      asteroids[i] = new SAsteroids();
    for (i = 0; i < scrapNum; i++)
      explosions[i] = new SAsteroids();
    g.setFont(font);
    fm = g.getFontMetrics();
    fontWidth = fm.getMaxAdvance();
    fontHeight = fm.getHeight();  

    highScore = 0;
    sound = true;
    detail = true;
    initGame();
    endGame();
    
  }
  
  
  

  public void initGame() 
  {
    score = 0;
    shipsLeft = shipNum;
    asteroidsSpeed = rockMinSpeed;
    newShipScore = NSPoints;
    newUfoScore = NPoints;
    createShip();
    createPhotons();
    initAsteroids();
    initExplosions();
    playing = true;
    paused = false;
  }

  public void endGame() 
  {
    playing = false;
    stopShip();
  }

  public void start() 
  {

    if (loopThread == null) 
    {
      loopThread = new Thread(this);
      loopThread.start();
    }
    if (!loaded && loadThread == null) 
    {
      loadThread = new Thread(this);
      loadThread.start();
    }
  }

  public void stop() 
  {

    if (loopThread != null) 
    {
      loopThread.stop();
      loopThread = null;
    }
    if (loadThread != null) 
    {
      loadThread.stop();
      loadThread = null;
    }
  }

  public void run() 
  {

    int i, j;
    long startTime;



    Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
    startTime = System.currentTimeMillis();

    if (!loaded && Thread.currentThread() == loadThread) 
    {
      loaded = true;
      loadThread.stop();
    }

    while (Thread.currentThread() == loopThread) 
    {

      if (!paused) 
      {
        updateShip();
        updatePhotons();
        updateAsteroids();
        updateExplosions();

        if (score > highScore)
          highScore = score;
        if (score > newShipScore) 
        {
          newShipScore += NSPoints;
          shipsLeft++;
        }
        if (playing && score > newUfoScore && !ufo.active) 
        {
          newUfoScore += NPoints; 
        }



        if (asteroidsLeft <= 0)
            if (--asteroidsCounter <= 0)
              initAsteroids();
      } 
      repaint();
      try 
      {
        startTime += delay;
        Thread.sleep(Math.max(0, startTime - System.currentTimeMillis()));
      }
      catch (InterruptedException e) 
      {
        break;
      }
    }
  }

  public void createShip() 
  {

    ship.active = true;
    ship.angle = 0.0;
    ship.deltaAngle = 0.0;
    ship.currentX = 0.0;
    ship.currentY = 0.0;
    ship.deltaX = 0.0;
    ship.deltaY = 0.0;
    ship.render();
    if (loaded)

    thrustersPlaying = false;

    hyperCounter = 0;
  }

  public void updateShip() 
  {

    double dx, dy, limit;

    if (!playing)
      return;

    // Rotate the ship.

    if (left) 
    {
      ship.angle += Math.PI / 16.0;
      if (ship.angle > 2 * Math.PI)
        ship.angle -= 2 * Math.PI;
    }
    if (right) 
    {
      ship.angle -= Math.PI / 16.0;
      if (ship.angle < 0)
        ship.angle += 2 * Math.PI;
    }

    // Moving forward and backward.

    dx = -Math.sin(ship.angle);
    dy =  Math.cos(ship.angle);
    limit = 0.8 * minRockSize;
    if (up) 
    {
      if (ship.deltaX + dx > -limit && ship.deltaX + dx < limit)
        ship.deltaX = 3*dx;
      if (ship.deltaY + dy > -limit && ship.deltaY + dy < limit)
        ship.deltaY = 3*dy;
    }
    if (down) 
    {
      if (ship.deltaX - dx > -limit && ship.deltaX - dx < limit)
        ship.deltaX = 3*dx;
      if (ship.deltaY - dy > -limit && ship.deltaY - dy < limit)
        ship.deltaY = 3*dy;
    }

    if (ship.active) 
    {
      ship.advance();
      ship.render();
      if (hyperCounter > 0)
        hyperCounter--;
    }
    else
      if (--shipCounter <= 0)
        if (shipsLeft > 0) 
        {
          createShip();
          hyperCounter = hCounter;
        }
        else
          endGame();
  }

  public void stopShip() 
  {

    ship.active = false;
    shipCounter = scrapCounter;
    if (shipsLeft > 0)
      shipsLeft--;
    if (loaded)

    thrustersPlaying = false;
  }

  public void createPhotons() 
  {

    int i;

    for (i = 0; i < shotNum; i++) 
    {
      photons[i].active = false;
      photonCounter[i] = 0;
    }
    photonIndex = 0;
  }

  public void updatePhotons() 
  {

    int i;

    for (i = 0; i < shotNum; i++)
      if (photons[i].active) 
      {
        photons[i].advance();
        photons[i].render();
        if (--photonCounter[i] < 0)
          photons[i].active = false;
      }
  }


//UFO is supposed to appear after certain score has been reached.
//It gives more point than destroying the rocks.
//Underconstruction
/*
  public void initUfo() 
  { 	
    int i;
    
    if(score>=newUfoScore)
    
    
  }

  public void updateUfo() 
  {	
    
  }

  public void stopUfo() 
  {
  	  
  }

//Unique object that is supposed to appear after certain score has been reached.
//Underconstruction.
  public void initMissle() 
  {
  	
  }

  public void updateMissle() 
  {

  }

  public void guideMissle() 
  {
  	
  }

  public void stopMissle() 
  {

  }
*/
  public void initAsteroids() 
  {
    int i, j;
    int s;
    double theta, r;
    int x, y; 

    for (i = 0; i < rockNum; i++) 
    {
      asteroids[i].shape = new Polygon();
      s = rockMin + (int) (Math.random() * (rockMax - rockMin));
      
      for (j = 0; j < s; j ++) 
      {
        theta = 2 * Math.PI / s * j;
        r = minRockSize + (int) (Math.random() * (maxRockSize - minRockSize));
        x = (int) -Math.round(r * Math.sin(theta));
        y = (int)  Math.round(r * Math.cos(theta));
        asteroids[i].shape.addPoint(x, y);
      }      
      asteroids[i].active = true;
      asteroids[i].angle = 0.0;
      asteroids[i].deltaAngle = (Math.random() - 0.5) / 10;

      if (Math.random() < 0.5) 
      {
        asteroids[i].currentX = -SAsteroids.width / 2;
        if (Math.random() < 0.5)
          asteroids[i].currentX = SAsteroids.width / 2;
        asteroids[i].currentY = Math.random() * SAsteroids.height;
      }
      else 
      {
        asteroids[i].currentX = Math.random() * SAsteroids.width;
        asteroids[i].currentY = -SAsteroids.height / 2;
        if (Math.random() < 0.5)
          asteroids[i].currentY = SAsteroids.height / 2;
      }

      asteroids[i].deltaX = Math.random() * asteroidsSpeed;
      if (Math.random() < 0.5)
        asteroids[i].deltaX = -asteroids[i].deltaX;
      asteroids[i].deltaY = Math.random() * asteroidsSpeed;
      if (Math.random() < 0.5)
        asteroids[i].deltaY = -asteroids[i].deltaY;

      asteroids[i].render();
      asteroidIsSmall[i] = false;
      
    }

    asteroidsCounter = sPause;
    asteroidsLeft = rockNum;
    if (asteroidsSpeed < rockMaxSpeed)
      asteroidsSpeed++;
      
  }

//Rock splits after it has been hit.
/*
  public void initSRock(int n) 
  {  	 	  
  	  
  }
*/

  public void updateAsteroids() 
  {

    int i, j;
  
    for (i = 0; i < rockNum; i++)
      if (asteroids[i].active) 
      {
        asteroids[i].advance();
        asteroids[i].render();

        for (j = 0; j < shotNum; j++)
          if (photons[j].active && asteroids[i].active && asteroids[i].isColliding(photons[j])) 
          {
            asteroidsLeft--;
            asteroids[i].active = false;
            photons[j].active = false;
            if (sound)

            explode(asteroids[i]);
            
            if (!asteroidIsSmall[i]) 
            {
              score += bPoints;           
            }
            
          }

        if (ship.active && hyperCounter <= 0 && asteroids[i].active && asteroids[i].isColliding(ship)) 
        {
          if (sound)
          explode(ship);
          stopShip();
        }
    }
  }

  public void initExplosions() 
  {
    int i;
    for (i = 0; i < scrapNum; i++) 
    {
      explosions[i].shape = new Polygon();
      explosions[i].active = false;
      explosionCounter[i] = 0;
    }
    explosionIndex = 0;
  }

  public void explode(SAsteroids s) 
  {
    int c, i, j;
    s.render();
    c = 2;
    if (detail || s.sprite.npoints < 6)
      c = 1;   
    
  }

  public void updateExplosions() 
  {
    int i;
    for (i = 0; i < scrapNum; i++)
      if (explosions[i].active) 
      {
        explosions[i].advance();
        explosions[i].render();
        if (--explosionCounter[i] < 0)
          explosions[i].active = false;
      }
  }

  public boolean keyDown(Event e, int key) 
  {
    if (key == Event.LEFT)
      left = true;
    if (key == Event.RIGHT)
      right = true;
    if (key == Event.UP)
      up = true;
    if (key == Event.DOWN)
      down = true;

    if ((up || down) && ship.active && !thrustersPlaying) 
    {
      if (sound && !paused)

      thrustersPlaying = true;
    }
    if (key == 32 && ship.active) 
    {
      if (sound & !paused) 
      photonIndex++;
      if (photonIndex >= shotNum)
      photonIndex = 0;
      photons[photonIndex].active = true;
      photons[photonIndex].currentX = ship.currentX;
      photons[photonIndex].currentY = ship.currentY;
      photons[photonIndex].deltaX = minRockSize * -Math.sin(ship.angle);
      photons[photonIndex].deltaY = minRockSize *  Math.cos(ship.angle);
      photonCounter[photonIndex] = Math.min(SAsteroids.width, SAsteroids.height) / minRockSize;
    }
    if (key == 104 && ship.active && hyperCounter <= 0) 
    {
      ship.currentX = Math.random() * SAsteroids.width;
      ship.currentX = Math.random() * SAsteroids.height;
      hyperCounter = hCounter;

    }
    if (key == 112) 
    {    
      paused = !paused;
    }
    if (key == 115 && loaded && !playing)
      initGame();

    return true;
  }

  public boolean keyUp(Event e, int key) 
  {
    if (key == Event.LEFT)
      left = false;
    if (key == Event.RIGHT)
      right = false;
    if (key == Event.UP)
      up = false;
    if (key == Event.DOWN)
      down = false;

    if (!up && !down && thrustersPlaying) 
    {

      thrustersPlaying = false;
    }


    return true;
  }

  public void paint(Graphics g) 
  {

  }

  public void update(Graphics g) 
  {

    Dimension d = size();
    int i;
    int c;
    String s;

    if (gBuffer == null || d.width != offDimension.width || d.height != offDimension.height) 
    {
      offDimension = d;
      virtualMem = createImage(d.width, d.height);
      gBuffer = virtualMem.getGraphics();
    }
    gBuffer.setColor(Color.black);
    gBuffer.fillRect(0, 0, d.width, d.height);
    if (detail) 
    {
      gBuffer.setColor(Color.white);     
    }
    gBuffer.setColor(Color.yellow);
    for (i = 0; i < shotNum; i++)
      if (photons[i].active)
        gBuffer.drawPolygon(photons[i].sprite);
  
    c = Math.min(missleCounter * 24, 255);
    gBuffer.setColor(new Color(c, c, c));
    if (missle.active) 
    {
      gBuffer.drawPolygon(missle.sprite);
      gBuffer.drawLine(missle.sprite.xpoints[missle.sprite.npoints - 1], missle.sprite.ypoints[missle.sprite.npoints - 1],
                           missle.sprite.xpoints[0], missle.sprite.ypoints[0]);
    }
    for (i = 0; i < rockNum; i++)
      if (asteroids[i].active) 
      {      	
        if (detail) 
        {
          gBuffer.setColor(Color.black);
          gBuffer.fillPolygon(asteroids[i].sprite);
        }
        if(i%5==0)        
        gBuffer.setColor(Color.gray);
        else
        if(i%2==0&&i%5!=0)        
        gBuffer.setColor(Color.green);
        else
        if(i%3==0&&i%2!=0&&i%5!=0)
        gBuffer.setColor(Color.blue);
        else
        gBuffer.setColor(Color.white);
       
        gBuffer.drawPolygon(asteroids[i].sprite);
        gBuffer.drawLine(asteroids[i].sprite.xpoints[asteroids[i].sprite.npoints - 1], asteroids[i].sprite.ypoints[asteroids[i].sprite.npoints - 1],
                         asteroids[i].sprite.xpoints[0], asteroids[i].sprite.ypoints[0]);
      }

    if (ufo.active) 
    {    
      if (detail) 
      {
        gBuffer.setColor(Color.black);
        gBuffer.fillPolygon(ufo.sprite);
      }
      
      gBuffer.setColor(Color.white);
      gBuffer.drawPolygon(ufo.sprite);
      gBuffer.drawLine(ufo.sprite.xpoints[ufo.sprite.npoints - 1], ufo.sprite.ypoints[ufo.sprite.npoints - 1],
                           ufo.sprite.xpoints[0], ufo.sprite.ypoints[0]);
    }
    
    c = 255;
    if (ship.active) 
    {
      if (detail && hyperCounter == 0) 
      {
        gBuffer.setColor(Color.black);
        gBuffer.fillPolygon(ship.sprite);
      }
      gBuffer.setColor(Color.red);
      gBuffer.drawPolygon(ship.sprite);
      gBuffer.drawLine(ship.sprite.xpoints[ship.sprite.npoints - 1], ship.sprite.ypoints[ship.sprite.npoints - 1],
                           ship.sprite.xpoints[0], ship.sprite.ypoints[0]);
    }    

    for (i = 0; i < scrapNum; i++)
      if (explosions[i].active) 
      {      	
        c = (255 / scrapCounter) * explosionCounter [i];
        gBuffer.setColor(new Color(c, c, c));
        gBuffer.drawPolygon(explosions[i].sprite);
      }    

    gBuffer.setFont(font);
    gBuffer.setColor(Color.blue);
    gBuffer.drawString("Your Score: " + score, fontWidth, fontHeight);
    gBuffer.drawString("Ships Left: " + shipsLeft, fontWidth, 3*fontHeight);
    s = "High Score: " + highScore;
    gBuffer.drawString(s, fontWidth, +2*fontHeight);
    if (!sound) 
    {
      s = "Mute";
      gBuffer.drawString(s, d.width - (fontWidth + fm.stringWidth(s)), d.height - fontHeight);
    }
    
    if (!playing) 
    {
      s = "Asteroids";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 - 5*fontHeight);
      s = "Press 'S' to start the game";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 - 4*fontHeight);
      s = "Instruction";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 - 2*fontHeight);
      s = "S     - Start Game";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 );
      s = "P     - Pause";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 + fontHeight);
      s = "Left  - Rotate Left";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 + 2*fontHeight);
      s = "Right - Rotate Right";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 + 3*fontHeight);
      s = "Up    - Forward";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 + 4*fontHeight);
      s = "Down  - Backward";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 + 5*fontHeight);
      s = "Space - Fire";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 + 6*fontHeight);
      s = "H     - Hyperspace";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 2 + 7*fontHeight);
     
      if(playing) 
      {
        s = "Game Over";
        gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 4);
        s = "'S' to Start";
        gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 4 + fontHeight);
      }
    }
    else if (paused) 
    {
      s = "Game Paused";
      gBuffer.drawString(s, (d.width - fm.stringWidth(s)) / 2, d.height / 4);
    }
    g.drawImage(virtualMem, 0, 0, this);
  }
 
}


class SAsteroids 
{
  static int width;    			 
  static int height;

  Polygon shape;  
  boolean active;                
  double  angle;                 
  double  deltaAngle;           
  double  currentX, currentY;    
  double  deltaX, deltaY;        
  Polygon sprite;
  
  public SAsteroids() 
  {

    this.shape = new Polygon();
    this.active = false;
    this.angle = 0.0;
    this.deltaAngle = 0.0;
    this.currentX = 0.0;
    this.currentY = 0.0;
    this.deltaX = 0.0;
    this.deltaY = 0.0;
    this.sprite = new Polygon();
  }  

  public void advance() 
  {
    this.angle += this.deltaAngle;
    if (this.angle < 0)
      this.angle += 2 * Math.PI;
    if (this.angle > 2 * Math.PI)
      this.angle -= 2 * Math.PI;
    this.currentX += this.deltaX;
    if (this.currentX < -width / 2)
      this.currentX += width;
    if (this.currentX > width / 2)
      this.currentX -= width;
    this.currentY -= this.deltaY;
    if (this.currentY < -height / 2)
      this.currentY += height;
    if (this.currentY > height / 2)
      this.currentY -= height;
  }

  public void render() 
  {
    int i;
    this.sprite = new Polygon();
    for (i = 0; i < this.shape.npoints; i++)
      this.sprite.addPoint((int) Math.round(this.shape.xpoints[i] * Math.cos(this.angle) + this.shape.ypoints[i] * Math.sin(this.angle)) + (int) Math.round(this.currentX) + width / 2,
                 (int) Math.round(this.shape.ypoints[i] * Math.cos(this.angle) - this.shape.xpoints[i] * Math.sin(this.angle)) + (int) Math.round(this.currentY) + height / 2);
  }

  public boolean isColliding(SAsteroids s) 
  {
    int i;    

    for (i = 0; i < s.sprite.npoints; i++)
      if (this.sprite.inside(s.sprite.xpoints[i], s.sprite.ypoints[i]))
        return true;
    for (i = 0; i < this.sprite.npoints; i++)
      if (s.sprite.inside(this.sprite.xpoints[i], this.sprite.ypoints[i]))
        return true;
    return false;
  }
}

