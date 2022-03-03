package sorting.mergesort;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        merge(0, arr.length - 1, arr);
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }

    public static void merge(int left, int right, int[] arr) {
        if(left < right) {
            int mid = (left + right) / 2;
            merge(left, mid, arr);
            merge(mid + 1, right, arr);
            mergeSortedArrays(left, right, mid, arr);
        }
    }

    public static void mergeSortedArrays(int left, int right, int mid, int[] arr) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];
        int p = 0;

        // fill the separated arrays
        while(p<leftSize) {
            leftArr[p] = arr[p + left];
            p++;
        }
        p = 0;
        while(p < rightSize) {
            rightArr[p] = arr[p + mid+1];
            p++;
        }


        //merging them into array
        int i = 0, j =0;
        int k = left;
        while(i < leftSize && j < rightSize) {
            if(leftArr[i] > rightArr[j]) {
                arr[k] = rightArr[j];
                j++;
            } else {
                arr[k] = leftArr[i];
                i++;
            }
            k++;
        }

        // filling remaining spots
        while(i < leftSize ) {
            arr[k++] = leftArr[i];
            i++;
        }

        while(j < rightSize) {
            arr[k++] = rightArr[j];
            j++;
        }

    }
}
