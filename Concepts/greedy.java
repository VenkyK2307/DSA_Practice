import java.util.*;

class greedy {

    static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;

        }
    }

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

    public static double FractionalKnapSack(Item[] items, int W) {

        double maxvalue = 0.0;
        Arrays.sort(items, (a, b) -> Double.compare((double) (b.value / b.weight), (double) (a.value / a.weight)));

        for (Item item : items) {
            if (W == 0)
                break;

            if (item.weight < W) {
                maxvalue = maxvalue + item.value;
                W -= item.weight;
            } else {
                maxvalue += ((double) item.value / item.weight) * W;
                W = 0;
            }

        }
        return maxvalue;

    }

    public static void ActivitySelection(int start[], int end[]) {

        List<Integer> ans = new ArrayList<>();
        int count = 1;
        ans.add(0);

        int Lastend = end[0];
        for (int i = 1; i < start.length; i++) {
            if (start[i] > Lastend) {
                count++;
                ans.add(i);
                Lastend = end[i];
            }
        }

        System.out.println("Total activivtes : " + count);
        for (int num : ans) {
            System.out.print("A" + num + " ");
        }

    }

    public static int MInimumAbsoluteDifferencePairs(int nums1[], int nums2[]) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int diff = 0;
        for (int i = 0; i < nums1.length; i++) {
            diff += Math.abs(nums1[i] - nums2[i]);
        }
        return diff;
    }

    public static int MaximumChainLength(int nums[][]) {

        Arrays.sort(nums, (a, b) -> a[1] - b[1]);

        int count = 1;
        int Lastend = nums[0][1];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] > Lastend) {
                count++;
                Lastend = nums[i][1];
            }
        }
        return count;
    }

    public static class Jobs {
        String id;
        int deadline;
        int profit;

        Jobs(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void JobSequencing(Jobs[] jobs) {

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int deadline = 0;
        for (Jobs job : jobs) {
            deadline = Math.max(deadline, job.deadline);
        }

        String schedule[] = new String[deadline];
        boolean time[] = new boolean[deadline];

        int totalprofit = 0;
        for (Jobs job : jobs) {
            for (int i = deadline - 1; i >= 0; i--) {
                if (!time[i]) {
                    time[i] = true;
                    schedule[i] = job.id;
                    totalprofit += job.profit;
                    break;
                }
            }
        }

        for (String job : schedule) {
            if (job != null) {
                System.out.print(job + " ");
            }
        }
        System.out.println();
        System.out.println("Total profit : " + totalprofit);

    }

    public static int CHOCOLAProblam(Integer costHor[], Integer costVer[]) {

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int v = 0;
        int h = 0;

        int hp = 1;
        int vp = 1;

        int totalcost = 0;

        while (v < costVer.length && h < costHor.length) {
            if (costVer[v] >= costHor[h]) {

                totalcost += hp * costVer[v];
                v++;
                vp++;
            } else {
                totalcost += vp * costHor[h];
                h++;
                hp++;
            }
        }

        if (v < costVer.length) {
            totalcost += hp * costVer[v];
            v++;
            vp++;
        }

        if (h < costHor.length) {
            totalcost += vp * costHor[h];
            h++;
            hp++;
        }
        return totalcost;

    }

    public static int TaskScheduler(char tasks[], int k) {

        int freq[] = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);
        int maxfreq = freq[25];
        int count = 0;

        for (int i = 24; i >= 0; i--) {
            if (maxfreq == freq[i]) {
                count++;
            } else {
                break;
            }
        }

        int partcount = k + 1;
        int partlength = maxfreq - 1;
        int emptyslots = partcount * partlength + count;
        return Math.max(tasks.length, emptyslots);

    }

    public static int AssignCookies(int child[], int cookie[]) {

        Arrays.sort(child);
        Arrays.sort(cookie);

        int count = 0;
        int i = 0;
        int j = 0;

        while (i < child.length && j < cookie.length) {
            if (child[i] <= cookie[j]) {
                count++;
                i++;
            }
            j++;
        }

        return count;
    }

    public static int PerfectSquare(int n) {

        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int sq = i * i;
            for (int j = sq; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - sq] + 1);
            }

        }

        for (int num : dp) {
            System.out.print(num + " ");
        }
        System.out.println();

        return dp[n];
    }

    public static void main(String[] args) {

        // int coins[] = { 5, 5, 10, 10, 20 };
        // System.out.println(lemonadeChange(coins));

        // int amount = 784;
        // System.out.println("No.of Denominations : " + IndianCoins(amount));

        // int coins[] = { 1, 3, 5 };
        // int sum = 8;
        // System.out.println(NoofWayCoins(coins, sum));

        // int coins[] = { 1, 3, 5 };
        // int amount = 11;
        // System.out.println(MinCoinChange(coins, amount));

        // Item[] items = {
        // new Item(64, 11),
        // new Item(176, 23),
        // new Item(145, 28)
        // };
        // int W = 61;
        // double max = FractionalKnapSack(items, W);
        // System.out.println(max);

        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };
        // ActivitySelection(start, end);

        // int nums1[] = { 1, 2, 3 };
        // int nums2[] = { 2, 1, 3 };
        // int ans = MInimumAbsoluteDifferencePairs(nums1, nums2);
        // System.out.println(ans);

        // int nums[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        // System.out.println(MaximumChainLength(nums));

        // Jobs[] jobs = {
        // new Jobs("A", 2, 100),
        // new Jobs("B", 5, 19),
        // new Jobs("C", 4, 27),
        // new Jobs("D", 1, 25),
        // new Jobs("E", 3, 15)
        // };
        // JobSequencing(jobs);

        // Integer costVer[] = { 2, 1, 3, 1, 4 };
        // Integer costHor[] = { 4, 1, 2 };
        // System.out.println("Minimum Cost to cut the choclate : " +
        // CHOCOLAProblam(costHor, costVer));

        // char tasks[] = { 'A', 'A', 'A', 'B', 'B', 'B' };
        // int k = 2;
        // System.out.println(TaskScheduler(tasks, k));

        // int child[] = { 1, 2, 3 };
        // int[] cookie = { 1, 1 };
        // System.out.println(AssignCookies(child, cookie));

        // int n = 1087;
        // System.out.println(PerfectSquare(n));

    }

}
