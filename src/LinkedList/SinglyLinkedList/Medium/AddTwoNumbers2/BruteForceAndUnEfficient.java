package LinkedList.SinglyLinkedList.Medium.AddTwoNumbers2;

public class BruteForceAndUnEfficient {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int num1=0;
            int num2=0;
            int p=0;

            ListNode temp1=l1;
            while(temp1!=null){
                num1=num1+(temp1.data*(int)Math.pow(10,p));
                temp1=temp1.next;
                p++;
            }
            p=0;

            ListNode temp2=l2;
            while(temp2!=null){
                num2=num2+(temp2.data*(int)Math.pow(10,p));
                temp2=temp2.next;
                p++;
            }

            int num=num1+num2;

            int digit=num%10;
            num/=10;
            ListNode newhead=new ListNode(digit);
            ListNode f=newhead;

            while(num>0){
                digit=num%10;
                f.next=new ListNode(digit);
                f=f.next;
                num/=10;
            }
            return newhead;
        }

}
