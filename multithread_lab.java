import java.io.*;
import java.util.*;

class Thread_1 extends Thread {
    File f;
    Thread_1(){
        f=new File("Personal_Record.txt");
    }
    
    public void run() {
        try{
            Scanner sc1 = new Scanner(f);
            while (sc1.hasNextLine()){
                System.out.println(sc1.nextLine());
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        }
        catch(Exception e){};
    }
}

class Thread_2 extends Thread {
    File fi;
    Thread_2(){
        fi=new File("Academic_Record.txt");
    }
    
    public void run() {
        try{
            Scanner sc2 = new Scanner(fi);
            while (sc2.hasNextLine()){
                System.out.println(sc2.nextLine());
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        }
        catch(Exception e){};
    }    
}
    
public class multithread_lab {
    public static void main(String[] args) {
        Thread_1 t1=new Thread_1();
        Thread_2 t2=new Thread_2();
        t1.start();
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){}
        t2.start();
    }
}