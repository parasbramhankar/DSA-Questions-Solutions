package LinkedList.SinglyLinkedList.Medium.DesignLinkedList707;


 class MyLinkedList {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (!isValid(index)) return -1;

        Node curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr.data;
    }

    public void addAtHead(int val) {
        head = new Node(val) {{
            next = head;
        }};
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) curr = curr.next;

            Node node = new Node(val);
            node.next = curr.next;
            curr.next = node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (!isValid(index)) return;

        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) curr = curr.next;
            curr.next = curr.next.next;
        }
        size--;
    }

    private boolean isValid(int index) {
        return index >= 0 && index < size;
    }
}

public class Solution {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Add at head: [10]
        list.addAtHead(10);
        printList(list); // Expected: 10

        // Add at tail: [10, 20]
        list.addAtTail(20);
        printList(list); // Expected: 10 -> 20

        // Add at index 1: [10, 15, 20]
        list.addAtIndex(1, 15);
        printList(list); // Expected: 10 -> 15 -> 20

        // Get index 1
        System.out.println("Element at index 1: " + list.get(1)); // Expected: 15

        // Delete index 0: [15, 20]
        list.deleteAtIndex(0);
        printList(list); // Expected: 15 -> 20

        // Delete last index: [15]
        list.deleteAtIndex(1);
        printList(list); // Expected: 15

        // Try to get invalid index
        System.out.println("Invalid get: " + list.get(5)); // Expected: -1
    }

    // Utility function to print a linked list
    public static void printList(MyLinkedList list) {
        for (int i = 0; i < 100; i++) { // Max 100 to avoid infinite loops
            int val = list.get(i);
            if (val == -1) break;
            System.out.print(val + (list.get(i + 1) != -1 ? " -> " : ""));
        }
        System.out.println();
    }
}


