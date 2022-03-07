package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

/*
Input = {2,1,1,1,4}
Output = 3
Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4
 */
public class MinJumps {
    public static int dp[] = new int[100];
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,1,1,4};
        System.out.println(minJumps(0, arr));
        System.out.println(minJumpsTopDown(0, arr));
    }

    public static int minJumps(int i, int input[]) {
        if(i == input.length - 1) {
            return 0;
        }
        if(i >= input.length || input[i] == 0) {
            return Integer.MAX_VALUE;
        }
        int jumps[] = new int[input[i]+1];
        jumps[0] = Integer.MAX_VALUE;
        for(int k = 1; k <= input[i]; k++) {
             int jump = minJumps(i + k, input);
             if(jump!=Integer.MAX_VALUE) {
                 jump = jump + 1;
             }
             jumps[k] = jump;
        }
        return minEle(jumps);
    }

    public static int minJumpsTopDown(int i, int input[]) {
        if(i == input.length - 1) {
            return 0;
        }
        if(i >= input.length || input[i] == 0) {
            return Integer.MAX_VALUE;
        }
        if(dp[i]!=0) {
            return dp[i];
        }
        int jumps[] = new int[input[i]+1];
        jumps[0] = Integer.MAX_VALUE;
        for(int k = 1; k <= input[i]; k++) {
            int jump = minJumpsTopDown(i + k, input);
            if(jump!=Integer.MAX_VALUE) {
                jump = jump + 1;
            }
            jumps[k] = jump;
        }
        dp[i] = minEle(jumps);
        return dp[i];
    }

    public static int minEle(int arr[] ) {
        if(arr.length == 0) return 0;
        int ele = arr[0];
        for(int i = 1; i< arr.length; i++) {
            if(arr[i] < ele) {
                ele = arr[i];
            }
        }
        return ele;
    }
}
