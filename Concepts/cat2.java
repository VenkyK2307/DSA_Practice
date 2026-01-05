import java.util.*;

public class cat2 {

    public static int boothsAlgorithm(int num1, int num2) {

        int product = 0;
        int bits = Integer.toBinaryString(num1).length();

        for (int i = 0; i < bits; i++) {
            int curr = (num1 & 0b1);
            if (curr == 1) {
                product += num2;
            }
            num2 <<= 1;
            num1 >>>= 1;

        }
        return product;

    }

    public static int EuclidianAlgorithm(int a, int b) {

        if (b == 0) {
            return a;
        }
        return EuclidianAlgorithm(b, a % b);

    }

    public static long KaratSuba(long x, long y) {

        if (x < 10 || y < 10) {
            return x * y;
        }

        int n = Math.max(Digits(x), Digits(y));
        int m = n / 2;

        long a = x / (long) Math.pow(10, m);
        long b = x % (long) Math.pow(10, m);
        long c = y / (long) Math.pow(10, m);
        long d = y % (long) Math.pow(10, m);

        long p1 = KaratSuba(a, c);
        long p2 = KaratSuba(b, d);
        long p3 = KaratSuba(a + b, c + d);

        long middle = p3 - p1 - p2;

        return p1 * (long) Math.pow(10, 2 * m) + middle * (long) Math.pow(10, m) + p2;

    }

    // Helper
    public static int Digits(long num) {
        return String.valueOf(num).length();

    }

    public static int LongestSequenceAfterFlipping(int nums[], int k) {

        int nor = 0;
        int start = 0;
        int length = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                nor++;
            }

            while (nor > k) {
                if (nums[start] == 0) {
                    nor--;
                }
                start++;
            }

            length = Math.max(length, end - start + 1);

        }
        return length;

    }

    public static int SwapNibbles(int num) {
        return ((num & 0x0f) << 4) | ((num & 0xf0) >> 4);
    }

    public static void BlockSwapAlgo(int nums[], int k) {
        int n = nums.length;

        int left[] = new int[nums.length];
        int right[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            left[i] = nums[(i + k) % nums.length];
            right[i] = nums[(n - k + i) % nums.length];
        }

        for (int num : left) {
            System.out.print(num + " ");
        }

        System.out.println();
        for (int num : right) {
            System.out.print(num + " ");
        }

    }

    public static int MaxProductSubarray(int nums[]) {

        int max = nums[0];
        int min = nums[0];
        int far = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(Math.max(nums[i], nums[i] * max), nums[i] * min);
            min = Math.min(Math.min(nums[i], nums[i] * max), nums[i] * min);
            max = temp;

            far = Math.max(far, max);

        }

        return far;

    }

    public static int MaxHourGlass(int nums[][]) {

        int max = 0;
        int sum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 0; j < nums.length - 2; j++) {
                sum = nums[i][j] + nums[i][j + 1] + nums[i][j + 2] + nums[i + 1][j + 1] + nums[i + 2][j]
                        + nums[i + 2][j + 1] + nums[i + 2][j + 2];

                max = Math.max(max, sum);

            }
        }
        return sum;

    }

    public static int MaxEquilibriumSum(int nums[]) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftsum = 0;
        int equi = Integer.MIN_VALUE;
        boolean found = true;

        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
            if (total == leftsum) {
                System.out.println("Index : " + i);
                System.out.println("Number at Index " + i + " : " + nums[i]);
                equi = Math.max(equi, leftsum);
                found = true;
            }
            leftsum += nums[i];
        }
        return found ? equi : -1;
    }

    public static List<Integer> LeadersOfArray(int nums[]) {

        List<Integer> list = new ArrayList<>();

        int max = nums[nums.length - 1];
        list.add(nums[nums.length - 1]); // Always the Rightmost

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                list.add(max);
            }
        }

        Collections.reverse(list);

        return list;

    }

    public static int MajorityElement(int nums[]) {

        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count = count + 1;
            } else {
                count = count - 1;
            }

        }
        return candidate;

    }

    public static int HashMapMajorityElement(int nums[]) {
        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {

                max = Math.max(max, entry.getKey());

            }

        }
        return max;

    }

    public static String LexogrphicallyFirstPolindromicsubstring(String string) {

        int[] freq = new int[26];

        for (char c : string.toCharArray()) {
            freq[c - 'a']++;
        }

        int oddcount = 0;

        for (int i = 0; i < 26; i++) {

            if (freq[i] == 1) {
                oddcount++;
            }

        }

        if (string.length() % 2 == 0 && oddcount > 0 || string.length() % 2 == 1 && oddcount != 1) {
            return "NO Polindrome";
        }

        String l = "";
        String m = "";
        for (int i = 0; i < 26; i++) {

            if (freq[i] % 2 == 1 && m.isEmpty()) {
                m += (char) (i + 'a');
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                l += (char) (i + 'a');
            }

        }

        return l + m + new StringBuilder(l).reverse();

    }

    public static void main(String[] args) {

        // int num1 = -3;
        // int num2 = -4;
        // int ans = boothsAlgorithm(num1, num2);
        // System.out.println(ans);

        // int a = 16;
        // int b = 18;
        // int ans = EuclidianAlgorithm(a, b);
        // System.out.println(ans);

        // long x = 1234;
        // long y = 2345;
        // long ans = KaratSuba(x, y);
        // System.out.println(ans);

        // int nums[] = { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 };
        // int k = 2;
        // int ans = LongestSequenceAfterFlipping(nums, k);
        // System.out.println(ans);

        // int num = 100;
        // int ans = SwapNibbles(num);
        // System.out.println(ans);

        // int[] nums = { 1, 2, 3, 4, 5, 6 };
        // int k = 2;
        // BlockSwapAlgo(nums, k);

        // int nums[] = { 1, 2, 3, -4 };
        // int ans = MaxProductSubarray(nums);
        // System.out.println(ans);

        // int nums[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int ans = MaxHourGlass(nums);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 3, 4, 6 };
        // int ans = MaxEquilibriumSum(nums);
        // System.out.println(ans);

        // int nums[] = { 16, 17, 8, 12, 9, 5, 3, 4 };
        // List<Integer> ans = LeadersOfArray(nums);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 2, 2, 1, 4, 2, 5, 2, 2, 2, 2 };
        // int ans = MajorityElement(nums);
        // System.out.println(ans);

        // int nums[] = { 1, 2, 2, 2, 1, 4, 2, 5, 2, 2, 2, 2 };
        // int ans = HashMapMajorityElement(nums);
        // System.out.println(ans);

        String string = "malayalam";
        String ans = LexogrphicallyFirstPolindromicsubstring(string);
        System.out.println(ans);

    }

}
