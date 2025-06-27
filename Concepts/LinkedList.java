
//Single LinkedList

// import java.util.Arrays;
// import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

// import org.xml.sax.HandlerBase;

class ListNode {
    int data;
    ListNode next;
    ListNode random;

    ListNode(int data) {
        this.data = data;
        this.next = null;
        this.random = null;

    }
}

public class LinkedList {

    private ListNode head;

    public void add(int data) {

        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
        }

        else {
            ListNode temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return;

    }

    public void PrintList() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " => ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow)
                return true;
        }

        return false;

    }

    public static ListNode RemoveNthNodesFromLast(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        return dummy.next;

    }

    public static ListNode InsertatPos(ListNode head, int pos, int data) {
        ListNode NewNode = new ListNode(data);

        if (pos == 0) {
            NewNode.next = head;
            return head;
        }

        ListNode curr = head;

        for (int i = 0; i < pos - 1; i++) {

            if (curr == null) {
                System.out.println("No linked Lsit");
                return head;
            }

            curr = curr.next;

        }

        NewNode.next = curr.next;
        curr.next = NewNode;

        while (head != null) {
            System.out.print(head.data + " => ");
            head = head.next;
        }

        return head;
    }

    public static ListNode Reverse(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;// reverse the pointer
            prev = curr; // Slide the window
            curr = next;
        }
        ListNode Newhead = prev;

        while (Newhead != null) {
            System.out.print(Newhead.data + " => ");
            Newhead = Newhead.next;
        }
        System.out.println("null");
        return prev;

    }

    public static ListNode SortedRemoveDupliactes(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        return head;

    }

    public static ListNode UnsortedRemoveDuplicates(ListNode head) {

        if (head == null)
            return null;

        ListNode curr = head;
        ListNode prev = null;

        HashSet<Integer> set = new HashSet<>();

        while (curr != null) {
            if (set.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;

        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        return head;

    }

    public static void AddingNUmbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int a = (l1 != null) ? l1.data : 0;
            int b = (l2 != null) ? l2.data : 0;

            int sum = a + b + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);

            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

        }

        ListNode result = dummy.next;

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }

    }

    public static void Merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null)
            curr.next = l1;
        if (l2 != null)
            curr.next = l2;

        ListNode res = dummy.next;

        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }

    public static void MergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;

            if (min.next != null) {
                pq.add(min.next);
            }

        }

        ListNode temp = dummy.next;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }

    }

    public static void RotateList(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return;
        }

        // Count Nodes

        ListNode tail = head;
        int count = 1;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }

        k = k % count;
        tail.next = head;

        for (int i = 0; i < count - k; i++) {
            tail = tail.next;
        }

        ListNode newNode = tail.next;
        tail.next = null;

        ListNode temp = newNode;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();

    }

    public static void DetectLoopandDelete(ListNode head) {

        if (head == null || head.next == null)
            return;

        ListNode fast = head;
        ListNode slow = head;

        boolean detected = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                detected = true;
                break;
            }

        }
        if (!detected)
            return;

        slow = head;

        if (fast == slow) {
            while (fast.next != null) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }

        while (fast.next != slow.next) {
            fast = fast.next;
            slow = slow.next;

        }

        fast.next = null;

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public static ListNode CloneListWithRandomPointer(ListNode head) {

        // step -1 Create Cloned nodes next to originals

        if (head == null)
            return null;

        ListNode curr = head;

        while (curr != null) {
            ListNode copy = new ListNode(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step -2 Assign the random pointers of Cloned nOdes;

        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;

        }

        // Step -3 Seperate the original and cloned lists

        ListNode dummy = new ListNode(0);
        ListNode copylist = dummy;
        curr = head;

        while (curr != null) {
            ListNode NextOrg = curr.next.next;
            ListNode copy = curr.next;

            copylist.next = copy;
            copylist = copy;

            curr.next = curr.next.next;
            curr = NextOrg;

        }
        return dummy.next;
    }

    public static void PrintClonedList(ListNode head) {

        ListNode curr = head;
        while (curr != null) {
            int randval = (curr.random != null) ? curr.random.data : -1;
            System.out.println("Node value : " + curr.data + " " + "Random pointer : " + randval);
            curr = curr.next;
        }

    }

    public static ListNode MultiplyLL(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;

        }

        int num1 = 0;
        int num2 = 0;

        while (l1 != null) {
            num1 = num1 * 10 + l1.data;
            l1 = l1.next;
        }

        while (l2 != null) {
            num2 = num2 * 10 + l2.data;
            l2 = l2.next;
        }

        int product = num1 * num2;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        String str = Long.toString(product);

        for (char ch : str.toCharArray()) {
            curr.next = new ListNode(ch - '0');
            curr = curr.next;
        }

        return dummy.next;

    }

    public static void Print(ListNode head) {

        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();

    }

    public static ListNode ReverseKNodes(ListNode head, int k) {

        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode PGE = dummy;
        ListNode curr = head;

        while (count >= k) {

            ListNode prev = null;
            ListNode tail = curr;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

            }

            PGE.next = prev;
            tail.next = curr;

            PGE = tail;
            count -= k;

        }
        Print(dummy.next);

        return dummy.next;

    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(10);
        list.add(20);
        list.add(60);

        // list.PrintList();

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = null;

        head.random = second;
        second.random = fifth;
        third.random = fourth;
        fourth.random = sixth;
        fifth.random = third;
        sixth.random = seventh;
        seventh.random = null;

        // System.out.println("Cycle Detected ? : " + hasCycle(head));

        // RemoveNthNodesFromLast(head, 2);
        // System.out.println();

        // InsertatPos(head, 5, 7);
        // System.out.println();

        // Reverse(head);

        // SortedRemoveDupliactes(head);

        // UnsortedRemoveDuplicates(head);

        // ListNode l1 = new ListNode(2);
        // ListNode eight = new ListNode(4);
        // ListNode ninth = new ListNode(6);
        // l1.next = eight;
        // eight.next = ninth;
        // ninth.next = null;

        // ListNode l2 = new ListNode(1);
        // ListNode tenth = new ListNode(4);
        // ListNode eleventh = new ListNode(9);
        // l2.next = tenth;
        // tenth.next = eleventh;
        // eleventh.next = null;

        // AddingNUmbers(l1, l2);

        // Merge(l1, l2);

        // ListNode[] lists = { l1, l2, head };
        // MergeKLists(lists);

        // RotateList(head, 5);

        // ListNode front1 = new ListNode(10);
        // ListNode front2 = new ListNode(12);
        // ListNode front3 = new ListNode(14);
        // ListNode front4 = new ListNode(16);
        // ListNode front5 = new ListNode(18);
        // front1.next = front2;
        // front2.next = front3;
        // front3.next = front4;
        // front4.next = front5;
        // front5.next = front3;
        // DetectLoopandDelete(front1);

        // System.out.println("Orginal List :");
        // PrintClonedList(head);
        // System.out.println();
        // System.out.println("Cloned List : ");
        // ListNode cloned = CloneListWithRandomPointer(head);
        // PrintClonedList(cloned);

        // ListNode result = MultiplyLL(l1, l2);
        // Print(result);

        // int k = 7;
        // ReverseKNodes(head, k);

    }

}
