public class CheckMail
{
    private int length;
    private int width;
    private int height;
    private int weight;

    public CheckMail(){
        this.length = 0;
        this.width = 0;
        this.height = 0;
        this.weight = 0;
    }

    public CheckMail(int length, int width, int height, int weight){
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public void findLargest(int dim1, int dim2, int dim3){
        //Use three variables, called dim1, dim2, and dim3.  
        //Try to end up with dim1 holding the largest value.
        int temp = 0;
        //Compare dim2 and dim1
        //if dim2 is greater 
        if(dim2 > dim1){
            //---swap the values of dim1 and dim2
            temp = dim1;
            dim1 = dim2; 
            dim2 = temp;
            //--- will be holding largest value.
        }
        //Compare dim3 and dim1
        //if dim3 is greater
        //---swap dim1 and dim3
        //---dim1 is still holding largest value.
        
        this.length = dim1;
        this.width = dim2;
        this.height = dim3;
    }

    public int calculateCircumference(){
        //Using width and height, calculate the circumference
        return (this.width + this.height) * 2;
    }

    public void outputMessage(){
        findLargest(length, width, height);
        int c = calculateCircumference();
        //if package is too big and too heavy, print appropriate message

        //else if package is too big, print appropriate message

        //else if package is too heavy, print appropriate message

        //else print package is acceptable

    }
}
