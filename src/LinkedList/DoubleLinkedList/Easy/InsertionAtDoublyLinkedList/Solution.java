package LinkedList.DoubleLinkedList.Easy.InsertionAtDoublyLinkedList;

/*
class Node {
    int data;
    Node next;
    Node prev;
    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}
*/

class Solution {
    Node insertAtPos(Node head, int p, int x) {
        Node newNode = new Node(x);

        // Traverse to the p-th node
        Node temp = head;
        int index = 0;
        while (index < p && temp != null) {
            temp = temp.next;
            index++;
        }

        // Insert after temp
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }


        // Helper to print the doubly linked list
        static void printList(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data);
                if (temp.next != null) System.out.print(" <-> ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Helper to create a linked list from array
        static Node createList(int[] arr) {
            if (arr.length == 0) return null;
            Node head = new Node(arr[0]);
            Node curr = head;
            for (int i = 1; i < arr.length; i++) {
                Node newNode = new Node(arr[i]);
                curr.next = newNode;
                newNode.prev = curr;
                curr = newNode;
            }
            return head;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            // Example 1
            int[] arr1 = {2, 4, 5};
            Node head1 = createList(arr1);
            System.out.print("Original List: ");
            printList(head1);

            head1 = sol.insertAtPos(head1, 2, 6); // insert after 2nd node (0-based)
            System.out.print("After Insertion: ");
            printList(head1);

            System.out.println();

            // Example 2
            int[] arr2 = {1, 2, 3, 4};
            Node head2 = createList(arr2);
            System.out.print("Original List: ");
            printList(head2);

            head2 = sol.insertAtPos(head2, 0, 44); // insert after 0th node
            System.out.print("After Insertion: ");
            printList(head2);
        }
}
