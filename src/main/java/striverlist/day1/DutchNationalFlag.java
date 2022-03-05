package striverlist.day1;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] nums = new int[] {2,1,1,2,2,1,0,2,2,0,0,0};
        dutchNationalFlag(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static void dutchNationalFlag(int []nums) {
        int start = 0, mid = 0;
        int end = nums.length - 1;
        while(mid < end) {
            switch (nums[mid]) {
                case 0 -> {
                    int temp = nums[start];
                    nums[start] = nums[mid];
                    nums[mid] = temp;
                    mid++;
                    start++;
                }
                case 1 -> mid++;
                case 2 -> {
                    int temp = nums[end];
                    nums[end] = nums[mid];
                    nums[mid] = temp;
                    end--;
                }
            }
        }
    }
}
