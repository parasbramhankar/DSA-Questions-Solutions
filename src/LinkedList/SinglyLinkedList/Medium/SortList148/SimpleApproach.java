package LinkedList.SinglyLinkedList.Medium.SortList148;


/**
 * Merge Sort for Singly Linked List:
 * ------------------------------------
 *     1. If the list is empty or has only one node, it is already sorted;
 *        this is our base case for recursive calls.
 *
 *     2. To divide the list, find the middle node using slow and fast pointers:
 *        - Initialize both at the start.
 *        - Move slow by one step, and fast by two steps.
 *        - When fast reaches the end, slow will be at the middle.
 *
 *     3. Split the list into two halves at the middle:
 *        - Set the 'next' of middle node to null.
 *
 *     4. Recursively sort the left half.
 *
 *     5. Recursively sort the right half.
 *
 *     6. Merge the two sorted halves using the merge function:
 *        - Compare the two nodes at the head of both lists.
 *        - Attach the smaller one to the result, move its pointer forward.
 *        - Repeat until one list is exhausted.
 *        - Append remaining nodes of the other list.
 *
 *     7. The recursive merge steps produce a sorted linked list.
 *
 *     8. Utility functions include display and getMiddle.
 *
 *     9. This approach takes O(n log n) time, and uses O(log n) space for recursion.
*/

public class SimpleApproach {

    static void display(ListNode head){
        ListNode temp=head;

        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("null\n");
    }

    static ListNode merge(ListNode l1,ListNode l2){
        ListNode lists=new ListNode(0);
        ListNode list=lists;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                list.next=l1;
                l1=l1.next;
            }else{
                list.next=l2;
                l2=l2.next;
            }

            list=list.next;
        }

        if(l1!=null){
            list.next=l1;
        }

        if(l2!=null){
            list.next=l2;
        }

        return lists.next;
    }
    static ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;

        ListNode l1=mergeSort(head);
        ListNode l2=mergeSort(slow);

        return merge(l1,l2);


    }
    public static void main(String[] args) {
        ListNode head=new ListNode(5);
        head.next=new ListNode(1);
        head.next.next=new ListNode(55);
        head.next.next.next=new ListNode(32);
        head.next.next.next.next=new ListNode(11);
        head.next.next.next.next.next=new ListNode(9);
        head.next.next.next.next.next.next=new ListNode(2);

        System.out.println("Before Sorting: ");
        display(head);

        ListNode newHead=mergeSort(head);

        System.out.println("After Sorting: ");
        display(newHead);

    }
}


/*
------------------------------------------------------------------------------------------------
Approach and Logic
------------------------------------------------------------------------------------------------
Recursive Merge Sort: We use a recursive method to split the linked list into halves,
                      sort each half, and then merge the sorted halves back together.

Splitting the List: To find the midpoint, we use two pointers: slow (moves one step),
                    and fast (moves two steps). When fast reaches the end, slow is at the midpoint.
                    We detach the first half from the second (prev.next = null).

Base Case: If the list is empty or has only one node (head == null || head.next == null),
           it is already sorted — just return it.

Merge Two Sorted Lists: After the two halves are sorted, we merge them using a helper merge function:
                        compare heads of both lists, attach the smaller node, and continue recursively until done.
                        Any remaining nodes are appended to the result.

Display Function: A utility to print the linked list from head to tail,
                  using -> as a separator, and ending with null for clarity.
------------------------------------------------------------------------------------------------------
Why use Merge Sort for Linked Lists?

Merge sort works well for linked lists since it doesn't require random access and can sort in
O(n*log n) time without extra space for arrays.
-----------------------------------------------------------------------------------------------------
Dry Run Example 1
Input: 5 -> 1 -> 55 -> 32 -> 11 -> 9 -> 2

Step-by-Step:
First Split: List gets split into roughly two halves.

5 -> 1 -> 55 -> 32 (head)

11 -> 9 -> 2 (slow)

Each half is recursively sorted:

5 -> 1 -> 55 -> 32 splits into only two (5 -> 1) and (55 -> 32). Finally, they split to single nodes, then recursively merge:

Sorting 5 -> 1: split to 5, 1 → merge yields 1 -> 5

Sorting 55 -> 32: split to 55, 32 → merge yields 32 -> 55

Merge 1 -> 5 and 32 -> 55: results 1 -> 5 -> 32 -> 55

Next, sort and merge 11 -> 9 -> 2 → split to 11, 9 -> 2; then 9 -> 2 splits to 9, 2. Merges: 2 -> 9, then 2 -> 9 -> 11.

Final Merge: Merge 1 -> 5 -> 32 -> 55 and 2 -> 9 -> 11: step-by-step, compare each node, attach smaller, move pointer.

Order: compare 1 (left) vs 2 (right), insert 1; then 2, then 5, etc.

Final result: 1 -> 2 -> 5 -> 9 -> 11 -> 32 -> 55
------------------------------------------------------------------------------------------------------
Dry Run Example 2
Input: 9 -> 8 -> 5 -> 2

Step-by-step:
Split:

9 -> 8 and 5 -> 2

Each half recursively sorted:

9 -> 8: split to 9, 8 → merge yields 8 -> 9

5 -> 2: split to 5, 2 → merge yields 2 -> 5

Final Merge: Merge 8 -> 9 and 2 -> 5 → compare, insert in sorted order:

2 then 5 then 8 then 9 → result is 2 -> 5 -> 8 -> 9

 */