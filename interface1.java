import java.util.*;

interface area {
    void rectangle();
    void circle();
}

public class interface1 implements area {

    public void rectangle() {
        int l, b;
        double a;
        l=5;
        b=7;
        a = l*b;
        System.out.println("Area of the rectangle is "+a);
    }
    
    public void circle() {
        int r;
        double ar, pi=3.14;
        r=5;
        ar = pi*r*r;
        System.out.println("Area of the circle is "+ar);
    }

    public static void main(String[] args) {
        area obj = new interface1();
        obj.rectangle();
        obj.circle();
    }
}
