package striverlist.day3;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1,3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                candidate = nums[i];
            }
            count += candidate == nums[i] ? 1: -1;
        }
        return candidate;
    }
}

