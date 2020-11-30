import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
import java.util.Comparator;
public class shopping {
 public static void main(String[] args) {
 Scanner sc=new Scanner(System.in);
 Vector<Shopping> shop=new Vector<Shopping>();
 int c=0,c1=0;
 String temp;
 for(int i=0;i<Integer.parseInt(args[0]);i++){
 Shopping s1=new Shopping(args[c1+1],Integer.parseInt(args[c1+2]),
Double.parseDouble(args[c1+3]), Integer.parseInt(args[c1+4]));
 c1+=4;
 shop.add(s1);
 }
 while(c!=6)
 { 
    System.out.print("\n1. Delete an item\n2. Add item at end\n3. Add
    item at specific position\n4. Sort the list\n5. Print the shopping
    list\n6. Exit\nEnter a choice: ");
     c=sc.nextInt();
     switch(c)
     {
     case 1:
     System.out.print("Enter id to remove: ");
     int id=sc.nextInt();
     for(int i=0;i<shop.size();i++){
     Shopping s=shop.get(i);
     if(id==s.id)
     shop.removeElement(s);
     }
     break;
    
     case 2:
     System.out.print("Enter item, item ID, cost and quantity to add:
    ");
     temp=sc.next();
     int id=sc.nextInt();
     double cost=sc.nextDouble();
     int quantity=sc.nextInt();
     Shopping s=new Shopping(temp, id, cost, quantity);
     shop.addElement(s);
     break;
     case 3:
     System.out.print("Enter item, item ID, cost, quantity and
    location to add: ");
     temp=sc.next();
     id=sc.nextInt();
     cost=sc.nextDouble();
     quantity=sc.nextInt();
     int pos=sc.nextInt();
     Shopping sh=new Shopping(temp, id, cost, quantity);
     shop.add(pos-1,sh);
     break;
     case 4:
     sort(shop);
     break;
    
     case 5: 
     display(shop);
     break;
     }
     }
     sc.close();
     }
     public static void sort(Vector<Shopping> shop){
     Comparator<Shopping> comparator=(Comparator<Shopping>) new Sorter();
     Collections.sort(shop, comparator);
     display(shop);
     }
     public static void display(Vector<Shopping> shop){
     for(int i=0;i<shop.size();i++){
     Shopping s=shop.get(i);
     System.out.println("Name: "+s.name+"\nID: "+(int)s.id+"\nPrice:
    "+(double)s.cost+"\nQuantity: "+(int)s.count);
     }
     }
    } 
    public class Shopping {
        String name;
        int id;
        double cost;
        int count;
        Shopping(String name, int id, double cost,int count){
        this.name=name;
        this.id=id;
        this.cost=cost;
        this.count=count;
        }
       } 
           