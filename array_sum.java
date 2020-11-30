import java.util.Scanner;
public class array_sum {
    public static void main(String[] args) {
        int n, sum=0;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter total number of elements:");
        n = s1.nextInt();
        int a[] = new int [n];
        for (int i = 0; i<a.length; i++)
        {
            System.out.println("Enter element at location:"+(i+1));
            a[i]=s1.nextInt();
        }
        for (int i=0; i<a.length; i++)
        {
            sum = sum + a[i];
        }
        System.out.println("Sum of all elements of array is "+ sum); 
    }
}