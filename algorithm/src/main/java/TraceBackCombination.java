import java.util.HashSet;
import java.util.Set;

public class TraceBackCombination {

    public static void main(String[] args) {
        String a = "abc";
        print2(a.toCharArray(), 0, a.length());

    }


    public static void print1(char[] arr, int begin, int end) {
        if (begin == end) {
            System.out.println(arr);
        } else {
            for (int i = begin; i < end; i++) {
                swap(arr, begin, i);
                print1(arr, begin + 1, end);
                swap(arr, i, begin);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(char[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        Set<String> stringSet = new HashSet<>();
        distinct(array, 0, stringSet);
        stringSet.forEach(System.out::println);
    }

    public static void distinct(char[] arr, int begin, Set<String> stringSet) {
        if (arr.length - 1 == begin) {
            stringSet.add(new String(arr));
        } else {
            char tmp;
            for (int i = begin; i <= arr.length - 1; i++) {
                tmp = arr[begin];
                arr[begin] = arr[i];
                arr[i] = tmp;
                distinct(arr, begin + 1, stringSet);
                tmp = arr[begin];
                arr[begin] = arr[i];
                arr[i] = tmp;
            }
        }
    }


    private static void print2(char[] arr, int begin, int end) {
        if (begin >= end - 1) {
            System.out.println(arr);
        } else {
            char tmp;
            for (int i = begin; i <= end - 1 ; i++) {
                tmp = arr[begin];
                arr[begin] = arr[i];
                arr[i] = tmp;
                print2(arr, begin + 1, end);
                tmp = arr[begin];
                arr[begin] = arr[i];
                arr[i] = tmp;
            }
        }

    }
}
