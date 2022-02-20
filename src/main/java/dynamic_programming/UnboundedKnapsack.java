package dynamic_programming;
/*
Given two integer arrays to represent weights and profits of ‘N’ items,
we need to find a subset of these items which will give us maximum profit
such that their cumulative weight is not more than a given number ‘C’.
We can assume an infinite supply of item quantities; therefore, each
item can be selected multiple times.
 */
public class UnboundedKnapsack {
    public static int dp[][] = new int[1000][1000];
    public static void main(String[] args) {
        for(int i = 0; i< 1000; i++) {
            for(int j = 0; j< 1000; j++) {
                dp[i][j] = -1;
            }
        }
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int capacity = 8;
        System.out.println(unboundedKnapsack(weights, profits, 0, capacity));
        System.out.println(unboundedKnapsackTopDown(weights, profits, 0, capacity));
    }

    public static int unboundedKnapsack(int weights[], int profits[], int i, int capacity) {
        int incInclude=0;
        if(capacity<=0 || i == weights.length || weights.length !=profits.length) {
            return 0;
        }
        if(capacity >= weights[i]) {
            incInclude = profits[i] + unboundedKnapsack(weights, profits, i, capacity - weights[i]);
        }

        int incDontInclude = unboundedKnapsack(weights, profits, i+1, capacity);
        return Math.max(incDontInclude, incInclude);
    }

    public static int unboundedKnapsackTopDown(int weights[], int profits[], int i, int capacity) {
        int incInclude=0;
        if(capacity<=0 || i == weights.length || weights.length !=profits.length) {
            return 0;
        }
        if(dp[i][capacity]!=-1) {
            return dp[i][capacity];
        }
        if(capacity >= weights[i]) {
            incInclude = profits[i] + unboundedKnapsack(weights, profits, i, capacity - weights[i]);
            dp[i][capacity-weights[i]] = incInclude;
        }

        int incDontInclude = unboundedKnapsack(weights, profits, i+1, capacity);
        dp[i+1][capacity] = incDontInclude;
        return Math.max(incDontInclude, incInclude);
    }


}
