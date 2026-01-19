import java.util.*;

public class placement {

    // Merging Sorted Array
    public static int[] MergeArrays(int nums1[], int n, int nums2[], int m) {

        int[] merged = new int[m + n];

        for (int i = 0; i < n; i++) {
            merged[i] = nums1[i];
        }

        for (int i = 0; i < m; i++) {
            merged[i + n] = nums2[i];
        }
        Arrays.sort(merged);

        return merged;

    }

    public static int[] RemoveElement(int nums[], int k) {

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != k) {
                nums[idx++] = nums[i];
            }

        }
        return nums;

    }

    public static HashSet<Integer> RemoveDuplicates(int nums[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    public static int MajorityElement(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "==> " + entry.getValue());

            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }

        }
        return result;
    }

    public static int MajorityElemetMoore(int nums[]) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;

        }

        return candidate;

    }

    // Helper
    public static void Swap(int nums[], int start, int end) {

        while (start <= end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;

        }
    }

    public static int[] RotateArray(int nums[], int k) {
        Swap(nums, 0, nums.length - 1);
        Swap(nums, 0, k - 1);
        Swap(nums, k, nums.length - 1);

        return nums;

    }

    public static boolean CanJumpI(int nums[]) {

        int maxreach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxreach) {
                return false;
            }

            maxreach = Math.max(maxreach, i + nums[i]);
            // Update just if it can be reachable
        }
        return true;
    }
    // Can Jump 2

    public static int[] ProductOfArrayExceptItself(int nums[]) {

        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        int[] result = new int[nums.length];

        left[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {

            result[i] = left[i] * right[i];

        }

        return result;

    }

    public static int MaxWater(int nums[]) {
        int left = 0;
        int right = nums.length - 1;

        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(nums[left], nums[right]) * (right - left));

            if (nums[left] > nums[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;

    }

    public static int candy(int rating[]) {

        int candies[] = new int[rating.length];

        Arrays.fill(candies, 1);

        for (int i = 1; i < rating.length; i++) {
            if (rating[i] > rating[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = rating.length - 2; i >= 0; i--) {
            if (rating[i] > rating[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int count = 0;
        for (int num : candies) {
            count += num;

        }

        return count;
    }

    // Trapping Rain Water

    public static int[] TwoSum(int nums[], int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];

            if (map.containsKey(comp)) {
                return new int[] { map.get(comp), i };

            }
            map.put(nums[i], i);

        }
        return new int[] {};

    }

    public static boolean ValidAnagrams(String str1, String str2) {

        int[] freq = new int[26];

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            char curr = str1.charAt(i);
            freq[curr - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            char curr = str2.charAt(i);
            freq[curr - 'a']--;
        }

        for (int ans : freq) {
            if (ans != 0) {
                return false;
            }
        }
        return true;

    }

    public static int HouseRobber(int nums[]) {

        int dp[] = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        for (int num : dp) {
            System.out.print(num + " ");
        }
        System.out.println();

        return dp[nums.length - 1];

    }

    public static List<List<Integer>> ThreeSum(int nums[], int target) {

        List<List<Integer>> map = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (i > 0 && nums[i] == nums[i + 1]) {// I duplicates
                i++;
            }
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];

                if (sum < target) {
                    j++;
                }

                else if (sum > target) {
                    k--;
                }

                else {
                    map.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;
                }

            }

        }
        return map;
    }

    public static int[] MaxElementSlidingWindow(int nums[], int k) {

        Deque<Integer> dq = new ArrayDeque<>();

        int[] dp = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            // Remove from first if its over the Window Size
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.removeFirst();
            }

            // Remove from last if the number is not satisfying the criteria
            // Symbol change gives you Large to Small
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                dp[index++] = nums[dq.pollFirst()];

            }

        }
        return dp;
    }

    // Do it Again
    public static List<int[]> MergeIntervels(int nums[][]) {

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        int start = nums[0][0];
        int end = nums[0][1];

        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {

            // Mergeing Condition

            if (nums[i][0] < end) {
                end = Math.max(end, nums[i][1]);
            }

            else {

                result.add(new int[] { start, end });
                start = nums[i][0];
                end = nums[i][1];

            }

            result.add(new int[] { start, end });

        }

        return result;

    }

    public static int LongestCommanSubSequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int[] line : dp) {
            for (int ans : line) {
                System.out.print(ans + " ");
            }
            System.out.println();
        }

        return dp[m][n];
    }

    public static int LongestCommanSubString(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m + 1][n + 1];
        int max = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);

                } else {
                    dp[i][j] = 0;
                }
            }
        }

        for (int[] line : dp) {
            for (int ans : line) {
                System.out.print(ans + " ");
            }
            System.out.println();
        }

        return max;
    }

    public static List<List<Integer>> PascalTriangle(int n) {

        int dp[][] = new int[n][n];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {

                if (i == j || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }

                row.add(dp[i][j]);
            }
            list.add(row);
        }
        return list;
    }

    public static int[] MoveZeros(int nums[]) {

        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }

        while (idx < nums.length) {
            nums[idx++] = 0;

        }
        return nums;
    }

    public static boolean Armstrongnumber(int num) {

        int length = String.valueOf(num).length();
        int org = num;
        int sum = 0;

        while (num > 0) {
            int rem = num % 10;
            sum += Math.pow(rem, length);
            num /= 10;
        }

        if (sum == org) {
            return true;
        }
        return false;

    }

    public static int LengthofNUmber(int num) {
        return String.valueOf(num).length();
    }

    public static int sumofDigits(int num) {

        int sum = 0;

        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }

        return sum;
    }

    public static boolean containsDuplicates(int nums[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        return nums.length != set.size();
    }
    // Happy NUmber

    // Merge Two Sorted Arrays

    public static int kadanesALgo(int nums[]) {
        int max = nums[0];
        int far = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i] + max, nums[i]);
            far = Math.max(far, max);
        }
        return far;

    }

    public static List<String> PrintallSubarrays(String str1) {

        // Brute Force Use need to use Reccursion
        List<String> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = i + 1; j <= str1.length(); j++) {
                String ans = str1.substring(i, j);
                list.add(ans);
                count++;
            }
        }
        System.out.println("Total combinations : " + count);
        return list;
    }

    public static void RotateImage(int nums[][]) {

        // Transposing an Array
        for (int i = 0; i < nums[0].length; i++) {
            for (int j = i; j < nums.length; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }

        // reversing Every Row
        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            int end = nums.length - 1;

            while (start < end) {
                int temp = nums[i][start];
                nums[i][start] = nums[i][end];
                nums[i][end] = temp;
                start++;
                end--;
            }
        }

        for (int num[] : nums) {
            for (int ans : num) {
                System.out.print(ans + " ");
            }
            System.out.println();

        }

    }

    public static int[] StockSpan(int nums[]) {
        // We have to find how mant consecutive days the prices are lower than or equal
        // today
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                // if present element is greater than pop the previous element;
                stack.pop();
            }

            if (stack.isEmpty()) {
                // If entire stack is empty which means there is no greater price before so i+1;
                span[i] = i + 1;
            } else {
                // If not empty there is a greater element and the distance is i-stack.peek()
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;

    }

    public static int[] nextGreaterElement(int nums[]) {
        int n = nums.length;

        int nge[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // next Greater ==> n-1 & nums[i] is greater
        for (int i = n - 1; i >= 0; i--) {

            // If any Element is smaller just pop It out;

            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }

            // if everything poped out which means there is no greater element than the
            // present one so -1;
            // If it doesn't poped out which means that is greater than the present
            nge[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i]);

        }
        return nge;

    }

    public static int[] nextSmallerElement(int nums[]) {

        // next Smaller ==> starts n-1 & nums[i] is smaller
        int n = nums.length;
        int[] nse = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // If any element is bigger than pop it up;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= stack.peek()) {
                stack.pop();
            }
            // If array is empty than there is no element which is smaller so return -1;
            // If its stop popping than the the smallest element is present

            nse[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i]);
        }

        return nse;

    }

    public static int[] PrevGreaterElemnt(int nums[]) {
        int pge[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // previous greater ==> start from 0 && nums[i] is greater
        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }

            pge[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i]);

        }
        return pge;

    }

    public static int[] PrevSmallerelement(int nums[]) {
        int pse[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[i] <= stack.peek()) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return pse;

    }

    public static int[] RisingTemperatures(int nums[]) {
        // We have to find the next warmer day from today
        // Next warmer day ==> Next Greater Element ==> starts from n-1 and arr[i] is
        // greater
        int n = nums.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }

            // if stack is empty there is no warmer day
            // If stack is not empty there is a warmer day at i - stack.peek()
            span[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return span;
    }

    public static int MaxAreaInHistoGram(int nums[]) {

        int n = nums.length;
        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> stack1 = new Stack<>();

        // PSE

        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && nums[i] <= nums[stack1.peek()]) {
                stack1.pop();
            }

            pse[i] = stack1.isEmpty() ? -1 : stack1.peek();

            stack1.push(i);
        }
        stack1.clear();

        // NSE

        for (int i = n - 1; i >= 0; i--) {
            while (!stack1.isEmpty() && nums[i] <= nums[stack1.peek()]) {
                stack1.pop();
            }

            nse[i] = stack1.isEmpty() ? n : stack1.peek();

            stack1.push(i);
        }

        int area = 0;

        for (int i = 0; i < nums.length; i++) {
            int height = nums[i];
            int width = nse[i] - pse[i] - 1;
            area = Math.max(area, height * width);

        }
        return area;

    }

    public static int[] CircularNextGreaterElement(int nums[]) {
        int n = nums.length;
        int cnge[] = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }

            if (i < n) {
                cnge[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return cnge;
    }

    public static int BuyandSellStockI(int nums[]) {

        int max = 0;
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Only we can sell after buying, so find the min till there
            min = Math.min(min, nums[i]);
            // find the diff between the present and the min to get the max
            max = Math.max(max, nums[i] - min);
        }
        return max;

    }

    public static int Buyandsell1(int nums[]) {
        int sell = 0;
        int buy = Integer.MIN_VALUE;

        for (int num : nums) {
            buy = Math.max(buy, -num);
            sell = Math.max(sell, buy + num);

        }
        return sell;
    }

    public static int BuyandSellStock2(int nums[]) {

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                max += nums[i] - nums[i - 1];
            }

        }
        return max;

    }

    public static int BUyandsellStocksin2Transactions(int nums[]) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int num : nums) {

            buy1 = Math.max(buy1, -num);
            sell1 = Math.max(sell1, num + buy1);
            buy2 = Math.max(buy2, sell1 - num);
            sell2 = Math.max(sell2, buy2 + num);

        }
        return sell2;
    }

    public static int BuyandSellinKTransactions(int nums[], int k) {

        int n = nums.length;
        int max = 0;

        if (k >= n / 2) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    max += nums[i] - nums[i - 1];
                }

            }
            return max;

        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int num : nums) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - num);
                sell[i] = Math.max(sell[i], buy[i] + num);
            }

        }

        return sell[k];

    }

    public static void SetMatrixToZeros(int nums[][]) {

        HashSet<Integer> listi = new HashSet<>();
        HashSet<Integer> listj = new HashSet<>();
        for (int i = 0; i < nums[0].length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i][j] == 0) {
                    listi.add(i);
                    listj.add(j);
                }
            }

        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (listi.contains(i) || listj.contains(j)) {
                    nums[i][j] = 0;
                }
            }
        }

        for (int num[] : nums) {
            for (int ans : num) {
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }

    // Celebrity Probalm
    // CoolDown
    // Fees Stocks
    // Largest Rectangle
    // Valid Peranthesis

    public static List<Integer> IndianCoins(int amount) {

        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000 };
        List<Integer> list = new ArrayList<>();
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                list.add(coins[i]);
                amount -= coins[i];
                count++;
            }
        }
        System.out.println("Minimum no. of Demominations : " + count);

        return list;

    }

    public static int CoinchangeMinimumCoins(int num, int coins[]) {

        int dp[] = new int[num + 1];
        Arrays.fill(dp, num + 1);

        dp[0] = 0;

        for (int i = 1; i <= num; i++) {
            // We have to fill all the amount with the min coins required;
            for (int coin : coins) {
                // We have to check with all the possible coins also
                if (coin <= i) {
                    // only if im able to make, I can't make a sum of 5 with 7 rupees coin;
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    // Logic : we already have min required coins at i-coin add 1 coin to that
                }
            }

        }

        for (int number : dp) {

            if (number == num + 1) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(number + " ");

            }

        }
        System.out.println();
        return dp[num] > num ? -1 : dp[num];

    }

    public static int CoinchangeWays(int num, int coins[]) {

        int dp[] = new int[num + 1];
        dp[0] = 1;

        for (int coin : coins) {
            // we have to check the coins to make sure that it cant be repeated ; it comes
            // in ascending order
            for (int i = coin; i <= num; i++) {
                // we have to check till the number
                dp[i] += dp[i - coin];
                // filling like the Version 1; it will check in how many ways dp[i-coin] will
                // check
            }
        }
        for (int number : dp) {
            System.out.print(number + " ");
        }
        System.out.println();
        return dp[num];

    }

    public static boolean EvenOrOdd(int num) {
        return num % 2 == 0 ? true : false;
    }

    // Astroid Collision

    // helper

    public static void Combinations(String str, int index, String curr) {

        if (str.length() == index) {
            System.out.print(curr + " ");
            return;
        }

        // Its Either taking that particular character or not taking it
        Combinations(str, index + 1, curr + str.charAt(index));
        Combinations(str, index + 1, curr);

    }

    public static List<String> SubStrings(String str) {
        List<String> list = new ArrayList<>();
        int Substrcount = 0;
        System.out.println();

        for (int i = 0; i <= str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                list.add(str.substring(i, j));
                Substrcount++;
            }
        }
        System.out.println(Substrcount);
        return list;
    }

    public static void Permutations(char[] arr, int index) {

        if (arr.length - 1 == index) {
            System.out.print(String.valueOf(arr) + " ");
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            Permutations(arr, index + 1);
            swap(arr, index, i);

        }

    }

    // Helper
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static List<List<Integer>> PrintSubarrays(int nums[]) {

        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {
                List<Integer> list = new ArrayList<>();

                for (int k = i; k <= j; k++) {
                    list.add(nums[k]);

                }
                map.add(list);

            }

        }
        return map;

    }

    public static int subarraywithsumk(int nums[], int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            // Finding the diff between the runnig total and K
            int target = sum - k;
            // Looking for extra sum to drop
            // With that gap we'll find the no. of possibilities;
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return count;
    }

    public static int BruteSubarraySumIsK(int nums[], int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }

            }
        }
        return count;
    }

    public static int[][] AddTwoMatrices(int nums1[][], int nums2[][]) {

        int row = nums1.length;
        int col = nums1[0].length;

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = nums1[i][j] + nums2[i][j];
            }

        }

        return matrix;

    }

    public static void DNFAlgo(int nums[]) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swapnums(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swapnums(nums, mid, high);
                high--;

            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    public static void swapnums(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        // int nums1[] = { 11, 4, 3, 4, 5 };
        // int n = 2;
        // int nums2[] = { 5, 10, 6, 9, 6 };
        // int m = 4;
        // int[] ans = MergeArrays(nums1, n, nums2, m);
        // System.out.println(Arrays.toString(ans));

        // int nums[] = { 1, 2, 2, 3, 4, 5, 1, 2, 3, 4 };
        // int k = 2;
        // int[] ans = RemoveElement(nums, k);
        // System.out.println(Arrays.toString(ans));

        // int nums[] = { 1, 2, 2, 3, 4, 5, 1, 2, 3, 4 };
        // HashSet<Integer> ans = RemoveDuplicates(nums);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 2, 2, 4, 5, 1, 2, 3, 4 };
        // int ans = MajorityElement(nums);
        // System.out.println("Max Repeated : " + ans);

        // int nums[] = { 1, 2, 2, 2, 1, 2, 4 };
        // int ans = MajorityElemetMoore(nums);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        // int k = 3;
        // int ans[] = RotateArray(nums, k);
        // System.out.println(Arrays.toString(ans));

        // int nums[] = { 1, 2, 3, 4, 5 };
        // int ans[] = ProductOfArrayExceptItself(nums);
        // System.out.println(Arrays.toString(ans));

        // int nums[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // int ans = MaxWater(nums);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 3, 4, 5 };
        // System.out.println(candy(nums));

        // int nums[] = { 1, 2, 3, 4, 5 };
        // int k = 4;
        // int[] ans = TwoSum(nums, k);
        // System.out.println(Arrays.toString(ans));

        // String str1 = "answer";
        // String str2 = "wetans";
        // boolean ans = ValidAnagrams(str1, str2);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 3, 4, 5, 6 };
        // int ans = HouseRobber(nums);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 3, 4, -1, 0, -4, 3, -2, -1, 8 };
        // int target = 0;
        // List<List<Integer>> ans = ThreeSum(nums, target);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 1, 0, 9 };
        // boolean ans = CanJumpI(nums);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int k = 3;
        // int[] ans = MaxElementSlidingWindow(nums, k);
        // System.out.println(Arrays.toString(ans));

        // int nums[][] = { { 1, 2 }, { 3, 6 }, { 4, 5 }, { 8, 10 } };
        // List<int[]> ans = MergeIntervels(nums);
        // System.out.println(Arrays.toString(ans));

        // String str1 = "korivivenkatakoteswarameenakshireddy";
        // String str2 = "kamasanivenkateswarareddy";
        // int ans = LongestCommanSubSequence(str1, str2);
        // System.out.println(ans);

        // String str3 = "korivivenkatakoteswarameenakshireddy";
        // String str4 = "kamasanivenkateswarareddy";
        // int ans1 = LongestCommanSubString(str3, str4);
        // System.out.println(ans1);

        // int n = 9;
        // System.out.println(PascalTriangle(n));

        // int nums[] = { 1, 0, 2, 0, 3, 0, 40, 5, 0, 6 };
        // int ans[] = MoveZeros(nums);
        // System.out.println(Arrays.toString(ans));

        // System.out.println(Armstrongnumber(92728));

        // System.out.println(LengthofNUmber(24517));

        // System.out.println(sumofDigits(542746));

        // int nums[] = { 1, 2, 3, 4, 5, 5 };
        // System.out.println("Contains Duplicates? " + containsDuplicates(nums));

        // int nums[] = { 1, 2, 3, 3, 4, 6, -2 };
        // System.out.println(kadanesALgo(nums));

        // String str1 = "ABCDEFGHI";
        // System.out.println(PrintallSubarrays(str1));

        // int nums[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // RotateImage(nums);

        // int[] nums = { 100, 80, 90, 60, 65, 85 };
        // int[] ans = StockSpan(nums);
        // System.out.println(Arrays.toString(ans));

        // int[] nums = { 3, 10, 5, 1, 15, 10, 7, 6 };
        // int[] ans1 = nextGreaterElement(nums);
        // int[] ans2 = nextSmallerElement(nums);
        // int[] ans3 = PrevGreaterElemnt(nums);
        // int[] ans4 = PrevSmallerelement(nums);
        // System.out.println("NGE : " + Arrays.toString(ans1));
        // System.out.println("NSE : " + Arrays.toString(ans2));
        // System.out.println("PGE : " + Arrays.toString(ans3));
        // System.out.println("PSE : " + Arrays.toString(ans4));

        // int[] nums = { 13, 12, 15, 11, 9, 12, 16 };
        // int[] ans = RisingTemperatures(nums);
        // System.out.println(Arrays.toString(ans));

        // int nums[] = { 2, 1, 5, 6, 2, 3 };
        // System.out.println(MaxAreaInHistoGram(nums));

        // int nums[] = { 2, 1, 5, 6, 2, 3 };
        // int[] ans = CircularNextGreaterElement(nums);
        // System.out.println(Arrays.toString(ans));

        // int nums[] = { 1, 2, 3, 2, 4, 7, 3, 8 };
        // int ans1 = BuyandSellStockI(nums);
        // int ans11 = Buyandsell1(nums);
        // int ans2 = BuyandSellStock2(nums);
        // int ans3 = BUyandsellStocksin2Transactions(nums);
        // int k = 3;
        // int ans4 = BuyandSellinKTransactions(nums, k);

        // System.out.println("One Transaction : " + ans1);
        // System.out.println("Other Version : " + ans11);
        // System.out.println("Unlimited Transactions : " + ans2);
        // System.out.println("B&SAtmost2Transactions : " + ans3);
        // System.out.println("Buy&SellInKTransactions : " + ans4);

        // int nums[][] = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
        // SetMatrixToZeros(nums);

        // String str = "{{[()]}}";
        // System.out.println(ValidParanthesis(str));

        // int num = 3888;
        // System.out.println(IndianCoins(num));

        // int num = 10;
        // int[] coins = { 1, 2, 5 };
        // System.out.println("Minimum Demominations : " + CoinchangeMinimumCoins(num,
        // coins));
        // System.out.println("Coin Change Ways : " + CoinchangeWays(num, coins));

        // int num = 11;
        // for (int i = 0; i < num; i++) {
        // System.out.println(EvenOrOdd(i));
        // }

        // String str = "ABCD";
        // Combinations(str, 0, "");
        // // System.out.println(SubStrings(str));
        // System.out.println();
        // Permutations(str.toCharArray(), 0);

        // int nums[] = { 2, 4, 6, 2, 8, 2 };
        // System.out.println(PrintSubarrays(nums));
        // System.out.println(subarraywithsumk(nums, 4));
        // System.out.println(BruteSubarraySumIsK(nums, 4));

        // int nums1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int nums2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int ans[][] = AddTwoMatrices(nums1, nums2);
        // System.out.println(Arrays.deepToString(ans));

        // int nums[] = { 0, 1, 2, 0, 1, 2, 0, 2, 1 };
        // DNFAlgo(nums);

    }

}
