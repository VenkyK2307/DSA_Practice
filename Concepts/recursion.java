import java.util.*;

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

    // helper -- NQueens
    public static boolean isSafe(char board[][], int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;

            }

        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;

            }

        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }

        }
        return true;

    }

    static int count = 0;

    public static void Nqueens(char board[][], int row) {

        if (row == board.length) {
            count++;
            PrintBoardChess(board);
            return;
        }

        int n = board.length;

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                Nqueens(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    // Helper -NQueen
    public static void PrintBoardChess(char[][] board) {
        int n = board.length;
        System.out.println("_______");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Helper -- combination Sum
    public static void CombineSum(int nums[], int idx, int target, List<List<Integer>> map, List<Integer> set) {

        if (target < 0 || idx >= nums.length) {
            return;
        }

        if (target == 0) {
            map.add(new ArrayList<>(set));
            return;
        }

        set.add(nums[idx]);

        // Include and Reuse
        // Stays on the same idx;
        CombineSum(nums, idx, target - nums[idx], map, set);

        // Not Include
        // Moves to the next Idx , when not using
        set.remove(set.size() - 1);
        CombineSum(nums, idx + 1, target, map, set);

    }

    public static List<List<Integer>> CombinationSum(int nums[], int target) {

        List<List<Integer>> map = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        CombineSum(nums, 0, target, map, set);

        return map;
    }

    public static void Parts(String str, List<List<String>> map, List<String> set) {

        if (str.length() == 0) {
            map.add(new ArrayList<>(set));
            return;

        }

        for (int i = 0; i < str.length(); i++) {
            String part = str.substring(0, i + 1);
            if (IsPolindrome(part)) {
                set.add(part);
                Parts(str.substring(i + 1), map, set);
                set.remove(set.size() - 1);
            }
        }

    }

    public static boolean IsPolindrome(String string) {

        int e = string.length() - 1;
        int s = 0;

        while (s < e) {
            if (string.charAt(s) != string.charAt(e)) {
                return false;
            }
            s++;
            e--;

        }

        return true;

    }

    public static List<List<String>> PolindromeParts(String str) {

        List<List<String>> map = new ArrayList<>();
        List<String> set = new ArrayList<>();

        Parts(str, map, set);
        return map;

    }

    // Helper for merge sort;
    public static int[] Merge(int nums[], int start, int mid, int end) {
        List<Integer> temp = new ArrayList<>();

        int i = start;
        int j = mid + 1;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
            }
        }

        while (i <= mid) {
            temp.add(nums[i]);
            i++;
        }

        while (j <= end) {
            temp.add(nums[j]);
            j++;

        }

        for (int idx = 0; idx < temp.size(); idx++) {
            nums[start + idx] = temp.get(idx);

        }
        return nums;

    }

    public static void MergeSort(int nums[], int start, int end) {

        if (start < end) {
            int mid = start + (end - start) / 2;

            // Left
            MergeSort(nums, start, mid);

            // Right
            MergeSort(nums, mid + 1, end);

            Merge(nums, start, mid, end);

        }

    }

    public static void reverseArray(int nums[], int k) {

        int n = nums.length;
        k = k % n;

        rev(nums, 0, n - 1);

        rev(nums, 0, k - 1);
        rev(nums, k, n - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    // Helper - reverse array
    public static void rev(int nums[], int start, int end) {

        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;

        }
    }

    public static List<List<Integer>> CombinationSumII(int nums[], int target) {

        List<List<Integer>> map = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums, 0, target, set, map);

        return map;
    }

    // Helper -- Combination Sum
    public static void backtrack(int nums[], int start, int target, List<Integer> set, List<List<Integer>> map) {

        if (target == 0) {
            map.add(new ArrayList<>(set));
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;

            if (nums[i] > target)
                break;

            set.add(nums[i]);
            backtrack(nums, i + 1, target - nums[i], set, map);
            set.remove(set.size() - 1);

        }
    }

    public static List<List<Integer>> Permutations(int nums[]) {

        List<List<Integer>> map = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        permubacktrack(nums, map, set);

        return map;
    }

    // Helper -- Permutations
    public static void permubacktrack(int nums[], List<List<Integer>> map, List<Integer> set) {
        if (set.size() == nums.length) {
            map.add(new ArrayList<>(set));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i]))
                continue;

            set.add(nums[i]);
            permubacktrack(nums, map, set);
            set.remove(set.size() - 1);

        }

    }

    public static List<String> GenerateParantheses(int n) {

        List<String> map = new ArrayList<>();
        GPBacktrack("", n, 0, 0, map);
        return map;
    }

    // Helper -- Generate perantheses
    private static void GPBacktrack(String curr, int max, int open, int close, List<String> map) {

        if (curr.length() == 2 * max) {
            map.add(curr);
            return;
        }

        if (open < max) {
            GPBacktrack(curr + "(", max, open + 1, close, map);
        }

        if (close < open) {
            GPBacktrack(curr + ")", max, open, close + 1, map);
        }

    }

    public static List<List<Integer>> Subsets1(int nums[]) {
        List<List<Integer>> map = new ArrayList<>();
        SSBacktrack(map, new ArrayList<>(), nums, 0);
        return map;
    }

    // Helper - Subset 1
    private static void SSBacktrack(List<List<Integer>> map, List<Integer> set, int[] nums, int start) {

        map.add(new ArrayList<>(set));
        for (int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            SSBacktrack(map, set, nums, i + 1);
            set.remove(set.size() - 1);

        }
    }

    public static List<List<Integer>> Subset2(int nums[]) {
        List<List<Integer>> map = new ArrayList<>();
        Arrays.sort(nums);
        SSTBacktrack(map, new ArrayList<>(), nums, 0);
        return map;

    }

    // Helper -- subset 2
    public static void SSTBacktrack(List<List<Integer>> map, List<Integer> set, int[] nums, int start) {

        map.add(new ArrayList<>(set));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1])
                continue;
            set.add(nums[i]);
            SSTBacktrack(map, set, nums, i + 1);
            set.remove(set.size() - 1);

        }
    }

    public static List<List<Integer>> Permutations1(int[] nums) {

        List<List<Integer>> map = new ArrayList<>();
        P1Backtrack(map, new ArrayList<>(), nums);
        return map;

    }

    // Helper -- Permutation1
    public static void P1Backtrack(List<List<Integer>> map, List<Integer> set, int[] nums) {

        if (set.size() == nums.length) {
            map.add(new ArrayList<>(set));
        }

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            P1Backtrack(map, set, nums);
            set.remove(set.size() - 1);
        }

    }

    public static List<List<Integer>> Permutations2(int nums[]) {

        List<List<Integer>> map = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        P2backtrack(map, new ArrayList<>(), nums, used);

        return map;
    }

    public static void P2backtrack(List<List<Integer>> map, List<Integer> set, int nums[], boolean used[]) {

        if (set.size() == nums.length) {
            map.add(new ArrayList<>(set));
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            set.add(nums[i]);

            used[i] = true;
            P2backtrack(map, set, nums, used);

            used[i] = false;
            set.remove(set.size() - 1);

        }
    }

    public static int NoofIslands(char grid[][]) {
        if (grid == null || grid.length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    searchforIslands(grid, i, j);
                    count++;
                }

            }
        }
        return count;

    }

    // Helper -- No.of Islands
    public static void searchforIslands(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        // 4 Directional
        searchforIslands(grid, i + 1, j);
        searchforIslands(grid, i - 1, j);
        searchforIslands(grid, i, j + 1);
        searchforIslands(grid, i, j - 1);

        // 8 - directional
        // searchforIslands(grid, i + 1, j);
        // searchforIslands(grid, i - 1, j);
        // searchforIslands(grid, i, j + 1);
        // searchforIslands(grid, i, j - 1);
        // searchforIslands(grid, i + 1, j + 1);
        // searchforIslands(grid, i - 1, j - 1);
        // searchforIslands(grid, i + 1, j - 1);
        // searchforIslands(grid, i - 1, j + 1);

    }

    public static int MaxAreaIsland(int grid[][]) {

        int n = grid.length;
        int m = grid[0].length;

        int maxarea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxarea = Math.max(maxarea, area);
                }

            }

        }
        return maxarea;
    }

    // Helper -- max Area
    public static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        int count = 1;

        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);

        return count;

    }

    public static boolean WordSearch(char board[][], String word) {

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (WSBacktrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper -- Word Search
    public static boolean WSBacktrack(char board[][], String word, int i, int j, int index) {

        if (word.length() == index) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];

        board[i][j] = '#';

        boolean found = WSBacktrack(board, word, i + 1, j, index + 1) ||
                WSBacktrack(board, word, i - 1, j, index + 1) ||
                WSBacktrack(board, word, i, j + 1, index + 1) ||
                WSBacktrack(board, word, i, j - 1, index + 1);

        board[i][j] = temp;

        return found;

    }

    public static int LongestPathinMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int dp[][] = new int[rows][cols];
        int maxlen = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxlen = Math.max(maxlen, LPbacktrack(matrix, i, j, -1, dp));
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return maxlen;

    }

    // Hemlper -- Longest path
    public static int LPbacktrack(int[][] matrix, int i, int j, int prev, int[][] dp) {

        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        int current = matrix[i][j];
        int up = LPbacktrack(matrix, i - 1, j, current, dp);
        int down = LPbacktrack(matrix, i + 1, j, current, dp);
        int left = LPbacktrack(matrix, i, j - 1, current, dp);
        int right = LPbacktrack(matrix, i, j + 1, current, dp);

        dp[i][j] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;

        return dp[i][j];

    }

    public static List<List<Integer>> Combinations(int n, int k) {

        List<List<Integer>> map = new ArrayList<>();
        ComBackTrack(1, n, k, new ArrayList<>(), map);
        System.out.println(map.size());
        return map;

    }

    // Helper --Combinations
    public static void ComBackTrack(int start, int n, int k, List<Integer> current, List<List<Integer>> map) {

        if (current.size() == k) {
            map.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            ComBackTrack(i + 1, n, k, current, map);
            current.remove(current.size() - 1);

        }

    }

    public static int[][] FloodFill(int[][] image, int sr, int sc, int color) {

        int orginalcolor = image[sr][sc];
        if (orginalcolor == color)
            return image;
        FFBacktrack(image, sc, sr, color, orginalcolor);

        return image;

    }

    public static void FFBacktrack(int[][] image, int row, int col, int color, int orginalcolor) {

        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length)
            return;
        if (image[row][col] != orginalcolor) {
            return;
        }

        image[row][col] = color;

        FFBacktrack(image, row - 1, col, color, orginalcolor);
        FFBacktrack(image, row + 1, col, color, orginalcolor);
        FFBacktrack(image, row, col - 1, color, orginalcolor);
        FFBacktrack(image, row, col + 1, color, orginalcolor);

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

        // int[][] board = {
        // { 0, 59, 38, 33, 30, 17, 8, 63 },
        // { 37, 34, 31, 60, 9, 62, 29, 16 },
        // { 58, 1, 36, 39, 32, 27, 18, 7 },
        // { 35, 48, 41, 26, 61, 10, 15, 28 },
        // { 42, 57, 2, 49, 40, 23, 6, 19 },
        // { 47, 50, 45, 54, 25, 20, 11, 14 },
        // { 56, 43, 52, 3, 22, 13, 24, 5 },
        // { 51, 46, 55, 44, 53, 4, 21, 12 }
        // };
        // boolean ans = knightSTour(board, 0, 0, board.length, 0);
        // System.out.println(ans);

        // int n = 9;
        // char board[][] = new char[n][n];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // board[i][j] = 'X';
        // }
        // }
        // Nqueens(board, 0);
        // System.out.println("Total combinations : " + count);

        // int nums[] = { 10, 1, 2, 7, 6, 1, 5 };
        // int target = 6;
        // System.out.println(CombinationSum(nums, target));

        // String str = "malayalam";
        // List<List<String>> list = PolindromeParts(str);
        // System.out.println(list);

        // int nums[] = { 4, 2, 6, 7, 3, 5, 8, 10, 9 };
        // MergeSort(nums, 0, nums.length - 1);
        // for (int num : nums) {
        // System.out.print(num + " ");
        // }

        // int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        // int k = 5;
        // reverseArray(nums, k);

        // System.out.println();
        // int nums1[] = { 10, 1, 2, 7, 6, 1, 5 };
        // int target1 = 6;
        // System.out.println(CombinationSumII(nums1, target1));

        // int nums[] = { 1, 2, 3, 4 };
        // System.out.println(Permutations(nums));

        // for (int i = 0; i < 6; i++) {
        // System.out.println(GenerateParantheses(i));
        // System.out.println();
        // }

        // int nums[] = { 1, 2, 2 };
        // System.out.println(Subsets1(nums));

        // int nums2[] = { 1, 2, 2 };
        // System.out.println(Subset2(nums2));

        // int nums[] = { 1, 2, 3 };
        // System.out.println(Permutations1(nums));

        // int nums1[] = { 1, 2, 2 };
        // System.out.println(Permutations2(nums1));

        // char[][] grid = {
        // { '0', '0', '1', '0', '0' },
        // { '1', '1', '1', '0', '0' },
        // { '0', '1', '0', '0', '0' },
        // { '0', '0', '0', '0', '1' },
        // { '0', '0', '0', '1', '1' }
        // };
        // System.out.println("Islands count : " + NoofIslands(grid));

        // int[][] grid1 = {
        // { 0, 0, 1, 0, 0 },
        // { 1, 1, 1, 0, 0 },
        // { 0, 1, 0, 0, 1 },
        // { 0, 0, 0, 1, 1 }
        // };
        // System.out.println("Max area Island : " + MaxAreaIsland(grid1));

        // char[][] board = {
        // { 'A', 'B', 'C', 'E' },
        // { 'S', 'F', 'C', 'S' },
        // { 'A', 'D', 'E', 'E' }
        // };
        // String word = "ABCCED";
        // System.out.println(WordSearch(board, word));

        // int[][] matrix = {
        // { 7, 6, 1 },
        // { 2, 7, 6 },
        // { 1, 3, 5 }
        // };
        // System.out.println(LongestPathinMatrix(matrix));

        // int n = 10;
        // int k = 2;
        // System.out.println(Combinations(n, k));

        // int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        // int sr = 1;
        // int sc = 1;
        // int color = 2;
        // int[][] image1 = FloodFill(image, sr, sc, color);
        // System.out.println(Arrays.deepToString(image1));

    }

}
