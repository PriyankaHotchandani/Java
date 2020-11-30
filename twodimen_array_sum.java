import java.util.Scanner;
public class twodimen_array_sum {
    public static void main(String[] args) {
        int n, m, i=0, j=0;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter total number of rows for:");
        m = s1.nextInt();
        System.out.println("Enter total number of columns:");
        n = s1.nextInt();
        int a[][] = new int [m][n];
        int b[][] = new int [m][n];
        int c[][] = new int [m][n];
        
        System.out.println("Enter the first matrix:");
        for (i = 0; i<m; i++)
        {
            for (j=0; j<n; j++)
            {
                System.out.println("Enter element at row:"+(i+1)+"and column:"+(j+1));
                a[i][j]=s1.nextInt();
            }         
        }

        System.out.println("Enter the second matrix:");
        for (i = 0; i<m; i++)
        {
            for (j=0; j<n; j++)
            {
                System.out.println("Enter element at row:"+(i+1)+"and column:"+(j+1));
                b[i][j]=s1.nextInt();
            }         
        }

        for (i=0; i<m; i++)
        {
            for (j=0; j<n; j++)
            {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        System.out.println("Sum of the two matrices is "+ c[i][j]); 
    }
}