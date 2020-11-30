import java.util.*;

public class Employee {
    String e_name;
    int e_id;
    float e_salary;
    static int n;
    static Vector<Employee> v;

    public static void sort()
    {
        Employee e = new Employee();
        for(int i=0;i<v.size();i++)
        {
            for(int j=0;j<v.size()-1-i;j++)
            {
                if(v.get(j).e_salary<v.get(j+1).e_salary)
                {
                    e = v.get(j);
                    v.set(j,v.get(j+1));
                    v.set(j+1,e);
                }
            }
        }
    }

    public static void display()
    {
        Enumeration<Employee> en = v.elements();
        while(en.hasMoreElements())
        {
            Employee e = en.nextElement();
            System.out.println("Name: "+ e.e_name + "\tId: "+ e.e_id +   "\tSalary: "+ e.e_salary);
        }
    }

    public static void create(int n)
    {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++)
        {
            Employee e = new Employee();
            System.out.println("Enter the employee's name:");
            e.e_name = sc.next();
            System.out.println("Enter the employee's id:");
            e.e_id = sc.nextInt();
            for(int j=0;j<v.size();j++)
            {
                while(e.e_id==v.get(j).e_id)
                {
                    System.out.println("This employee id already exists, please enter a valid id");
                    System.out.println("Enter the employee's id: ");
                    e.e_id = sc.nextInt();
                    j=0;
                }
            }
            System.out.println("Enter the employee's salary: ");
            e.e_salary = sc.nextFloat();
            v.add(e);
        }
        sort();
    }

    public static void insert()
    {
        Scanner sc = new Scanner(System.in);
        Employee e = new Employee();
        System.out.println("Enter the employee's name: ");
        e.e_name = sc.next();
        System.out.println("Enter the employee's id: ");
        e.e_id = sc.nextInt();
        for(int j=0;j<v.size();j++)
        {
            while(e.e_id==v.get(j).e_id)
            {
                System.out.println("This employee id already exists, please enter a valid id");
                System.out.println("Enter the employee's id: ");
                e.e_id = sc.nextInt();
                j=0;
            }
        }
        System.out.println("Enter the employee's salary: ");
        e.e_salary = sc.nextFloat();
        for(int i=0;i<v.size();i++)
        {
            if(e.e_salary>v.get(i).e_salary)

            {
                v.insertElementAt(e,i);
                break;
            }
        }
        display();
    }

    public static void delete()
    {
        Scanner sc = new Scanner(System.in);
        String name;
        int c,id;
        boolean b=false;
        System.out.println("Delete by:-\n\t1)ID\n\t2)Name");
        c = sc.nextInt();
        switch(c)
        {
            case 1:
                System.out.println("Enter id to be deleted:");
                id = sc.nextInt();
                for(Employee e:v)
                {
                    if(e.e_id==id)
                    {
                        b = v.remove(e);
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Enter name to be deleted:");
                name = sc.next();
                for(Employee e:v)
                {
                    if(e.e_name.equals(name))
                    {
                        b = v.remove(e);
                        break;
                    }
                }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        if(b==true)
            System.out.println("Employee details deleted successfully");
        else
            System.out.println("Employee not found");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of employees");
        n = s.nextInt();
        v = new Vector<Employee>(n);
        create(n);
        while(true)
        {
            System.out.println("\n\t1) Insert");
            System.out.println("\t2) Delete");
            System.out.println("\t3) Display");
            System.out.println("\t4) Exit");
            int x = s.nextInt();
            switch(x)
            {
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
