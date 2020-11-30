import java.util.*;
public class nonrestoring {
    public static void main(String[] args) {
        int M, Q, bits=6;
        int count=bits;
        int M_bin[]=new int[bits];
        int Q_bin[]=new int[bits];
        int A[]=new int[bits];
        int M_temp[]=new int[bits];

        Scanner s1=new Scanner(System.in);
        System.out.println("NON-RESTORING DIVISION: ");
        System.out.print("Enter Divisor(M): ");
        M=s1.nextInt();
        System.out.print("Enter Dividend(Q): ");
        Q=s1.nextInt();

        M_bin=binary(M, bits);
        Q_bin=binary(Q, bits);
        if(M<0)
        {
            M_bin=complement(M_bin, bits);
        }
        if(Q<0)
        {
            Q_bin=complement(Q_bin, bits);
        }
        
        System.out.print("\nM in binary is: ");
        for(int x: M_bin)
        System.out.print(x);
        System.out.print("\nQ in binary is: ");
        for(int x: Q_bin)
        System.out.print(x); 
        System.out.println("\nInitial Value: ");
        for(int x: A)
        System.out.print(x); 
        System.out.print(" : ");
        for(int x: Q_bin)
        System.out.print(x); 

        while(count>0)
        {
            System.out.println("\n\nCOUNT= "+count);
            for(int i=0;i<bits-1;i++)
            {
                A[i]=A[i+1];
            }
            A[bits-1]=Q_bin[0];
            for(int i=0;i<bits-1;i++)
            {
                Q_bin[i]=Q_bin[i+1];
            }
            System.out.println("\nArray after left shift: ");
            for(int x: A)
            System.out.print(x); 
            System.out.print(" : ");
            for(int x: Q_bin)
            System.out.print(x); 

            if(A[0]==0)
            {
                System.out.println("\nArray after A=A-M: ");
                M_temp=complement(M_bin.clone(), bits);
                A=add(A, M_temp, bits);
                for(int x: A)
                System.out.print(x); 
                System.out.print(" : ");
                for(int x: Q_bin)
                System.out.print(x); 
            }
            else if(A[0]==1)
            {
                M_temp=M_bin.clone();        
                A=add(A, M_temp, bits);
                System.out.println("\nArray after A=A+M: ");
                for(int x: A)
                System.out.print(x); 
                System.out.print(" : ");
                for(int x: Q_bin)
                System.out.print(x); 
            }        

            if(A[0]==0) 
            {
                Q_bin[bits-1]=1;
            }
            else if(A[0]==1)
            {
                Q_bin[bits-1]=0;
            }

            count--;
        }

        if(count==0)
        {
            if(A[0]==1)
            {
                M_temp=M_bin.clone();
                A=add(A, M_temp, bits);
                System.out.println("\nArray after A=A+M: ");
                for(int x: A)
                System.out.print(x); 
                System.out.print(" : ");
                for(int x: Q_bin)
                System.out.print(x); 
            }
        }
        
        System.out.print("\nRemainder: ");
        for(int x: A)
        System.out.print(x); 
        System.out.print("\nQuotient: ");
        for(int x: Q_bin)
        System.out.print(x); 
        decimal(A, Q_bin);
    }

    public static int[] binary(int dec, int bits) {
        int[] dec_bin=new int[bits];
        for(int i=bits-1;i>=0;i--)
        {
            dec_bin[i]=dec%2;
            dec=dec/2;
        }
        return dec_bin;
    }
    
    public static void decimal (int[] rem, int[] quo){  
        StringBuilder s_1 = new StringBuilder();
        for (int i : rem)
        {
            s_1.append(i);
        }
        String binnn_1=s_1.toString();
        System.out.println("/n");
        System.out.println("Reaminder in decimal: "+Integer.parseInt(binnn_1, 2));
        
        StringBuilder s_2 = new StringBuilder();
        for (int i : quo)
        {
            s_2.append(i);
        }
        String binnn_2=s_2.toString();
        System.out.println("Quotient in decimal: "+Integer.parseInt(binnn_2, 2));
    }

    public static int[] add(int[] arr1,int[] arr2, int bits) {
        int carry=0;
        int arr[]=new int[bits];
        for(int i=bits-1;i>=0;i--)
        {
            arr[i]=(arr1[i]+arr2[i]+carry)%2;
            carry=(arr1[i]+arr2[i]+carry)/2;
        }
        return arr;
    }

    public static int[] complement(int[] bin, int bits) {
        for(int i=0;i<bits;i++)
        {
            bin[i]=(bin[i]==0)?1:0;
        }
        int plus_one[]=new int[bits];
        plus_one[bits-1]=1;
        bin=add(bin,plus_one,bits);
        return bin;
    }
}
           