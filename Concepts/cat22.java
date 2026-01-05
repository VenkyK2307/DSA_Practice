import java.util.HashMap;
import java.util.Map;

public class cat22 {

    public static int longestLenngth(int nums[], int k) {

        int nor = 0;
        int start = 0;
        int length = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nor++;
            }

            while (nor > k) {
                if (nums[start] == 0) {
                    nor--;
                }
                start++;
            }

            length = Math.max(length, i - start + 1);
        }

        return length;
    }

    public static int MajorityElement(int nums[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;

    }

    public static int booths(int Multiplicand, int Multiplier) {

        int product = 0;
        int bits = Integer.toBinaryString(Multiplicand).length();

        for (int i = 0; i < bits; i++) {
            int curr = (Multiplicand & 0b1);
            if (curr == 1) {
                product += Multiplier;
            }

            Multiplier <<= 1;
            Multiplicand >>>= 1;
        }
        return product;
    }

    public static int MaxProductSubarray(int nums[]) {

        int max = nums[0];
        int min = nums[0];
        int far = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);

            far = Math.max(far, max);

        }
        return far;

    }

    public static void main(String[] args) {

        // int nums[] = { 1, 0, 0, 0, 1, 1, 0, 1, 0 };
        // int k = 2;
        // int ans = longestLenngth(nums, k);
        // System.out.println(ans);

        // int ans1 = MajorityElement(nums);
        // System.out.println(ans1);

        // int Multiplicand = -8;
        // int Multiplier = -9;
        // int ans = booths(Multiplicand, Multiplier);
        // System.out.println(ans);

        int nums[] = { 2, 7, 0, 3 };
        int ans = MaxProductSubarray(nums);
        System.out.println(ans);

    }

}
