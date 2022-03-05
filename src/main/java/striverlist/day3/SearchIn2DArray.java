package striverlist.day3;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(search(arr, 3));

    }

    public static boolean search(int[][] matrix,int target) {
        int l = 0, r = matrix.length * matrix[0].length - 1;

        while(l <= r) {
            int mid = (l + r)/2;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;
            if(matrix[i][j] == target) {
                return true;
            } else if(target > matrix[i][j]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return false;
    }
}
