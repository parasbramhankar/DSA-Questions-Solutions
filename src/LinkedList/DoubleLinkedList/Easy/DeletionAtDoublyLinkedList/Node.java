package LinkedList.DoubleLinkedList.Easy.DeletionAtDoublyLinkedList;

// Definition of a Node in Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    // Constructor to initialize node data
    Node(int val) {
        this.data = val;
        this.next = null;
        this.prev = null;
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
