public class LongestCommonSubstring {

    public static void main(String[] args) {
        String a = "abcbac";
        String b = "abcbee";
        System.out.println(longestCommonSubstring(a, b));
    }

    public static int longestCommonSubstring(String a, String b) {
        int[][] dp  = new int[a.length() + 1][b.length() + 1];
        int result = 0;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j -1 )) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result;
    }
}
