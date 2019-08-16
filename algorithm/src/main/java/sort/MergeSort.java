package sort;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/16 11:18
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] tenInt = {9,2,5,7,1,3,6,8,4,0};
        int[] ints = mergeSort(tenInt, 0, tenInt.length - 1);
        for (int i : ints) {
            System.out.print(i);
        }
    }


    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h) {
            return new int[] { nums[l] };
        }
        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid);
        int[] rightArr = mergeSort(nums, mid + 1, h);
        int[] newNum = new int[leftArr.length + rightArr.length];

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            newNum[m++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            newNum[m++] = rightArr[j++];
        }

        return newNum;
    }
}
