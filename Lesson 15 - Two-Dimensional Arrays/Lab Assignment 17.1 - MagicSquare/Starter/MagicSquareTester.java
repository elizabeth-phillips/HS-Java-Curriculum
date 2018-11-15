/**
 * Created by E157813 on 3/6/2017.
 */
public class MagicSquareTester {
    public static void main(String[] args){

        MagicSquare magic = new MagicSquare(5);

        magic.computeMagicSquare();
        magic.displayMagicSquare();
        magic.checkRows();
        magic.checkColumns();
        magic.checkDiagonals();
    }
}
