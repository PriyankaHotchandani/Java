import java.util.Scanner;
class NumberException extends Exception {
    public String toString()
    {
        return "Error: Number contains digit 9";
    }
}

public class throwException {
    public static void main(String[] args) {
        int n;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the number: ");
        n = s1.nextInt();
        try
        {
            while (n>0)
            {
                if (n%10==9)
                {
                    throw new NumberException();
                }
                n=n/10;
            }
        }
        catch(NumberException e) {
            System.out.println(e.toString());
        }
    }
}