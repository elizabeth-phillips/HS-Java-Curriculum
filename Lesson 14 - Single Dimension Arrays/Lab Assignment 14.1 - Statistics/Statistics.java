/**
 * Created by Elizabeth on 2/26/2017.
 */
public class Statistics {
    private int[] numbers;
    public Statistics(int[] numbers){
        this.numbers = numbers;
    }

    public long findSum(){
        long sumNum = 0;
        for(int num : numbers){
            sumNum += num;
        }
        return sumNum;
    }

    public double findAverage(){
        return (double)findSum() / numbers.length;
    }

    public double standardDeviation(){
        double avg = findAverage();
        double sumDiff = 0;
        double[] differences = new double[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            differences[i] = avg - numbers[i];
        }
        for(double num : differences){
            sumDiff += (num * num);
        }
        sumDiff /= (numbers.length - 1);
        return Math.sqrt(sumDiff);
    }
}
