package LinkedList.DoubleLinkedList.Medium.DeleteAllOccurenceOfGivenKey;

public class BruteForce {

    static Node deleteAllOccurOfX(Node head, int x) {
        if (head == null) return null;

        Node newHead = null;
        Node newTail = null;

        Node temp = head;

        while (temp != null) {
            if (temp.data != x) {
                Node newNode = new Node(temp.data);

                if (newHead == null) {
                    newHead = newNode;
                    newTail = newNode;
                } else {
                    newTail.next = newNode;
                    newNode.prev = newTail;
                    newTail = newNode;
                }
            }
            temp = temp.next;
        }

        return newHead;
    }

    // Utility method to print the list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Utility method to create doubly linked list from array
    static Node createDLL(int[] arr) {
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
        int[] arr = {1, 2, 3, 2, 4, 2, 5};
        int x = 2;

        Node head = createDLL(arr);

        System.out.println("Original List: ");
        printList(head);// You can reuse the createDLL from earlier

        Node result = deleteAllOccurOfX(head, x);

        System.out.println("After Deletion");
        printList(result); // Reuse printList to display
    }


}
