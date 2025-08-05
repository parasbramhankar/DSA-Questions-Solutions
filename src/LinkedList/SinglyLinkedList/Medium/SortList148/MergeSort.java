package LinkedList.SinglyLinkedList.Medium.SortList148;

// Merge sort solution for linked list
class MergeSort {

    // Find the middle of the linked list
    static ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted linked lists
    static ListNode sortedMerge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode result;
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    // Merge sort function
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null; // split the list

        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMiddle);

        return sortedMerge(left, right);
    }


// Main class to test the sorting

    public static void main(String[] args) {
        // Create sample list: 5 -> 3 -> 8 -> 1 -> 2
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);

        System.out.println("Original List:");
        printList(head);

        // Sort the list
        MergeSort solution = new MergeSort();
        head = solution.sortList(head);

        System.out.println("Sorted List:");
        printList(head);
    }

    // Print the linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    }
