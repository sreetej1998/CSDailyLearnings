package dynamic_programming;
/*
Given a rod of length ‘n’, we are asked to cut the rod and sell
the pieces in a way that will maximize the profit. We are also
given the price of every piece of length ‘i’ where ‘1 <= i <= n’.
Example:
Lengths: [1, 2, 3, 4, 5]
Prices: [2, 6, 7, 10, 13]
Rod Length: 5

MaxProfit - 14
 */
public class RodCutting {
    public static int dp[][] = new int[1000][1000];
    public static void main(String[] args) {
        for(int i = 0; i< 1000; i++) {
            for(int j = 0; j< 1000; j++) {
                dp[i][j] = -1;
            }
        }
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int rodLength =5;
        System.out.println(rodCutting(prices, lengths, rodLength, 0));
        System.out.println(rodCuttingTopDown(prices, lengths, rodLength, 0));
    }

    public static int rodCutting(int prices[], int lengths[], int rodLength, int i) {
        if(i>=prices.length) {
            return 0;
        }
        int sell = 0, sellDontInc = 0;
        if(rodLength >= lengths[i]) {
            sell = prices[i] + rodCutting(prices, lengths, rodLength - lengths[i], i+1);
        }
        if(rodLength >= lengths[i]) {
            sellDontInc = prices[i] + rodCutting(prices, lengths, rodLength - lengths[i], i);
        }
        int dontSell = rodCutting(prices, lengths, rodLength, i+1);
        return Math.max(sell, Math.max(dontSell, sellDontInc));
    }

    public static int rodCuttingTopDown(int prices[], int lengths[], int rodLength, int i) {
        if(i>=prices.length) {
            return 0;
        }
        int sell = 0, sellDontInc = 0;
        if(dp[i][rodLength]!=-1) {
            return dp[i][rodLength];
        }

        if(rodLength >= lengths[i]) {
            sell = prices[i] + rodCutting(prices, lengths, rodLength - lengths[i], i+1);
            dp[i+1][rodLength - lengths[i]] = sell;
        }
        if(rodLength >= lengths[i]) {
            sellDontInc = prices[i] + rodCutting(prices, lengths, rodLength - lengths[i], i);
            dp[i][rodLength - lengths[i]] = sellDontInc;
        }
        int dontSell = rodCutting(prices, lengths, rodLength, i+1);
        dp[i+1][rodLength] = dontSell;
        return Math.max(dp[i+1][rodLength - lengths[i]], Math.max(dp[i][rodLength - lengths[i]] , dp[i+1][rodLength]));
    }
}
