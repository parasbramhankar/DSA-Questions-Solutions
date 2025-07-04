package Array.Medium.BestTimeToBuyAndSellStock_II122;
/*
/*
=====================================================================================
Detailed Explanation of Logic and Approach
=====================================================================================

Problem Summary:
-----------------
You are given an integer array 'prices' where prices[i] is the price of a stock on the i-th day.

You want to maximize the total profit by performing as many transactions as you want.
A transaction consists of buying and then selling the stock. However:
- You can only hold at most one share at a time (must sell before buying again).
- You may buy and sell on the same day.

Logic & Approach (Greedy):
---------------------------
The best way to maximize the profit is to capture every opportunity where the price increases.

- If prices[i+1] > prices[i], it means we can profit by buying at prices[i] and selling at prices[i+1].
- We can simply sum up all such differences (prices[i+1] - prices[i]) to get the maximum profit.

This is effectively the same as making a new buy/sell transaction for each rise,
even if in reality you might hold it over several days.

Why this works:
---------------
- Whether you buy once and sell at the end of a continuous rise, or buy/sell on each increase,
  the total profit remains the same.

Example:
---------
For prices = [1,2,3,4,5]:
- Buying at 1 and selling at 5 gives profit = 4.
- Buying at 1, selling at 2 (+1), buying at 2, selling at 3 (+1), ... totals to 4.

Time Complexity: O(n)
Space Complexity: O(1)

=====================================================================================
*/
public class Optimize {
    /**
     * Calculates the maximum profit by buying and selling multiple times,
     * capturing all upward price movements.
     *
     * @param prices array of stock prices where prices[i] is the price on day i
     * @return maximum total profit achievable
     */
    /*
    Your current function is actually the optimal greedy solution for this problem.
    It runs in O(n) time and O(1) space, because it:

    1. Just iterates once through the array.

    2. Adds up all the positive differences prices[i+1] - prices[i] whenever the next day is higher.

    This is the most efficient approach possible for this problem.
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            // If tomorrow's price is higher, buy today and sell tomorrow
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Example input array of prices
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Call the function and print the result
        int maxProfit = maxProfit(prices);

        System.out.println("Maximum profit is: " + maxProfit);
    }
}
/*
=====================================================================================
Step-by-Step Dry Run
=====================================================================================

Example Input:
--------------
prices = [7,1,5,3,6,4]

Tracking:
---------
maxProfit = 0

Loop through prices:

i=0: prices[0]=7, prices[1]=1
    - prices[1] < prices[0] => no transaction

i=1: prices[1]=1, prices[2]=5
    - prices[2] > prices[1] => buy at 1, sell at 5
    - profit = 5-1 = 4
    - maxProfit = 0 + 4 = 4

i=2: prices[2]=5, prices[3]=3
    - prices[3] < prices[2] => no transaction

i=3: prices[3]=3, prices[4]=6
    - prices[4] > prices[3] => buy at 3, sell at 6
    - profit = 6-3 = 3
    - maxProfit = 4 + 3 = 7

i=4: prices[4]=6, prices[5]=4
    - prices[5] < prices[4] => no transaction

Result:
-------
Maximum profit = 7

=====================================================================================
*/
