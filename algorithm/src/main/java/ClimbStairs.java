import java.util.HashMap;

/**
 * 爬楼梯问题
 * @author GeHejun
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs3(10));
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n > 2) {
            return climbStairs1(n) + climbStairs1(n - 1);
        }
        return 0;
    }
    /**
     * 递归 + 备忘录
     */
    public static int climbStairs2(int n) {
        HashMap memory = new HashMap(16);
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n > 2) {
            if (memory.containsKey(n)) {
                return (Integer) memory.get(n);
            }
            int value = climbStairs2(n) + climbStairs2(n - 1);
            memory.put(n,value);
            return value;
        }
        return 0;
    }
    /**
     * 动态规划
     */
    public static int climbStairs3(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int x = 0;
        int y = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                x = 1;
                y = 1;
            }
            if (i == 2) {
                y = 2;
            }
            if (i > 2) {
                int tmp = x;
                x = y;
                y = tmp + x;
            }
        }
        return y;
    }
}
