public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(5, arr, 0,  arr.length - 1));
    }



    private static int binarySearch(int target, int[] arr, int begin, int end) {
     int middle = ( begin + end ) / 2;
     if (arr[middle] > target) {
         return binarySearch(target, arr, middle, end);
     }
     if (arr[middle] < target) {
         return binarySearch(target, arr, begin, middle);
     }
     if (arr[middle] == target) {
         return middle;
     }
     if (arr[begin] > target || arr[end] < target || begin > end) {
         return -1;
     }
     return -1;
    }
}
