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

    // public static char[][] NQueens(int[][] board){

    // }

    public static void main(String[] args) {

        // String str = "ABC";
        // subsets(str, "", 0);

        // String str = "ABC";
        // permutations(str, "");

    }

}
