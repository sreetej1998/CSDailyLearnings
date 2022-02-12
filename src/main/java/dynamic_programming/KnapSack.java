package dynamic_programming;

//Educational problem statement
/*
You are a thief and you will enter a house
You have a bag of capacity C
The house has n objects of weight w[i] and their cost in cost[i]
Your objective is to steal objects which satisfy your bag capacity and gain maximum profit.
*/

public class KnapSack {
    static int dp[][] = new int[999][999];
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        System.out.println(knapSack(W, val, wt, 0));
        System.out.println(knapSackTopDown(W, val, wt, 0));
    }
//  The Choice is in weather we choose to keep the element in our bag or not
    public static int knapSack(int cap, int cost[], int weight[], int i) {
        if(i >= cost.length) {
            return 0;
        }
        int include = 0;
        if(cap >= weight[i]) {
            include = cost[i] + knapSack(cap - weight[i], cost, weight, i + 1);
        }
        int dontInclude = knapSack(cap, cost, weight, i+1);
        return Math.max(include, dontInclude);
    }

//    Memoizing the above solution to avoid recomputing the recursive calls(Top Down DP)
    public static int knapSackTopDown(int cap, int cost[], int weight[], int i) {
        if(i >= cost.length) {
            return 0;
        }
        int include = 0;
        if(cap >= weight[i]) {
            if(dp[cap - weight[i]][i+1]!=0) {
                include = dp[cap - weight[i]][i+1];
            } else {
                include = cost[i] + knapSack(cap - weight[i], cost, weight, i + 1);
                dp[cap - weight[i]][i + 1] = include;
            }
        }
        int dontInclude;
        if(dp[cap][i+1]!=0) {
            dontInclude = dp[cap][i+1];
        } else {
            dontInclude = knapSack(cap, cost, weight, i+1);
            dp[cap][i+1] = dontInclude;
        }
        return Math.max(include, dontInclude);
    }

    public static int knapSackBottomUp(int cap, int cost[], int weight[]) {
        int dp[][] = new int[999][999];
        for(int i = cost.length - 1; i >= 0; i--) {
            for(int j = cost.length - 1; j >= 0; j--) {
                if( i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.max(dp[cap][i + 1], cost[i] + dp[cap - weight[i]][i + 1]);
                }
            }
        }
        return dp[cap][0];
    }


}
