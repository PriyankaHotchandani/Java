import java.util.Scanner;

class Student {
    int stud_id;
    String name;
    double avg_marks;
    Student (int s_id, String n, double avg)
    {
        stud_id=s_id;
        name=n;
        avg_marks=avg;
    }
} 

public class problemstatement {
    public static void main(String[] args) {
        int n, i, choice, len, p, pos;
        String r;
        double marks;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter total no. of students:");
        n=s1.nextInt(); 
        
        Student arr[][]=new Student[n];

        while(true)
        {
            System.out.println("Options are:");
            System.out.println("1. Add student");
            System.out.println("2. Delete a student:");
            System.out.println("3. Display student details");
            System.out.println("Enter your option:");
            choice=s1.nextInt();

            switch(choice)
            {
                case 1:
                System.out.println("Enter no. of student records to be added:");
                len=s1.nextInt();
                for (i=0;i<len;i++)
                {
                    System.out.println("Enter student id:");
                    p=s1.nextInt();
                    System.out.println("Enter name of the student:");
                    r=s1.nextLine();
                    System.out.println("Enter average marks of the student:");
                    marks=s1.nextDouble();
                    arr[i]=new Student(p,r,marks);
                }
                break;

                case 2:
                System.out.println("Enter position of student record to be deleted:");
                pos=s1.nextInt();
                for(int i = pos-1; i<arr.length-1; i++)
                {
                    arr[i]=arr[i+1];
                }
                break;

                case 3:
                System.out.println("Employee details are:");
                for(i=0;i<arr.length;i++)
                {
                    if(arr[i]!=null)
                    {
                        System.out.println("Employee details of "+(i+1)+":" +arr[i].stud_id+"  "+arr[i].name+"  "+arr[i].salary);
                    }
                }
                break;

                default:
                System.out.println("Please enter the correct choice");
                break;
            }
        }
    }
}