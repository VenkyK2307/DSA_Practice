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

    // Stocks 1
    // Stocks 2;

    // Can Jump 1
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

        for (int i = 0; i < nums[0].length; i++) {
            for (int j = i; j < nums.length; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }

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

        int nums[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        RotateImage(nums);

    }

}
