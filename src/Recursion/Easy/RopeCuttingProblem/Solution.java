package Recursion.Easy.RopeCuttingProblem;

import java.util.Scanner;
/**
 * Calculates the maximum number of pieces a rope of length 'n' can be cut into
 * using only cuts of lengths 'a', 'b', and 'c'.
 *
 * Approach:
 * -----------------------------------------------------------------------
 * The function uses recursion to explore all possible ways to cut the rope.
 *
 * Logic:
 * 1. Base Case:
 *    - When the rope length 'n' is exactly 0, no cuts are needed, so return 0.
 *    - When 'n' becomes negative, it means the current cutting path is invalid, return -1.
 *
 * 2. Recursive Case:
 *    - Recursively try cutting by length 'a', 'b', and 'c' by reducing 'n' accordingly.
 *    - Get the maximum number of cuts possible from these recursive calls.
 *
 * 3. If all recursive results return -1, it means no valid cuts are possible for this 'n'.
 *    Return -1.
 *
 * 4. Otherwise, add 1 to the maximum valid recursive result, counting the current cut.
 *
 * Dry Run (Example: n=5, a=2, b=5, c=1):
 * - Start with n=5:
 *   - Try cut of 2: recurse with n=3.
 *   - Try cut of 5: recurse with n=0 → returns 0 (valid; rope fully cut).
 *   - Try cut of 1: recurse with n=4.
 * - For n=3 or n=4, recursion continues similarly exploring all cuts.
 * - Among all valid paths, find the one that yields the maximum number of pieces.
 *
 * This method guarantees exploration of all possible combinations and returns
 * the maximum number of cuts possible to exactly reduce the rope length to zero.
 *
 * Note:
 * - This recursive method can be inefficient for large 'n' due to overlapping subproblems.
 * - It can be optimized using dynamic programming or memoization.
 *
 */


public class Solution {
    static int function(int n,int a,int b,int c){
        if(n==0){
            return 0;
        }

        if(n<=-1){
            return -1;
        }

        int result=Math.max(function(n-a,a,b,c),Math.max(function(n-b,a,b,c),function(n-c,a,b,c)));

        if(result==-1){
            return -1;
        }

        return result+1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the rope: ");
        int n=scanner.nextInt();

        System.out.println("Enter the length of cuts");
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int c= scanner.nextInt();

        int maximumCuts=function(n,a,b,c);

        System.out.println("Maximum Cuts: "+maximumCuts);

    }
}

/*
 * Here is a step-by-step dry run of your rope cutting recursive code with input (n=5, a=2, b=5, c=1):
 *
 * 1. Call function(5, 2, 5, 1)
 *    - n=5, not 0 or <0, so proceed.
 *    - Compute:
 *      - function(5-2=3, 2,5,1)
 *      - function(5-5=0, 2,5,1)
 *      - function(5-1=4, 2,5,1)
 *
 * 2. function(3, 2, 5, 1)
 *    - n=3, proceed.
 *    - Compute:
 *      - function(3-2=1, 2,5,1)
 *      - function(3-5=-2, 2,5,1) → returns -1 (invalid)
 *      - function(3-1=2, 2,5,1)
 *
 * 3. function(0, 2, 5, 1)
 *    - n=0 base case → return 0 (valid no cuts left)
 *
 * 4. function(4, 2, 5, 1)
 *    - n=4, proceed.
 *    - Compute:
 *      - function(4-2=2, 2,5,1)
 *      - function(4-5=-1, 2,5,1) → -1
 *      - function(4-1=3, 2,5,1)
 *
 * 5. function(1, 2, 5, 1)
 *    - n=1, proceed.
 *    - Compute:
 *      - function(1-2=-1) → -1
 *      - function(1-5=-4) → -1
 *      - function(1-1=0) → 0 (valid)
 *
 * 6. function(2, 2, 5, 1)
 *    - n=2, proceed.
 *    - Compute:
 *      - function(2-2=0) → 0 (valid)
 *      - function(2-5=-3) → -1
 *      - function(2-1=1) → as above, 1 returns max cuts 1
 *
 * 7. Back to function(3,2,5,1):
 *    - results: max(1 (from function(1)), -1, 1 (from function(2))) = 1
 *    - return 1 + 1 = 2
 *
 * 8. Back to function(4,2,5,1):
 *    - results from calls:
 *      - function(2) = max cuts calculated below
 *      - function(-1) = -1
 *      - function(3) = 2 (from above)
 *    - function(2) calls (from step 6):
 *      - max(0, -1, 1) = 1, return 1 + 1 = 2
 *    - So function(4) returns max(2, -1, 2) = 2 + 1 = 3
 *
 * 9. Finally, back to function(5,2,5,1):
 *    - results:
 *      - function(3) = 2 (step 7)
 *      - function(0) = 0
 *      - function(4) = 3 (step 8)
 *    - max = 3
 *    - return 3 + 1 = 4
 *
 * But note a call was function(5-5=0) which returned 0 cuts, meaning 1 cut of length 5. So max also considers 1 cut.
 *
 * However, the best is cutting into five pieces of length 1 each (function(1) repeatedly), totaling 5 cuts.
 *
 * This shows the algorithm recursively explores all paths and eventually identifies the max number of cuts (5 pieces by cutting 1 length five times).
 *
 * The recursion tree unfolds exploring all possible cuts until hitting base cases, collects valid results, picks max, and adds 1 each step to count current cut.
 *
 * This detailed execution demonstrates the recursive steps and maximum cuts calculation for input (5, 2, 5, 1).
 *
 */


/**
Dry run
--------------------

Here is the explicit step-by-step flow of recursive calls for the rope cutting problem with input (n=5, a=2, b=5, c=1):

Start with function(5, 2, 5, 1):
- Check base cases: 5 != 0 and 5 > 0 so proceed.

Try cutting by 2:
- Call function(3, 2, 5, 1)
  - Check base cases: 3 != 0 and 3 > 0 so proceed.
  
  Try cutting by 2:
  - Call function(1, 2, 5, 1)
    - Check base cases: 1 != 0 and 1 > 0 so proceed.
    
    Try cutting by 2:
    - Call function(-1, 2, 5, 1) → n<0 → return -1

    Try cutting by 5:
    - Call function(-4, 2, 5, 1) → n<0 → return -1
    
    Try cutting by 1:
    - Call function(0, 2, 5, 1) → n==0 → return 0
    
    Results for function(1): max(-1, -1, 0) = 0 → Add 1 → return 1

 Try cutting by 5:
  - Call function(-2, 2, 5, 1) → n<0 → return -1

 Try cutting by 1:
  - Call function(2, 2, 5, 1)
    - Check base cases: proceed.

    Try cutting by 2:
    - Call function(0, 2, 5, 1) → return 0
    
    Try cutting by 5:
    - Call function(-3, 2, 5, 1) → return -1
    
    Try cutting by 1:
    - Call function(1, 2, 5, 1) → computed before → returns 1
    
    Results for function(2): max(0, -1, 1) = 1 → Add 1 → return 2

  Results for function(3): max(1, -1, 2) = 2 → Add 1 → return 3

Try cutting by 5:
- Call function(0, 2, 5, 1) → return 0

Try cutting by 1:
- Call function(4, 2, 5, 1)
  - Check base case → proceed.

  Try cutting by 2:
  - Call function(2, 2, 5, 1) → computed before → returns 2

  Try cutting by 5:
  - Call function(-1, 2, 5, 1) → return -1

  Try cutting by 1:
  - Call function(3, 2, 5, 1) → computed before → returns 3

  Results for function(4): max(2, -1, 3) = 3 → Add 1 → return 4

Results for function(5): max(3, 0, 4) = 4 → Add 1 → return 5

Final answer: 5 cuts

This traverses all cut possibilities, with recursive calls branching for each allowed cut length, recursing until base cases and bubbling maximum cuts back up.

This detailed call flow clarifies how recursion explores all possibilities systematically until a final solution emerges.
 */