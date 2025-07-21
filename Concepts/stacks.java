import java.util.*;

public class stacks {

    public static int[] NextGreaterRight(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int res[] = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && nums[i] > stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;

    }

    public static int[] StockSpan(int nums[]) {
        // How many days before stock has lower price;
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }

            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);

        }

        return span;

    }

    public static int[] AstroidCollision(int nums[]) {

        Stack<Integer> stack = new Stack<>();

        for (int ast : nums) {

            boolean destroyed = false;

            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (Math.abs(ast) > stack.peek()) {
                    stack.pop();
                }

                else if (Math.abs(ast) == stack.peek()) {
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(ast);
            }

        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.get(i);
        }
        return result;

    }

    public static boolean ValidParanthesis(String str) {

        int n = str.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            char curr = str.charAt(i);

            if (!stack.isEmpty()) {
                if (curr == ')' && stack.peek() == '(')
                    stack.pop();
                if (curr == ']' && stack.peek() == '[')
                    stack.pop();
                if (curr == '}' && stack.peek() == '{')
                    stack.pop();

            }

            stack.push(curr);

        }

        return stack.isEmpty();

    }

    public static boolean ValidPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        int n = str.length();
        for (int i = 0; i < n; i++) {

            char curr = str.charAt(i);
            stack.push(curr);

        }

        for (int i = 0; i < n; i++) {

            if (str.charAt(i) != stack.pop()) {
                return false;
            }

        }

        return true;

    }

    public static int[] DailyTemperatutres(int nums[]) {

        // Hou many days we have to wait to see a Warmer temperatue;
        Stack<Integer> stack = new Stack<>();

        int n = nums.length;

        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.pop();

            }

            result[i] = (!stack.isEmpty()) ? stack.peek() - i : 0;

            stack.push(i);
        }
        return result;
    }

    public static String SimplifyPath(String path) {

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        String route[] = path.split("/");

        for (String part : route) {
            if (part.equals(".") || part.equals(""))
                continue;

            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            else {
                stack.push(part);
            }
        }

        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }

    public static void main(String[] args) {

        // int nums[] = { 3, 4, 2, 5, 7, 4, 8, 4, 2 };
        // int result[] = NextGreaterRight(nums);
        // System.out.println(Arrays.toString(result));

        // int nums[] = { 90, 100, 60, 70, 60, 80, 100 };
        // int[] res = StockSpan(nums);
        // System.out.println(Arrays.toString(res));

        // int[] astroids = { 6, 4, -2, -8, 4, 5, 6, -9 };
        // int[] ast = AstroidCollision(astroids);
        // System.out.println(Arrays.toString(ast));

        // String str = "{{[()]}";
        // System.out.println(ValidParanthesis(str));

        // String str = "malaylam";
        // System.out.println(ValidPalindrome(str));

        // int nums[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
        // int[] result = DailyTemperatutres(nums);
        // System.out.println(Arrays.toString(result));

        // String path =
        // "/home/./user/docs/../projects/alpha/./../beta/../gamma/./delta/../../x/y/../z/../../final/";
        // String result = SimplifyPath(path);
        // System.out.println(result);
    }

}
