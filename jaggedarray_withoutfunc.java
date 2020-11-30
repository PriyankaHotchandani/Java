import java.util.Scanner;
public class jaggedarray_withoutfunc {
    public static void main(String[] args) {
        int n,m;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        n=s1.nextInt();
        int arr[][]=new int[n][];

        for (int i=0; i<arr.length; i++)
        {
            System.out.println("Enter number of matches played by player "+(i+1)+" : ");
            m=s1.nextInt();
            arr[i]=new int[m];
        }
        System.out.println();

        for (int i=0; i<arr.length; i++)
        {
            for (int j=0; j<arr[i].length; j++)
            {
                System.out.println("Enter runs scored in match "+(j+1)+" by player "+(i+1));
                arr[i][j]=s1.nextInt();
            }
        }

        for (int i=0; i<arr.length; i++)
        {
            float total=0;
            float avg=0;
            for (int j=0; j<arr[i].length; j++)
            {
                total=total+arr[i][j];
            }
            avg=total/(arr[i].length +1);
            System.out.println("Total runs scored by player "+(i+1)+" is "+total);
            System.out.println("Batting average of player "+(i+1)+" is "+avg);
        }
    }
}

