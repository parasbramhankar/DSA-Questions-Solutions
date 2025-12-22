package Stack.Medium.DailyTemperatures739;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    static int[] function(int[]temp){

        Stack<Integer>stack=new Stack<>();
        int[]ans=new int[temp.length];

        for(int i=0;i<temp.length;i++){

            while(!stack.isEmpty() && temp[i]>temp[stack.peek()]){
                ans[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[]temp=new int[]{73,74,75,71,69,72,76,73};

        int []ans=function(temp);

        System.out.println("Answer: "+ Arrays.toString(ans));
    }
}
