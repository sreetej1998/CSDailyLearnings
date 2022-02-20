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

        System.out.println(minCoinsRequired(denominations, 0, 0, sum,0 ));
        System.out.println(minCoinsRequiredTopDown(denominations, 0, 0, sum,0 ));
    }

    public static int minCoinsRequired(int den[], int i, int currSum, int sum, int count) {
        if(currSum == sum) {
            return count - 1;
        }
        if(i == den.length || currSum > sum) {
            return Integer.MAX_VALUE;
        }
        int dontIncInclude = minCoinsRequired(den, i, currSum + den[i], sum, count+1);
        int incInclude = minCoinsRequired(den, i+1, currSum + den[i], sum, count+1);
        int incExclude = minCoinsRequired(den, i+1, currSum, sum, count+1);

        return Math.min(dontIncInclude, Math.min(incExclude, incInclude));
    }

    public static int minCoinsRequiredTopDown(int den[], int i, int currSum, int sum, int count) {
        if(currSum == sum) {
            return count - 1;
        }
        if(i == den.length || currSum > sum) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][currSum]!=-1) {
            return dp[i][currSum];
        }

        int dontIncInclude = minCoinsRequired(den, i, currSum + den[i], sum, count+1);
        dp[i][currSum + den[i]] = dontIncInclude;
        int incInclude = minCoinsRequired(den, i+1, currSum + den[i], sum, count+1);
        dp[i+1][currSum + den[i]] = incInclude;
        int incExclude = minCoinsRequired(den, i+1, currSum, sum, count+1);
        dp[i+1][den[i]] = incExclude;

        return Math.min(dontIncInclude, Math.min(incExclude, incInclude));
    }
}
