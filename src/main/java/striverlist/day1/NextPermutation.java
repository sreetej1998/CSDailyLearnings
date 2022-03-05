package striverlist.day1;

public class NextPermutation {
    public static void main(String[] args) {
        int []nums = new int[]{1,2,4,3};
        nextPermutation(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] nextPermutation(int[] nums) {

        // find the inversion point
        int inv = -1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > nums[i-1]) {
                inv = i;
                break;
            }
        }

        if(inv == -1) {
            int left = 0, right = nums.length - 1;
            while( left < right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
            return nums;
        }
        // swap the inversion point
        for(int i = nums.length - 1; i >=0; i--) {
            if(nums[inv] < nums[i]) {
                int temp = nums[inv];
                nums[inv] = nums[i];
                nums[i] = temp;
            }
        }

        // reverse the array from inflection point
        int left = inv + 1, right = nums.length - 1;

        while( left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }

        return nums;
    }
}
