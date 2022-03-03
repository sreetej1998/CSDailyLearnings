package striverlist.day2;
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FindTheDuplicate {
    public static void main(String[] args) {
        int []nums = new int[]{1,3,4,2,2};
        System.out.println(repeatedNumber(nums));
    }


    public static int repeatedNumber(int nums[]) {
        int n = nums.length - 1;
        int sum = 0;
        for(int i = 0; i<=n; i++) {
            sum+=nums[i];
        }
        return sum - n*(n+1)/2;
    }
}
