import java.util.Scanner;

class Customers {
    int acc_id;
    String name;
    double balance;
    Customers (int a_id, String n, double bal)
    {
        acc_id=a_id;
        name=n;
        balance=bal;
    }
} 

public class functionalities {
    public static void main(String[] args) {
        int n, i, k, choice, len=0, p, pos;
        String r;
        double b;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter total no. of customers:");
        n=s1.nextInt(); 
        
        Customers arr[]=new Customers[n];

        while(true)
        {
            System.out.println("Options are:");
            System.out.println("1. To add account");
            System.out.println("2. To delete any account details");
            System.out.println("3. To display account details");
            System.out.println("4. Exit");
            System.out.println("Enter your option:");
            choice=s1.nextInt();

            switch(choice)
            {
                case 1:
                System.out.println("Enter no. of customer accounts to be added:");
                k=s1.nextInt();
                if ((k+len)>n)
                {
                    System.out.println("More accounts can't be added since maximum number of accounts are "+n);
                    break;
                }
                for (i=0;i<k;i++)
                {
                    System.out.println("Enter account id:");
                    p=s1.nextInt();
                    System.out.println("Enter name of the customer:");
                    r=s1.next();
                    System.out.println("Enter balance of the customer:");
                    b=s1.nextDouble();
                    arr[i+len]=new Customers(p,r,b);
                }
                len=len+k;
                break;

                case 2:
                if (len==0)
                {
                    System.out.println("No records are found");
                    break;
                }
                System.out.println("Enter position of the customer account to be deleted:");
                pos=s1.nextInt();
                for(i = pos-1; i<arr.length-1; i++)
                {
                    arr[i]=arr[i+1];
                }
                len=len-1;
                break;

                case 3:
                if (len==0)
                {
                    System.out.println("No records are found");
                    break;
                }
                System.out.println("Customer account details are:");
                for(i=0;i<len;i++)
                {
                    if(arr[i]!=null)
                    {
                        System.out.println("Customer account details of "+(i+1)+": Account Id-"+arr[i].acc_id+" Name-"+arr[i].name+" Balance-"+arr[i].balance);
                    }
                }
                break;

                case 4:
                System.exit(0);

                default:
                System.out.println("Please enter the correct choice");
                break;
            }
        }
    }
}