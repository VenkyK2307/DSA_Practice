import java.util.*;

public class litcoder {

    public static int HouseRobber(int nums[]) {

        int n = nums.length;
        int dp[] = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {

            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        }

        for (int num : dp) {
            System.out.print(num + " ");
        }
        System.out.println();

        return dp[n - 1];

    }

    // Helper

    public static int CountDigits(int num) {

        while (num >= 10) {

            int digitsum = 0;

            while (num > 0) {
                digitsum += num % 10;
                num = num / 10;
            }
            num = digitsum;
        }
        return num;

    }

    public static String GeneratePin(int nums[])

    {

        int n = nums.length;
        int dp[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = CountDigits(nums[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int num : dp) {
            if (num % 2 == 0) {
                sb.append(Integer.toString(num));
            } else {
                char sym = (char) ('a' + num - 1);
                sb.append(sym);
            }
        }

        return sb.toString();

    }

    // Brute Forcing The Pairs divisible by a number

    public static List<List<Integer>> FindPairs(int nums[], int k) {

        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == 9) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    map.add(list);
                }

            }
        }
        return map;

    }

    public static int MigratoryBirds(int nums[]) {

        Arrays.sort(nums);

        int maxcount = 1;
        int count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxcount) {
                maxcount = count;
                return nums[i];
            }
        }
        return -1;

    }

    // FInd the largegst Special Prime Number

    // Helper

    public static boolean IsPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsSpecialPrime(int num) {

        String number = String.valueOf(num);
        String prefix = "";

        for (int i = 0; i < number.length(); i++) {
            prefix = prefix + number.charAt(i);
            int prefixnumber = Integer.parseInt(prefix);

            if (!IsPrime(prefixnumber)) {
                return false;
            }

        }
        return true;

    }

    public static int FindingSpecialPM(int limitnumber) {

        for (int i = limitnumber; i >= 0; i--) {
            if (IsPrime(i) && IsSpecialPrime(i)) {
                return i;
            }
        }
        return -1;
    }

    // Helper
    // Check Polindrome

    public static boolean CheckPolindrome(String name) {

        int left = 0;
        int right = name.length() - 1;

        while (left < right) {

            if (name.charAt(left) != name.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static List<String> WritingAllPolindromeSubStrings(String name) {

        List<String> list = new ArrayList<>(); // All substrings
        List<String> plist = new ArrayList<>();// All Polindrome SubStrings
        int count = 0;

        for (int i = 0; i <= name.length(); i++) {
            for (int j = i + 1; j <= name.length(); j++) {
                list.add(name.substring(i, j));

                String check = name.substring(i, j);
                if (CheckPolindrome(check)) {
                    count++;
                    plist.add(check);
                }
            }
        }
        System.out.println(count);
        return list;

    }

    public static int NoOfPaths(int row, int col) {

        int dp[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < col; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        }

        for (int[] num1 : dp) {
            {
                for (int num : num1) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }

        }

        return dp[row - 1][col - 1];

    }

    public static void main(String args[]) {

        // int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int ans = HouseRobber(nums);
        // System.out.println(ans);

        // Scanner in = new Scanner(System.in);
        // String[] code = in.nextLine().split(" ");
        // int length = code.length;
        // int[] nums = new int[length];

        // for (int i = 0; i < length; i++) {
        // nums[i] = Integer.parseInt(code[i]);
        // }
        // String ans = GeneratePin(nums);
        // System.out.println(ans);
        // in.close();

        // int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // int k = 9;
        // List<List<Integer>> ans = FindPairs(nums, k);
        // System.out.println(ans);

        // int nums[] = { 1, 1, 3, 3, 2, 4, 5, 6 };
        // System.out.println(MigratoryBirds(nums));

        // System.out.print(FindingSpecialPM(400));

        // String name = "Venky";
        // System.out.println(WritingAllPolindromeSubStrings(name));

        System.out.println(NoOfPaths(6, 6));

    }

}
