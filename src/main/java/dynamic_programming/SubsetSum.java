package dynamic_programming;

/*
Input: {1, 2, 3, 7}, S=6
Output: True
The given set has a subset whose sum is '6': {1, 2, 3}
 */
public class SubsetSum {
    public static void main(String[] args) {
        int input[] = new int[]{1, 2, 7, 1, 5};
        int sum = 10;
        System.out.println(subsetSum(sum, input, 0, 0));
        System.out.println(subsetSumTopDown(sum, input, 0, 0, new int[1000][1000]));

    }

    public static boolean subsetSum(int sum, int input[], int i, int currSum) {
        if(currSum == sum) {
            return true;
        }
        if(i >= input.length || input.length == 0) {
            return false;
        }
        boolean include = subsetSum(sum, input, i+1, currSum + input[i]);
        boolean dontInclude = subsetSum(sum, input, i+1, currSum);
        return include || dontInclude;
    }

    public static boolean subsetSumTopDown(int sum, int input[], int i, int currSum, int dp[][]) {
        if(currSum == sum) {
            return true;
        }
        if(i >= input.length || input.length == 0) {
            return false;
        }
        if(dp[i+1][currSum]!=0) {
            return dp[i+1][currSum] == 1;
        }
        boolean include = subsetSum(sum, input, i+1, currSum + input[i]);
        dp[i+1][currSum + input[i]] = include ? 1: -1;
        boolean dontInclude = subsetSum(sum, input, i+1, currSum);
        dp[i+1][currSum] = include ? 1: -1;
        return include || dontInclude;
    }
}
