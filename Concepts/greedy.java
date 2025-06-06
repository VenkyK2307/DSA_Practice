import java.util.*;

public class greedy {

    public static boolean lemonadeChange(int[] coins) {

        int five = 0;
        int ten = 0;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == 5) {
                five++;
            }

            else if (coins[i] == 10) {
                ten++;

                if (five >= 1) {
                    five--;
                } else {
                    return false;
                }

            }

            else if (coins[i] == 20) {

                if (five >= 3)
                    five -= 3;
                else if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else {
                    return false;
                }

            }
        }
        return true;

    }

    public static int IndianCoins(int amount) {

        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000 };

        int n = coins.length;
        int count = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            if (amount >= coins[i]) {
                while (amount >= coins[i]) {
                    count++;
                    list.add(coins[i]);
                    amount -= coins[i];
                }

            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        return count;

    }

    public static int NoofWayCoins(int coins[], int sum) {

        int dp[] = new int[sum + 1];

        // DP and Greedy

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }

        return dp[sum];

    }

    public static int MinCoinChange(int coins[], int amount) {

        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public static void main(String[] args) {

        // int amount = 784;
        // System.out.println("No.of Denominations : " + IndianCoins(amount));

        // int coins[] = { 5, 5, 10, 10, 20 };
        // System.out.println(lemonadeChange(coins));

        // int coins[] = { 1, 3, 5 };
        // int sum = 8;
        // System.out.println(NoofWayCoins(coins, sum));

        // int coins[] = { 1, 3, 5 };
        // int amount = 11;
        // System.out.println(MinCoinChange(coins, amount));

    }

}
