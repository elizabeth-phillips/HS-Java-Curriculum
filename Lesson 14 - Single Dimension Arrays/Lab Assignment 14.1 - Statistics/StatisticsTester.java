/**
 * Created by Elizabeth on 2/26/2017.
 */
public class StatisticsTester {
    public static void main(String[] args){
        System.out.println("============List 1============");
        int[] list1 = {47, 31, 51, 70, 77, 28, 50, 26, 80, 24, 20, 65, 46, 90, 36, 87, 48, 25, 63,100,
                4, 39, 16, 69, 42, 45,  8,  9, 89, 91, 64, 62, 81, 52, 61, 40, 96, 88, 67, 95, 29, 97,
                68, 93,  7, 19, 54,  6, 27,  3, 34, 86, 79, 83,  2, 32, 58, 11, 18, 10, 92, 43, 17,  1,
                12, 84, 76, 30, 99, 98, 57, 14, 53, 59, 78, 23, 73, 94, 21, 75, 72, 15, 35, 66, 22, 37,
                82, 13, 55, 38, 49, 71, 85, 41, 33, 74, 56, 60,  5, 44};
        Statistics stat1 = new Statistics(list1);
        System.out.println("The sum of list 1: " + stat1.findSum());
        System.out.println("The average of list 1: " + stat1.findAverage());
        System.out.println("The standard deviation of list 1: " + stat1.standardDeviation());

        System.out.println("\n\n============List 2============");
        int[] list2 = {3,  7, 73, 32, 88, 18, 84, 40, 63, 72, 96, 56, 38, 28, 35, 26, 34, 45, 59, 30, 43,
                42, 24, 80, 87, 68, 79, 66,  9, 69, 54, 37, 81, 27,  8, 65, 16, 71, 60, 62, 15,  6, 33,
                17, 99, 94, 13, 14, 91, 46, 52, 51, 61, 22, 19, 86, 36, 82,  1, 47, 50,100, 10, 76, 97,
                78, 39, 83, 64, 70, 85, 20, 95, 74, 57,  4, 49, 77};
        Statistics stat2 = new Statistics(list2);
        System.out.println("The sum of list 2: " + stat2.findSum());
        System.out.println("The average of list 2: " + stat2.findAverage());
        System.out.println("The standard deviation of list 2: " + stat2.standardDeviation());

        System.out.println("\n\n============List 3============");
        int[] list3 = {19, 99, 62,100, 58, 68, 33, 41, 22, 55,  5, 74, 20, 34, 86, 21,  7, 92, 26, 35,
                31, 30, 79, 11, 48, 88, 49, 80, 6,  8, 60, 75, 83, 28, 45, 15, 56, 69, 89, 98, 67, 44,
                94, 65, 57, 51,  3, 63, 27, 93, 38, 73, 25, 24, 91, 82, 95, 64, 59, 46,  2, 85, 81, 42,
                87, 16, 90, 39, 96, 52, 72, 18, 14, 71, 10, 29, 23, 36, 97, 43, 76, 70, 13, 40, 84};
        Statistics stat3 = new Statistics(list3);
        System.out.println("The sum of list 3: " + stat3.findSum());
        System.out.println("The average of list 3: " + stat3.findAverage());
        System.out.println("The standard deviation of list 3: " + stat3.standardDeviation());

    }
}
/*
Output of StatisticsTester
============List 1============
The sum of list 1: 5050
The average of list 1: 50.5
The standard deviation of list 1: 29.011491975882016


============List 2============
The sum of list 2: 3988
The average of list 2: 51.12820512820513
The standard deviation of list 2: 28.55587322142146


============List 3============
The sum of list 3: 4452
The average of list 3: 52.37647058823529
The standard deviation of list 3: 29.22041705912569
 */
