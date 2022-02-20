package dynamic_programming;
/*
Input: {1, 2, 3, 9}
Output: 3
Explanation: We can partition the given set into two subsets where the minimum absolute difference 
between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
*/
public class MinimumSubsetDifference {
    public static int dp[][] = new int[1000][1000];
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 9};
        System.out.println(minimumSubSetDifference(num, 0, 0, 0));
        System.out.println(minimumSubSetDifferenceTopDown(num, 0,0,0));
    }

    public static int minimumSubSetDifference(int input[], int sum1, int sum2, int i) {
        if(i == input.length) {
            return Math.abs(sum1 - sum2);
        }
        int diff1 = minimumSubSetDifference(input, sum1 + input[i], sum2, i+1);
        int diff2 = minimumSubSetDifference(input, sum1, sum2 + input[i], i+1);
        return Math.min(diff1, diff2);
    }


    public static int minimumSubSetDifferenceTopDown(int input[], int sum1, int sum2, int i) {
        if(i == input.length) {
            return Math.abs(sum1 - sum2);
        }
        if(dp[i][sum1]!=0) {
            return dp[i][sum1];
        }
        int diff1 = minimumSubSetDifferenceTopDown(input, sum1 + input[i], sum2, i+1);
        int diff2 = minimumSubSetDifferenceTopDown(input, sum1, sum2 + input[i], i+1);
        dp[i][sum1] = Math.min(diff1, diff2);
        return dp[i][sum1];
    }

}
