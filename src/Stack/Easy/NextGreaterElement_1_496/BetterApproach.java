package Stack.Easy.NextGreaterElement_1_496;

import java.util.HashMap;
import java.util.Stack;

public class BetterApproach {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> hs=new HashMap<>();

        for(int i=0;i<nums2.length;i++){

            while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                hs.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
        }
        int []ans=new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            ans[i] = hs.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}

