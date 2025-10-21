package BitManipulation.Medium.PowerSetArray78;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PowerSetInArrayUsingBitManipulation {

/***
 * The function 'findThePowerSet(int[] arr)' generates the **power set** of a given array using **bit manipulation**.
 *  The power set is the set of all possible subsets of a given set, including the empty set and the set itself.
 *
 *  --- Concept ---
 *  If a set has `n` elements, its power set will contain `2^n` subsets.
 *  Each subset can be represented by a binary number between 0 and (2^n - 1).
 *  Each bit in the binary representation indicates whether the corresponding element
 *  from the input set is present (1) or absent (0) in that subset.
 *
 *  --- Approach ---
 *  1. **Determine total subsets:**
 *      - For an array of size n, total subsets (power set size) = 2^n.
 *      - This is found by: `int pSize = (int) Math.pow(2, n);`
 *
 *  2. **Iterate through all numbers from 0 to (2^n - 1):**
 *      - Each number `i` acts as a bitmask to generate one subset.
 *      - Example: If n = 3, then i goes from 0 (000) to 7 (111).
 *
 *  3. **For each number i:**
 *      - Check each bit position j (0 to n-1).
 *      - If bit j in i is set `(i & (1 << j)) != 0`, include arr[j] in the current subset.
 *      - This means the j-th element of array participates in this subset.
 *
 *  4. **Add the constructed subset** to the result list.
 *
 *  --- Binary Intuition ---
 *  Let’s say arr = [1, 2, 3]
 *  Number of elements (n) = 3  → total subsets = 2^3 = 8
 *  Binary representations:
 *        Binary | Include Elements | Subset
 *        ---------------------------------
 *        000    | none              | []
 *        001    | 1st element       | [1]
 *        010    | 2nd element       | [2]
 *        011    | 1st & 2nd         | [1, 2]
 *        100    | 3rd element       | [3]
 *        101    | 1st & 3rd         | [1, 3]
 *        110    | 2nd & 3rd         | [2, 3]
 *        111    | 1st, 2nd, 3rd     | [1, 2, 3]
 *
 *  --- Dry Run Example ---
 *  Input: arr = [1, 2, 3]
 *
 *  Step 1: n = 3, pSize = 8
 *  Step 2: loop i = 0 to 7
 *
 *  i = 0 (binary 000): No bits set → subset = []
 *  i = 1 (binary 001): only bit 0 set → subset = [1]
 *  i = 2 (binary 010): only bit 1 set → subset = [2]
 *  i = 3 (binary 011): bits 0,1 set → subset = [1, 2]
 *  i = 4 (binary 100): only bit 2 set → subset = [3]
 *  i = 5 (binary 101): bits 0,2 set → subset = [1, 3]
 *  i = 6 (binary 110): bits 1,2 set → subset = [2, 3]
 *  i = 7 (binary 111): bits 0,1,2 set → subset = [1, 2, 3]
 *
 *  ---> Final Output:
 *  [ [], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] ]
 *
 *  --- Time & Space Complexity ---
 *  Time: O(n * 2^n) → Each of 2^n subsets checks up to n bits.
 *  Space: O(2^n) → to store all subsets in the result list.
 *
 *  --- Summary ---
 *  This algorithm leverages bits to represent inclusion/exclusion of elements.
 *  Each integer from 0 to (2^n - 1) uniquely maps to a subset.
 *  Efficient, elegant, and foundational to many bit-manipulation problems.
*/
    static List<List<Integer>> findThePowerSet(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();

        int n = arr.length;
        int pSize = (int) Math.pow(2, n);  // Total number of subsets

        for (int i = 0; i < pSize; i++) {
            List<Integer> arrList = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                // Check whether j-th bit in i is set
                if ((i & (1 << j)) != 0) {
                    arrList.add(arr[j]);
                }
            }

            list.add(arrList); // Add this subset to the final list
        }

        return list; // Return all subsets
    }
    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of Array elements: ");
        int n=scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        List<List<Integer>>finalList=findThePowerSet(arr);

        System.out.println(finalList.toString());

        scanner.close();
    }
}
