package Stack.Medium.EvaluateReversePolishNotation150;

import java.util.Stack;

public class Solution {

    public static int evaluateExpression(String[] tokens){
        Stack<Integer>str=new Stack<>();

        for(String s:tokens){
            if(s.equals("+")){
                str.push(str.pop()+str.pop());
            } else if (s.equals("-")) {
                int first=str.pop();
                int sec=str.pop();
                str.push(sec-first);
            } else if (s.equals("/")) {
                int first=str.pop();
                int sec=str.pop();

                str.push(sec/first);
            } else if (s.equals("*")) {
                str.push(str.pop()*str.pop());
            }else{
                str.push(Integer.parseInt(s));
            }
        }

        return str.peek();
    }
    public static void main(String[] args) {

        String []str1=new String[]{"2","1","+","3","*"};
        String []str2=new String[]{"4","13","5","/","+"};

        int ans=evaluateExpression(str1);
        int ans1=evaluateExpression(str2);

        System.out.println("Final ans: "+ans);
        System.out.println("Final ans: "+ans1);

    }
}
