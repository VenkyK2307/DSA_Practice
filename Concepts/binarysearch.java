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

    }
}