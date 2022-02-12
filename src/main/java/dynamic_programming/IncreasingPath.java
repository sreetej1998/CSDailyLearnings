package dynamic_programming;

/*

Problem Description

Given a 2D integer matrix A of size N x M.

From A[i][j] you can move to A[i+1][j], if A[i+1][j] > A[i][j], or can move to A[i][j+1] if A[i][j+1] > A[i][j].

The task is to find and output the longest path length if we start from (0, 0).

NOTE:

If there doesn't exist a path return -1.
 */
public class IncreasingPath {
    static int dp[][] = new int[100][100];
    public static void main(String[] args) {
        for(int i=0; i<99;i++) {
            for( int j=0; j< 99; j++) {
                dp[i][j] = -1;
            }
        }

        int[][] a = { { 1, 2 }, { 3, 4 } };
        int [][] b={{1, 2, 3, 4}, {2, 2, 3, 4}, {3, 2, 3, 4}, {4, 5, 6, 7}};
        System.out.println(1 + path(b, 0, 0));
        System.out.println(pathBottomUp(b));
        System.out.println(1 + pathTopDown(b, 0, 0));
    }

    public static int path(int[][] a, int i, int j) {
        if(i > a.length - 1 || j > a[0].length - 1) return 0;
        if((i+1 <= a.length - 1 && a[i+1][j] > a[i][j]) && (j+1 <=a[0].length - 1 && a[i][j+1] > a[i][j])) {
            return 1 + Math.max(path(a, i+1, j), path(a, i, j+1));
        }
        else if(i+1 <= a.length - 1 &&  a[i+1][j] > a[i][j]) {
            return 1 + path(a, i+1, j);
        } else if(j+1 <=a[0].length - 1 && a[i][j+1] > a[i][j]) {
            return 1 + path(a, i, j+1);
        } else {
            return 0;
        }
    }

    public static int pathTopDown(int [][]a, int i, int j) {
        if(i > a.length - 1 || j > a[0].length - 1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if((i+1 <= a.length - 1 && a[i+1][j] > a[i][j]) && (j+1 <=a[0].length - 1 && a[i][j+1] > a[i][j])) {
            dp[i][j] =  1 + Math.max(path(a, i+1, j), path(a, i, j+1));
            return dp[i][j];
        }
        else if(i+1 <= a.length - 1 &&  a[i+1][j] > a[i][j]) {
            dp[i][j] = 1 + path(a, i+1, j);
            return dp[i][j];
        } else if(j+1 <=a[0].length - 1 && a[i][j+1] > a[i][j]) {
            dp[i][j]  = 1 + path(a, i, j+1);
            return dp[i][j];
        } else {
            return 0;
        }
    }

    public static int pathBottomUp(int[][] a) {
        int dp[][] = new int[100][100];
        for(int i = a.length - 1; i >= 0; i-- ){
            for(int j = a[0].length - 1; j>=0; j--) {
                if((i+1 <= a.length - 1 && a[i+1][j] > a[i][j]) && (j+1 <=a[0].length - 1 && a[i][j+1] > a[i][j])) {
                    dp[i][j] = 1 + Math.max(dp[i+1][j], dp[i][j+1]);
                } else if( i+1 <= a.length - 1 && a[i+1][j] > a[i][j]) {
                    dp[i][j] = 1 + dp[i+1][j];
                } else if(j+1 <=a[0].length - 1 && a[i][j+1] > a[i][j]) {
                    dp[i][j] = 1 + dp[i][j+1];
                }
            }
        }
        return 1+dp[0][0];
    }
}
