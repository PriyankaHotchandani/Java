import java.util.Scanner;
public class jaggedarray {
    static double sum(int y[]) 
    {
        double total = 0;
        for (int i=0; i<y.length; i++)
        {
            total = total + y[i];
        }
        return total;
    }
    
    static double batting_avg(int y[]) 
    {
        double total = 0;
        for (int i=0; i<y.length; i++)
        {
            total = total + y[i];
        }
        return total/y.length;
    }
    public static void main(String[] args) {
        int n,m;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        n=s1.nextInt();
        int arr[][]=new int[n][];

        double total[] = new double[n];
		double avg[] = new double[n];

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
            total[i]=sum(arr[i]);
            avg[i]=batting_avg(arr[i]);
            System.out.println("Total runs scored by player "+(i+1)+" is "+total[i]);
            System.out.println("Batting average of player "+(i+1)+" is "+avg[i]);
        }
    }
}