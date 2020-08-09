public class ExchangeMoney {
    public static void exchangeMoney(int[] arr, int num) {
        int[] tmp = new int[arr.length];
        if (arr.length == 1) {
            if (num % arr[0] == 0) {
                tmp[0] = num / arr[0];
            } else {
                tmp[0] = 0;
            }
        }
        if (arr.length == 2) {

        }
    }
}
