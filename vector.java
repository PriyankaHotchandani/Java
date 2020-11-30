import java.util.Vector;
import java.util.Scanner;

class Employee {
    int E_id;
    String E_name;
    double E_salary;
    Employee (int id, String n, double sal)
    {
        E_id=id;
        E_name=n;
        E_salary=sal;
    }
} 

public class vector {
    public static void main(String[] args) {
        Vector<Employee> v = new Vector<Employee>();
        Scanner s1 = new Scanner(System.in);
        int choice=0;
        int start=0;
        int count=0;
        int _id, _sal;
        String _name;

        while (choice != 6 ) {
            System.out.println("1. Accept employee records");
            System.out.println("2. Insert a given employee record");
            System.out.println("3. Display account details");
            System.out.println("4. Delete record by name");
            System.out.println("5. Delete record by Id");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = s1.nextInt();

            switch(choice){

                case 1:
                    System.out.println("Enter the number of accounts you want to add");
                    int m =s1.nextInt();
                    for(int i=0;i<m;i++){
                        System.out.println("Enter your account ID: ");
                        _id = s1.nextInt();
                        System.out.println("Enter your name: ");
                        _name = s1.next();
                        System.out.println("Enter your balance: ");
                        _sal = s1.nextInt();
                        Employee acc_1 = new Employee(_id, _name, _sal);
                        v.add(acc_1);
                    }
                    break;

                case 2:

                    break;

                case 3:
                    if(v.size() == 0){
                        System.out.println("No Accounts have been found");
                    }
                    else{
                        for(int i = 0;i<v.size();i++){
                            System.out.println("The account no of employee number "+ (i+1) +" is " + v.get(i).E_id + "\nName is "+ v.get(i).E_name +"\nBalance is " + v.get(i).E_salary);
                        }
                    }
                    break;

                case 4:

                    break;    
                
                case 5:
                    System.out.println("Enter the id of the account you want to delete: ");
                    int del_id = s1.nextInt();
                    int ind;
                    boolean flag = v.removeElement(del_id);
                    if  (flag)
                    {
                        ind=v.indexOf(del_id);
                    }
                    else 
                    {
                        System.out.println("Id doesn't exist");
                    }
                    v.remove(ind);
                    break;
                
               

                default:
                    System.out.println("Please enter a valid option");


            }
        }
    }
}
