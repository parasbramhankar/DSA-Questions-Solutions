package BitManipulation.Medium.TwoOddAppearingNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Finds two unique numbers in an array where all other numbers repeat an even number of times.
 *
 * -------- LOGIC & APPROACH --------
 * 1. XOR All Array Elements:
 *    - The loop calculates the XOR (^) of all elements.
 *    - Numbers that appear an even number of times cancel out to 0 (e.g., 1 ^ 1 = 0, 9 ^ 9 ^ 9 ^ 9 = 0).
 *    - What remains in 'xor' is the XOR of the two unique numbers.
 *
 * 2. Find The Rightmost Set Bit:
 *    - The line 'int k = (xor & -xor);' isolates the lowest set bit in 'xor'.
 *    - This bit tells which position the unique numbers differ.
 *
 * 3. Split Into Two Groups & XOR Again:
 *    - Group 1: Numbers with that bit set.
 *    - Group 2: Numbers with that bit not set.
 *    - XOR-ing within each group cancels all duplicates, leaving just one unique number from each group.
 *
 * -------- DRY RUN EXAMPLE --------
 * Array: {1, 1, 5, 7, 9, 9, 9, 9}
 * Step 1: XOR All
 *   - 1 ^ 1 = 0
 *   - 9 ^ 9 ^ 9 ^ 9 = 0
 *   - 0 ^ 5 ^ 7 = 2   (final result, xor = 2)
 *
 * Step 2: Extract Rightmost Set Bit
 *   - k = 2 (binary 10), showing these two numbers differ in the 2's bit.
 *
 * Step 3: Partition Using k
 *   - Group 1: arr[i] & k != 0 → only 7
 *   - Group 2: arr[i] & k == 0 → 1, 1, 5, 9, 9, 9, 9
 *   
 *   HOW ??
 *   
 * Partition Using `k` - In Depth Explanation
 *
 * This step divides the input array into two groups based on the rightmost set bit `k` found in the XOR of the two unique numbers.
 *
 *  Why partition?
 * - The XOR of the two unique numbers has a '1' in bit position `k`, meaning these two numbers differ at that exact bit.
 * - By checking individual elements for this bit, we separate them into different groups.
 *
 *  How grouping works:
 * - For each number `arr[i]`, do `(arr[i] & k)`.
 *   - If not zero, bit `k` is set, and the number goes to Group 1.
 *   - Otherwise, it goes to Group 2.
 *
 *  What happens inside each group?
 * - Every duplicate number will appear twice and will have the same bit pattern at `k`, so they fall into the same group.
 * - XOR-ing all numbers in a group cancels all duplicates (because `x ^ x = 0`).
 * - The unique number in each group remains after cancellation.
 *
 *  Dry run example with array `{1, 1, 5, 7, 9, 9, 9, 9}` and `k = 2` (binary `10`):
 *
 * ----------------------------------------------------------------------------
 * | Number (Decimal) | Binary (4-bit) |   `(arr[i] & k) != 0`?     | Group   |
 * |------------------|----------------|----------------------------|---------|
 * | 1                | `0001`         | No (`0001 & 0010=0`)       | Group 2 |
 * | 1                | `0001`         | No                         | Group 2 |
 * | 5                | `0101`         | No (`0101 & 0010=0`)       | Group 2 |
 * | 7                | `0111`         | Yes (`0111 & 0010=0010`)   | Group 1 |
 * | 9                | `1001`         | No (`1001 & 0010=0`)       | Group 2 |
 * | 9                | `1001`         | No                         | Group 2 |
 * | 9                | `1001`         | No                         | Group 2 |
 * | 9                | `1001`         | No                         | Group 2 |
 * ----------------------------------------------------------------------------
 *
 *
 * - Group 1 contains only: `7`
 * - Group 2 contains: `1, 1, 5, 9, 9, 9, 9`
 *
 * XOR within groups:
 * - Group 1 XOR: `7` (only one number, remains as unique)
 * - Group 2 XOR: `1 ^ 1 ^ 5 ^ 9 ^ 9 ^ 9 ^ 9` which simplifies to `5` after cancellations
 *
 * Summary of Step 3:
 * - Partitioning uses the differing bit `k` to separate the two unique numbers into distinct groups.
 * - Duplicate numbers fall into the same group, ensuring their XOR cancels out.
 * - XOR within each group isolates the unique number.
 *
 * > This partitioning is essential for isolating the two unique numbers efficiently using bit operations.
 *
 * 
 * Step 4: XOR within groups
 *   - Group 1: 7 → result1 = 7
 *   - Group 2: 1 ^ 1 ^ 5 ^ 9 ^ 9 ^ 9 ^ 9 = 5 → result2 = 5
 *
 * -------- SUMMARY --------
 * - Efficient O(n) time, O(1) space.
 * - Classic bit manipulation trick for interview questions and optimizations.
 * - Great for arrays with exactly two odd-count numbers, everything else repeats even times.
 *
 * For more, see GeeksforGeeks or StackOverflow explanations on XOR for unique numbers.
 */

public class OptimizeSolution {

    static List<Integer> findNumber(int[]arr){

        int xor=0;
        int n=arr.length;

        for(int i=0;i<n;i++){
            xor=xor^arr[i];
        }

        int k=(xor & (-xor));
        int res1=0;
        int res2=0;
        for(int i=0;i<n;i++){
            if((arr[i] & k)!=0){
                res1^=arr[i];
            }else{
                res2^=arr[i];
            }
        }

        return new ArrayList<>(Arrays.asList(res1,res2));
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        List<Integer>ans=findNumber(arr);

        System.out.println("Two odd appearing number: "+ ans);
    }


}
