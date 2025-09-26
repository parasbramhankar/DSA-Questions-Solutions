package String.Easy.RemoveOutermostParentheses1021;

import java.util.Scanner;

public class Solution {

    static String removeOuterParentheses(String s){
        int count=0;
        StringBuilder sb=new StringBuilder();

        for(char ch:s.toCharArray()){
            if(ch=='('){
                count++;
                if(count>1){
                    sb.append('(');
                }
            }else{
                if(count>1){
                    sb.append(')');
                }
                count--;
            }
        }
        return new String(sb);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String s=scanner.next();

        String innerParentheses=removeOuterParentheses(s);

        System.out.println("Inner Parenthesis: "+innerParentheses);
    }
}
