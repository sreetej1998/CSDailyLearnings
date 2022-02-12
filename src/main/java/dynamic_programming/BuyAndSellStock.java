package dynamic_programming;

public class BuyAndSellStock {
    static int[] prices = {7,1,5,3,6,4};
    static int dp[][] = new int[100][100];

    public static void main(String[] args) {
        System.out.println(maxProfit(0, 0));
        System.out.println(bottomUpMaxProfit());
    }

//    Top down memoize approach any transactions
    static int maxProfit(int i, int own) {
        if( i>= prices.length) return 0;
        if(dp[i][own] != 0) return dp[i][own];
        if(own == 1) {
            int sell = maxProfit(i+1, 0) + prices[i];
            int dontSell = maxProfit(i+1, 1);
            int max = Math.max(sell, dontSell);
            dp[i][own] = max;
            return max;
        } else {
            int buy = maxProfit(i+1, 1) - prices[i];
            int dontBuy = maxProfit(i+1, 0);
            int max = Math.max(buy, dontBuy);
            dp[i][own] = max;
            return max;
        }
    }

//    Bottom up approach any transactions
    static int bottomUpMaxProfit() {
        for(int i = prices.length - 1; i >= 0; i--) {
            if( i == prices.length - 1) {
                dp[i][0] = 0;
                dp[i][1] = prices[i];
            }
            dp[i][0] = Math.max(dp[i+1][1] - prices[i], dp[i+1][0]);
            dp[i][1] = Math.max(dp[i+1][0] + prices[i], dp[i+1][1]);
        }
        return dp[0][0];
    }
}



