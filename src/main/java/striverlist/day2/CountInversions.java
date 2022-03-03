package striverlist.day2;

public class CountInversions {
//    Already there in sorting variants package
    public static void main(String[] args) {
        int arr[] = { 3,2, 1};
        System.out.println(
                sorting.mergesort.CountInversions.countInversions(0, arr.length - 1, arr)
        );
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
