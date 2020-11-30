import java.util.Vector;
public class vectorAssignment2 {
    public static void main(String[] args) {
        Vector<Integer> v1 = new Vector<Integer>();

        v1.add(1);
        v1.add(2);
        v1.add(3);
        v1.add(4);
        v1.add(5);
        v1.add(6);
        v1.add(7);
        v1.add(8);

        System.out.println("Size: "+v1.size());
        System.out.println("Capacity: "+v1.capacity());
        System.out.println("Elements: "+v1);
        
        v1.remove(0);

        System.out.println("After deleting first occurence:");
        System.out.println("Elements: "+v1);

        v1.remove(4);
        System.out.println("After removing element at index 4:");
        System.out.println("Elements: "+v1);

        System.out.println("Element at index 5:"+v1.get(5));

        System.out.println("Is the vector empty? "+v1.isEmpty());
        
        System.out.println("Hash Code of the vector is:"+v1.hashCode());
    
    }
}