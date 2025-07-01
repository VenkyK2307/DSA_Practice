import java.util.*;

public class dp {

    public static int fibonacci(int n) {

        int dp[] = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[n];
    }

    public static int fact(int n) {

        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = i * dp[i - 1];

        }
        return dp[n];
    }

    public static int Knapscak(int[] weights, int[] values, int W) {

        int n = weights.length;

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {

                int v = values[i - 1];
                int w = weights[i - 1];

                if (w <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], v + dp[i - 1][j - w]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                System.out.print(dp[i][j] + " ");

            }
            System.out.println();
        }

        return dp[n][W];

    }

    public static int UKnapscak(int[] weights, int[] values, int W) {

        int n = weights.length;

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {

                int v = values[i - 1];
                int w = weights[i - 1];

                if (w <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], v + dp[i][j - w]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                System.out.print(dp[i][j] + " ");

            }
            System.out.println();
        }

        return dp[n][W];

    }

    public static int LCSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }
        return dp[n][m];
    }

    public static int LCSubstring(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }

        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }
        return dp[n][m];
    }

    public static int editdistance(String s, String t) {

        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    // ADD,REMOVE ,REPLACE
                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][m];

    }

    public static boolean Wildcard(String s, String t) {

        int n = s.length();
        int m = t.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= m; j++) {
            if (t.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1) || t.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (t.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");

            }
            System.out.println();
        }

        return dp[n][m];

    }

    public static int UniquePaths(int n, int m) {

        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }

        return dp[n - 1][m - 1];
    }

    public static int HouseRobber(int[] nums) {

        int n = nums.length;

        int dp[] = new int[n + 1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];

    }

    public static int MinDifferenceSubsets(int nums[]) {

        int sum = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int W = sum / 2;

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                if (nums[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], nums[i - 1] + dp[i - 1][j - nums[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);
    }

    public static boolean IsPossibletoSeperate(int nums[]) {

        int sum = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int W = sum / 2;

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                if (nums[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], nums[i - 1] + dp[i - 1][j - nums[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;

        return sum1 == sum2;

    }

    public static int ClimbingSteps(int n) {

        // Same as fibonacci but one Step forward
        int dp[] = new int[n];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[n - 1];
    }

    public static boolean TargetSum(int nums[], int W) {

        int n = nums.length;

        boolean dp[][] = new boolean[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int w = nums[i - 1];

                if (w <= j && dp[i - 1][j - w] == true) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }

        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][W];

    }

    public static int FrogJump(int nums[]) {

        int n = nums.length;

        int dp[] = new int[n + 1];

        dp[0] = nums[0];
        dp[1] = Math.abs(nums[1] - nums[0]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(nums[i] - nums[i - 1]), dp[i - 2] + Math.abs(nums[i] - nums[i - 2]));
        }

        return dp[n - 1];
    }

    public static int MaxNonAdjacentSum(int nums[]) {
        int n = nums.length;

        int dp[] = new int[n + 1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }

    public static int CountingPrimes(int n) {

        boolean dp[] = new boolean[n];

        Arrays.fill(dp, true);
        dp[0] = dp[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (dp[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    dp[j] = false;

                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i]) {
                count++;
            }

        }

        int ans[] = new int[count];
        int idx = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i]) {
                ans[idx++] = i;

            }

        }

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        return count;

    }

    public static List<List<Integer>> PascalTriangle(int n) {

        int dp[][] = new int[n][n];

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

                }

                row.add(dp[i][j]);
            }
            triangle.add(row);
        }
        return triangle;

    }

    public static int NcR(int n, int r) {
        // Variataion of pascal triangle

        int[][] dp = new int[n + 1][r + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }

        }
        return dp[n][r];

    }

    public static int UniquePathswithObstacle(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 1)
                break;
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n - 1][m - 1];

    }

    public static int CoinGame(int nums[]) {
        int n = nums.length;

        int dp[][] = new int[n][n];

        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;

                if (i == j) {
                    dp[i][j] = nums[i];
                }

                else if (j == i + 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);

                }

                else {
                    dp[i][j] = Math.max(nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                            nums[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
                }

            }

        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][n - 1];

    }

    public static int BuyandSellStock(int nums[]) {

        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -nums[i]);
        }

        System.out.println("Only 1 buy and 1 sell");

        for (int i = 0; i < dp.length; i++) {
            System.out.print(nums[i] + " -> ");
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n - 1][0];

    }

    public static int BuyandSellStockII(int nums[]) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i]);
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(nums[i] + " -> ");
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n - 1][0];

    }

    public static int HouseRobberII(int nums[]) {
        int n = nums.length;

        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        // Step-1 0 to n-1;

        int dp1[] = new int[n];

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        // STEP-2 1 to n

        int dp2[] = new int[n];

        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for (int i = 3; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);

    }

    public static int MInCostToClimbStairs(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + nums[i - 1], dp[i - 2] + nums[i - 2]);
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[n];

    }

    public static int DecodeWays(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            int twodigit = Integer.parseInt(s.substring(i - 2, i));
            if (twodigit >= 10 && twodigit <= 26) {
                dp[i] += dp[i - 2];
            }

        }

        for (int num : dp) {
            System.out.print(num + " ");
        }
        return dp[n];

    }
    // public static int BuyandSellStockIII(int nums[]) {

    // }

    // public static int BuyandSellStockIV(int nums[]) {

    // }

    public static void main(String[] args) {

        // int n = 6;
        // System.out.println(fibonacci(n));

        // int n = 6;
        // System.out.println(fact(n));

        // int weights[] = { 4, 6, 2, 3, 5, 6, 8 };
        // int values[] = { 10, 20, 30, 40, 50, 60, 70 };
        // int W = 20;
        // System.out.println("The knapsack vales : " + Knapscak(weights, values, W));

        // int weights[] = { 4, 6, 2, 3, 5, 6, 8 };
        // int values[] = { 10, 20, 30, 40, 50, 60, 70 };
        // int W = 20;
        // System.out.println("The unbound Knapsack : " + UKnapscak(weights, values,W));

        // String s = "abcde";
        // String t = "abcde";
        // System.out.println("Max Length of the SubSequence : " + LCSubsequence(s, t));

        // String s = "abcde";
        // String t = "abde";
        // System.out.println("Max Length of the Substring : " + LCSubstring(s, t));

        // String s = "intention";
        // String t = "execution";
        // System.out.println("Minimum no. of Operation : " + editdistance(s, t));

        // String s = "cb";
        // String t = "*?a";
        // System.out.println("Can MAtch : " + Wildcard(s, t));

        // int rows = 5;
        // int cols = 5;
        // System.out.println("Total Number of Ways : " + UniquePaths(rows, cols));

        // int nums[] = { 1, 2, 3, 1 };
        // System.out.println(HouseRobber(nums));

        // int nums[] = { 2, 3, 1, 8 };
        // System.out.println(MinDifferenceSubsets(nums));

        // int nums[] = { 2, 3, 1 };
        // System.out.println(IsPossibletoSeperate(nums));

        // int n = 20;
        // System.out.println("For " + n + " Steps the " + "Total No. of Ways : " +
        // ClimbingSteps(n));

        // int[] nums = { 1, 2, 3, 4, 5 };
        // int W = 14;
        // System.out.println(TargetSum(nums, W));

        // int nums[] = { 10, 20, 30, 10 };
        // System.out.println(FrogJump(nums));

        // int nums[] = { 1, 2, 3, 1 };
        // System.out.println(MaxNonAdjacentSum(nums));

        // int n = 1000;
        // System.out.println("Total No. of Primes : " + CountingPrimes(n));

        // int n = 9;
        // System.out.println(PascalTriangle(n));

        // int n = 5;
        // int r = 2;
        // System.out.println(NcR(n, r));

        // int[][] matrix = {
        // { 0, 0, 1, 0, 0, 0, 0, 0, 0 },
        // { 1, 1, 1, 1, 1, 1, 1, 1, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 1, 0 },
        // { 1, 1, 1, 1, 1, 1, 0, 1, 0 },
        // { 0, 0, 0, 0, 0, 1, 0, 0, 0 },
        // { 0, 1, 1, 1, 0, 1, 0, 1, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        // };
        // System.out.println(UniquePathswithObstacle(matrix));

        // int nums[] = { 3, 9, 1, 2, 7, 5, 6, 4, 8, 10 };
        // System.out.println("The minimum a Winner could get : " + CoinGame(nums));

        // int nums[] = { 7, 1, 5, 3, 6, 4 };
        // System.out.println(BuyandSellStock(nums));

        // int nums[] = { 7, 1, 5, 3, 6, 4 };
        // System.out.println(BuyandSellStockII(nums));

        // int nums[] = { 10, 9, 4, 5, 8, 6, 10, 1, 18, 23, 4, 5, 7, 6, 7 };
        // System.out.println(HouseRobberII(nums));

        // int nums[] = { 10, 15, 20 };
        // System.out.println(MInCostToClimbStairs(nums));

        // String s = "226";
        // System.out.println(DecodeWays(s));

    }
}