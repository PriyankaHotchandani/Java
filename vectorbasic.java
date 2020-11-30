import java.util.Vector;
public class vectorbasic {
    public static void main(String[] args) {
        Vector<String> v1 = new Vector<String>();

        v1.add("Apple");
        v1.add("Orange");
        v1.add("Kiwi");
        v1.add("Banana");
        v1.add("Fig");

        System.out.println("Size: "+v1.size());
        System.out.println("Capacity: "+v1.capacity());
        System.out.println("Elements: "+v1);
        
        v1.add("Grape");
        v1.add("Pineapple");
        v1.add("Berry");

        System.out.println("After Increment:");
        System.out.println("Size: "+v1.size());
        System.out.println("Capacity: "+v1.capacity());
        System.out.println("Elements: "+v1);

    }
}
