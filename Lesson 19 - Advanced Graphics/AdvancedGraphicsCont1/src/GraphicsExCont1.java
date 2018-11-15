import java.applet.Applet;
import java.awt.*;

/**
 * Created by Elizabeth on 5/3/2017.
 */
public class GraphicsExCont1 extends Applet {
    int appletWidth;		//  width of the Applet window
    int appletHeight;	//  height of the Applet window

    public void init(){
        appletWidth = getWidth();
        appletHeight = getHeight();
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,appletWidth,appletHeight);
    }

}
