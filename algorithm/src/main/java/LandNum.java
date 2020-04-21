import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class LandNum {
    private static int i = 0;
    public static void main(String[] args) {

        String str = "hshaksdhqqkqwkasfa,shgjqijasjkdhajkcsnidh";
        String[] as = str.split("a");
        for (int i = 0; i < as.length; i++) {
            if (as[i].contains("s")) {
                as[i] = as[i].subSequence(0, as[i].indexOf("s")).toString();
            }
        }
        System.out.println(Arrays.stream(as).sorted(String::compareTo).collect(Collectors.joining()));

//
//        System.out.println(ss); String str = "hshaksdhqqkqwkasfa,shgjqijasjkdhajkcsnidh";
////        StringBuilder ss = new StringBuilder();
////        int i = 0, j = 1;
////        while (i < str.length() && j < str.length()) {
////            if (str.charAt(i) == 'a') {
////                ss.append(str.charAt(j));
////                j++;
////            }
////            else if (str.charAt(j) == 's') {
////                i++;
////                j++;
////            }
////
////        }
////
////        System.out.println(ss);

    }

    public static void test() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Test()).start();

        }
    }



    
}
