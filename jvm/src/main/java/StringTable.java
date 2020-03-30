public class StringTable {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        String s5 = "a" + "b";
        System.out.println(s3.equals(s4));
        System.out.println(s3 == s4);
    }
}
