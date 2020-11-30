interface test {
int square();
}

class arithmetic implements test {
    int b;
    arithmetic(int x) {
        b = x;
    }

    public int square() {
        return (b*b);
    }
}

public class ToTestInt {

    public int ret(int x) {
        arithmetic a=new arithmetic(x);
        return a.square();
    }

    public static void main(String []args) {
        ToTestInt x= new ToTestInt();
        System.out.println("The square of 13 is "+x.ret(13));
    }
}





