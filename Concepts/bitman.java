import java.util.HashSet;

public class bitman {

    public static void Operations(int n, int m) {

        // AND
        System.out.println(n & m);
        // OR
        System.out.println(n | m);
        // XOR
        System.out.println(n ^ m);
        // COMPLEMENT
        System.out.println(~n);
        // LEFT SHIFT
        System.out.println(n << 2);
        // RIGHT SHIFT
        System.out.println(n >> 2);
    }

    public static void EvenOrOdd(int n) {
        int Bitmask = 1;
        int sign = (n & Bitmask);

        String result = (sign == 0) ? "even" : "odd";
        System.out.println(result);

    }

    public static void getIthBit(int n, int i) {
        int bitmask = 1 << i;
        int sign = (n & bitmask);

        int result = (sign == 0) ? 0 : 1;
        System.out.println(result);
    }

    public static int SetiThbit(int n, int i) {

        int bitmask = 1 << i;
        return n | bitmask;

    }

    public static int ClearIthBit(int n, int i) {

        int bitmask = ~(1 << i);
        return n & bitmask;

    }

    public static int UpdateIthBit(int n, int i, int newbit) {
        if (newbit == 0) {
            return ClearIthBit(n, i); // n & ~(1<<i)
        } else {
            return SetiThbit(n, i); // n | (1<<i)
        }

    }

    public static int clearIbits(int n, int i) {

        int bitmask = (~0) << i; // (~0)<<i = 11111100
        return n & bitmask; // 00001111 & 11111100 = 00001100
    }

    public static int CLearBitsInRange(int n, int i, int j) {

        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;

        int bitmask = a | b;
        return n & bitmask;

    }

    public static boolean IsPoweroftwo(int n) {
        return ((n & (n - 1)) == 0);
    }

    public static int CountBits(int n) {
        int count = 0;

        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static double fastExpo(double a, int n) {

        double ans = 1.0;
        long power = n;

        if (power < 0) {
            a = 1 / a;
            power = -power;

        }

        while (power > 0) {
            if ((power & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            power >>= 1;

        }
        return ans;
    }

    public static int[] CountNoOfones(int n) {

        // DP approach
        int dp[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;

    }

    public static int ReverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 8; i++) {

            int lastBit = n & 1;
            result <<= 1;
            result = result | lastBit;
            n >>= 1;
        }
        return result;
    }

    public static int addTwoNUmbers(int a, int b) {

        while (b != 0) {
            int carry = a & b;// Finds carry
            a = a ^ b;// Adds Wihout Carry
            b = carry << 1;
        }
        return a;
    }

    public static int FindUniqueNumber(int nums[]) {

        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public static int FindUniqueNumberII(int nums[]) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;

            for (int num : nums) {
                if (((num >> i) & 1) == 0) {
                    sum++;
                }
            }

            if (sum % 3 != 0) {
                result = result | (1 << i);
            }

        }
        return result;
    }

    static int count = 0;
    static int max = 0;

    public static int FindMaximumXORSubarrays(int nums[]) {

        for (int num : nums) {
            max = max | num;
        }

        backtrackXOR(nums, 0, 0);
        return count;
    }

    // Helper -- XOR Subarray
    public static void backtrackXOR(int nums[], int idx, int curr) {
        if (nums.length == idx) {
            if (max == curr) {
                count++;
            }
            return;
        }

        backtrackXOR(nums, idx + 1, curr);
        backtrackXOR(nums, idx + 1, curr | nums[idx]);
    }

    public static int LongestLengthbitwiseAND(int nums[]) {

        int maxval = 0;

        for (int num : nums) {
            maxval = Math.max(maxval, num);
        }

        int count = 0;
        int length = 0;

        for (int num : nums) {
            if (maxval == num) {
                count++;
                length = Math.max(count, length);
            } else {
                count = 0;
            }

        }

        return length;

    }

    public static int BitwiseORs(int nums[]) {

        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();

        for (int num : nums) {
            HashSet<Integer> curr = new HashSet<>();
            curr.add(num);

            for (int p : prev) {
                curr.add(num | p);
                // For all the combinatios
            }

            res.addAll(curr);
            prev = curr;
        }

        return res.size();
    }

    public static void main(String[] args) {

        // Operations(5, 6);

        // EvenOrOdd(10);
        // EvenOrOdd(11);

        // getIthBit(10, 0);// 1010
        // getIthBit(10, 1); //1010

        // System.out.println(SetiThbit(5, 1)); //101
        // System.out.println(SetiThbit(10, 2)); //1010

        // System.out.println(ClearIthBit(10, 3)); //1010

        // System.out.println(UpdateIthBit(10, 2, 1));
        // System.out.println(UpdateIthBit(10, 3, 0));

        // System.out.println(clearIbits(15, 2));

        // System.out.println(CLearBitsInRange(10, 2, 4));

        // System.out.println(IsPoweroftwo(17));

        // System.out.println(CountBits(31));

        // System.out.println(fastExpo(2.4, 2));

        // int arr[] = CountNoOfones(5);
        // System.out.println(Arrays.toString(arr));

        // int n = 11;
        // int reversed = ReverseBits(n);
        // System.out.println("Original (decimal): " + n);
        // System.out.println("Original (binary) : " + String.format("%4s",
        // Integer.toBinaryString(n)).replace(' ', '0'));
        // System.out.println("Reversed (decimal): " + reversed);
        // System.out.println(
        // "Reversed (binary) : " + String.format("%4s",
        // Integer.toBinaryString(reversed)).replace(' ', '0'));

        // int a = 5;
        // int b = 7;
        // System.out.println(addTwoNUmbers(a, b));

        // int nums[] = { 1, 1, 2, 3, 5, 5, 3, 4, 4 };
        // System.out.println(FindUniqueNumber(nums));

        // int nums2[] = { 1, 1, 1, 6, 5, 5, 5, 4, 4, 4 };
        // System.out.println(FindUniqueNumber(nums2));

        // int nums[] = { 2, 2, 2 };
        // System.out.println(FindMaximumXORSubarrays(nums));

        // int nums[] = { 1, 2, 3, 3, 2, 2 };
        // System.out.println(LongestLengthbitwiseAND(nums));

        // int nums[] = { 1, 2, 4 };
        // System.out.println(BitwiseORs(nums));
    }

}
