import java.util.Scanner;
public class gcd_lcm1 {
    public static void main(String[] args) 
	{
		Scanner s1 = new Scanner(System.in);
        int a,b;
        System.out.println("Enter two numbers:");
        a = s1.nextInt();
        b = s1.nextInt(); 
        
        int g = abc.gcd(a,b);
        System.out.println("Gcd: "+ g);
        int lcm = (a*b)/g;
        System.out.println("Lcm: "+ lcm);
    }
    static int gcd(int a, int b)
    {
        if (a>b) 
        {
            return gcd(a-b,b);
        }    
        else if (a<b)
        {
            return gcd(b,b-a);
        }
        else 
        {
            return a;
        }
    }

}



    
