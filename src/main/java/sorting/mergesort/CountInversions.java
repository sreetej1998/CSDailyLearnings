package sorting.mergesort;

public class CountInversions {
    public static void main(String[] args) {
        int arr[] = { 3,2, 1};
        System.out.println(countInversions(0, arr.length - 1, arr));
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

    }

    public static int countInversions(int first, int last, int arr[]) {
        if(first < last) {
            int mid = (first + last) / 2;
            int c1 = countInversions(first, mid, arr);
            int c2 = countInversions(first, mid, arr);
            int c3 = inversionMergeSortArray(first, last, mid, arr);
            return c1+c2+c3;
        } else {
            return 0;
        }

    }

    public static int inversionMergeSortArray(int first, int last, int mid, int[] arr) {
        int inv = 0;
        int n1 = mid - first + 1;
        int n2 = last - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        int i = 0, j = 0;

        while(i < n1) {
            left[i] = arr[i];
            i++;
        }
        while (j < n2) {
            right[j] = arr[mid + j + 1];
            j++;
        }
        i=0;j=0;
        int k = 0;
        while( i < n1 && j < n2) {
            if(left[i] < right[j]) {
                arr[k] = left[i];
                k++;i++;
            } else {
                arr[k] = right[j];
                k++;j++;
                inv+= n1 - i;
            }
        }

        while(i < n1) {
            arr[k++] = left[i++];
        }
        while(j < n2) {
            arr[k++] = right[j++];
        }
        return inv;
    }

}
