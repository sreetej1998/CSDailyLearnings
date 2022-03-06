package sorting.mergesort;
/*
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
 */
//TODO: TLE in leetcode and need to trace the shit out of it.
public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,5,1};
        int count = reversePairs(0, nums.length - 1, nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(count);
    }

    public static int reversePairs(int left, int right, int nums[]) {
        if(left < right) {
            int mid = (left + right)/2;
            int p1 = reversePairs(0, mid, nums);
            int p2 = reversePairs(mid+1, right, nums);
            int p3 = merge(left, right, mid, nums);
            return p1 + p2 + p3;
        } else {
            return 0;
        }
    }

    public static int merge(int left, int right, int mid, int nums[]) {
        int count = 0, l = mid + 1;
        for(int i = left; i <= mid; i++) {
            while (l <= right && nums[i] > (long)2*nums[l]) {
                l++;
            }
            count+= l - (mid + 1);
        }

        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for(int k = left; k <= mid; k++) {
            leftArr[k - left] = nums[k];
        }
        for(int k = mid+1; k <= right; k++) {
            rightArr[k - (mid + 1)] = nums[k];
        }
        int i = 0, j = 0;
        int k = left;
        while( i < n1 && j < n2 ) {
            if(leftArr[i] < rightArr[j]) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }

        while(i < n1) {
            nums[k++] = leftArr[i++];
        }

        while(j < n2) {
            nums[k++] = rightArr[j++];
        }

        return count;
    }
}
