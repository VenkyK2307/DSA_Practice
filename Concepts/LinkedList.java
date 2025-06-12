import java.util.*;

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

    public static void RemoveDuplicateNodes(ListNode head) {

    }

    public static void RemoveNthNodesFromLast(ListNode head) {

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

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        // System.out.println("Cycle Detected ? : " + hasCycle(head));

    }

}
