
import java.util.*;
import java.util.LinkedList;

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

    public static List<Integer> duplicatesnumbers(int nums[]) {

        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (!set.add(num)) {
                list.add(num);
            }
        }

        return list;

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

    public static List<List<Integer>> Target3sum(int nums[], int target) {

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i + 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum > target)
                    k--;
                else if (sum < target)
                    j++;
                else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j > 0 && nums[j] == nums[j + 1])
                        j++;
                    while (k > 0 && nums[k] == nums[k - 1])
                        k--;

                    j++;
                    k--;

                }

            }

        }
        return list;

    }

    public static List<List<Integer>> Targert4sum(int nums[], int target) {

        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;

                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        if (k < l && nums[k] == nums[k + 1])
                            k++;
                        if (k < l && nums[l] == nums[l - 1])
                            l--;

                        k++;
                        l--;

                    }

                }

            }
        }
        return list;

    }

    public static List<List<Integer>> Targert2sum(int nums[], int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = n - 1;

            while (left <= right) {
                int sum = nums[i] + nums[right];

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    list.add(Arrays.asList(nums[i], nums[right]));

                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    while (left < right && nums[left] == nums[left + 1])
                        left++;

                    left++;
                    right--;

                }

            }

        }
        return list;

    }

    public static double Median0f2Arrays(int nums1[], int nums2[]) {

        int n = nums1.length;
        int m = nums2.length;

        int res[] = new int[n + m];

        for (int i = 0; i < n; i++) {
            res[i] = nums1[i];
        }

        for (int i = 0; i < m; i++) {
            res[i + n] = nums2[i];
        }

        Arrays.sort(res);

        int total = res.length;

        if (total % 2 != 0) {
            return res[(total) / 2];
        } else {
            return (res[total / 2] + res[(total / 2) - 1]) / 2.0;
        }

    }

    public static void MaxandMinWindow(int nums[], int k) {

        int n = nums.length;
        int[] small = new int[n - k + 1];
        int[] large = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int j = i; j < k + i; j++) {
                max = Math.max(max, nums[j]);
                large[i] = max;
                min = Math.min(min, nums[j]);
                small[i] = min;
            }

        }

        for (int i = 0; i < small.length; i++) {
            System.out.print(large[i] + " ");

        }
        System.out.println();

        for (int i = 0; i < small.length; i++) {
            System.out.print(small[i] + " ");

        }

        System.out.println();
        return;

    }

    public static HashSet<Integer> CommanElementsSorted(int nums1[], int nums2[], int nums3[]) {

        HashSet<Integer> set = new HashSet<>();

        int i = 0;
        int k = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length && k < nums3.length) {

            if (nums1[i] == nums2[j] && nums2[j] == nums3[k]) {
                set.add(nums1[i]);
                i++;
                j++;
                k++;
            } else {

                int min = Math.min(nums1[i], Math.min(nums2[j], nums3[k]));
                if (nums1[i] == min)
                    i++;
                if (nums2[j] == min)
                    j++;
                if (nums3[k] == min)
                    k++;

            }

        }
        return set;

    }

    public static TreeSet<Integer> CommanElementsUnSorted(int nums1[], int nums2[], int nums3[]) {

        // In treeset sorting also happens;

        TreeSet<Integer> set1 = new TreeSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        TreeSet<Integer> set2 = new TreeSet<>();

        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        TreeSet<Integer> set3 = new TreeSet<>();

        for (int num : nums3) {
            if (set2.contains(num)) {
                set3.add(num);
            }
        }
        return set3;
    }

    public static int MajorityElementMoore(int nums[]) {

        int count = 0;
        int candidate = -1;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count = (candidate == num) ? count + 1 : count - 1;

        }
        return candidate;

    }

    public static void MajorityElementHashMap(int nums[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > nums.length / 2) {
                System.out.println(num);
                return;
            }
        }
        System.out.println("No majority element Found!!");

    }

    public static int[][] RotateMatrix(int matrix[][]) {

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;

            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;

            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();

        }
        return matrix;

    }

    public static List<List<Integer>> COuntInversions(int nums[]) {

        List<List<Integer>> map = new ArrayList<>();

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    map.add(Arrays.asList(nums[i], nums[j]));
                    count++;
                }

            }

        }
        System.out.println("Total Inversions : " + count);

        return map;

    }

    public static List<Integer> MissingAndRepeating(int nums[]) {

        List<Integer> list = new ArrayList<>();

        int n = nums.length;

        int rsum = (n * (n + 1)) / 2;
        int rsqsum = (n * (n + 1) * (2 * n + 1)) / 6;

        int sum = 0;
        int sqsum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sqsum += Math.pow(nums[i], 2);
        }

        int x = rsum - sum;
        int y = rsqsum - sqsum;

        int missing = (x + y) / 2;
        int repeated = Math.abs((x - y) / 2);

        list.add(missing);
        list.add(repeated);

        System.out.println("Missing : " + list.get(0));
        System.out.println("Repeated : " + list.get(1));

        return list;

    }

    public static int[] ReverseBubbleSort(int nums[]) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (nums[j - 1] < nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    public static int NumberofSubarrayWith0sum(int nums[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        int count = 0;
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            // Overlapping also there ;

            if (map.containsKey(sum)) {
                count += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

    }

    public static List<List<Integer>> PrintSubarrays(int nums[]) {

        List<List<Integer>> map = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                List<Integer> list = new ArrayList<>();

                for (int k = i; k <= j; k++) {
                    list.add(nums[k]);

                }

                map.add(list);
            }

        }
        return map;
    }

    public static List<List<Integer>> PrintSubarraysWith0Sum(int nums[]) {
        int n = nums.length;

        List<List<Integer>> map = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {

                sum += nums[j];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    count++;

                    for (int k = i; k <= j; k++) {
                        list.add(nums[k]);
                    }
                    map.add(list);
                }

            }
        }
        System.out.println("No.Of subarrays with 0 sum : " + count);
        return map;

    }

    public static List<List<Integer>> SUbArraySumDivisibleByK(int nums[], int target) {

        List<List<Integer>> map = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum = sum + nums[j];

                if (sum % target == 0) {
                    List<Integer> list = new ArrayList<>();

                    for (int k = i; k <= j; k++) {
                        list.add(nums[k]);
                    }
                    map.add(list);

                }

            }
        }
        return map;

    }

    public static int HashmapSubarraysumDivisiblebyK(int nums[], int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            int mod = sum % target;

            if (mod < 0) {
                mod = mod + target;
            }

            if (map.containsKey(mod)) {
                count += map.get(mod);

            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);

        }
        return count;

    }

    public static boolean CanJump(int nums[]) {

        // Need to solve in DP

        int far = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i > far)
                return false;

            far = Math.max(far, nums[i] + i);
        }
        return true;
    }

    public static int CanJumpII(int nums[]) {
        int jumps = 0;
        int farthest = 0;
        int current = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == current) {
                jumps++;
                current = farthest;
            }

        }

        return jumps;

    }

    public static int[] TopKFrequencyofElements(int nums[], int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // System.out.print(entry.getKey() + " => " + entry.getValue() + " | ");

        // }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        int arr[] = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = pq.poll().getKey();

        }
        return arr;

    }

    public static int[] NoofElementsareComman(int nums1[], int nums2[]) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        int ans1 = 0;
        int ans2 = 0;

        for (int num : nums1) {
            if (set2.contains(num))
                ans1++;
        }

        for (int num : nums2) {
            if (set1.contains(num))
                ans2++;
        }

        return new int[] { ans1, ans2 };
    }

    public static int BuyandSellStockII(int nums[]) {

        int profit = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                profit += nums[i] - nums[i - 1];
            }
        }

        return profit;

    }

    public static int[][] SetMatrixTo0(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    set1.add(i);
                    set2.add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (set1.contains(i) || set2.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return matrix;

    }

    public static List<int[]> MergingOverlappingIntervels(int nums[][]) {

        List<int[]> merged = new ArrayList<>();
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        for (int[] num : nums) {

            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < num[0]) {
                merged.add(num);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(num[1], merged.get(merged.size() - 1)[1]);
            }

        }
        return merged;

    }

    public static int TheCelebrityProblam(int matrix[][]) {

        int n = matrix.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {

            int A = stack.pop();
            int B = stack.pop();

            if (matrix[A][B] == 1) {
                stack.push(B);
            } else
                stack.push(A);

        }

        int candiadte = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != candiadte) {
                if (matrix[candiadte][i] == 1 || matrix[i][candiadte] == 0)
                    return -1;
            }
        }
        return candiadte;

    }

    public static int[] KLargestElements(int nums[], int k) {

        int n = nums.length;

        // Bubble sort

        // for (int i = 0; i < n - 1; i++) {
        // for (int j = 0; j < n - 1 - i; j++) {
        // if (nums[j] > nums[j + 1]) {
        // int temp = nums[j];
        // nums[j] = nums[j + 1];
        // nums[j + 1] = temp;
        // }

        // }

        // }

        Arrays.sort(nums);

        int result[] = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = nums[n - 1 - i];
        }
        return result;

    }

    public static List<Integer> DistinctElementsInKWindowSIze(int nums[], int k) {

        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }
            list.add(set.size());
        }
        return list;

    }

    public static List<List<Integer>> LargestSubArraywith0Sum(int nums[]) {
        int n = nums.length;
        int max = 0;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum == 0) {
                    int len = j - i + 1;

                    if (len > max) {
                        max = len;
                        result.clear();
                    }

                    if (len == max) {
                        List<Integer> list = new ArrayList<>();
                        for (int k = i; k <= j; k++) {
                            list.add(nums[k]);
                        }
                        result.add(list);
                    }

                }

            }

        }
        return result;

    }

    public static int[] DequeueSlidingWindowMaximum(int nums[], int k) {

        int n = nums.length;
        int result[] = new int[n - k + 1];

        // check SW, check values , push Index , push to array

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];

            }
        }

        return result;

    }

    public static String IntegerToRoman(int num) {

        LinkedHashMap<Integer, String> romanMap = new LinkedHashMap<>();

        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            int amount = entry.getKey();
            String symbol = entry.getValue();

            while (num >= amount) {
                sb.append(symbol);
                num -= amount;
            }

        }

        return sb.toString();
    }

    public static int RomantoInteger(String roman) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int value = 0;

        for (int i = 0; i < roman.length() - 1; i++) {
            int curr = map.get(roman.charAt(i));
            int next = map.get(roman.charAt(i + 1));

            if (i + 1 < roman.length() && next > curr) {
                value -= curr;
            } else {
                value += curr;
            }

        }
        value += map.get(roman.charAt(roman.length() - 1));
        return value;

    }

    public static int LongestIncreaingSubsequence(int nums[]) {

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {

            int index = Collections.binarySearch(list, num);

            if (index < 0) {
                index = -(index + 1);
            }

            if (index == list.size()) {
                list.add(num);
            } else {
                list.set(index, num);
            }

        }

        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        return list.size();

    }

    // Sorted and split at i
    public static boolean CanSplitintoTwoEqualArrays(int nums[]) {

        int total = 0;

        for (int num : nums) {
            total += num;

        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            left += nums[i];

            int right = total - left;

            if (left == right) {
                System.out.println("Split at index : " + i);
                return true;

            }

        }
        return false;
    }

    public static int longestConsecutiveSubsequence(int nums[]) {

        HashSet<Integer> set = new HashSet<>();
        int longest = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int curr = num;
                int count = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }

                longest = Math.max(longest, count);

            }

        }
        return longest;

    }

    public static int CandyProblam(int nums[]) {

        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res, 1);

        // Forward Pass
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }

        // BackWardPass
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }

        int sum = 0;

        for (int num : res) {
            sum += num;
        }

        return sum;
    }

    public static int ConvertBinarytoNum(String binary) {

        int index = 0;

        int num = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            int rem = binary.charAt(i) - '0';
            num += rem * Math.pow(2, index);
            index++;
        }

        return num;

    }

    public static String NumtoBinary(int num) {

        if (num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int rem = num % 2;
            sb.append(rem);
            num /= 2;

        }

        return sb.reverse().toString();

    }

    public static int TrappingraianWater(int nums[]) {
        int start = 0;
        int end = nums.length - 1;

        int maxstart = 0;
        int maxend = 0;
        int water = 0;

        while (start < end) {

            if (nums[start] < nums[end]) {

                if (nums[start] >= maxstart) {
                    maxstart = nums[start];
                } else {
                    water += maxstart - nums[start];

                }

                start++;
            }

            else {

                if (nums[end] >= maxend) {
                    maxend = nums[end];
                } else {
                    water += maxend - nums[end];
                }

                end--;
            }

        }
        return water;

    }

    public static int MaxsizeRectanglehistogram(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int max = 0;

        int newHeights[] = Arrays.copyOf(nums, n + 1);

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {

                int height = newHeights[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                max = Math.max(max, height * width);
            }

            stack.push(i);
        }
        return max;

    }

    public static boolean HappyNumber(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSquares(n);
        }
        return n == 1;
    }

    // Helper--(squares of digits)
    public static int getSquares(int n) {
        int rev = 0;
        while (n != 0) {
            int rem = n % 10;
            rev += (rem * rem);
            n /= 10;
        }
        return rev;
    }

    public static int[] NextPermutaion(int nums[]) {

        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;

            while (nums[j] < nums[i]) {
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int start = i + 1;
        int end = n - 1;

        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

    public static boolean Armstrongnumber(int num) {

        int original = num;
        int sum = 0;

        int digits = count(num);

        while (num != 0) {
            int rem = num % 10;

            sum += Math.pow(rem, digits);
            num /= 10;
        }

        return sum == original ? true : false;
    }

    // Helper -- Armstrong Number;
    public static int count(int num) {

        int count = 0;

        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    public static List<Integer> WierdNum(int nums[], int k) {
        // Number should not divisible by K but
        // the nubers digit sum should be divisible by K;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int digits = sumofdigits(nums[i]);

            if (nums[i] % k != 0 && digits % k == 0) {
                {
                    list.add(nums[i]);
                }

            }

        }
        return list;
    }

    // Helper--Wierd Number;
    public static int sumofdigits(int num) {

        int sum = 0;

        while (num != 0) {
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }
        return sum;
    }

    public static boolean IsPerfectNUmber(int num) {

        int sum = 1;

        for (int i = 2; i * i < num; i++) {

            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }

            }
        }
        return sum == num;

    }

    public static void LCMandHCF(int dividend, int divisor) {

        int rem = dividend % divisor;

        if (rem == 0) {
            System.out.println(divisor);
            return;

        }
        LCMandHCF(divisor, rem);

    }

    public static int LastStoneWeight(int nums[]) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }

        while (pq.size() > 1) {

            int y = pq.poll();
            int x = pq.poll();

            if (y != x) {
                pq.add(y - x);
            }

        }

        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static int CountTrailingZerosofFact(int n) {

        int counter = 0;

        while (n > 5) {
            n = n / 5;
            counter += n;
        }
        return counter;
    }

    public static int MaxConsecutiveOnesII(int nums[]) {

        int left = 0;
        int zeros = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static int MaxConsecutiveOnesIII(int nums[], int k) {

        int left = 0;
        int zeros = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {

            // Sliding Window + two Pointer

            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;

                }
                left++;

            }
            max = Math.max(max, right - left + 1);

        }

        return max;

    }

    public static int dayofTheYear(String date) {

        int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // 2020-12-09 format

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int remdays = Integer.parseInt(date.substring(8, 10));

        if (IsLeapYear(year)) {
            months[1] = 29;
        }

        int days = remdays;

        for (int i = 0; i < month - 1; i++) {
            days += months[i];
        }

        return days;

    }

    // Helper
    public static boolean IsLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

    }

    public static int[] MostNoofOnesRow(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int row = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }

            }
            if (count > max) {
                max = count;
                row = i;
            }

        }

        return new int[] { row, max };

    }

    public static int[][] InsertIntervels(int intervels[][], int newIntervel[]) {

        List<int[]> list = new ArrayList<>();

        int i = 0;
        int n = intervels.length;

        while (i < n && intervels[i][1] < newIntervel[0]) {
            list.add(intervels[i]);
            i++;
        }

        while (i < n && intervels[i][0] < newIntervel[1]) {
            newIntervel[0] = Math.min(intervels[i][0], newIntervel[0]);
            newIntervel[1] = Math.max(intervels[i][1], newIntervel[1]);
            i++;

        }
        list.add(newIntervel);

        while (i < n) {
            list.add(intervels[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }

    public static int KthLargestMInHeap(int nums[], int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static int KthSmallestElement(int nums[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();

    }

    public static int findPivotNUmber(int n) {
        int total = (n * (n + 1)) / 2;

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
            if (total == 2 * sum - i) {
                return i;
            }
        }
        return -1;

    }

    public static boolean MeetingRooms(int[][] meetings) {

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] < meetings[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

    public static int MeetingRoomsII(int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(meetings[0][1]);

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] >= pq.peek()) {
                pq.poll(); // If the overlap is not there, no need of new meeting room
            }
            pq.offer(meetings[i][1]);
        }

        return pq.size();

    }

    // same as "Divide array into set of K Consecutive numbers"
    public static boolean handsOfStraight(int nums[], int k) {

        if (nums.length % k != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {

            int first = map.firstKey();

            for (int i = 0; i < k; i++) {
                int card = first + i;

                if (!map.containsKey(card))
                    return false;

                map.put(card, map.get(card) - 1);

                if (map.get(card) == 0) {
                    map.remove(card);
                }
            }
        }

        return true;
    }

    public static int KthSmallestElementinMatrixSorted(int matrix[][], int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }

    public static int[][] KclosestPointstoOrigin(int points[][], int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> distance(b) - distance(a));

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int result[][] = new int[k][2];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            result[idx++] = pq.poll();
        }
        return result;

    }

    // Helper--KClosestPointstoOrigin
    public static int distance(int point[]) {
        return point[0] * point[0] + point[1] * point[1];

    }

    public static int[] SquaresandSortedArray(int nums[]) {

        int n = nums.length;

        int left = 0;
        int right = n - 1;
        int idx = n - 1;
        int res[] = new int[n];

        while (left <= right) {

            int leftsquare = nums[left] * nums[left];
            int rightsquare = nums[right] * nums[right];

            if (leftsquare > rightsquare) {
                res[idx--] = leftsquare;
                left++;

            } else {
                res[idx--] = rightsquare;
                right--;
            }
        }
        Arrays.sort(res);

        return res;
    }

    public static double FindTheMedian(int nums[]) {

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {

            maxheap.offer(num);
            minheap.offer(maxheap.poll());

            if (maxheap.size() < minheap.size()) {
                maxheap.offer(minheap.poll());
            }
        }

        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        } else {
            return maxheap.peek();
        }

    }

    public static int[] SetMismatch(int nums[]) {

        int counter[] = new int[nums.length + 1];
        int res[] = new int[2];

        for (int num : nums) {
            counter[num]++;
        }

        for (int i = 0; i <= nums.length; i++) {
            if (counter[i] == 2) {
                res[0] = i;
            }

            if (counter[i] == 0) {
                res[1] = i;

            }
        }

        return res;
    }

    public static int PlayerandTrainers(int players[], int trainers[]) {

        Arrays.sort(players);
        Arrays.sort(trainers);

        int counter = 0;
        int i = 0;
        int j = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                counter++;
                i++;

            }
            j++;
        }
        return counter;

    }

    public static int LongestConitgiousArrayofZerosandOnes(int nums[]) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i] == 0 ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;

    }

    public static int LongestValidSequencewithCondition(int nums[]) {

        int oddcount = 0;
        int evencount = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                evencount++;
            } else {
                oddcount++;
            }
        }

        int maxp1 = Math.max(evencount, oddcount);

        int prevparity = nums[0] % 2;
        int maxlen = 1;

        for (int i = 1; i < nums.length; i++) {
            int presentparity = nums[i] % 2;

            if (prevparity != presentparity) {
                maxlen++;
                prevparity = presentparity;
            }
        }

        return Math.max(maxp1, maxlen);

    }

    public static int LongestValidSequencewithConditionII(int nums[], int k) {

        int n = nums.length;
        int ans = 1;

        int dp[][] = new int[n][k];

        for (int arr[] : dp) {
            Arrays.fill(arr, 1);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;

                dp[i][mod] = dp[j][mod] + 1;
                ans = Math.max(ans, dp[i][mod]);

            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return ans;

    }

    public static int MInDiffAfterRemovel(int nums[]) {
        int length = nums.length;
        int n = length / 3;

        int[] right = new int[length];
        int[] left = new int[length];

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        int leftsum = 0;

        for (int i = 0; i < length; i++) {
            pq1.offer(nums[i]);
            leftsum += nums[i];

            if (pq1.size() > n) {
                leftsum -= pq1.poll();
            }

            if (pq1.size() == n) {
                left[i] = leftsum;
            }

        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int rightsum = 0;

        for (int i = length - 1; i >= 0; i--) {
            pq2.offer(nums[i]);
            rightsum += nums[i];

            if (pq2.size() > n) {
                rightsum -= pq2.poll();
            }

            if (pq2.size() == n) {
                right[i] = rightsum;
            }

        }

        int mindiff = Integer.MAX_VALUE;

        for (int i = n; i < 2 * n; i++) {
            int diff = left[i] - right[i + 1];
            mindiff = Math.min(diff, mindiff);
        }
        return mindiff;

    }

    public static int[][] Matrix01(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] result = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        int directions[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int curr[] = queue.poll();
            int rows = curr[0];
            int cols = curr[1];

            for (int[] dir : directions) {
                int newrow = rows + dir[0];
                int newcol = cols + dir[1];

                if (newcol >= 0 && newrow >= 0 && newrow < row && newcol < col && !visited[newrow][newcol]) {

                    result[newrow][newcol] = result[rows][cols] + 1;
                    visited[newrow][newcol] = true;
                    queue.add(new int[] { newrow, newcol });

                }

            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        return result;

    }

    public static int NoofSubarraysumequaltoK(int nums[], int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return count;

    }

    public static void main(String[] args) {

        // int nums[] = { 1,2,3,4,5,6,7 };
        // int target = 4;
        // int result[] = twosum(nums, target);
        // System.out.println("First index " + result[0] + " | Second index " +
        // result[1]);

        // int nums[] = { 1,2,3,4,5,6,7 };
        // System.out.println(duplicates(nums));

        // int nums[] = { 1, 2, 3, 3, 4, 2 };
        // System.out.println(duplicatesnumbers(nums));

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

        // int nums[] = { 2, -3, -2, 4 };
        // System.out.println(MaxproductSubarray(nums));

        // int nums[] = { 1, 2, 3, -1, 0, 4, -4, 9, -5, -3, -1 };
        // int target = 0;
        // System.out.println(Target3sum(nums, target));

        // int nums[] = { 1, 2, 3, -1, 0, 4, -4, 9, -5, -3, -1 };
        // int target = 5;
        // List<List<Integer>> result = Targert4sum(nums, target);
        // System.out.println(result);

        // int nums[] = { 1, 2, 3, -1, 0, 4, -4, 9, -5, -3, -1 };
        // int target = 6;
        // List<List<Integer>> result = Targert2sum(nums, target);
        // System.out.println(result);

        // int nums1[] = { 1, 2, 3, 4, 5 };
        // int nums2[] = { 6, 7, 8, 9 };
        // System.out.println(Median0f2Arrays(nums1, nums2));

        // int nums[] = { 1, 2, 3, -1, 0, 4, -4, 9, -5, -3, -1 };
        // int k = 2;
        // MaxandMinWindow(nums, k);

        // int[] nums1 = { 10, 20, 30, 40, 50, 60 };
        // int[] nums2 = { 20, 30, 40, 60, 80, 100, 120 };
        // int[] nums3 = { 30, 60, 90, 120, 150, 180 };
        // System.out.println(CommanElementsSorted(nums1, nums2, nums3));

        // int[] nums1 = { 10, 20, 30, 40, 50, 60 };
        // int[] nums2 = { 10, 30, 40, 60, 50, 100, 120 };
        // int[] nums3 = { 30, 60, 50, 10, 50, 180 };
        // System.out.println(CommanElementsUnSorted(nums1, nums2, nums3));

        // int nums[] = { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 4 };
        // System.out.println(MajorityElementMoore(nums));

        // int nums[] = { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 4 };
        // MajorityElementHashMap(nums);

        // int matrix[][] = {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 } };
        // int[][] rotated = RotateMatrix(matrix);
        // System.out.println(Arrays.toString(rotated));

        // int nums[] = { 2, 1, 5, 4, 6, 3, 0 };
        // List<List<Integer>> result = COuntInversions(nums);
        // System.out.println(result);

        // int nums[] = { 1, 2, 3, 4, 2, 5, 6 };
        // List<Integer> finals = MissingAndRepeating(nums);
        // System.out.println(finals);

        // int nums[] = { 2, 3, 1, 7, 5, 54, 23, 42 };
        // int result[] = ReverseBubbleSort(nums);
        // System.out.println(Arrays.toString(result));

        // int nums[] = { 1, -1, 2, -2, 3, -3 };
        // System.out.println(NumberofSubarrayWith0sum(nums));

        // int nums[] = { 1, -1, 2, -2, 3, -3 };
        // List<List<Integer>> list1 = PrintSubarrays(nums);
        // System.out.println(list1);

        // int nums[] = { 1, -1, 2, -2, 3, -3 };
        // List<List<Integer>> list1 = PrintSubarraysWith0Sum(nums);
        // System.out.println(list1);

        // int nums[] = { 1, -1, 2, -2, 3, -3 };
        // int target = 4;
        // List<List<Integer>> list1 = SUbArraySumDivisibleByK(nums, target);
        // System.out.println(list1);

        // int nums[] = { 1, -1, 2, -2, 3, -3, 9 };
        // int target = 1;
        // System.out.println(HashmapSubarraysumDivisiblebyK(nums, target));

        // int nums[] = { 3, 2, 1, 0, 4 };
        // System.out.println(CanJump(nums));

        // int nums[] = { 2, 3, 1, 1, 4 };
        // System.out.println(CanJumpII(nums));

        // int nums[] = { 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5 };
        // int result[] = TopKFrequencyofElements(nums, 2);
        // System.out.println(Arrays.toString(result));

        // int nums1[] = { 1, 1, 2 };
        // int nums2[] = { 1, 2, 2, 2, 3 };
        // int arr[] = NoofElementsareComman(nums1, nums2);
        // System.out.println(Arrays.toString(arr));

        // int nums[] = { 7, 1, 5, 3, 6, 4 };
        // System.out.println(BuyandSellStockII(nums));

        // int[][] matrix = { { 5, 1, 4, 11 },
        // { 2, 6, 6, 8 },
        // { 2, 3, 0, 7 },
        // { 10, 13, 14, 1 } };
        // int[][] setmatrix = SetMatrixTo0(matrix);
        // System.out.println(Arrays.toString(setmatrix));

        // int[][] matrix = { { 1, 3 },
        // { 1, 10 },
        // { 2, 3 },
        // { 4, 5 },
        // { 6, 9 } };
        // List<int[]> result = MergingOverlappingIntervels(matrix);
        // for (int res[] : result) {
        // System.out.print(Arrays.toString(res) + " ");
        // }

        // int[][] matrix = {
        // { 0, 1, 0, 1, 0 }, // Person 0 knows 1 and 3
        // { 0, 0, 1, 1, 0 }, // Person 1 knows 2 and 3
        // { 1, 0, 0, 1, 0 }, // Person 2 knows 0 and 3
        // { 0, 0, 0, 0, 0 }, // Person 3 knows no one ✅
        // { 1, 0, 0, 1, 0 } // Person 4 knows 0 and 3
        // };
        // System.out.println(TheCelebrityProblam(matrix));

        // int nums[] = { 9, 10, 11, 1, 2, 3, 4, 12, 5, 6, 13, 7, 8 };
        // int k = 3;
        // int res[] = KLargestElements(nums, k);
        // System.out.println(Arrays.toString(res));

        // int nums[] = { 1, 2, 6, 3, 4, 6, 6 };
        // int k = 4;
        // System.out.println(DistinctElementsInKWindowSIze(nums, k));

        // int nums[] = { 1, -1, 2, -2, 3, -3, 5 };
        // System.out.println(LargestSubArraywith0Sum(nums));

        // int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        // int k = 3;
        // int arr[] = DequeueSlidingWindowMaximum(nums, k);
        // System.out.println(Arrays.toString(arr));

        // int num = 1994;
        // System.out.println(IntegerToRoman(num));

        // String roman = "LVIII";
        // System.out.println(RomantoInteger(roman));

        // int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18, 23, 45, 7, 67 };
        // System.out.println(LongestIncreaingSubsequence(nums));

        // int nums[] = { 1, 2, 3, 7 };
        // System.out.println(CanSplitintoTwoEqualArrays(nums));

        // int nums[] = { 10, 9, 4, 5, 8, 6, 101, 11, 23, 45, 7, 67 };
        // System.out.println(longestConsecutiveSubsequence(nums));

        // int nums[] = { 1, 2, 0, 3, 5 };
        // System.out.println(CandyProblam(nums));

        // String binary = "10010101011010101";
        // System.out.println(ConvertBinarytoNum(binary));

        // int num = 76501;
        // System.out.println(NumtoBinary(num));

        // int nums[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // System.out.println(TrappingraianWater(nums));

        // int nums[] = { 2, 1, 5, 6, 2, 3 };
        // System.out.println(MaxsizeRectanglehistogram(nums));

        // int n = 19;
        // System.out.println("Is happy number : " + HappyNumber(n));

        // int nums[] = { 1, 6, 2, 5, 4 };
        // int arr[] = NextPermutaion(nums);
        // System.out.println(Arrays.toString(arr));

        // int num = 548814;
        // boolean ans = Armstrongnumber(num);
        // System.out.println(ans);

        // int nums[] = { 23, 41, 40, 64, 55, 73 };
        // int k = 5;
        // System.out.println(WierdNum(nums, k));

        // int num = 28;
        // System.out.println(IsPerfectNUmber(num));

        // int dividend = 36;
        // int divisor = 12;
        // LCMandHCF(dividend, divisor);

        // int nums[] = { 2, 7, 4, 1, 8, 1 };
        // System.out.println(LastStoneWeight(nums));

        // int n = 60;
        // System.out.println(CountTrailingZerosofFact(n));

        // int nums[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        // int k = 2;
        // System.out.println(MaxConsecutiveOnesIII(nums, k));

        // int nums2[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        // System.out.println(MaxConsecutiveOnesII(nums2));

        // String date = "2024-02-10";
        // System.out.println(dayofTheYear(date));

        // int[][] matrix = {
        // { 0, 0, 1, 0, 0 },
        // { 1, 1, 0, 1, 0 },
        // { 0, 1, 1, 1, 1 },
        // { 0, 0, 0, 1, 1 }
        // };
        // int[] arr = MostNoofOnesRow(matrix);
        // System.out.println(Arrays.toString(arr));

        // int[][] intervals = { { 1, 3 }, { 6, 9 } };
        // int[] newInterval = { 2, 5 };
        // int[][] result = InsertIntervels(intervals, newInterval);
        // System.out.println(Arrays.deepToString(result));

        // int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        // int k = 3;
        // System.out.println(KthLargestMInHeap(nums, k));
        // System.out.println(KthSmallestElement(nums, k));

        // int n = 8;
        // System.out.println(findPivotNUmber(n));

        // int[][] meetings = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        // System.out.println(MeetingRooms(meetings));

        // int[][] meetings = { { 0, 6 }, { 5, 10 }, { 4, 20 } };
        // System.out.println(MeetingRoomsII(meetings));

        // int nums[] = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        // int k = 3;
        // System.out.println(handsOfStraight(nums, k));

        // int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int k = 4;
        // System.out.println(KthSmallestElementinMatrixSorted(matrix, k));

        // int points[][] = { { 1, 2 }, { 2, 1 }, { 4, 5 }, { 2, 3 } };
        // int k = 3;
        // int[][] result = KclosestPointstoOrigin(points, k);
        // System.out.println(Arrays.deepToString(result));

        // int nums[] = { -2, 9, -3, -6, 8, 10 };
        // int arr[] = SquaresandSortedArray(nums);
        // System.out.println(Arrays.toString(arr));

        // int nums[] = { 2, 3, 1, 5, 4, 8, 6, 7, 9 };
        // System.out.println(FindTheMedian(nums));

        // int nums[] = { 1, 2, 3, 4, 4, 6, 7 };
        // int[] arr = SetMismatch(nums);
        // System.out.println(Arrays.toString(arr));

        // int[] players = { 4, 7, 9 };
        // int[] trainers = { 8, 2, 5, 8 };
        // System.out.println(PlayerandTrainers(players, trainers));

        // int nums[] = { 0, 1, 0, 1, 1, 0, 0, 1 };
        // System.out.println(LongestConitgiousArrayofZerosandOnes(nums));

        // int nums[] = { 1, 2, 1, 2, 3, 1, 2, 3, 4 };
        // System.out.println(LongestValidSequencewithCondition(nums));

        // int nums[] = { 1, 2, 3, 4, 5 };
        // System.out.println(LongestValidSequencewithConditionII(nums, 2));

        // int nums[] = { 7, 9, 5, 8, 1, 3 };
        // System.out.println(MInDiffAfterRemovel(nums));

        // int matrix[][] = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
        // int res[][] = Matrix01(matrix);
        // System.out.println(Arrays.deepToString(res));

        // int nums[] = { 1, 2, 3, 4 };
        // int k = 1;
        // System.out.println(NoofSubarraysumequaltoK(nums, k));

    }
}
