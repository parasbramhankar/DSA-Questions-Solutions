package Array.Easy.BestTimeToBuyAndSellStock121;


/*
✅ Approach Explanation (One-Pass):

This method finds the maximum profit by tracking the minimum price so far and
calculating profit for each price seen.

Steps:

1. Initialize `minPrice` to a very large value (infinity).
2. Loop through the array:
   * If the current price is less than `minPrice`, update `minPrice`.
   * Otherwise, calculate profit as `currentPrice - minPrice`.
   * Update `maxPro` if this profit is greater than the previous maximum.
3. Return `maxPro` at the end.

This ensures you buy at the lowest price so far and sell at the highest price later.

 */
import java.util.Scanner;

public class Optimize {

    static public int maxProfit(int[] prices) {
        int maxPro = 0; // Store the maximum profit
        int minPrice = Integer.MAX_VALUE; // Track the minimum price seen so far

        // Traverse each price in the array
        for (int num : prices) {
            // Update minPrice if a lower price is found
            if (num < minPrice) {
                minPrice = num;
            }
            // Else check if selling at current price gives a higher profit
            else if (num - minPrice > maxPro) {
                maxPro = num - minPrice; // Update maxPro if current profit is higher
            }
        }
        return maxPro; // Return the maximum profit possible
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int majorityElement = maxProfit(arr);

        System.out.println("The Maximum Profit : " + majorityElement);
    }


}
