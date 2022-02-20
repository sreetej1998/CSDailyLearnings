package dynamic_programming;
/*
Input: {1, 2, 7, 1, 5}, S=9
Output: 3
The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
 */
public class CountOfSubsetSum {
    static int dp[][] = new int[1000][1000];
    public static void main(String[] args) {
        for(int i = 0; i< 1000; i++) {
            for(int j = 0; j< 1000; j++) {
                dp[i][j] = -1;
            }
        }
        int input[] = new int[]{1, 2, 7, 1, 5};
        int sum = 9;
        System.out.println(countSubSetSum(input, 0, sum, 0));
        System.out.println(countSubSetSumTopDown(input, 0, sum, 0));
    }

    public static int countSubSetSum(int input[], int i, int sum, int currSum) {
        if(currSum == sum) {
            return 1;
        }
        if(i == input.length) {
            return 0;
        }
        int include = countSubSetSum(input, i+1, sum, currSum + input[i]);
        int dontInclude = countSubSetSum(input, i+1, sum, currSum);
        return include + dontInclude;
    }

    public static int countSubSetSumTopDown(int input[], int i, int sum, int currSum) {
        if(currSum == sum) {
            return 1;
        }
        if(i == input.length) {
            return 0;
        }
        if(dp[i][currSum] !=-1) {
            return dp[i][currSum];
        }
        int include = countSubSetSum(input, i+1, sum, currSum + input[i]);
        dp[i+1][currSum + input[i]] = include;
        int dontInclude = countSubSetSum(input, i+1, sum, currSum);
        dp[i+1][currSum] = dontInclude;
        return  dp[i+1][currSum + input[i]] + dp[i+1][currSum];
    }
}
