public class program1 {
    String name;
    int age;
    int rollNo;
    public static void main(String[] args){
        program1 student_class = new program1();
        student_class.name = "Priyanka Hotchandani";
        student_class.age = 18;
        student_class.rollNo = 1911106;
        System.out.println("Name:"+student_class.name);
        System.out.println("Age:"+student_class.age);
        System.out.println("Roll No.:"+student_class.rollNo);
    }
}