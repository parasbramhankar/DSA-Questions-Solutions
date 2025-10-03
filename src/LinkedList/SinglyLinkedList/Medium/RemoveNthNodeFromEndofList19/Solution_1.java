package LinkedList.SinglyLinkedList.Medium.RemoveNthNodeFromEndofList19;



public class Solution_1 {


    static int findTheLengthOfTheList(Node head){
        Node temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }


    public Node removeNthFromEnd(Node head, int n) {

        if (head == null) {
            return null;
        }

        int length = findTheLengthOfTheList(head);

        // If n is greater than the length, return head as is
        if (length < n) {
            return head;
        }

        // If the node to remove is the head node
        if (length == n) {
            return head.next;
        }

        int rem = length - n; // position of the node before the target

        Node temp = head;
        // Move temp to the node just before the one to delete
        for (int i = 1; i < rem; i++) {
            temp = temp.next;
        }

        // Remove the nth node from the end
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }





    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(50);

        System.out.println("Before removing the nth node from the last: ");
        display(head);

        head=removeNthNodeFromLast(head,2);

        System.out.println("After removing the node:");
        display(head);

    }
}