import java.util.Scanner;

import jdk.internal.util.xml.impl.Input;
public class method_overloading {
    public static void main (String[] args) {
        int a,b,c,option;
        Scanner s1 = new Scanner(System.in);

        System.out.println("Enter the numbers:");
        a = s1.nextInt();
        System.out.println("A = "+a);
        b = s1.nextInt();
        System.out.println("B = "+b);
        c = s1.nextInt();
        System.out.println("C = "+c);

        overloading obj = new overloading();

        System.out.println("Which numbers to be added: ");
        System.out.println("1: Add A and B");
        System.out.println("2: Add B and C");
        System.out.println("3: Add C and A");
        System.out.println("4: Add A, B and C");

        Scanner s1 = new Scanner(System.in);
        option = s1.nextInt();
        
        switch(option){
            case 1:
            obj.add(a, b);
            break;
            
            case 2:
            obj.add(b, c);
            break;

            case 3:
            obj.add(c, a);
            break;

            case 4:
            obj.add(a, b, c);
            break;
        }

    
    }
}

class overloading {
    public void add (int num1, int num2) {
        System.out.println(num1+num2);
    }

    public void add(int num1, int num2, int num3) {
        System.out.println(num1+num2+num3);
    }
}