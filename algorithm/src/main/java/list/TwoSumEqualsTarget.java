package list;

public class TwoSumEqualsTarget {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 5};
        int target = 9;
        final int[] ints = twoSum(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1 ; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
