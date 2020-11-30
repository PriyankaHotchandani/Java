import java.util.*;
class InvalidNumberException extends Exception {
    public String toString()
    {
        return "Entered number is not even";
    }
}

public class exceptionHandling {
    public static void main(String[] args) {
        int num;
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter the number: ");
        num=s1.nextInt();
        try 
        {
            if(num%2==0)
            {
                System.out.println("Number entered successfully");
            }
            else
            {
                throw new InvalidNumberException();
            }
        }
        catch(InvalidNumberException e) {
            System.out.println(e.toString());
        }
    }
} 