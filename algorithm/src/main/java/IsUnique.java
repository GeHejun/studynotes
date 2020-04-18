public class IsUnique {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(isUnique(s));
    }

    public static boolean isUnique(String arr) {
        for (int i = 0 ; i < arr.length() - 1; i++) {
            for (int j = i + 1; j < arr.length(); j++) {
                if (arr.charAt(i) == arr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
