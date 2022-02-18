package dynamic_programming;

import java.util.Arrays;

/*
Input: {1, 2, 3, 4}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}

HINT: equivalent to = find if there are a group of elements with sum s/2 were s = sum of all ele in arr
 */
public class EqualSubsetSumPartition {
    static int dp[][] = new int[1000][1000];
    public static void main(String[] args) {
        int input[] = {1, 1, 3, 4, 7};
        for(int i = 0; i <1000; i++) {
            for(int j =0; j< 1000; j++) {
                dp[i][j] = -1;
            }
        }
        int totalSum = Arrays.stream(input).sum();
        System.out.println(equalSubsetSumPartition(0, input, 0, totalSum));
        System.out.println(equalSubsetSumPartitionTopDown(0, input, 0, totalSum));
    }
//Recursion
    public static boolean equalSubsetSumPartition(int i, int input[], int currSum, int totalSum) {
        // base check
        if (totalSum == 0 || input.length == 0) {
            return true;
        }
        if(totalSum%2 == 0 && currSum == totalSum/2) {
            return true;
        }
        if(i >= input.length){
            return false;
        }
        boolean include = equalSubsetSumPartition(i+1, input, currSum+input[i], totalSum);
        boolean dontInclude = equalSubsetSumPartition(i+1, input, currSum, totalSum);
        return include || dontInclude;
    }
// TopDown
    public static boolean equalSubsetSumPartitionTopDown(int i, int input[], int currSum, int totalSum) {
        if(totalSum%2 == 0 && currSum == totalSum/2) {
            return true;
        }
        if(i >= input.length){
            return false;
        }
        if(dp[i][currSum]!=-1) {
            return dp[i][currSum] == 1;
        }
        boolean include = equalSubsetSumPartition(i+1, input, currSum+input[i], totalSum);
        dp[i+1][currSum + input[i]] = include ? 1 : 0;
        boolean dontInclude = equalSubsetSumPartition(i+1, input, currSum, totalSum);
        dp[i+1][currSum] = include ? 1 : 0;
        return include || dontInclude;
    }


}
