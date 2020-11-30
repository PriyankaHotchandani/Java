import java.util.Scanner;
public class myMath {
    public static void main(String[] args) {
        double x, n, sin =0, cos=0;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the value of x:");
        x = s1.nextDouble();
        System.out.println("Enter number of terms:");
        n = s1.nextDouble();
        
        double total[] = new double[n];
		double avg[] = new double[n];

        for (int i=0; i<=n; ++i) {
            sin = sin + power(-1, i)*(power(x, 2*i+1)/factorial(2*i+1));
        }

        for (int i=0; i<=n; ++i) {
            cos = cos + power(-1, i)*(power(x, 2*i)/factorial(2*i));
        }
        System.out.println("The value of sin(x) is "+sin);
        System.out.println("The value of cos(x) is "+cos);
    }

    static double factorial(double x) {
        if (x==0)
            return 1;

        return x*factorial(x-1);
    }

    static double power(double x, double n){
        double r=1;
        if (x>=0&&n==0)
            r=1;
        else if (x==0&&n>=1)
            r=0;
        else 
            for (int i=1; i<=n; i++) 
                r=r*x;
        return r;
    }
}