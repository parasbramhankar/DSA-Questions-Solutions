package LinkedList.SinglyLinkedList.Easy.MiddleOfTheLinkedList876;

/**
 * The Tortoise and Hare algorithm leverages two pointers, 'slow' and 'fast', initiated at the beginning of the linked list.
 * The 'slow' pointer advances one node at a time, while the 'fast' pointer moves two nodes at a time.
 *
 * See: LinkedList/SinglyLinkedList/Easy/MiddleOfTheLinkedList876/Optimize_Image 1.png
 *
 * The Tortoise and Hare algorithm works because the fast-moving hare reaches the end of the list in exactly the same time it takes for the slow-moving tortoise to reach the middle. When the hare reaches the end, the tortoise is guaranteed to be at the middle of the list.
 *
 * Algorithm
 *
 * Step 1: Initialise two pointers, `slow` and `fast`, to the head of the linked list. `slow` will advance one step at a time, while `fast` will advance two steps at a time. These pointers will move simultaneously.
 * Step 2: Traverse the linked list with the `slow` and `fast` pointers. While traversing, repeatedly move `slow` one step and `fast` two steps at a time.
 * Step 3: Continue this traversal until fast reaches the end of the list (i.e., fast or fast.next is null), the slow pointer will be at the middle of the list.
 *
 *  See: LinkedList/SinglyLinkedList/Easy/MiddleOfTheLinkedList876/Optimize_Image 2.png
 *
 * When the linked list has an odd number of nodes, fast.next ensures that the fast pointer doesn't go past the end of the list. In this case, fast reaches the last node, and fast.next becomes null, signalling the end of the traversal.
 *
 *  See: LinkedList/SinglyLinkedList/Easy/MiddleOfTheLinkedList876/Optimize_Image 3.png
 *
 * When the linked list has an even number of nodes, fast will reach the end of the list and be null, which still signifies the end of the traversal.
 *
 */





public class OptimalSolution {
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
        OptimalSolution sol = new OptimalSolution();
        ListNode middle = sol.middleNode(head);


        // Print from middle to end
        System.out.print("Middle node and onward: ");
        while (middle != null) {
            System.out.print(middle.data + " ");
            middle = middle.next;
        }

    }

}
