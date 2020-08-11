public class ExchangeMoney {
    public static int exchangeMoney1(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0) {
            return 0;
        }
        return process1(arr, 0, target);
    }

    private static int process1(int[] arr, int index, int target) {
        int result = 0;
        if (index == arr.length) {
            return target == result ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= target; i++) {
                result += process1(arr, index + 1, target);
            }
        }
        return result;
    }
}
