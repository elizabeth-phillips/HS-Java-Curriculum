/**
 * @author Aimee Ornelas
 * @version January 5, 2018
 */
class CollegeStudent extends Student
{
    private String myMajor;
    private int myYear;

    public CollegeStudent(String name, int age, String gender, String idNum, double gpa, String major, int year){
        super(name, age, gender, idNum, gpa);

        myMajor = major;
        myYear = year;
    }

    public String getMajor(){return myMajor;}
    public void setMajor(String major){ myMajor = major;}
    public int getYear(){return myYear;}
    public void setYear(int year){myYear = year;}

    public String toString(){
        return super.toString() + ", major: " + myMajor + ", year: " + myYear;
    }
}
