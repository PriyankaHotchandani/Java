import java.util.*;
public class factorial{
    static int factorial(int n){
        int fact=1;
        for(int i=n;i>0;i--){
            fact=fact*i;
        }
        return fact;
    }
public static void main(String[] args){
    int a,f;
    System.out.println("Enter a number:");
    Scanner n = new Scanner(System.in);
    a=n.nextInt();
    f=factorial(a); 
    System.out.println("The factorial of the entered number is: "+f);
    }
}
