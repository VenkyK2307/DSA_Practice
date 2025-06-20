import java.util.ArrayList;
import java.util.List;

public class recursion {

    public static void subsets(String str, String ans, int i) {

        if (i == str.length()) {

            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.print(ans + " ");
            }

            return;
        }
        subsets(str, ans + str.charAt(i), i + 1);
        subsets(str, ans, i + 1);

    }

    public static void permutations(String str, String ans) {

        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i + 1);
            permutations(newstr, ans + curr);
        }

    }

    public static boolean IsArraysorted(int nums[], int n) {
        {

            if (n == 0 || n == 1)
                return true;
            return nums[n - 1] >= nums[n - 2] && IsArraysorted(nums, n - 1);
        }

    }

    public static int sum(int n) {
        if (n == 1)
            return 1;

        return n + sum(n - 1);
    }

    public static int fact(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * fact(n - 1);
    }

    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);

    }

    public static void reverse(int nums[], int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        reverse(nums, start + 1, end - 1);

    }

    public static int RecursiveBS(int nums[], int target, int start, int end) {

        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (mid > target) {
            return RecursiveBS(nums, target, start, mid - 1);
        } else {
            return RecursiveBS(nums, target, mid + 1, end);
        }

    }

    public static void PrintNumbersReverse(int n) {

        if (n == 0)
            return;
        System.out.print(n + " ");
        PrintNumbersReverse(n - 1);

    }

    public static void PrintRange(int start, int end) {

        if (start >= end + 1) {// Inclusive of Boundary
            return;
        }

        System.out.print(start + " ");
        PrintRange(start + 1, end);
    }

    public static int Reverse(int n) {

        int sign = (n < 0) ? -1 : 1;
        Math.abs(n);

        int rev = 0;

        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }

        return sign * rev;

    }

    public static boolean Sudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {

                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;
                            if (Sudoku(board)) {
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }

        }
        return true;
    }

    // Helper -- Sudoku
    public static boolean isValid(char[][] board, int row, int col, int c) {

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == 'c')
                return false;
            if (board[row][i] == 'c')
                return false;

            int subrow = 3 * (row / 3) + i / 3;
            int subcol = 3 * (col / 3) + i % 3;

            if (board[subrow][subcol] == c) {
                return false;
            }

        }

        return true;

    }

    // Helper -- Sudoku
    public static void PrintBoard(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-------+--------+------");
            }

            for (int col = 0; col < board[0].length; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print(" | ");
                }

                System.out.print(board[row][col] + " ");

            }
            System.out.println();
        }

    }

    public static void Ratmaze(int[][] maze, int row, int col, String path, boolean vis[][], List<String> paths) {

        int n = maze.length;

        if (row == n - 1 && col == n - 1) {
            paths.add(path);
            return;
        }

        if (row < 0 || col < 0 || row >= n || col >= n || maze[row][col] == 0 || vis[row][col]) {
            return;
        }

        vis[row][col] = true;

        Ratmaze(maze, row + 1, col, path + "D", vis, paths);
        Ratmaze(maze, row, col + 1, path + "R", vis, paths);
        Ratmaze(maze, row - 1, col, path + "U", vis, paths);
        Ratmaze(maze, row, col - 1, path + "L", vis, paths);

        vis[row][col] = false;

    }

    public static boolean knightSTour(int[][] board, int row, int col, int n, int expVal) {

        if (row < 0 || col < 0 || row >= n || col >= n || board[row][col] != expVal) {
            return false;
        }

        if (Math.pow(n, 2) - 1 == expVal) {
            return true;
        }

        boolean ans1 = knightSTour(board, row - 2, col + 1, n, expVal + 1);
        boolean ans2 = knightSTour(board, row - 1, col + 2, n, expVal + 1);
        boolean ans3 = knightSTour(board, row + 1, col + 2, n, expVal + 1);
        boolean ans4 = knightSTour(board, row + 2, col + 1, n, expVal + 1);
        boolean ans5 = knightSTour(board, row + 2, col - 1, n, expVal + 1);
        boolean ans6 = knightSTour(board, row + 1, col - 2, n, expVal + 1);
        boolean ans7 = knightSTour(board, row - 1, col - 2, n, expVal + 1);
        boolean ans8 = knightSTour(board, row - 2, col - 1, n, expVal + 1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;

    }

    public static void main(String[] args) {

        // String str = "ABC";
        // subsets(str, "", 0);

        // String str = "ABC";
        // permutations(str, "");

        // int nums[] = { 1, 2, 3, 4, 5, 6 };
        // System.out.println(IsArraysorted(nums, nums.length));

        // System.out.println(sum(10));

        // int n = 5;
        // System.out.println(fib(n));

        // System.out.println(fib(5));

        // int nums[] = { 1, 2, 3, 4, 5, 6 };
        // reverse(nums, 0, nums.length - 1);
        // for (int num : nums) {
        // System.out.print(num + " ");
        // }

        // int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        // int target = 6;
        // int ans = RecursiveBS(nums, target, 0, nums.length - 1);
        // System.out.println(ans);

        // PrintNumbersReverse(10);

        // PrintRange(1, 10);

        // System.out.println(Reverse(-1234));

        // char[][] board = {
        // { '.', '.', '4', '8', '.', '.', '6', '3', '.' },
        // { '6', '.', '.', '.', '.', '.', '.', '.', '.' },
        // { '.', '.', '.', '.', '.', '1', '.', '.', '.' },
        // { '.', '9', '.', '.', '.', '.', '.', '7', '.' },
        // { '.', '.', '.', '5', '.', '9', '.', '.', '.' },
        // { '.', '2', '.', '.', '.', '.', '.', '4', '.' },
        // { '.', '.', '.', '2', '.', '.', '.', '.', '.' },
        // { '.', '.', '.', '.', '.', '.', '.', '.', '5' },
        // { '.', '3', '1', '.', '.', '7', '2', '.', '.' }
        // };
        // PrintBoard(board);
        // System.out.println("Answer : ");
        // if (Sudoku(board)) {
        // PrintBoard(board);
        // } else {
        // System.out.println("Solution not exist");
        // }

        // int maze[][] = {
        // { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        // { 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 },
        // { 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
        // { 0, 1, 0, 1, 1, 0, 0, 0, 1, 0 },
        // { 0, 1, 0, 0, 0, 1, 0, 0, 1, 0 },
        // { 0, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
        // { 0, 1, 0, 0, 0, 0, 1, 0, 1, 0 },
        // { 1, 1, 1, 1, 1, 0, 1, 1, 1, 0 },
        // { 0, 0, 0, 0, 0, 0, 1, 0, 1, 0 },
        // { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 }
        // };
        // int n = maze.length;
        // boolean vis[][] = new boolean[n][n];
        // List<String> paths = new ArrayList<>();
        // Ratmaze(maze, 0, 0, "", vis, paths);
        // if (paths.isEmpty()) {
        // System.out.println("No paths Exist");
        // } else {
        // for (String path : paths) {
        // System.out.println(path);
        // }
        // System.out.println("NO of Paths : " + paths.size());
        // }

        int[][] board = {
                { 0, 59, 38, 33, 30, 17, 8, 63 },
                { 37, 34, 31, 60, 9, 62, 29, 16 },
                { 58, 1, 36, 39, 32, 27, 18, 7 },
                { 35, 48, 41, 26, 61, 10, 15, 28 },
                { 42, 57, 2, 49, 40, 23, 6, 19 },
                { 47, 50, 45, 54, 25, 20, 11, 14 },
                { 56, 43, 52, 3, 22, 13, 24, 5 },
                { 51, 46, 55, 44, 53, 4, 21, 12 }
        };
        boolean ans = knightSTour(board, 0, 0, board.length, 0);
        System.out.println(ans);

    }

}
