public class sum_forEachLoop {
    public static void main(String[] args) {
        int sum=0;
        int arr[] = {5, 7, 14, 56};

        for(int x:arr) {
            sum=sum+x;
        }
        System.out.println(sum);
    }
}