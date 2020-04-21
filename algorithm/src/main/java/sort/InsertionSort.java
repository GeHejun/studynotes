package sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {9,2,5,7,1,3,6,8,4,0};
        insertionSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void insertionSort(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("数组为空");
        }
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int m = 1;
        while (m < nums.length) {
            int j = m - 1;
            int i = m;
            while (j >= 0 && nums[i] < nums[j]) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
                i--;
            }
            m++;
        }
    }
}
