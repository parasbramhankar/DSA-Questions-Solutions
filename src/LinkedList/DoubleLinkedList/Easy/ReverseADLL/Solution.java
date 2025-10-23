package LinkedList.DoubleLinkedList.Easy.ReverseADLL;


public class Solution {
    // Helper to print the doubly linked list
    static void printList(Node head) {
      Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper to create a linked list from array
    static Node createList(int[] arr) {
        if (arr.length == 0)
            return null;

        Node head = new Node(arr[0]);

        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            newNode.prev = curr;
            curr.next = newNode;
            curr=newNode;
        }

        return head;
    }

    public static Node reverse(Node head) {
        // code here
        Node prev=null;
        Node next=null;
        Node current=head;

        while(current!=null){
            next=current.next;

            current.next=prev;
            current.prev=next;

            prev=current;
            current=next;
        }

        return prev;
    }

    public static void main(String[] args) {

        // Example 1
        int[] arr = {2, 4, 5, 10, 3, 9, 12, 5};
        Node head = createList(arr);

        System.out.print("Before reversal Original List: ");
        printList(head);

        System.out.println();

        Node newHead=reverse(head);

        System.out.print("After reversal List: ");
        printList(newHead);





    }
}
