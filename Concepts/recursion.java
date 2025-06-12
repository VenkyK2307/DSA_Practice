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

    public static class NQueens {

        public static char[][] NQueens(int n) {

            char[][] board = new char[n][n];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] = 'X';
                }
            }

            return board;
        }

        public static void PrintBoard(char[][] board) {

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        }

        public static void main(String[] args) {
            int n = 4;
            char[][] chess = NQueens(n);
            PrintBoard(chess);
            System.out.println("Print chess Board");
        }

    }

    public static void main(String[] args) {

        // String str = "ABC";
        // subsets(str, "", 0);

        // String str = "ABC";
        // permutations(str, "");

    }

}
