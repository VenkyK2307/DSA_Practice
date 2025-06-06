import java.util.*;

class LCSubsting {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "abcde";

        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n + 1][m + 1];

        /*
         * for (int i = 0; i < dp.length; i++) {
         * dp[i][0] = 0;
         * }
         * for (int j = 0; j < dp[0].length; j++) {
         * dp[0][j] = 0;
         * }
         */
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    max = Math.max(max, dp[i][j]);

                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(max);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
