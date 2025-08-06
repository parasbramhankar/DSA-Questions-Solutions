package LinkedList.DoubleLinkedList.Medium.DeleteAllOccurenceOfGivenKey;

public class Optimize {

        static Node deleteAllOccurOfX(Node head, int x) {

            Node dummy=new Node(0);

            dummy.next=head;

            if(head!=null) head.prev=dummy;
            Node temp=dummy;

            while (temp.next != null) {
                if (temp.next.data == x) {
                    temp.next = temp.next.next;

                    if (temp.next != null) {
                        temp.next.prev = temp;
                    }
                } else {
                    temp = temp.next;
                }
            }

            if(dummy.next!=null){
                dummy.next.prev=null;
            }

            return dummy.next;
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
        int[] values = {1, 2, 3, 2, 4, 2, 5};
        int keyToDelete = 2;

        Node head = createDLL(values);

        System.out.println("Original list:");
        printList(head);

        head = deleteAllOccurOfX(head, keyToDelete);

        System.out.println("After deleting all occurrences of " + keyToDelete + ":");
        printList(head);
    }
}
