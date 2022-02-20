package dynamic_programming;
/*
Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the minimum number of coins needed to make up that amount.
 */
public class MinimumCoinChange {
    static int dp[][] = new int[1000][1000];
    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        for(int i = 0; i< 1000; i++) {
            for(int j = 0; j< 1000; j++) {
                dp[i][j] = -1;
            }
        }
        int sum = 5;

        System.out.println(minCoinsRequired(denominations, 0, sum ));
        System.out.println(minCoinsRequiredTopDown(denominations, 0, sum));
    }

    public static int minCoinsRequired(int den[], int i, int sum) {
        if( sum==0) {
            return 0;
        }
        if(i == den.length) {
            return Integer.MAX_VALUE;
        }
        int dontIncInclude = Integer.MAX_VALUE;
        if(sum - den[i] >=0) {
             dontIncInclude = minCoinsRequired(den, i, sum - den[i]);
            if (dontIncInclude != Integer.MAX_VALUE) {
                dontIncInclude += 1;
            }
        }
        int incInclude = minCoinsRequired(den, i+1, sum);

        return Math.min(dontIncInclude, incInclude);
    }
    public static int minCoinsRequiredTopDown(int den[], int i, int sum) {
        if( sum==0) {
            return 0;
        }
        if(i == den.length) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][sum]!=-1) {
            return dp[i][sum];
        }
        int dontIncInclude = Integer.MAX_VALUE;
        if(sum - den[i] >=0) {
            dontIncInclude = minCoinsRequiredTopDown(den, i, sum - den[i]);
            if (dontIncInclude != Integer.MAX_VALUE) {
                dontIncInclude += 1;
            }
            dp[i][sum-den[i]] = dontIncInclude;
        }
        int incInclude = minCoinsRequiredTopDown(den, i+1, sum);
        dp[i+1][sum] = incInclude;

        return Math.min(dontIncInclude, incInclude);
    }
}
