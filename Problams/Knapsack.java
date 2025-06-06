
class Knapsack {

    public static int Knapsack(int weights[], int values[], int W) {

        int n = weights.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = values[i - 1];
                int w = weights[i - 1];

                if (w <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], v + dp[i - 1][j - w]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("O_1 Knapsack table : ");

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][W];

    }

    public static int Unbound(int weights[], int values[], int W) {

        int n = weights.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = values[i - 1];
                int w = weights[i - 1];

                if (w <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], v + dp[i][j - w]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Unbound Knapsack table : ");

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][W];

    }

    public static void main(String[] args) {

        int weights[] = { 10, 6, 9, 5 };
        int values[] = { 300, 40, 50, 100 };
        int W = 7;

        System.out.println("0/1 knapscak answer : " + Knapsack(weights, values, W));
        System.out.println("Unbound answer : " + Unbound(weights, values, W));

    }
}