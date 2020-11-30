package JAVA;
import java.util.*;
public class oopm 1 {
    public static void main(String[] args) 
	{
		int a,b;
		Scanner s1 = new Scanner(System.in);
        
        System.out.println("Enter two numbers:");
        a = s1.nextInt();
        b = s1.nextInt(); 
        
        abc d = new abc();
        int g = d.gcd(a, b);
	}
}

class abc
{
    public static int gcd(int a, int b)
    {
        int c = a*b;
        if (a!=b)
        {
            if (a>b) 
            {a=a-b;}
            else 
            {b=b-a;}
        }
        System.out.println("Gcd:"+a);
        System.out.println("Lcm:"+c/a);
        return a;
    }
}
