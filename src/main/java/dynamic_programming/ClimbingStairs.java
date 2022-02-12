package dynamic_programming;

public class ClimbingStairs {
    static int dp[] = new int[100];
    public static void main(String[] args) {
        System.out.println(climbingStairs(5));
        System.out.println(climbBottomUp(5));
    }

//    Top Down approach memoization
    static int climbingStairs(int n) {

        if( n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        } else {
            if(dp[n]!=0) {
                return dp[n];
            }
            dp[n] = climbingStairs(n-1) + climbingStairs(n-2);
            return dp[n];
        }
    }

    static int climbBottomUp(int n) {
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<= n; i++) {
            dp[i] = dp[i-2] +dp[i-1];
        }
        return dp[n];
    }
}
