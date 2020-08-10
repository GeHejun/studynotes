public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch1(5, arr, 0,  arr.length - 1));
    }

    private static int binarySearch(int i, int[] arr, int i1, int i2) {
        if (i1 >= i2) {
            return -1;
        }
        if (arr[(i2 - i1) / 2] == i) {
            return (i2 - i1) / 2;
        } else {
            if (arr[(i2 - i1) / 2] > i) {
                return binarySearch(i, arr, i1, (i2 - i1) / 2);
            } else {
                return binarySearch(i, arr, (i2 - i1) / 2, i2);
            }
        }

    }

    public static int binarySearch1(int target, int[] arr, int begin, int end) {
        if (begin >= end) {
            return -1;
        }
        if (arr[(end - begin) / 2] == target) {
            return (end - begin) / 2;
        }

        if (arr[(end - begin) / 2] > target) {
            return binarySearch1(target, arr, 0, (end - begin) / 2);
        } else {
            return binarySearch1(target, arr, (end - begin) / 2, end);
        }
    }


}
