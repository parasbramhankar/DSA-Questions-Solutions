package LinkedList.SinglyLinkedList.Medium.FindTheLengthOfLoop;

public class Node {
    Node next;
    int data;

    public Node(int data) {
        this.next = null;
        this.data = data;
    }

    public Node(Node next, int data) {
        this.next = next;
        this.data = data;
    }
}
