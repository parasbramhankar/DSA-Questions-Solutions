package Array.Easy.BestTimeToBuyAndSellStock121;

/*

✅ Approach Explanation:

This brute-force method calculates the maximum profit that can be earned by
buying and selling a stock exactly once.

Steps:

1. Iterate through each day as a potential buy day (index `i`).
2. For each buy day, iterate over all future days (index `j > i`) as sell days.
3. If the selling price `prices[j]` is greater than the buying price `prices[i]`, calculate the profit.
4. Update `maxPro` with the maximum profit seen so far.
5. Return the highest profit found.

⚠️ Time complexity is O(n²), which is inefficient for large input.

 */

import java.util.Scanner;

public class BruteForce {

    static public int maxProfit(int[] prices) {
        int maxPro = 0; // Variable to store the maximum profit
        int n = prices.length; // Total number of days

        // Outer loop for choosing the buying day
        for (int i = 0; i < n; i++) {
            // Inner loop for choosing the selling day after buying
            for (int j = i + 1; j < n; j++) {
                // If the selling price is greater than buying price, calculate profit
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i]; // Potential profit
                    maxPro = Math.max(maxPro, profit);  // Update maximum profit if higher
                }
            }
        }
        return maxPro; // Return the maximum profit found
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
