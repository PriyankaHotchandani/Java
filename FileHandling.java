import java.io.*;
import java.util.*;

public class FileHandling {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of the file:");
        String name=sc.next();
        int ch;
        char in;
        int count=0;
        File f=new File(name+".txt");
        System.out.println("Enter a character:");
        in=sc.next().charAt(0);
        FileReader fr=null;
        try
        {
            fr=new FileReader(f);
        }
        catch(FileNotFoundException e){}
        try
        {
            while((ch=fr.read())!=-1)
            {
                if(Character.toLowerCase((char)ch)==Character.toLowerCase(in))
                {
                    count++;
                }         
            }
            fr.close();
        }
        catch(IOException e){}
        System.out.println("Number of occurences of "+in +" is "+count);
    }
}