
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

    public static boolean ArmstrongNumber(int num) {

        int org = num;
        int sum = 0;
        while (num != 0) {
            int rem = num % 10;
            sum += Math.pow(rem, 3.0);
            num = num / 10;
        }

        return sum == org ? true : false;

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

    // public static int MaxsizeRectangle(int[][] matrix) {

    // }

    // public static int MinimumSwapsToSort(int nums[]) {

    // }

    public static void main(String[] args) {

        // int nums[] = { 1,2,3,4,5,6,7 };
        // int target = 4;
        // int result[] = twosum(nums, target);
        // System.out.println("First index " + result[0] + " | Second index " +
        // result[1]);

        // int nums[] = { 1,2,3,4,5,6,7 };
        // System.out.println(duplicates(nums));

        // int n = 143;
        // System.out.println(ArmstrongNumber(n));

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

        // int nums[] = { 1, 2, 3, 4, 5, 6, 6 };
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

        // int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18, 23, 45, 7, 67 };
        // System.out.println(LongestIncreaingSubsequence(nums));

        // int nums[] = { 1, 2, 3, 7 };
        // System.out.println(CanSplitintoTwoEqualArrays(nums));

    }

}
