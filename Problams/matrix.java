class matrix {
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }

        };

        int top = 0;
        int left = 0;

        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }

            for (int i = top + 1; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }

            if (top < bottom) {
                for (int j = right - 1; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
            }

            if (left < right) {
                for (int i = bottom - 1; i > top; i--) {
                    System.out.print(matrix[i][left] + " ");

                }
            }

            top++;
            right--;
            bottom--;
            left++;
        }
    }
}