package striverlist.day3;

public class UniqPaths {
    public static void main(String[] args) {
        int m=3, n=7;
        int dp[][] = new int[m+1][n+1];
        System.out.println( countPaths(0,0, m,n, dp));
    }

    public static int countPaths(int i, int j, int m, int n, int[][] dp) {

        if(i>=m || j >=n) {
            return 0;
        }
        if(i == m-1 && j == n-1) {
            return 1;
        }
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        dp[i+1][j] = countPaths(i+1, j, m, n, dp);
        dp[i][j+1] = countPaths(i,j+1, m, n, dp);
        dp[i][j] = dp[i+1][j] + dp[i][j+1];
        return dp[i][j];
    }
}
