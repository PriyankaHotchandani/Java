import java.util.Scanner;
public class gcd_lcm3{
    public static void main(String[] args) 
	{
		int a,b;
		Scanner s1 = new Scanner(System.in);
        
        System.out.println("Enter two numbers:");
        a = s1.nextInt();
        b = s1.nextInt(); 
        
        abc d = new abc();
        int g = d.gcd(a,b);
        System.out.println("Gcd: "+ g);
        int lcm = (a*b)/g;
        System.out.println("Lcm: "+ lcm);
	}
}

class abc
{
    public int gcd(int a, int b)
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
