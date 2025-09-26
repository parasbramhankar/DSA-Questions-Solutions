package String.Easy.RotateString796;

import java.util.Scanner;
/***
Approach and Logic:

1. First, check if the lengths of the two input strings 's' and 'goal' are equal.
   - If they are not equal, 's' cannot be rotated to form 'goal'. So, return false.

2. If lengths are equal, create a new string 'str' by concatenating 's' with itself.
   - This doubled string 'str' contains all possible rotations of 's' as substrings.
   - For example, if s = "abcde", then str = "abcdeabcde".

3. Now, check if 'goal' is a substring of 'str'.
   - If yes, it means 'goal' is a rotation of 's'.
   - Otherwise, 'goal' is not a rotation of 's'.

4. Return the result of this substring check.
----------------------------------------------------------------------------------------------
Dry Run:
----------------------------------------------------------------------------------------------
Input:
s = "abcde"
goal = "deabc"

Step 1: Length of 's' and 'goal' are both 5, so continue.

Step 2: Create str = s + s = "abcdeabcde".

Step 3: Check if str.contains("deabc"):
- "deabc" is a substring of "abcdeabcde" starting at index 3.
- Therefore, return true.

Output:
Yes, 'String s' can become 'String goal' after some number of shifts on 'String s'.

Summary:
This approach efficiently detects rotations by leveraging the doubled string containing all rotations as substrings.
-------------------------------------------------------------------------------------
 Time Complexity: O(n)

 Where n is the length of the string, due to the substring search operation.
*/
public class Solution {
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        String str=s+s;
        return str.contains(goal);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String s=scanner.next();
        String goal= scanner.next();

        boolean checkRotatedString=rotateString(s,goal);

        if(checkRotatedString){
            System.out.println("Yes, 'String s' can become 'String goal' after some number of shifts on 'String s'.");
        }
    }

}
