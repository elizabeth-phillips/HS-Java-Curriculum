import java.applet.Applet;
import java.awt.*;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class GraphicsExCont13 extends java.applet.Applet{
    Image picture1, picture2, picture3, picture4, picture5, picture6;

    public void init(){
        picture1 = getImage(getDocumentBase(),"space.gif");
        picture2 = getImage(getDocumentBase(),"computer.gif");
        picture3 = getImage(getDocumentBase(),"gears.gif");
        picture4 = getImage(getDocumentBase(),"butterfly.gif");
        picture5 = getImage(getDocumentBase(),"pizza.gif");
        picture6 = getImage(getDocumentBase(),"jet.gif");
    }

    public void paint(Graphics g){
        g.drawImage(picture1,100,100,this);
        g.drawImage(picture2,450,100,this);
        g.drawImage(picture3,700,100,this);
        g.drawImage(picture4,100,400,this);
        g.drawImage(picture5,400,350,this);
        g.drawImage(picture6,700,400,this);
    }
    public void update(Graphics g)   {   paint(g);   }

}

