import java.util.Scanner;
public class program2 {
    public static void main(String[] args) 
	{
		Scanner s1 = new Scanner(System.in);
        
        System.out.println("Enter a number:");
        int a = s1.nextInt();
        check_oddEven(a);
        
    }
    
    static void check_oddEven(int a) {
        if (a % 2 == 0)
            System.out.println(a+" is even");
        else
            System.out.println(a+" is odd");
    }
}