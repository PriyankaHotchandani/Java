import java.util.*;
public class ieee {
    static double num, frac;
    static int sign=0, integer;
    static Vector intBin=new Vector();
    static Vector fracBin=new Vector();
    static int singlePrec[]=new int[32];
    static int doublePrec[]=new int[64];
    public static void main(String[] args) {
        System.out.println("IEEE-754 Notation ");
        System.out.print("Enter your number: ");
        Scanner sc=new Scanner(System.in);
        num=sc.nextDouble();
        int exp=0;
        if(num<0)
        {
            sign=1;
            singlePrec[0]=doublePrec[0]=sign;
            num=Math.abs(num);  //returns absolute value of an int value
        }
        String[] input=String.valueOf(num).split("\\.");
        integer=Integer.parseInt(input[0]);
        frac=Double.parseDouble("0."+input[1]);
        System.out.println("Integral: "+integer+" Fraction: "+frac);
        int integral=integer;
        double fraction=frac;
        intBinary(integral);
        fracBinary(fraction);
        int i=0;
        Iterator int_itr=intBin.iterator();
        Iterator frac_itr=fracBin.iterator();

        while(int_itr.hasNext())
        {
            if(((int)int_itr.next())==1) 
            {
                exp=i;
            }
            i++;
        }

        if(exp==0)
        {
            while(frac_itr.hasNext())
            {
                exp--;
                if((int)(frac_itr.next())==1)
                {
                    break;
                }
            }
        }
        int sing_exp=127+exp;
        int doub_exp=1023+exp;
        exp_binary(sing_exp,8); 

        exp_binary(doub_exp,11);
        Vector bigvec = new Vector();
        Vector intbinrev = (Vector)intBin.clone();
        Collections.reverse(intbinrev);
        bigvec.addAll(intbinrev);
        bigvec.addAll(fracBin);
        int in = bigvec.indexOf(1)+1;

        int j = 0;
        for(j=0; j<23 && j<bigvec.size()-in; j++)
        {
            singlePrec[j+9]=(int)bigvec.get(in+j);
        }
        for(j=0;j<23;j++)
        {
            singlePrec[j+9]=0;
        }
        j = 0;
        for(j=0; j<52 && j<bigvec.size()-in; j++)
        {
            doublePrec[j+12]=(int)bigvec.get(in+j);
        }
        for(j=0;j<52;j++)
        {
            doublePrec[j+12]=0;
        }
        System.out.println("Single precision:");
        System.out.print(sign+" ");
        for(j=1;j<=31;j++)
        {
            if(j==9)
            {
                System.out.print(" ");
            }
            System.out.print(singlePrec[j]);
        }
        System.out.println("\nDouble precision: ");
        System.out.print(sign+" ");
        for(j=1;j<64;j++)
        {
            if(j==12)
            {
                System.out.print(" ");
            }
            System.out.print(doublePrec[j]);
        }
    }
    
    public static void intBinary(int num) { 
        int i=0,rem;
        while(num>0)
        {
            rem=num%2;
            intBin.add(i,rem);
            num/=2;
            i++;
        }
    }
    
    public static void fracBinary(double fraction) {
        int i=0;
        while(fraction!=(double)(1) && fracBin.size()<52) 
        {
            fraction=fraction*2;
            if(fraction>=1)
            {
                fracBin.add(1);
                if(fraction == 1) 
                    return;
            fraction=fraction-1;
            }
            else
                fracBin.add(0);
        }
    }
 
    public static void exp_binary(int num,int length) {
        int i;
        if(length==8)
        {
            for(i=1;i<=length;i++)
            {
                singlePrec[9-i]=num%2;
                num/=2;
            }
        }
        else if(length==11)
        {
            for(i=1;i<=length;i++)
            {
                doublePrec[12-i]=num%2;
                num/=2;
            }
        }
    }
} 
