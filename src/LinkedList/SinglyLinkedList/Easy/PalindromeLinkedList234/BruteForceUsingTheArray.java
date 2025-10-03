package LinkedList.SinglyLinkedList.Easy.PalindromeLinkedList234;

public class BruteForceUsingTheArray {


    static int findTheLength(ListNode head) {
        int length = 0;

        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    static boolean checkPallindrome(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        int length = findTheLength(head);
        int[] arr = new int[length];
        int i = 0;
        ListNode temp = head;
        while (temp != null) {
            arr[i] = temp.val;
            temp = temp.next;
            i++;
        }
        return checkPallindrome(arr);
    }

    public static void main(String[] args) {
        // Create the linked list: 1 → 2 → 2 → 1
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))));

       boolean result=isPalindrome(head);

        System.out.println("Is the linked list a palindrome: ?\n" + result);

    }

}
