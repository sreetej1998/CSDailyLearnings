package striverlist.day1;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] a = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix = setZeros(a);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] setZeros(int[][] matrix) {
        boolean isColZero = false;

        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                if( i == 0) {
                    isColZero = true;
                }
                matrix[0][0] = 0;
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                isColZero = true;
            }
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        if(matrix[0][0] == 0) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(isColZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
