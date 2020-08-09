public class ExchangeMoney {
    public static void exchangeMoney(int[] arr, int num) {
        int[] tmp = new int[arr.length + 1];
        if (arr.length == 1) {
            if (num % arr[0] == 0) {
                tmp[0] = 1;
            } else {
                tmp[0] = 0;
            }
        }
        for (int i = 1; i < arr.length; i++) {

        }

    }
}
