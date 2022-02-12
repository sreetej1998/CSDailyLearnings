package dynamic_programming;

public class TargetSum {
    static int dp[][] = new int[100][100];
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        for(int i =0; i < 100; i++) {
            for(int j = 0; j<100;j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(targetSum(arr, 5,0,0 ));
    }

    static int targetSum(int setArr[], int target, int i, int currSum) {
        if(currSum == target) {
            return 1;
        }
        if( i >= setArr.length) return 0;
        if(dp[i+1][currSum + setArr[i]]!=-1 && dp[i+1][currSum]!=-1) {
            return dp[i+1][currSum + setArr[i]] +  dp[i+1][currSum];
        }
        int includeEle = targetSum(setArr, target, i+1, currSum + setArr[i] );
        int dontIncludeEle = targetSum(setArr, target, i+1,currSum );
        dp[i+1][currSum + setArr[i]] = includeEle;
        dp[i+1][currSum] = dontIncludeEle;
        return includeEle + dontIncludeEle;
    }

    static int targetSumBottomUp(int setArr[], int target) {
        for(int i = setArr.length -1; i>=0; i--) {
            for(int j = setArr.length - 1; j >=0; j--) {
                if (i == setArr.length - 1) {
                    dp[i][target] = 1;
                }
            }

        }

        return 0;
    }
}
