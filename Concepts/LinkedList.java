
//Single LinkedList
class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;

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

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        // System.out.println("Cycle Detected ? : " + hasCycle(head));

        // RemoveNthNodesFromLast(head, 2);
        // System.out.println();

        // InsertatPos(head, 5, 7);
        // System.out.println();

        Reverse(head);

    }

}
