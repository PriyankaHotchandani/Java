import java.util.*;

public class lru {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=3;
        int elem, hit=0;
        int arr[]=new int[]{-1,-1,-1};
        int priority[]=new int[]{3,3,3}; 
        System.out.print("Enter the number of elements you want to enter: ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter number "+(i+1)+": ");
            elem=sc.nextInt();
            int index=search(elem, arr);
            if(index!=-1){
                System.out.print("\nStack unchanged: ");
                for(int j=0;j<len;j++){
                    if(priority[j]!=3){
                        priority[j]+=1;
                        priority[search(elem,arr)]=1;
                    }   
                }
                hit++;
                print(arr);
            }
            else{
                arr[search(3,priority)]=elem;
                System.out.print("\nCurrent stack: ");
                for(int j=0;j<len;j++){
                    if(priority[j]!=3){
                        priority[j]+=1;
                    }
                }
                priority[search(elem,arr)]=1;
                print(arr);
            }
            if(i==n-1){
                System.out.println("Page-Hit: "+hit);
            }
        }      
        sc.close();
    }

    static int search(int elem, int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==elem){
                return i;
            }
        }
        return -1;
    }

    static void print(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" "); 
            System.out.println();
        }
    }
} 
