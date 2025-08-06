package LinkedList.DoubleLinkedList.Medium.DeleteAllOccurenceOfGivenKey;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}