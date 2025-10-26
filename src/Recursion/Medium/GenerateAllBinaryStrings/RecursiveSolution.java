package Recursion.Medium.GenerateAllBinaryStrings;

import java.util.ArrayList;
import java.util.Scanner;

/*
Approach and Logic Explanation:
-------------------------------
Goal:
-----
We need to generate all possible binary strings of length 'n'.
Each binary string can contain only '0' or '1' at every position.

Example:
---------
If n = 2, we want -> ["00", "01", "10", "11"]
If n = 3, we want -> ["000", "001", "010", "011", "100", "101", "110", "111"]

Approach:
----------
We use recursion to build all possible combinations step by step.

1. Start with an empty string builder (str = "").
2. At each recursive call, we have two choices:
   a) Add '0' to the current string
   b) Add '1' to the current string
3. We explore both choices recursively until the string reaches length n.
4. Once str.length() == n (base condition):
   - Add the completed binary string into the ArrayList.
   - Return to explore other possibilities (backtrack).

We use StringBuilder instead of String concatenation to efficiently modify strings
(since "+" creates a new string every time).

Backtracking step:
------------------
After exploring one choice (say adding '0'):
 - We remove the last character (deleteCharAt) to backtrack,
   so that the same StringBuilder can be reused to try the next choice ('1').

Function Call Flow:
-------------------
function(list, n, str):
   if str.length == n:
       add str
       return
   append '0', recurse
   backtrack
   append '1', recurse
   backtrack

So in each node of recursion tree, there are 2 branches — '0' branch and '1' branch.

----------------------------------------------------------
Dry Run Example 1: n = 2
----------------------------------------------------------
Initial: str = ""

Call Tree Expansion:

function([], n=2, str="")
│
├── append '0' → str = "0"
│     ├── append '0' → str = "00" (length=2) → add "00"
│     └── backtrack: str="0"
│     ├── append '1' → str = "01" (length=2) → add "01"
│     └── backtrack: str=""
│
├── append '1' → str = "1"
│     ├── append '0' → str = "10" (length=2) → add "10"
│     └── backtrack: str="1"
│     ├── append '1' → str = "11" (length=2) → add "11"
│     └── backtrack: str=""

Final Output: ["00", "01", "10", "11"]

----------------------------------------------------------
Dry Run Example 2: n = 3
----------------------------------------------------------
Call trace:
str = ""

Level 1 → append '0'
    Level 2 → append '0'
        Level 3 → append '0' → "000" → add
        Backtrack → str="00"
        append '1' → "001" → add
        Backtrack → str="0"
    Level 2 → append '1'
        Level 3 → append '0' → "010" → add
        Backtrack → str="01"
        append '1' → "011" → add
        Backtrack → str="0"
Backtrack → str=""

Level 1 → append '1'
    Level 2 → append '0'
        Level 3 → append '0' → "100" → add
        Backtrack → str="10"
        append '1' → "101" → add
        Backtrack → str="1"
    Level 2 → append '1'
        Level 3 → append '0' → "110" → add
        Backtrack → str="11"
        append '1' → "111" → add
        Backtrack → str=""

Final Output:
-------------
["000", "001", "010", "011", "100", "101", "110", "111"]

----------------------------------------------------------
Time Complexity:
----------------
Each position has 2 choices, total O(2^n) combinations.

Space Complexity:
-----------------
O(n) recursion depth + O(2^n) output storage
*/





public class RecursiveSolution {

    static ArrayList<String> generateBinaryString(int n){
        ArrayList<String> stringArrayList=new ArrayList<>();

        function(stringArrayList,n,new StringBuilder(""));

        return stringArrayList;
    }

    static void  function(ArrayList<String>stringArrayList,int n, StringBuilder str){

        if(str.length()==n){
            stringArrayList.add(str.toString());
            return;
        }

        str.append("0");
        function(stringArrayList,n,str);
        str.deleteCharAt(str.length()-1);

        str.append("1");
        function(stringArrayList,n,str);
        str.deleteCharAt(str.length()-1);
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=scanner.nextInt();

        ArrayList<String>stringArrayList=generateBinaryString(n);
        System.out.println(stringArrayList);
    }
}
