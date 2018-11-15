/**
 * Created by E157813 on 3/2/2017.
 */
public class CompactTester {
    public static void main(String[] args){
        System.out.println("========================List 1========================");
        int[] list1 = {47, 0, 51, 0, 77, 28, 0, 26, 0, 24, 0, 65, 46, 0, 36, 87, 48, 25, 63,0,
                4, 39, 16, 69, 42, 45, 62, 81, 52, 61, 0, 96, 88, 67, 95, 29, 97, 0, 93,  7, 0};
        Compact comp1 = new Compact(list1);
        System.out.println("List before: ");
        comp1.printList();
        comp1.compact();
        System.out.println("List after: ");
        comp1.printList();

        System.out.println("========================List 2========================");
        int[] list2 = {0, 9, 7, 0, 0, 23, 4, 0};
        Compact comp2 = new Compact(list2);
        System.out.println("List before: ");
        comp2.printList();
        comp2.compact();
        System.out.println("List after: ");
        comp2.printList();

    }
}
/*Desired Output

========================List 1========================
List before:
47  0  51  0  77  28  0  26  0  24  0  65  46  0  36  87  48  25  63  0  4  39  16  69  42  45  62  81  52  61  0  96  88  67  95  29  97  0  93  7  0

List after:
47  51  77  28  26  24  65  46  36  87  48  25  63  4  39  16  69  42  45  62  81  52  61  96  88  67  95  29  97  93  7

========================List 2========================
List before:
0  9  7  0  0  23  4  0

List after:
9  7  23  4  


 */