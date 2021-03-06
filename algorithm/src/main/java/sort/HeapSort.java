package sort;

/**
 * @author gehj
 * @version 1.0
 * @description 归并排序
 * @date 2019/8/9 12:44
 */
public class HeapSort {



    public static void heapSort(int[] tree, int n) {
        buildHeap(tree, n);
        int i;
        for (i = n - 1; i >=0; i--) {
            swap(tree, i , 0);
            heapfiy(tree, i , 0);
        }

    }

    public static void buildHeap(int[] tree, int n) {
        int last = n - 1 ;
        int parent = (last - 1) / 2;
        int i;
        for (i = parent; i >= 0; i--) {
            heapfiy(tree, n , i);
        }

    }

    public static void heapfiy(int[] tree, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < n && tree[left] > tree[max]) {
            max = left;
        }
        if (right < n && tree[right] > tree[max]) {
            max = right;
        }
        if (max != i) {
            swap(tree, max, i);
            heapfiy(tree, n , max);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {

        int[] arr  = {1, 5, 3, 9,  4};

        heapSort(arr, 8);
        for (int value : arr) {
            System.out.println(value);
        }

    }
}
