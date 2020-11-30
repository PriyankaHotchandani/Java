import java.util.*;
public class fifo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=3;
        int j=-1, elem, hit=0;
        int arr[]=new int[]{-1,-1,-1};
        System.out.print("Enter number of elements you want to enter: ");
        int n=sc.nextInt();
        for(int i=0;i<n; i++){
            System.out.print("\nEnter number "+(i+1)+": ");
            elem=sc.nextInt();
            boolean result=search(elem, arr);
            if(result){
                System.out.print("\nStack unchanged: ");
                print(arr);
                hit++;
            }
            else{
                arr[(j+1)%len]=elem;
                System.out.print("\nCurrent stack: ");
                print(arr);
                j++;
            }
            if(i==n-1){
                System.out.println("\nPage-Hit: "+hit);
            }
        }
        sc.close();
    }
    
    static boolean search(int elem, int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==elem){
                return true;
            }
        }
        return false;
    }

    static void print(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
} 