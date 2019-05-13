import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * @Description 抢银行
 * @Author GeHejun
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(houseRobber(nums));
    }

    /**
     * 对于非环形数组
     * @param numbers
     * @return
     */
    public static int houseRobber(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        if (numbers.length == 2) {
            return Math.max(numbers[0],numbers[1]);
        }
        int x = 0,y = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (i == 0) {
                x = numbers[0];
            }
            if (i == 1) {
                y = numbers[1];
            }
            if (i > 1) {
                int tmp = x;
                x = y;
                y = tmp + numbers[i];
            }
        }
        return Math.max(x,y);

    }
}
