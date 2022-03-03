package striverlist.day2;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 */
public class FindRepeatingNumbers {
    //        TODO: binary search approach
    public static void main(String[] args) {
        int []nums = new int[]{1,3,4,2,2};
        System.out.println(tortoiseAndHareApproach(nums));
        System.out.println(store(0, nums));
        System.out.println(storeIterative(new int[]{1,3,4,2,2}));
    }

//  Tortoise and hare uses constant space and has 0[n] time complexity
    public static int tortoiseAndHareApproach(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(tortoise != hare);

        tortoise = nums[0];

        while(tortoise!= hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise;
    }

//    Array as a hashmap approach
    public static int store(int next, int[] nums) {
        if(nums[next] == next) {
            return next;
        }
        int temp = nums[next];
        nums[next] = next;
        return store(temp, nums);
    }

//    Array as a hashmap approach iterative
    public static int storeIterative(int[] nums) {

        while(nums[nums[0]] != nums[0]) {
            int temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;
        }
        return nums[0];
    }
}
