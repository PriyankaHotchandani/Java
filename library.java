import java.util.*;
import java.lang.*;
class Catalogue{
  public Vector<Book> books=new Vector<Book>();
  public Vector<Person> customers=new Vector<Person>();
  public Vector<Person> librarian=new Vector<Person>();
}
class Person extends Catalogue{
  String name;
  int age,id;
  protected String email;
  protected String mobile;
  protected String aadhar;
  protected String address;
  Person(String name, int age,String email,String mobile, String aadhar, String address, int id){
    this.name=name;
    this.age=age;
    this.email=email;
    this.mobile=mobile;
    this.aadhar=aadhar;
    this.address=address;
    this.id=id;
  }
  public void display(){
    System.out.println("USER DETAILS: ");
    System.out.println("Name: "+name+"\nAge: "+age+"\nE-mail ID: "+email+"\nMobile Number: "+mobile+"\nAddress: "+address);
  }
}

class Librarian extends Catalogue{
  protected void add_librarian(){
    Person p=new Person("Priyanka Hotchandani", 19, "p.hotchandani@somaiya.edu","8934567890", "Secret", "SP-35, Subroto Park, Dhaula Kuan, New Delhi-110010, India", 1711072);
    librarian.add(p);
    p.display();
  }
  protected String admin_id="123456789";
  protected void search_books(){
    System.out.print("Search a book: ");
    Scanner sc=new Scanner(System.in);
    String book=sc.nextLine();
    int flag=0;
    for(int i=0;i<books.size();i++){
      Book b=books.get(i);
      if(b.title.equals(book))
        {System.out.println("Book found");
        flag=1;}
    }
    if(flag==0)
      System.out.println("Book not found");
    //System.out.println("No such book.");
  }
  protected void add_member(){
    System.out.print("Enter new member details: ");
    Person p=new Person("Priyanka Hotchandani", 19, "p.hotchandani@somaiya.edu","8934567890", "Secret", "SP-35, Subroto Park, Dhaula Kuan, New Delhi-110010, India", 1711072);
    customers.add(p);
    p.display();
  }
  protected void remove_member(){
    System.out.print("Enter Membership ID of member to be deleted: ");
    Scanner sc=new Scanner(System.in);
    int id=sc.nextInt();
    for(int i=0;i<customers.size();i++){
      Person p=customers.get(i);
      if(p.id==id)
        customers.removeElementAt(i);
    }
  }

  protected void check_availability(){
    System.out.print("Enter ISBN number of book whose availability you want  to check: ");
    Scanner sc=new Scanner(System.in);
    String ISBN=sc.next();
    for(int i=0;i<books.size();i++){
      Book b=books.get(i);
      if((b.ISBN).equals(ISBN)){
        System.out.println("Book is available");
        flag=1;
      }
    }if(flag==1)
      System.out.println("No such book in library.");
  }
  protected void add_books(){
    Book b=new Book("title", "ISBN", "author", "pub_house", 465.30, 2018, "edition",1);
    books.add(b);
    System.out.println("Book added.");
  }

  protected void update_edition(){
    Book b;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter title of book: ");
    String title=sc.nextLine();
    int flag=0;
    for(int i=0;i<customers.size();i++){
      b=books.get(i);
      if((b.title).equals(title)){
        System.out.println("Enter new edition: ");
        String edition=sc.nextLine();
        b.edition=edition;
        break;
      }
      else
      System.out.println("No such book in library");
    }
  }
}

class Customer extends Catalogue{
  void enrol(){
    Person p=new Person("Priyanka Hotchandani", 19, "p.hotchandani@somaiya.edu","8934567890", "Secret", "SP-35, Subroto Park, Dhaula Kuan, New Delhi-110010, India", 1711072);
    customers.add(p);
    p.display();
  }
  protected String membership_id;
  protected void search_books(){
    System.out.print("Search a book: ");
    Book b;
    Scanner sc=new Scanner(System.in);
    String book_name=sc.next();
    for(int i=0;i<books.size();i++){
      b=books.get(i);
      if(book_name.equals(b.title)){
        System.out.println("Book present");
        break;
      }
      System.out.println("Not available.");
    }
  }
  protected void issue_books(){
    System.out.print("Do you want to issue this book?(Y/N): ");
    Scanner sc=new Scanner(System.in);
    String choice=sc.next();
    Transaction t=new Transaction();
    t.transact();
  }
  protected void return_books(){
    System.out.print("Enter your membership ID: ");
    Scanner sc=new Scanner(System.in);
    String id=sc.next();
    System.out.print("Enter ISBN number of book you wish to return: ");
    String ISBN=sc.next();
    for(int i=0;i<books.size();i++){
    Book b=books.get(i);
    if((b.ISBN).equals(ISBN)){
      System.out.println("Book returned.");
      }
    }    
  }
}

class Transaction extends Catalogue{
  public void transact(){
    System.out.println("Enter customer details: ");
    System.out.print("Enter name: ");
    Scanner sc=new Scanner(System.in);
    String name=sc.nextLine();
    System.out.print("Enter ID: ");
    int ID=sc.nextInt();
    for(int i=0;i<customers.size();i++){
      Person p=customers.get(i);
      if((p.name).equals(name) && p.id==ID){
        System.out.println("\n1. Credit Card\n2. Debit Card\n3. Net Banking\n4. UPI\n5. Cancel Transaction\n6. Report payment discrepancy\n7. Display Transaction details\n8. Mail transaction details\n9. Generate transaction ID\n0. Exit\nEnter option: ");
        int choice=sc.nextInt();
        while(choice!=0){
          switch(choice){
            case 1:
            System.out.println("Payment received via credit card.");
            break;
            case 2: 
            System.out.println("Payment received via debit card.");
            break;
            case 3: 
            System.out.println("Payment received via net banking.");
            break;
            case 4: 
            System.out.println("Payment received via UPI.");
            break;
            case 5: 
            System.out.println("Transaction cancelled.");
            break;
            case 6: 
            System.out.println("We have received your complain and our team will write back to you shortly.");
            break;
            case 7: 
            System.out.println("Please find the payment details.");
            break;
            case 8: 
            System.out.println("Kindly check your mail. Check spam if not received.");
            break;
            case 9: 
            System.out.println("Here's your transaction ID.");
            break;
            case 0: 
            System.exit(1);

          }
        }
      }
      else
        System.out.println("User not present in our database.");
    }
  } 
}

class Book extends Catalogue{
  String title, ISBN, author, pub_house, edition;
  double price;
  int yop, count;
  Book(){}
  Book(String title, String ISBN, String author, String pub_house, double price, int yop, String edition, int count){
    this.title=title;
    this.ISBN=ISBN;
    this.author=author;
    this.pub_house=pub_house;
    this.price=price;
    this.yop=yop;
    this.edition=edition;
    this.count+=count;
  }
  public void display(){
    System.out.println("BOOK DETAILS: ");
    System.out.println("Title: "+title+"\nISBN: "+ISBN+"\nPublication House: "+pub_house+"\nPrice: "+price+"\nYear of publication: "+yop+"\nEdition: "+edition);
  }
}


class library{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    Customer c=new Customer();
    Librarian lib=new Librarian();
    System.out.print("Welcome to Library Management System!");
    int user=10, choice=10;
    while(user!=0){
      System.out.print("\nWho are you?\n1. Customer\n2. Librarian\n3. Exit\nEnter choice: ");
      user=sc.nextInt();
      switch(user){
        case 1: 
          while(choice!=5){
            System.out.print("\n1. New customer\n2. Search books\n3. Issue books\n4. Return books\nEnter a choice: ");
            choice=sc.nextInt();
            switch(choice){
              case 1: 
              c.enrol();
              System.out.println("Customer added.");
              break;
              case 2:
              c.search_books();
              break;
              case 3:
              c.issue_books();
              break;
              case 4:
              c.return_books();
              break;
            }
          }
          break;
          case 2:
            while(choice!=8){
              System.out.print("1. Add librarian\n2. Search books\n3. Add members\n4. Remove members\n5. Check availability of a book\n6. Add books\n7. Update edition\nEnter choice: ");
            choice=sc.nextInt();
            switch(choice){
              case 1:
              lib.add_librarian();
              break;
              case 2:
              lib.search_books();
              break;
              case 3:
              lib.add_member();
              break;
              case 4:
              lib.remove_member();
              break;
              case 5:
              lib.check_availability();
              break;
              case 6:
              lib.add_books();
              break;
              case 7:
              lib.update_edition();
              break;
              }
            }
        break;
        case 3: 
        System.exit(1);
      }
    }
  }
}
