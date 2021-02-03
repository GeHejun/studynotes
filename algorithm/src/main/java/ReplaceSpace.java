public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replaceSpace(str));
    }
    public static String replaceSpace(String str) {
        return str.replace(" ", "%20");
    }
}
