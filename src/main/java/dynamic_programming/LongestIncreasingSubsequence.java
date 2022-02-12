package dynamic_programming;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int a[] = {-1, 10, 9, 2, 5, 3, 7, 101, 18};
        int ae[] = {10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println(LIS(0, 1, a));
//        System.out.println(topDown(a));
        System.out.println(LisOwnChoice(ae, 0, ae.length - 1, ae.length - 1));
    }


//    Weird algorithm which exists for LIS.
    static int LIS(int i, int j, int arr[]) {
        if( j>= arr.length) return 0;
        if(arr[i] >= arr[j]) {
            return LIS(i, j+1, arr);
        } else {
            return Math.max(1 + LIS(j, j+1, arr), LIS(i, j+1, arr));
        }
    }


// Top down for the above algo
    static int topDown(int arr[]) {
        int a[] = {-1,10,9,2,5,3,7,101,18};
        int dp[][] = new int[100][100];
        for(int j = a.length - 1; j >= 0; j--) {
            for(int i = j - 1; i >= 0; i--) {
                if( j == a.length - 1) {
                    if(arr[i] >= arr[j]) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                if(arr[i] >=arr[j]) {
                    dp[i][j] = dp[i][j+1];
                } else {
                    dp[i][j] = Math.max(1+dp[j][j+1], dp[i][j+1]);
                }
            }
        }
        return dp[0][1];
    }


/*
1,4,2,3
in progress

 */
    static int LisOwnChoice(int arr[], int start, int end, int prevEnd) {
        if(start == end) {
            return 1;
        }
        if(arr[start] < arr[end] && (arr[prevEnd] > arr[end] || end == arr.length - 1)) {
            return 1 + LisOwnChoice(arr, start, end -1, end);
        } else {
            return Math.max(LisOwnChoice(arr, start, end -1, end), LisOwnChoice(arr, start+1, end, end));
        }
    }
//        return the max increasing subsequences of index i
//    1000,100, 1001
    static int LisOfficial(int arr[]) {
        int a[] = new int[arr.length];
        int max = arr[0];
        for(int o = 0; o < arr.length; o++) {
            a[o] = 1;
        }

        for(int i = 0; i< arr.length; i++) {
            for(int k = i - 1; k >= 0; k--) {
                if (arr[i] > arr[k]) {
                    a[i] = Math.max(a[i], 1+a[k]);
                }
            }
        }

        for(int j = 0; j < arr.length; j++) {
            if(arr[j] > max) {
                max = arr[j];
            }
        }
        return max;
    }
}


