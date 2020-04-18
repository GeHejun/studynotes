package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2 };
        quickSort(arr, 0, 4);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right, pivot = arr[i];
        while (i < j) {
            while (arr[j] > pivot && i < j) {
                j--;
            }
            int t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;

            while (arr[i] < pivot && i < j) {
                i++;
            }
            t = arr[i];
            arr[i] =  arr[j];
            arr[j] = t;
        }
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }


}
