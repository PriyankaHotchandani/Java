import java.util.Scanner;

class MarksOutOfRangeException extends Exception {
    public String toString()
    {
        return "Marks out of range [0-100]";
    }
}

public class exception {
    public static void main(String[] args) {
        int marks;
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter the marks: ");
        marks=s1.nextInt();
        try 
        {
            if(marks>100 || marks<0)
            {
                throw new MarksOutOfRangeException();
            }
            else
            {
                System.out.println("Marks entered successfully");
            }
        }
        catch(MarksOutOfRangeException e) {
            System.out.println(e.toString());
        }
    }
} 