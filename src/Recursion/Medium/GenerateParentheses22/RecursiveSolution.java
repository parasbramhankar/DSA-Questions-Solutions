package Recursion.Medium.GenerateParentheses22;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursiveSolution {

    static ArrayList<String> generateParentheses(int n){

        ArrayList<String>stringArrayList=new ArrayList<>();
        int close=0;
        int open=0;

        function(stringArrayList,open,close,n,new StringBuilder());

        return stringArrayList;
    }

    static void function(ArrayList<String>stringArrayList,int open, int close,int n,StringBuilder str){
        if(str.length()==2*n){
            stringArrayList.add(str.toString());
            return;
        }

        if(open<n){
            str.append("(");
            function(stringArrayList,open+1,close,n,str);
            str.deleteCharAt(str.length()-1);
        }

        if(open>close){
            str.append(")");
            function(stringArrayList,open,close+1,n,str);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the n");
        int n=scanner.nextInt();

        ArrayList<String>stringArrayList=generateParentheses(n);
        System.out.println(stringArrayList);
    }
}
