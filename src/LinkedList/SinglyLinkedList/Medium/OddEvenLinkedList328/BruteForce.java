package LinkedList.SinglyLinkedList.Medium.OddEvenLinkedList328;

public class BruteForce {

    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode newHead=new ListNode(0); //dummy node
        ListNode temp=newHead;
        ListNode headtemp=head;

        while(headtemp!=null ){
            temp.next=new ListNode(headtemp.data);
            temp=temp.next;

            if(headtemp.next==null) break;
            headtemp=headtemp.next.next;
        }

        headtemp=head.next;

        while(headtemp!=null){
            temp.next=new ListNode(headtemp.data);
            temp=temp.next;
            if(headtemp.next==null) break;
            headtemp=headtemp.next.next;
        }

        return newHead.next;
    }

    // Helper: Convert array to linked list
    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper: Print linked list
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" → ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(input);

        BruteForce solution = new BruteForce();
        ListNode result = solution.oddEvenList(head);

        System.out.print("Output: ");
        printLinkedList(result);  // Expected: 1 → 3 → 5 → 2 → 4
    }
}
