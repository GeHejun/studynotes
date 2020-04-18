public class RepeatNumber {
    public static void main(String[] args) {
        int[] nums = { 0, 2, 1 };
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums)  {
        int[] tmp = new int[nums.length];
        int i = 0;
        while (i < nums.length) {
            tmp[nums[i]]++;
            if (tmp[nums[i]] > 1) {
                return nums[i];
            }
            i++;
        }
        throw new IllegalArgumentException("数组中不存在重复数");
    }
}
