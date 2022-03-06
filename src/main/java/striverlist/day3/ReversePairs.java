package striverlist.day3;

import static sorting.mergesort.ReversePairs.reversePairs;

// Variant of merge sort solution in sorting package
public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,5,1};
        int count = reversePairs(0, nums.length - 1, nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(count);
    }

}
