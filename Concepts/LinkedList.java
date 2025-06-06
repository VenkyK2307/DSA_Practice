public class LinkedList {

    class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;

        }
    }

    static ListNode head;

    public static void add(int data) {

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

    public static void main(String[] args) {

        LinkedList list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(10);
        list.add(20);

        System.out.println(list);

    }

}
