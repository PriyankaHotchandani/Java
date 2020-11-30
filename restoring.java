import java.util.*;
public class restoring {
    public static void main(String[] args) {
        int M, Q, bits=6;
        int count=bits;
        int M_bin[]=new int[bits];
        int Q_bin[]=new int[bits];
        int A[]=new int[bits];
        int M_temp[]=new int[bits];
       
        Scanner s1=new Scanner(System.in);
        System.out.println("Restoring Division Algorithm: ");
        System.out.print("Enter the divisor (M): ");
        M=s1.nextInt();
        System.out.print("Enter the dividend (Q): ");
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
        
        System.out.print("\nBinary equivalent of M: ");
        for(int x: M_bin)
        System.out.print(x); 
        System.out.print("\nBinary equivalent of Q: ");
        for(int x: Q_bin)
        System.out.print(x); 
        System.out.println("\n\nInitial value: "+(M*Q));
        for(int x: A)
        System.out.print(x); 
        System.out.print(" : ");
        for(int x: Q_bin)
        System.out.print(x); 

        while(count>0)
        {
            System.out.println("\n\nCount= "+count);
            for(int i=0;i<bits-1;i++)
            {
                A[i]=A[i+1];
            }
            A[bits-1]=Q_bin[0];
            for(int i=0;i<bits-1;i++)
            {
                Q_bin[i]=Q_bin[i+1];
            }
            System.out.println("\nArray after left shift and A=A-M: ");
            M_temp=complement(M_bin.clone(), bits);
            A=to_add(A, M_temp, bits);
            for(int x: A)
            System.out.print(x); 
            System.out.print(" : ");
            for(int x: Q_bin)
            System.out.print(x); 
            
            if(A[0]==0)
            {
                Q_bin[bits-1]=1;
                System.out.println("\nArray after Q0=1: ");
                for(int x: A)
                System.out.print(x); 
                System.out.print(" : ");
                for(int x: Q_bin)
                System.out.print(x); 
            }
    
            else if(A[0]==1)
            {
                Q_bin[bits-1]=0;
                M_temp=M_bin.clone();
                A=to_add(A, M_temp, bits);
                System.out.println("\nArray after Q0=0 and A=A+M: ");
                for(int x:A)
                System.out.print(x); 
                System.out.print(" : ");
                for(int x: Q_bin)
                System.out.print(x); 
            }
            
            count--;
        }
        System.out.print("\nRemainder : ");
        for(int x:A)
        System.out.print(x); 
        System.out.print("\nQuotient : ");
        for(int x: Q_bin)
        System.out.print(x); 
    }

    public static int[] binary(int dec, int bits)
    {
        int[] decimal_bin=new int[bits];
        for(int i=bits-1;i>=0;i--)
        {
            decimal_bin[i]=dec%2;
            dec=dec/2;
        }
        return decimal_bin;
    }
    
    public static int[] to_add(int[] arr1,int[] arr2, int bits)
    {
        int carry=0;
        int arr[]=new int[bits];
        for(int i=bits-1;i>=0;i--)
        {
            arr[i]=(arr1[i]+arr2[i]+carry)%2;
            carry=(arr1[i]+arr2[i]+carry)/2;
        }
        return arr;
    }

    public static int[] complement(int[] bin, int bits)
    {
        for(int i=0;i<bits;i++)
        {
            bin[i]=(bin[i]==0)?1:0;
        }    
        int plus_one[]=new int[bits];
        plus_one[bits-1]=1;
        bin=to_add(bin,plus_one,bits);
        return bin;
    }
}
