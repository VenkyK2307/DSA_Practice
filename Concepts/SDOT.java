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

    // BASIC cALCULATOR

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

    }

}
