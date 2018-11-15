import java.applet.Applet;
import java.awt.*;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class GraphicsExCont12 extends java.applet.Applet{
    Image picture1, picture2, picture3, picture4;

    public void init(){
        picture1 = getImage(getDocumentBase(),"LSchram.gif");
        picture2 = getImage(getDocumentBase(),"JSchram.jpg");
        picture3 =
                getImage(getDocumentBase(),"ShortCircuit.bmp");
        picture4 = getImage(getDocumentBase(),"bunny.png");
    }

    public void paint(Graphics g){
        g.drawImage(picture1,0,0,this);
        g.drawImage(picture2,300,0,this);
        g.drawImage(picture3,50,300,this);
        g.drawImage(picture4,400,400,this);
    }
}

