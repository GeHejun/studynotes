import java.util.HashSet;
import java.util.Set;

public class Combination {

    public static void main(String[] args) {
        String a = "abc";
        print(a.toCharArray());

    }

    public static void print(char[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        Set<String> stringSet = new HashSet<>();
        distinct(array, 0, stringSet);
        stringSet.forEach(s -> System.out.println(s));
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
}
