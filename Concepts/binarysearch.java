import java.util.*;

public class binarysearch {
    public static int Binarysearch(int nums[], int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;

            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

    public static boolean StaircaseSearch(int matrix[][], int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = m - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                System.out.println("(" + i + "," + j + ")");
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;

    }

    public static int RotatedSearch(int nums[], int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {

                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            else {
                if (nums[mid] <= target && target < nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;

    }

    public static int MinRotatedSearch(int nums[]) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

    public static void BinarySearch2D(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = (m * n) - 1;

        while (start <= end) {
            int mid = (start + (end - start) / 2);

            if (matrix[mid / m][mid % m] == target) {
                System.out.println("[" + mid / m + " , " + mid % m + "]");
            }

            if (matrix[mid / m][mid % m] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

    }

    public static int AggressiveCows(int nums[], int k) {
        Arrays.sort(nums);

        int start = 1;
        int end = nums[nums.length - 1] - nums[0];
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (CanPlace(nums, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;

    }

    // Helper -- Aggressive cows
    public static boolean CanPlace(int nums[], int k, int dist) {

        int count = 1;
        int lastpos = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - lastpos >= dist) {
                count++;
                lastpos = nums[i];
            }

            if (count == k) {
                return true;
            }
        }
        return false;

    }

    public static List<Integer> KNearestElements(int nums[], int k, int x) {

        int left = 0;
        int right = nums.length - k;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (x - nums[mid] > nums[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = left; i < left + k; i++) {
            list.add(nums[i]);
        }
        return list;

    }

    public static int KOKOEatingbananas(int piles[], int h) {

        int low = 1;
        int high = findMax(piles);

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (CanEatAll(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Helper -- KOKOEatingBanana
    public static boolean CanEatAll(int[] piles, int k, int h) {

        int hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours <= h;

    }

    // Helper -- KOKOEatingBanana
    public static int findMax(int piles[]) {
        int max = 0;
        for (int num : piles) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args) {

        // int nums[] = { 4, 11, 18, 24, 28, 35, 42, 47, 53, 57, };
        // int target = 11;
        // System.out.println(Binarysearch(nums, target));

        // int[][] matrix = {
        // { 1, 4, 7, 11 },
        // { 2, 5, 8, 12 },
        // { 3, 6, 9, 16 },
        // { 10, 13, 14, 17 }
        // };
        // int target = 9;
        // System.out.println(StaircaseSearch(matrix, target));

        // int nums[] = { 28, 35, 42, 47, 53, 57, 4, 11, 18, 24 };
        // int target = 11;
        // System.out.println(RotatedSearch(nums, target));

        // int nums[] = { 28, 35, 42, 47, 53, 57, 4, 11, 18, 24 };
        // System.out.println("Minimum value : " + MinRotatedSearch(nums));

        // int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
        // 14, 15, 16 } };
        // BinarySearch2D(matrix, 6);

        // int nums[] = { 5, 11, 17, 100 };
        // int k = 2;
        // System.out.println(AggressiveCows(nums, k));

        // int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        // int k = 4;
        // int x = 3;
        // System.out.println(KNearestElements(nums, k, x));

        // int piles[] = { 3, 6, 7, 11 };
        // int h = 8;
        // System.out.println(KOKOEatingbananas(piles, h));

    }
}