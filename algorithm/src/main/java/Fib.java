/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/7/12 18:05
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(100));
    }

    private static int fib(int n) {
        if(n == 0) {
            return 0;
        }
        int[] tmp = new int[n + 1];
        tmp[0] = 0 % 1000000007;
        tmp[1] = 1 % 1000000007;

        for (int i = 2 ; i < n + 1; i++) {
            tmp[i] = (tmp[i - 1] + tmp[i - 2]) % 1000000007;
        }
        return tmp[n];
    }
}
