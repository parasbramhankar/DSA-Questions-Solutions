package Array.Medium.BestTimeToBuyAndSellStock_II122;

/*
=====================================================================================
Brute-force approach (illustrative)
=====================================================================================

Try every pair of buy/sell days and sum the best profits.

Time Complexity: O(n^2) since we have two nested loops.

Note: This doesn't properly maximize multiple transactions together, but shows how to
brute-force by checking every possible buy-sell pair.

=====================================================================================
*/
/*
=====================================================================================
Brute-force approach (illustrative)
=====================================================================================

Try every pair of buy/sell days and sum the best profits.

Time Complexity: O(n^2) due to nested loops.

Note: This is primarily for educational purposes to see how a naive approach
would look. It checks all possible transactions in pairs and attempts to
accumulate profits.

=====================================================================================
*/

public class BruteForce {

    public int calculateMaxProfitBruteForce(int[] prices) {
        int n = prices.length;
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i];

                    // Recursively compute max profit from remaining days
                    profit += findMaxProfitInSubarray(prices, j + 1, n - 1);

                    if (profit > totalProfit) {
                        totalProfit = profit;
                    }
                }
            }
        }
        return totalProfit;
    }

    // Helper method to compute max profit in a subarray using same brute-force idea
    private int findMaxProfitInSubarray(int[] prices, int start, int end) {
        int subProfit = 0;

        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (prices[j] > prices[i]) {
                    subProfit = Math.max(subProfit, prices[j] - prices[i]);
                }
            }
        }
        return subProfit;
    }

    public static void main(String[] args) {
        BruteForce solution = new BruteForce();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = solution.calculateMaxProfitBruteForce(prices);
        System.out.println("Maximum profit (Brute Force) is: " + result);
    }
}



