package LinkedList.SinglyLinkedList.Medium.RemoveNthNodeFromEndofList19;


import LinkedList.SinglyLinkedList.Easy.ReverseALinkedList206.Solution;

public class Solution_1 {

    static Node removeNthNodeFromLast(Node head,int n){
        Node temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }

        temp=head;
        if(n==size){
            return head.next;
        }

        for(int i=0;i<size-n-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;

        return head;
    }

    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(50);

        System.out.println("Before removing the nth node from the last: ");
        display(head);

        head=removeNthNodeFromLast(head,2);

        System.out.println("After removing the node:");
        display(head);

    }
}
