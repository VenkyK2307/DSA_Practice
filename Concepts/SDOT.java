import java.util.*;
import java.util.LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class vertex {
    int src;
    int dest;
    int wt;

    vertex(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;

    }
}

class SDOT {

    // DAY - 1
    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " => ");
            head = head.next;
        }
        System.out.println("null");

    }

    public static int Length(Node head) {

        Node temp = head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;

        }
        return length;
    }

    public static Node Merge2LLS(Node head, Node head1) {

        Node dummy = new Node(0);

        // Create a Curr NOde to traverse over
        Node curr = dummy;

        while (head != null && head1 != null) {
            if (head.data <= head1.data) {
                curr.next = head;
                head = head.next;
            } else {
                curr.next = head1;
                head1 = head1.next;
            }
            curr = curr.next;

        }

        // Extra Lengths Direct Adding
        if (head != null) {
            curr.next = head;
        } else if (head1 != null) {
            curr.next = head1;
        }

        return dummy.next;
    }

    public static Node OddEvenPositionsLL(Node head) {

        if (head == null || head.next == null)
            return head;

        Node odd = head;
        Node even = odd.next;
        Node evehead = even;// To connect at Last

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;

        }

        odd.next = evehead;
        return head;

    }

    public static boolean Polindrome(Node head) {

        // 3 Steps ==> Find the middle , Reverse LL from Middle , Compare the LLs

        // Finding the Middle of the LL
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reversing from the middle

        Node prev = null;
        Node curr = slow; // this is the starting of the Half
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Comparing the two LLs
        Node ll1 = head;
        Node ll2 = prev;// Prev becomes the first element in Reversed LL

        while (ll1 != null && ll2 != null) {
            if (ll1.data != ll2.data) {
                return false;
            }

            ll1 = ll1.next;
            ll2 = ll2.next;

        }
        return true;

    }

    // DAY -2

    public static Node RoateListKSteps(Node head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        // Find the lenght of the LL
        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        k = k % length;// if K is greater than N do k%n;
        tail.next = head;// Make it Circular LL, With the tail at end

        int steps = length - k;// No. of steps to mOve

        Node newtail = head;// Moving Steps from head;
        for (int i = 1; i < steps; i++) {
            newtail = newtail.next;
        }

        Node newnode = newtail.next;// Createing the new Head;
        newtail.next = null;// Make NewTails next as Null;

        return newnode;

    }

    public static String HappySuffixBrute(String str) {

        for (int i = str.length() - 1; i > 0; i--) {
            String front = str.substring(0, i);
            String back = str.substring(str.length() - i);

            System.out.println(front + " " + back);

            // Checking the back and Front
            if (front.equals(back)) {
                return front;
            }

        }
        return "null";
    }

    public static String HappySuffixOptimal(String str) {

        int[] LPS = new int[str.length()];
        int len = 0;
        int i = 1;

        while (i < str.length()) {
            if (str.charAt(len) == str.charAt(i)) {
                len++;
                LPS[i] = len;
                i++;

                // If chars are same ==> len++ , LPS[i] = len , i++
                // if chars are not same , len is not 0 ==> backtrack to the safest possible
                // point where there is LPS possible
                // if chars are not same , len is 0 ==> Just take that LPS[i] = 0 and increnet
                // the i
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                    // BackTracking to Safest Possible place
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }

        int last = LPS[str.length() - 1];

        return str.substring(0, last);

    }

    public static String MakeTheStringSmallestPlolindrome(String str) {

        String rev = new StringBuilder(str).reverse().toString();
        String combined = str + "*" + rev;

        int n = combined.length();
        int LPS[] = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (combined.charAt(len) == combined.charAt(i)) {
                len++;
                LPS[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];// BacjTrack to the Safest Possible Prefix
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }

        int length = LPS[n - 1];

        // Finding the Suffix/Prefix length and merge that part in the reversed String
        // abca ==> rev = acba so the PS is a , merge it it becomes => acbabca
        return rev.substring(0, str.length() - length) + str;

    }

    // DAY - 3

    public static void SumRoottoLeaf(TreeNode root) {
        int ans = dfs(root, 0);
        System.out.println(ans);
    }

    public static int dfs(TreeNode root, int current) {
        if (root == null)
            return current;

        current = current * 10 + root.data;

        if (root.left == null && root.right == null) {
            return current;
        }

        return dfs(root.left, current) + dfs(root.right, current);

    }

    public static ArrayList<Integer> RightView(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1) {
                    ans.add(curr.data);
                }
                // Store Childer of the Present Roots
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }

        }

        return ans;

    }

    public static ArrayList<ArrayList<Integer>> ZigZagTraversal(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean lefttoright = true;

        ArrayList<ArrayList<Integer>> map = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.add(curr.data);

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }

            if (!lefttoright) {
                Collections.reverse(level);
            }
            lefttoright = !lefttoright;

            map.add(level);

        }
        return map;
    }

    // DAY - 4

    public static void BasicCalculator(String str) {

        int sum = 0;
        int num = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (Character.isDigit(curr)) {

            }

            else if (curr == '+') {
                sum += sign * num;
                num = 0;
                sign = 1;
            }

            else if (curr == '-') {
                sum += sign * num;
                num = 0;
                sign = -1;
            }

            else if (curr == '(') {
                stack.push(sign);
                stack.push(sum);
                sign = 1;
                num = 0;

            }

            else if (curr == ')') {

            }
        }
        return;
    }

    public static int PostFixEval(String str) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (Character.isDigit(curr)) {
                stack.push(curr - '0');
            }

            else {
                // Take 2 elements and Perform the OPeration Between them;
                int a = stack.pop();
                int b = stack.pop();

                switch (curr) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                    default:
                        break;
                }
            }

        }

        return stack.peek();
    }

    public static String infixToPostfix(String str) {

        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr == ' ') {// If there is any space in between IGNORE
                continue;
            }
            if (Character.isLetterOrDigit(curr)) {// If it is Character or Digit
                ans.append(curr);
            }

            else if (curr == '(') {// If its a Opening Operator push into stack
                stack.push(curr);
            }

            else if (curr == ')') {// If its a closing Bracket just add everything until you find a opening bracket
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }

                if (!stack.isEmpty()) {// DIscard the perantheses as we dont get any in the ans
                    stack.pop();
                }

            }

            else {
                while (!stack.isEmpty() && Precedence(curr) <= Precedence(stack.peek())) {
                    ans.append(stack.pop());// More preedence Operator should come first
                }
                stack.push(curr);
            }

        }
        while (!stack.isEmpty()) {// Add the remaining chars in the stack if my stac is not empty
            ans.append(stack.pop());
        }

        return ans.toString();

    }

    // Helper -- I2P
    public static int Precedence(char curr) {

        switch (curr) {
            case '^':
                return 3;
            case '/':
                return 2;
            case '*':
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;

            default:
                break;
        }
        return -1;

    }

    // Stck using Queue
    // Queue using STack

    // DAY-5.1

    public static int LongestPosibleValidPerantheses(String str) {

        Stack<Integer> stack = new Stack<>();
        int maxlen = 0;
        stack.push(-1);// Acts as the First Boundary if a pair is valid

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {// If my stack is empty i will push my closing index to act as wall
                    stack.push(i);
                }

                else {
                    maxlen = Math.max(maxlen, i - stack.peek());// Updating the maxlen when sommething in the stack
                }
            }

            maxlen = Math.max(maxlen, i - stack.peek());
        }

        return maxlen;

    }

    public static int FixingUnbalencedPeranthesis(String str) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr == '(') {
                stack.push(i);
            } else {

                if (!stack.isEmpty() && str.charAt(stack.peek()) == '(') {
                    // Check if the Stack contains the opening Bracket
                    stack.pop();
                }

                else {
                    stack.push(i);
                }

            }
        }
        return stack.size();
    }

    public static void BInartycodeGeneration(int n) {

        Queue<String> q = new LinkedList<>();
        q.offer("1");

        for (int i = 0; i < n; i++) {
            String curr = q.poll();
            System.out.print(curr + " ");
            if (i < n - 1) {
                System.out.print(" , ");
            }

            q.offer(curr + "0");
            q.offer(curr + "1");

        }

    }

    public static boolean ValidPerantheses(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else {
                char top = stack.peek();

                if ((curr == ')' && top == '(') ||
                        (curr == '}' && top == '{') ||
                        (curr == ']' && top == '[')) {
                    stack.pop();
                } else {
                    return false;
                }

            }

        }

        return true;
    }

    // public static boolean HaveUnnessecaryPerantheses(String str) {

    // }

    // DAY - 5.2

    // Permutation

    public static int TrappingRainWater(int heights[]) {
        int rightmax = 0;
        int leftmax = 0;
        int left = 0;
        int right = heights.length - 1;
        int water = 0;

        while (left < right) {
            if (heights[left] <= heights[right]) {// Whichever is smaller we go insie
                if (heights[left] > leftmax) {// if my boundery is lesser update boundary
                    leftmax = heights[left];
                } else {
                    water += leftmax - heights[left];// if my boundary is bigger update boundary - curr;
                }

                left++;
            } else {
                if (heights[right] > rightmax) {
                    rightmax = heights[right];
                } else {
                    water += rightmax - heights[right];
                }

                right--;
            }

        }
        return water;
    }

    // DAY 6.1
    public static List<String> GeneratePerantheis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, "", n, 0, 0);

        return result;
    }

    // Helper -- Generate Peranthesis
    public static void backTrack(List<String> result, String curr, int n, int open, int close) {

        if (2 * n == curr.length()) {
            result.add(curr);
            return;
        }

        if (open < n) {
            backTrack(result, curr + "(", n, open + 1, close);
        }

        if (close < open) {
            backTrack(result, curr + ")", n, open, close + 1);
        }
    }

    public static List<Integer> SpiralMatrix(int[][] matrix) {

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }

            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }

        return list;

    }

    public static String keypad[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> LetterCombination(String input) {

        ArrayList<String> list = new ArrayList<>();
        HelperLetterCombination(list, input, "", 0);
        return list;

    }

    public static void HelperLetterCombination(ArrayList<String> list, String input, String curr, int index) {
        if (index == input.length()) {
            list.add(curr);
            return;
        }

        String letters = keypad[input.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            HelperLetterCombination(list, input, curr + c, index + 1);

        }

    }

    // DAY -6.2

    public static void BUildGraph(ArrayList<vertex> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<vertex>();
        }

        graph[0].add(new vertex(0, 1, 2));
        graph[0].add(new vertex(0, 2, 4));
        graph[1].add(new vertex(1, 0, 2));
        graph[1].add(new vertex(1, 3, 3));
        graph[2].add(new vertex(2, 0, 4));
        graph[3].add(new vertex(3, 1, 3));
    }

    public static void DFS(ArrayList<vertex> graph[], int curr, boolean[] visited) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            vertex v = graph[curr].get(i);

            if (!visited[v.dest]) {
                DFS(graph, v.dest, visited);
            }
        }

    }

    public static int IslandCount(char[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    IslandDfs(grid, i, j);

                }

            }
        }
        return count;
    }

    public static void IslandDfs(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || j >= grid[0].length || i >= grid.length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        IslandDfs(grid, i + 1, j);
        IslandDfs(grid, i - 1, j);
        IslandDfs(grid, i, j - 1);
        IslandDfs(grid, i, j + 1);

    }

    // DAY 7

    // houseRobber
    // WildcardMAtching
    // LengthofIncresingSubsequence
    // MInimumnoofdeletions

    // DAY - 8

    public static int PrimsAlgo(ArrayList<vertex> graph[], int V) {

        PriorityQueue<vertex> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new vertex(0, 0, 0));

        boolean visited[] = new boolean[V];
        int total = 0;

        while (!pq.isEmpty()) {
            vertex curr = pq.poll();
            int u = curr.dest;

            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            total += curr.wt;

            for (int i = 0; i < graph[curr.dest].size(); i++) {
                vertex e = graph[curr.dest].get(i);

                if (!visited[e.dest]) {
                    pq.offer(new vertex(e.src, e.dest, e.wt));
                }

            }

        }
        return total;

    }

    public static boolean CourseSchedule(int num, int[][] prerequsites) {

        List<List<Integer>> map = new ArrayList<>();
        int[] indegree = new int[num];

        for (int i = 0; i < num; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] arr : prerequsites) {
            int course = arr[0];
            int prereq = arr[1];
            map.get(prereq).add(course);
            indegree[course]++;

        }

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Starts with a course which has no Prerequsite;
        int index = 0;

        while (!q.isEmpty()) {

            int curr = q.poll();
            index++;

            for (int neighbour : map.get(curr)) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        return num == index;
    }

    public static void main(String[] args) {

        // Linked List 1
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(20);
        Node fourth = new Node(10);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        // Linked List 2
        Node head1 = new Node(0);
        head1.next = new Node(11);
        head1.next.next = new Node(21);
        head1.next.next.next = new Node(31);

        // Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);

        // Node ans = Merge2LLS(head, head1);
        // printList(ans);

        // Node ans = OddEvenPositionsLL(head);
        // printList(ans);

        // boolean ans1 = Polindrome(head);
        // System.out.println(ans1);

        // int ans = Length(head);
        // System.out.println(ans);

        // String str = "acba";
        // System.out.println(HappySuffixBrute(str));
        // System.out.println(HappySuffixOptimal(str));
        // System.out.println(MakeTheStringSmallestPlolindrome(str));

        // SumRoottoLeaf(root);

        // ArrayList<Integer> ans = RightView(root);
        // System.out.println(ans);

        // ArrayList<ArrayList<Integer>> ans = ZigZagTraversal(root);
        // System.out.println(ans);

        // String str = "84/5*3+2-";
        // int ans = PostFixEval(str);
        // System.out.println(ans);

        // System.out.println(infixToPostfix("A + (B * C)"));

        // String str = ")()()(";
        // int ans = LongestPosibleValidPerantheses(str);
        // System.out.println(ans);

        // String str = ")()())";
        // System.out.println(FixingUnbalencedPeranthesis(str));

        // int n = 10;
        // BInartycodeGeneration(n);

        // String str = "({{{}}})[]";
        // System.out.println(ValidPerantheses(str));

        // int heights[] = { 4, 0, 2, 3, 5, 8, 6, 7, 3 };
        // System.out.println(TrappingRainWater(heights));

        // List<String> ans = GeneratePerantheis(4);
        // System.out.println(ans);

        // int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
        // 14, 15, 16 } };
        // List<Integer> ans = SpiralMatrix(matrix);
        // System.out.println(ans);

        // int V = 4;
        // ArrayList<vertex> graph[] = new ArrayList[V];
        // BUildGraph(graph);
        // boolean visited[] = new boolean[V];
        // DFS(graph, 2, visited);

        // char[][] grid = {
        // { '1', '1', '0', '0', '0' },
        // { '1', '1', '0', '0', '0' },
        // { '0', '0', '1', '0', '0' },
        // { '0', '0', '0', '1', '1' }
        // };

        // int ans = IslandCount(grid);
        // System.out.println(ans);

        // List<String> ans = LetterCombination("235");
        // System.out.println(ans);

        // int V = 5;
        // ArrayList<vertex> graph[] = new ArrayList[V];
        // BUildGraph(graph);
        // int ans = PrimsAlgo(graph, V);
        // System.out.println("Minimum Distance : " + ans);

        int num = 7;
        int[][] prerequsites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 4, 2 }, { 5, 3 }, { 5, 4 }, { 6, 5 } };
        boolean ans = CourseSchedule(num, prerequsites);
        System.out.println(ans);

    }

}
