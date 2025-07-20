package LinkedList.SinglyLinkedList.Easy.LinkedListCycle141;

import java.util.HashMap;
import java.util.Map;

public class BruteForce {

        public boolean hasCycle(ListNode head) {

            Map<ListNode,Integer> map=new HashMap<>();

            ListNode temp=head;

            while(temp!=null){
                if(map.containsKey(temp)){
                    return true;
                }else{
                    map.put(temp,1);
                }

                temp=temp.next;

            }

            return false;


    }
}
