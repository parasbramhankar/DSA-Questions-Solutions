package LinkedList.SinglyLinkedList.Easy.MiddleOfTheLinkedList876;

public class Solution {
    static void display(ListNode head) {
        ListNode temp = head;

        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println(temp.data);  // this is done only for the -> to print after the element
        // If we do not want to add, "->", then we can use the  while(temp!=null)
        //which iterate up to the last element of the linked list
        System.out.println();
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

    //Solution of the Question
        // Create an object of Solution and find the middle node
        Solution sol = new Solution();
        ListNode middle = sol.middleNode(head);


        // Print from middle to end
        System.out.print("Middle node and onward: ");
        while (middle != null) {
            System.out.print(middle.data + " ");
            middle = middle.next;
        }

    }

}
