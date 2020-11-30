import java.util.*;
public class ieeeRep {
    static int[] mantissa = new int[52];
    static int[] dec_bin = new int[50];   //decimal to bin
    static int power = 0, sign, t;  //temp
    static int esp_single[] = new int[8], exp_double[] = new int[11];   //Exponents of single and double
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n;
        System.out.println("IEEE-754 Notation ");
        System.out.println("Enter the number:");
        n = sc.nextDouble();
        norm(n);
        Single_Precision();
        Double_Precision();
    }
 
    static void norm(double n) {
        int a, i, j, count = 0;  
        if (n < 0) 
        {
            sign = 1;
        } 
        else 
        {
            sign = 0;
        }
        n = Math.abs(n);
        a = (int) n; 
        double f = n - a; //fraction

        //n should be greater than 1, if not use frac_bin

        if (n < 1) 
        {
            frac_bin(f);
        } 
        else 
        {
            while (a != 0) 
            {
                dec_bin[count] = a % 2;
                a = a / 2;
                count++;
            }
            power = count - 1;
            for (i = 0, j = count - 2; i < count - 1; i++, j--) 
            {
                mantissa[i] = dec_bin[j];
            }
            frac_bin(f);
        }
    } 

    static void frac_bin(double fr) //frac_bin is binary of frac part
    {
        int count = power, i = 0, x = power - 1;
        while (x == -1) 
        {
            fr = fr * 2;
            t = (int) fr;
            if (t == 1) 
            {
                x++;
                fr = fr - t;
            }
            power--;
        }

        while (fr != 0 && count <= 52)
        {
            fr = fr * 2;
            t = (int) fr;
            mantissa[count] = t;
            if (t == 1)
            {
                fr = fr- t;
            }
            count++;
        }
    }

    static void dec_bin(double n, double x) 
    {
        int i, j, a, count = 0, array[] = new int[11];
        a = (int) n;
        while (a != 0) 
        {
            array[count] = a % 2;
            a = a / 2;
            count++;
        }
        for (i = 0, j = count - 1; i < count; i++, j--) 
        {
            if (x == 8) 
            {
                esp_single[7 - i] = array[i];
            } 
            else 
            {
                exp_double[10 - i] = array[i];
            }
        }
    }

    static void Single_Precision() 
    {
        int i, expo = power + 127;
        System.out.println("\nExponent part: 127 + " + power + " = " + expo);
        dec_bin(expo, 8);
        System.out.println("\nSingle Precision: \n " + sign);

        for (i = 0; i < 8; i++) 
        { 
            System.out.print(" " + esp_single[i]);
        }
            System.out.println(" ");    // print mantissa 23 bits
            
        for (i = 0; i < 23; i++) 
        {
            System.out.print(" " + mantissa[i]);
        }
        
    }

    static void Double_Precision() 
    {
        int i, expo = power + 1023;
        System.out.println("\n\nExponent part: 1023 + " + power + " = " + expo);
        dec_bin(expo, 11);
        System.out.println("\nDouble Precision: \n " + sign);

        for (i = 0; i < 11; i++) 
        {
            System.out.print(" " + exp_double[i]);
        }
        System.out.println(" ");   // print mantissa 52 bits
        for (i = 0; i < 52; i++) 
        {
            System.out.print(" " + mantissa[i]);
        }
    }

}