/**
 * @description 抢银行
 * @author GeHejun
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,1,1,2};
        System.out.println(houseRobber(numbers));
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
        int x = numbers[0],y = Math.max(x,numbers[1]);
        for (int i = 2; i <= numbers.length - 1; i++) {
            if (i > 1) {
                int tmp = x;
                x = y;
                y = Math.max(tmp + numbers[i],x);
            }
        }
        return y;
    }

}
