import java.util.HashMap;
import java.util.Map;

/**
 * 重复n次数
 * @author gehj
 */
public class RepeatNNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3};
        repeatNNumber(nums);
    }
    private static  int repeatNNumber(int[] nums) {
        HashMap<Integer,Integer> memory = new HashMap(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            if (memory.get(nums[i]) != null) {
                memory.put(nums[i],1 +  memory.get(nums[i]));
            } else {
                memory.put(nums[i],1);
            }

        }

        for (Map.Entry entry:memory.entrySet()) {
            if ((Integer)entry.getValue() > 1) {
                return (Integer) entry.getKey();
            }
        }
        return 0;
    }
}
