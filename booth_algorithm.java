import java.util.*;
class booth_algorithm {
    public static void main(String[] args) {
        int M, Q, Q_1=0, bits=6;
        int count=bits;
        int M_bin[]=new int[bits];
        int Q_bin[]=new int[bits];
        int A[]=new int[bits];
        int M_temp[]=new int[bits];

        Scanner s1=new Scanner(System.in);
        System.out.println("Booth's Alrorithm: ");
        System.out.print("Enter multiplicand(M): ");
        M=s1.nextInt();
        System.out.print("Enter multiplier(Q): ");
        Q=s1.nextInt();

        M_bin=convert_binary(M, bits);
        Q_bin=convert_binary(Q, bits);
        if(M<0)
        {
            M_bin=get_complement(M_bin, bits);
        }
        if(Q<0)
        {
            Q_bin=get_complement(Q_bin, bits);
        }

        System.out.print("\nBinary equivalent of M is: ");
        for(int x: M_bin)
        System.out.print(x);
        System.out.print("\nBinary equivalent of Q is: ");
        for(int x: Q_bin)
        System.out.print(x); 
        System.out.println("\n\nInitial value: ");
        for(int x: A)
        System.out.print(x); 
        System.out.print(" : ");
        for(int x: Q_bin)
        System.out.print(x); 
        System.out.print(" "+Q_1);

        while(count>0)
        {
            if(Q_bin[bits-1]==1 && Q_1==0)
            {
                M_temp=get_complement(M_bin.clone(), bits);
                A=add(A, M_temp, bits);
            }
            else if(Q_bin[bits-1]==0 && Q_1==1)
            {
                M_temp=M_bin.clone();
                A=add(A, M_temp, bits);
            }
            System.out.println("\n\nCOUNT = "+count);
            System.out.println("Array after comparing the digits: ");
            for(int x: A)
            System.out.print(x); 
            System.out.print(" : ");
            for(int x: Q_bin)
            System.out.print(x); 
            System.out.print(" "+Q_1);
            Q_1=Q_bin[bits-1];
            for(int i=bits-1;i>0;i--)
            {
                Q_bin[i]=Q_bin[i-1];
            }
            Q_bin[0]=A[bits-1];
            for(int i=bits-1;i>0;i--)
            {
                A[i]=A[i-1];
            }
            System.out.println("\nArray after right shift: ");
            for(int x: A)
            System.out.print(x); 
            System.out.print(" : ");
            for(int x: Q_bin)
            System.out.print(x); 
            System.out.print(" "+Q_1);
            count--;
        }

        System.out.println("\nFinal Product: ");
        for(int x: A)
        System.out.print(x); 
        System.out.print(" : ");
        for(int x: Q_bin)
        System.out.print(x); 
        System.out.println("\n\nFinal Product in decimal: "+(M*Q));
    }

    public static int[] convert_binary(int dec, int bits) {
        int[] dec_bin=new int[bits];
        for(int i=bits-1;i>=0;i--)
        {
            dec_bin[i]=dec%2;
            dec=dec/2;
        }
        return dec_bin;
    }

    public static int[] add(int[] arr1, int[] arr2,  int bits) {
        int carry=0;
        int arr[]=new int[bits];
        for(int i=bits-1;i>=0;i--)
        {
            arr[i]=(arr1[i]+arr2[i]+carry)%2;
            carry=(arr1[i]+arr2[i]+carry)/2;
        }
        return arr;
    }

    public static int[] get_complement(int[] bin, int bits) {
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