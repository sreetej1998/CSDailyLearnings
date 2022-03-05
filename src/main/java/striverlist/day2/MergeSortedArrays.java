package striverlist.day2;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] s = new int[]{3,1,2};
        int []c = new int[6];
        c[0] = 5;
        c[1] = 4;
        c[2] = 3;
        gapMethod(c, s);
        for (int j : c) {
            System.out.print(j + " ");
        }

    }

    public static int[] gapMethod(int[] nums1, int[] nums2) {
        int t = nums1.length;
        int l = nums1.length - nums2.length;
        if(t == 1) {
            return nums1;
        }
        for(int i = t - nums2.length; i < t; i++) {
            nums1[i] = nums2[i - l];
        }

        int gap = t%2 == 0  ? t/2 : t/2 + 1;

        while(gap > 0) {
            int idx = 0;
            int nextIdx = gap;
            while(nextIdx < t) {
                if(nums1[idx] > nums1[nextIdx]) {
                    int temp = nums1[idx];
                    nums1[idx] = nums1[nextIdx];
                    nums1[nextIdx] = temp;
                }
                idx++;
                nextIdx++;
            }
            if(gap == 1) {
                gap = 0;
            }
            gap = gap%2 == 0 ? gap/2 : gap/2 + 1;
        }
        return nums1;
    }


}
