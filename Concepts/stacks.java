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

    // public static int AstroidCollision(int nums[]) {

    // }

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

    public static void main(String[] args) {

        // int nums[] = { 3, 4, 2, 5, 7, 4, 8, 4, 2 };
        // int result[] = NextGreaterRight(nums);
        // System.out.println(Arrays.toString(result));

        // int[] astroids = { 10, 15, 17 };
        // int[] ast = AstroidCollision(astroids);
        // System.out.println(Arrays.toString(ast));

        // String str = "{{[()]}";
        // System.out.println(ValidParanthesis(str));

        // String str = "malaylam";
        // System.out.println(ValidPalindrome(str));

        // int nums[] = { 90, 100, 60, 70, 60, 80, 100 };
        // int[] res = StockSpan(nums);
        // System.out.println(Arrays.toString(res));

    }

}
