import java.util.*;

public class arrays {

    public static int[] twosum(int[] nums, int target) {

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

    public static boolean duplicates(int nums[]) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return nums.length != set.size();
    }

    public static int kadenes(int nums[]) {

        int n = nums.length;

        int currsum = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {

            currsum = Math.max(nums[i], currsum + nums[i]);
            max = Math.max(max, currsum);

        }
        return max;

    }

    public static int[] reverse(int nums[]) {

        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }

        return nums;
    }

    public static int BuyandSellStock(int prices[]) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < n; i++) {

            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);

        }
        return max;

    }

    public static int MostWater(int heights[]) {

        int left = 0;
        int right = heights.length - 1;

        int max = 0;

        while (left <= right) {

            max = Math.max(max, Math.min(heights[right], heights[left]) * (right - left));
            if (heights[left] > heights[right])
                right--;
            else {
                left++;
            }
        }

        return max;

    }

    public static int MaxConsiquitiveOnes(int nums[]) {

        int count = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            }

            else {
                count = 0;
            }
        }
        return max;
    }

    public static int[] MoveZeros(int nums[]) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
        return nums;

    }

    public static int GasStation(int[] cost, int[] gas) {

        int total = 0;
        int curr = 0;
        int start = 0;

        for (int i = 0; i < cost.length; i++) {

            curr += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if (curr < 0) {
                start = start + 1;
                curr = 0;
            }

        }

        return total < 0 ? -1 : start;

    }

    public static int NoOfFactors(int n) {
        int count = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {

                if (n == i * i) {
                    count = count + 1;
                } else {
                    count = count + 2;
                }

            }

        }
        return count;

    }

    public static void SpiralMatrix(int[][] matrix) {

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }

            for (int i = top + 1; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }

            if (left < right) {
                for (int j = right - 1; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
            }

            if (top < bottom) {
                for (int i = bottom - 1; i > top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
            }

            top++;
            right--;
            left++;
            bottom--;
        }

        return;

    }

    public static int DiagonalSum(int[][] matrix) {

        int sum = 0;
        int n = matrix.length;

        for (int i = 0; i < matrix.length; i++) {

            sum = sum + matrix[i][i];
            sum = sum + matrix[i][n - 1 - i];

        }

        if (n % 2 != 0) {
            sum = sum - matrix[n / 2][n / 2];
        }

        return sum;
    }

    public static int[] SlidingWindowSum(int nums[], int k) {
        int n = nums.length;

        if (n < k) {
            System.out.println("Sliding sum not possible");
            return new int[0];
        }

        int res[] = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];

            }
            res[i] = sum;

        }
        return res;

    }

    public static int[] SlidingWindowMax(int nums[], int k) {
        int n = nums.length;

        if (n < k) {
            System.out.println("Sliding sum not possible");
            return new int[0];
        }

        int res[] = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = 0;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;

        }
        return res;

    }

    public static List<List<Integer>> ThreeSum(int nums[]) {

        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (j < k && nums[k] == nums[k - 1])
                        k--;

                    j++;
                    k--;

                }

            }

        }
        return list;

    }

    public static void MinAndMax(int nums[]) {

        // for VOID return no need of using Sysytem.out.println();

        int large = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > large) {
                large = nums[i];
            }
        }

        int small = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < small) {
                small = nums[i];
            }

        }

        System.out.println("The largest element : " + large);
        System.out.println("The smallest element : " + small);

    }

    public static void KLargestSmallest(int nums[], int k) {

        int n = nums.length;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] >= nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        System.out.println("K - Largest element : " + nums[k - 1]);
        System.out.println("K - Smallest element : " + nums[n - k]);

    }

    public static List<int[]> Sumpair(int nums[], int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];

            if (map.containsKey(comp)) {
                int[] arr = new int[] { nums[i], comp };
                list.add(arr);
            }
            map.put(nums[i], i);

        }
        return list;

    }

    public static int[] ProductOFArrayExceptItself(int nums[]) {
        int n = nums.length;

        int[] left = new int[n];
        int[] prod = new int[n];

        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int rprod = 1;
        for (int i = n - 1; i >= 0; i--) {
            prod[i] = left[i] * rprod;

            rprod = rprod * nums[i];
        }

        return prod;

    }

    public static int MaxproductSubarray(int nums[]) {
        int far = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if (curr < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            // Both min and Max we have to check..
            min = Math.min(min * curr, curr);
            max = Math.max(max * curr, curr);

            // far and max => maximum;
            far = Math.max(far, max);

        }
        return far;

    }

    public static void main(String[] args) {

        // int nums[] = { 1,2,3,4,5,6,7 };
        // int target = 4;
        // int result[] = twosum(nums, target);
        // System.out.println("First index " + result[0] + " | Second index " +
        // result[1]);

        // int nums[] = { 1,2,3,4,5,6,7 };
        // System.out.println(duplicates(nums));

        // int nums[] = { -8, -3, -6, -2, -5, -4 };
        // System.out.println(kadenes(nums));

        // int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        // int[] reverse = reverse(nums);
        // System.out.println(Arrays.toString(reverse));

        // int prices[] = { 7, 1, 5, 3, 6, 4 };
        // System.out.println(BuyandSellStock(prices));

        // int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // System.out.println(MostWater(heights));

        // int nums[] = { 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1 };
        // System.out.println(MaxConsiquitiveOnes(nums));

        // int nums[] = { 1, 0, 3, 0, 5, 0, 2, 5, 0, 0, 6 };
        // int arr[] = MoveZeros(nums);
        // System.out.println(Arrays.toString(arr));

        // int gas[] = { 1, 2, 3, 4, 5 };
        // int cost[] = { 3, 4, 5, 1, 2 };
        // System.out.println(GasStation(cost, gas));

        // int n = 36;
        // System.out.println(NoOfFactors(n));

        // int[][] matrix = {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 }
        // };
        // SpiralMatrix(matrix);

        // int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // System.out.println(DiagonalSum(matrix));

        // int nums[] = { 1, 0, 3, 0, 5, 0, 2, 5, 0, 0, 6 };
        // int[] ans = SlidingWindowSum(nums, 3);
        // for (int val : ans) {
        // System.out.print(val + " ");
        // }

        // int nums[] = { 1, 0, 3, 0, 5, 0, 2, 5, 0, 0, 6 };
        // int[] ans = SlidingWindowMax(nums, 3);
        // for (int val : ans) {
        // System.out.print(val + " ");
        // }

        // int nums[] = { 1, 2, 3, -1, 0, 4, -4, 9, -5, -3, -1 };
        // System.out.print(ThreeSum(nums) + " ");

        // int nums[] = { 1, 2, 3, 4, 1, 2, 3, 4, -10, 9 };
        // MinAndMax(nums);

        // int nums[] = { -2, 1, 6, 5, -3, 4, 8, -75, 10 };
        // int k = 4;
        // KLargestSmallest(nums, k);

        // int nums[] = { 1, 2, 4, -1, 6, 5, -2, -3 };
        // int target = 3;
        // List<int[]> result = Sumpair(nums, target);
        // for (int[] pair : result) {
        // System.out.print(pair[0] + "," + pair[1] + " ");
        // }

        // int nums[] = { 2, 4, 0, 5, 8 };
        // int res[] = ProductOFArrayExceptItself(nums);
        // System.out.println(Arrays.toString(res));

        int nums[] = { 2, -3, -2, 4 };
        System.out.println(MaxproductSubarray(nums));

    }

}
