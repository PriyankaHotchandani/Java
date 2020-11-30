public class matrixTranpose {
    public static void main(String[] args) {
        int a[][] = {{1,4,5}, {2,6,3}, {8,9,7}};
        int b[][] = new int[3][3];
        System.out.println("Given matrix: ");

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Matrix after tranpose: ");

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                b[i][j] = 0;
                for (int k=0;k<3;k++){
                    b[i][j]=a[j][i];
                }
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }
}