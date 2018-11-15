public class Compact {
    private int[]numbers;
    private int validNumber;
    public Compact(int[] numbers) {
        this.numbers = numbers;
        validNumber = numbers.length;
    }
    public void rearrange(){
        for(int s =0; s < numbers.length; s++){
            if(numbers[s] == 0){
                validNumber -= 1;
            }
        }
        for(int t = 0; t < numbers.length; t++){
            for (int i = 0; i < numbers.length-1; i++) {
                if (numbers[i] == 0) {
                    numbers[i] = numbers[i + 1];
                    numbers[i+1] = 0 ;
                }

            }
        }

    }
    public void printList(){
        for(int i = 0; i < validNumber; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}


