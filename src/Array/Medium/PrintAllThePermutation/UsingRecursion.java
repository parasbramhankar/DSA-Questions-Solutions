/*
package Array.Medium.PrintAllThePermutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsingRecursion {

    public static void recursiveFunction(int[]arr, List<List<Integer>>ans,List<Integer>ds,boolean[]check){
        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!check[i]){
                check[i]=true;
                ds.add(arr[i]);
                recursiveFunction(arr,ans,ds,check);
                ds.removeLast();
                check[i]=false;
            }
        }
    }

    public  static List<List<Integer>>printAllPermutation(int[]arr){
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ds=new ArrayList<>();
        boolean[]check=new boolean[arr.length];

        recursiveFunction(arr,ans,ds,check);

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        List<List<Integer>>ans=printAllPermutation(arr);

        System.out.println(ans);

    }

}
*/

package Array.Medium.PrintAllThePermutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UsingRecursion {

    /**
     * Helper recursive function that builds permutations.
     *
     * @param arr   input array of numbers
     * @param ans   list that collects all full permutations (each permutation is a List<Integer>)
     * @param ds    current partial permutation (dynamic sequence)
     * @param used  boolean array marking which indices from arr are already used in `ds`
     */

    public static void recursiveFunction(int[] arr, List<List<Integer>> ans, List<Integer> ds, boolean[] used) {
        // BASE CASE: if the current partial permutation `ds` has the same length as the input array,
        // we have formed one complete permutation. Add a copy of `ds` to `ans` and return.
        if (ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds)); // copy because ds is reused
            return;
        }

        // Try to place every element arr[i] at the next position of the permutation
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) { // choose element if not used
                used[i] = true;
                ds.add(arr[i]);

                // Recursive call to fill the next position
                recursiveFunction(arr, ans, ds, used);

                // BACKTRACK: undo the choice
                ds.remove(ds.size() - 1);
                used[i] = false;
            }
        }
    }

    /**
     * Public method that prepares data structures and starts recursion.
     */
    public static List<List<Integer>> printAllPermutation(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>(); // store all permutations
        List<Integer> ds = new ArrayList<>();        // current permutation
        boolean[] used = new boolean[arr.length];    // mark used elements

        recursiveFunction(arr, ans, ds, used);
        return ans;
    }

    /**
     * MAIN METHOD: reads input and prints permutations.
     * Input format: first n (size), then n integers. Example: 3 1 2 3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n then n integers (e.g. 3 1 2 3):");

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        List<List<Integer>> ans = printAllPermutation(arr);

        // Print results line by line
        for (List<Integer> perm : ans) {
            System.out.println(perm);
        }

        scanner.close();
    }
}

/* ===============================================================
   STEP-BY-STEP APPROACH (simple language)
   ===============================================================
   Goal: Print all permutations of the given array.

   1. Keep a working list `ds` – stores the current partial permutation.
   2. Keep a boolean array `used[]` – true if that element is already picked.
   3. Start with empty `ds` and all `used[] = false`.
   4. At each step:
      - If `ds.size() == arr.length`, record one permutation.
      - Else, try every element that is not used yet:
          • Pick it → mark used → recurse.
          • After recursion, undo choice (backtrack).
   5. Continue until all branches are explored.

   Why copy list? Because `ds` is reused across calls.

   ===============================================================
   DRY RUN with arr = [1, 2, 3]
   ===============================================================
   Start: ds = [], used = [F,F,F]
   → Pick 1 → ds=[1]
       → Pick 2 → ds=[1,2]
           → Pick 3 → ds=[1,2,3] → record it
       → Backtrack to [1]
       → Pick 3 → ds=[1,3,2] → record it
   → Backtrack to []
   → Pick 2 → ds=[2]
       → Pick 1 → ds=[2,1,3] → record it
       → Pick 3 → ds=[2,3,1] → record it
   → Backtrack to []
   → Pick 3 → ds=[3]
       → Pick 1 → ds=[3,1,2] → record it
       → Pick 2 → ds=[3,2,1] → record it

   Final permutations:
   [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]

   ===============================================================
   COMPLEXITY:
   - Time: O(n * n!) (n! permutations, each costs O(n) to build).
   - Space: O(n) recursion + O(n * n!) results.
   ===============================================================
*/
