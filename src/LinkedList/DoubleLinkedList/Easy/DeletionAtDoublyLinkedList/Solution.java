package LinkedList.DoubleLinkedList.Easy.DeletionAtDoublyLinkedList;


import java.util.Scanner;

// Solution class contains the method to delete a node at position x
public class Solution {
    /**
     * Deletes the node at position x (1-based index) in the doubly linked list
     *
     * @param head Head of the doubly linked list
     * @param x    Position of node to delete (1-based)
     * @return Head of the modified list after deletion
     */

    static Node delPos(Node head, int x) {
        // If list is empty, nothing to delete
        if (head == null) {
            return head;
        }

        // Start from head and traverse to the x-th node
        Node temp = head;
        int pos = 1;
        while (temp != null && pos < x) {
            temp = temp.next;
            pos++;
        }

        // If position x is beyond list length (temp is null), return unchanged list
        if (temp == null) {
            return head;
        }

        // If the node to delete is the head node (first node)
        if (temp.prev == null) {
            head = temp.next;          // Move head to next node
            if (head != null) {
                head.prev = null;      // Set new head's prev pointer to null
            }
        } else {
            // Link previous node's next to node after temp
            temp.prev.next = temp.next;
            // If temp is not the last node, link next node's prev to node before temp
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }

        // Return possibly updated head of the list
        return head;
    }

  static Node createDLL(int[] arr) {
        Node head = new Node(arr[0]);

        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], null, temp);
            temp.next = newNode;
            temp = temp.next;
        }

        return head;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50, 60, 70};


        System.out.println("Before Deletion: ");
        Node head = createDLL(arr);
        display(head);
        System.out.println();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the position of node to delete: ");
        int x=scanner.nextInt();

        System.out.println("After Deletion: ");
        head=delPos(head,x);
        display(head);
    }
}


