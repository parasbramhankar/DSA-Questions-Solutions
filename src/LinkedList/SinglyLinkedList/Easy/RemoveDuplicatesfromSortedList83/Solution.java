package LinkedList.SinglyLinkedList.Easy.RemoveDuplicatesfromSortedList83;


class Node{
    Node next;
    int data;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class Solution {


    public static void displayList(Node head){
        Node temp=head;

        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static Node removeDuplicate(Node head){
        if(head==null){
            return null;
        }
        Node dummy=new Node(head.data);
        Node left=dummy;

        Node right=head;

        while(right!=null){
            if(right.data!=left.data){
                left.next= new Node(right.data);
                left=left.next;
            }

            right=right.next;
        }

        return dummy;
    }

    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(1);
        head.next.next=new Node(2);
        System.out.println("Before Removing the duplicates");
        displayList(head);

        Node ans=removeDuplicate(head);
        System.out.println("After removing the duplicates");
        displayList(ans);
    }
}
