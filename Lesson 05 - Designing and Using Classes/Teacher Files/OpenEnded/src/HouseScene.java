
/**
 * This code puts all of the house scene together
 * 
 * @author Elizabeth Phillips 
 * @version 1
 */
import gpdraw.*;
public class HouseScene
{
    public static void main(String[] args){
        SketchPad sp = new SketchPad(600,600);

		//Background is done first so it will be the bottom layer
		Background background = new Background(sp);
		background.drawBackground();

        House house = new House(sp);
        house.drawBrick();
        house.drawRoof();
		house.drawDoor();
		house.drawWindows();

		Tree tree = new Tree(sp);
		tree.drawTrunk();
		tree.drawLeaves();
		tree.drawKnot();
    }
}
