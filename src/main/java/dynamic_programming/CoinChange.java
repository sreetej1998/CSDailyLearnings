package dynamic_programming;

public class CoinChange {
    public static void main(String[] args) {
        int arr[] = {1,2,5};
        System.out.println( coinChange(arr, 0, 11, 0));
    }

    public static int coinChange(int price[], int i, int maxAmount, int amount) {
        if(i >= price.length) {
            return Integer.MAX_VALUE;
        }
        if(amount == maxAmount) {
            return 0;
        }
        if(amount > maxAmount) {
            return Integer.MAX_VALUE;
        }
        int include = coinChange(price, i, maxAmount, price[i] + amount);
        if(include != Integer.MAX_VALUE) {
            include = 1 + include;
        }
        int notInclude = coinChange(price, i+1, maxAmount, amount);
        return Math.min(include, notInclude);
    }

//    public static int coinChangeDP(int price[], int i, int maxAmount, int amount) {
//        if(i == price.length ) {
//            return Integer.MAX_VALUE;
//        }
//        if(amount == maxAmount) {
//            return 1;
//        }
//        if(amount > maxAmount) {
//            return 0;
//        }
//        int include = 1 + coinChange(price, i, maxAmount, price[i] + amount);
//        int notInclude = coinChange(price, i+1, maxAmount, amount);
//        return Math.min(include, notInclude);
//    }
}
