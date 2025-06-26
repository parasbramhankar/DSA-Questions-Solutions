package Array.Easy.DistributeCandies575;

import java.util.HashSet;
import java.util.Set;
/*
✅ 2. Approach & Logic (In-Depth)

    🔎 Step-by-step Thought Process:

    1. Find Unique Candy Types:

       * Since the same type of candy can appear multiple times, we need to count how many unique types exist.
       * Use a `HashSet` to store unique elements.

    2. Limit on Number of Candies Alice Can Eat:

       * Alice can eat only half of the total candies. So `maxCandiesAliceCanEat = n / 2`.

    3. Maximize Different Types:

       * We want to give Alice as many different types as possible, but not more than `n / 2`, because she can eat only that many.
       * Hence, the result is:
         ➤ `min(number of unique types, n / 2)`
---
 */

/*
✅ Important:

🕒Time Complexity: O(n)

Where `n` is the number of elements in the `candyType` array.

Breakdown:

* Creating HashSet + Looping through array:
  The `for` loop runs `n` times, and each insertion in a `HashSet` is on average O(1) (because HashSet uses hashing).
  → So this loop takes O(n) time.

* Calling `uniqueTypes.size()`:
  This is O(1), just returns the size of the set.

* Other operations (division, `Math.min`):
  These are constant time → O(1).

 ✅ Final Time Complexity:

O(n)
---

🧠 Space Complexity: O(k)

Where `k` is the number of unique candy types in the array.

 Breakdown:

* The only extra space used is the `HashSet<Integer> uniqueTypes`:

  * In the worst case, all candies are of different types → then `k = n`.
  * So the HashSet could store up to `n` unique integers.

 ✅ Final Space Complexity:

O(k) → where `k` ≤ `n`
Worst case: O(n) if all elements are unique.

---

 ✅ Summary

|       Type       |    Complexity     |
| ---------------- | ----------------- |
| Time Complexity  | O(n)              |
| Space Complexity | O(k) (≤ O(n))     |

 */
public class Optimize {

    // Function to calculate the max number of different candy types Alice can eat
    public static int distributeCandies(int[] candyType) {

        // Step 1: Use a HashSet to store unique candy types
        Set<Integer> uniqueTypes = new HashSet<>();

        // Traverse each candy and add it to the set
        // (Duplicates will automatically be ignored by HashSet)
        for (int candy : candyType) {
            uniqueTypes.add(candy);
        }

        // Step 2: Alice can eat only half of the total candies
        int maxCandiesAliceCanEat = candyType.length / 2;

        // Step 3: Total number of unique candy types
        int uniqueCandyTypes = uniqueTypes.size();

        // Step 4: Alice can eat either all unique types OR just half candies
        // So return the minimum of the two
        return Math.min(uniqueCandyTypes, maxCandiesAliceCanEat);
    }

    // Test the function
    public static void main(String[] args) {
        int[] candyType = {1, 1, 2, 2, 3, 3}; // Example input
        int result = distributeCandies(candyType);
        System.out.println("Maximum types Alice can eat: " + result);  // Output: 3
    }
}
