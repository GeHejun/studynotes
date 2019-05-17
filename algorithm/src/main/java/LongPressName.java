public class LongPressName {
    public static void main(String[] args) {
        System.out.println(isNameLongPressed("alex","aaleex"));
    }

    public static boolean isNameLongPressed(String name, String typed) {
        int i = 0;
        for (; i < name.length(); i++) {
            for (int j = 0; j < typed.length(); j++) {
                if (typed.charAt(j) == name.charAt(i)) {
                    break;
                }
            }
        }
        if (i == name.length() - 1) {
            return true;
        }
        return false;
    }
}
