package LinkedList.DoubleLinkedList.Easy.ReverseADLL;

public class Node {
    Node next;
    Node prev;
    int data;

    public Node(int data) {
        this.next = null;
        this.prev = null;
        this.data = data;
    }

    public Node(Node next, Node prev, int data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }
}
