package LinkedList.SinglyLinkedList.Medium.OddEvenLinkedList328;

public class Optimize {
    ListNode oddEvenList(ListNode head){

        if(head==null || head.next==null){
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=even;

        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;

            even.next=odd.next;
            even=even.next;
        }

        odd.next=evenHead;

        return head;
    }
    // Helper: Convert an array to linked list
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

