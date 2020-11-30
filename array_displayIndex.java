import java.util.Scanner;
public class array_displayIndex {
    public static void main(String[] args) {
        int n, i=0, t;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter total number of elements:");
        n = s1.nextInt();
        int a[] = new int [n];
        for (i = 0; i<a.length; i++)
        {
            System.out.println("Enter element at location:"+(i+1));
            a[i]=s1.nextInt();
        }
        System.out.println("Enter the number whose index to be found: ");
        t = s1.nextInt();
        for (i = 0; i<a.length; i++)
        {
            if (t == a[i]) {
                System.out.println(i);
            }
            else {
                System.out.println("Element not present in array");
        }
        }
    }
}