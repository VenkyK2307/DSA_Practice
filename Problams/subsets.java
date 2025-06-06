public class subsets {

    public static void sub(String str, String ans, int i) {

        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            }
            System.out.print(ans + "|");
            return;
        }

        sub(str, ans + str.charAt(i), i + 1);
        sub(str, ans, i + 1);
    }

    public static void per(String str, String ans) {

        if (str.length() == 0) {
            System.out.print(ans + "|");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            String rem = str.substring(0, i) + str.substring(i + 1);
            per(rem, ans + curr);
        }
    }

    public static void main(String[] args) {

        String str = "ABCD";

        System.out.println("All Subsets");
        sub(str, "", 0);

        System.out.println("All Permutatons");
        per(str, "");

    }

}
