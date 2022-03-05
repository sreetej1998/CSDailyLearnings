package striverlist.day2;

public class RotateMatrix {
//    TODO: Rotate Groups of Four Cells Approach
    public static void main(String[] args) {
        int[][] matrix= new int[][] {
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(rotate90(matrix));
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] rotate90(int [][] matrix ) {
        transpose(matrix);
        reverseRowsInMatrix(matrix);
        return matrix;
    }

    public static void transpose(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i+1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverseRowsInMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            int l = 0;
            int r = matrix[i].length - 1;
            while(l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l+=1;
                r-=1;
            }
        }
    }
}
