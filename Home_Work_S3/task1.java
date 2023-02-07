import java.util.Arrays;

/*
 * Реализовать алгоритм сортировки слиянием
 */

public class task1 {
    public static void main(String[] args) {
        int[] firstArr = new int[] {12, 5, 7, 1, 28, 15, 6, 9};
        int indexFirst = 0;
        int indexLast = firstArr.length - 1;

        SortUnsorted(firstArr, indexFirst, indexLast);
        for (int i : firstArr) {
            System.out.print(i + " ");
        }
    }

    private static void SortUnsorted(int[] arr, int first, int last) {

        if (last <= first)
            return;
        int mid = first + (last - first) / 2;
        SortUnsorted(arr, first, mid);
        SortUnsorted(arr, mid + 1, last);
    
        int[] buf = Arrays.copyOf(arr, arr.length);
    
        for (int k = first; k <= last; k++)
            buf[k] = arr[k];
    
        int i = first, j = mid + 1;
        for (int k = first; k <= last; k++) {
    
            if (i > mid) {
                arr[k] = buf[j];
                j++;
            } else if (j > last) {
                arr[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                arr[k] = buf[j];
                j++;
            } else {
                arr[k] = buf[i];
                i++;
            }
        }
    }
}
