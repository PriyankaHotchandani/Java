public class minvalue_array {
    public static void main(String[] args) {
        int array[] = {10, 12, 8, 9};
        int min = getMin(array);
        System.out.println("Minimum value is "+min);
    }

    public static int getMin(int[] num) {
        int minValue = num[0];
        for(int i=1; i<num.length; i++){
            if(num[i]<minValue){
                minValue = num[i];
            }
        }
        return minValue;
    }
}

