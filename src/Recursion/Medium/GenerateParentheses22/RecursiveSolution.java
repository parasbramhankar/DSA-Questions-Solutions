package Recursion.Medium.GenerateParentheses22;
/*
-----------------------------------------------
PROBLEM: Generate Parentheses
-----------------------------------------------

We are given an integer n.
We need to generate all combinations of well-formed (valid) parentheses
using exactly n opening '(' and n closing ')'.

-----------------------------------------------
APPROACH: Backtracking
-----------------------------------------------

This problem is solved using RECURSION + BACKTRACKING.

We build the string step by step and make decisions at each step:
- Add '('
- Add ')'

But we must follow 2 IMPORTANT RULES to keep the parentheses valid:

1️⃣ We can add '(' only if open < n
   (Because we can use maximum n opening brackets)

2️⃣ We can add ')' only if close < open
   (Because we cannot close more brackets than we have opened)

-----------------------------------------------
LOGIC FLOW
-----------------------------------------------

We maintain:
- StringBuilder str → current string being built
- open → number of '(' used
- close → number of ')' used
- n → total pairs required
- ans → list to store final valid combinations

Base Case:
If str.length() == 2 * n
→ That means we used all brackets
→ Add string to answer list
→ Return

Recursive Case:

Step 1:
If open < n
→ Add '('
→ Call recursion
→ Backtrack (remove last character)

Step 2:
If close < open
→ Add ')'
→ Call recursion
→ Backtrack (remove last character)

-----------------------------------------------
WHY BACKTRACKING?
-----------------------------------------------

After exploring one possibility,
we remove the last added character
so we can explore other possible combinations.

This ensures all valid combinations are generated.

-----------------------------------------------
TIME COMPLEXITY
-----------------------------------------------

O(2^n) approx
(Actually equal to Catalan Number count)

-----------------------------------------------
SPACE COMPLEXITY
-----------------------------------------------

O(n) recursion stack
-----------------------------------------------
*/



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
