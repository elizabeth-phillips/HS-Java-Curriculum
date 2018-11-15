import java.applet.Applet;
import java.awt.*;
import java.awt.Image;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class GraphicsExCont11 extends java.applet.Applet{
    Image picture;

    public void init(){
        picture=getImage(getDocumentBase(),"cat.jpg");
    }
    public void paint(Graphics g){
        picture = picture.getScaledInstance(50,50,Image.SCALE_DEFAULT);
        g.drawImage(picture,0,0,this);
        g.drawImage(picture,600,150,this);
        g.drawImage(picture,300,400,this);
    }
}
