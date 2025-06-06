class chess {

    public static void nQ(char[][] board, int row) {

        if (row == board.length) {
            printboard(board);
            System.out.println();
            return;
        }

        for (int j = 0; j < board.length; j++) {

            if (issafe(board, row, j)) {
                board[row][j] = 'Q';
                nQ(board, row + 1);
                board[row][j] = 'X';
            }

        }
    }

    public static boolean issafe(char[][] board, int row, int col) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;

    }

    public static void printboard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;

        char[][] board = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'X';

            }

        }
        nQ(board, 0);

    }
}
