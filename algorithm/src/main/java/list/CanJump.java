package list;

public class CanJump {
    public static void main(String[] args) {

    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int pos = nums.length - 1;
        for (int i = nums.length - 2 ;  i >= 0; i--) {
            if (nums[i] + i > pos) {
                pos = i;
            }
        }
        return pos == 0;
    }
}
