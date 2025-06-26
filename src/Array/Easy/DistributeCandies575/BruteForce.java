package Array.Easy.DistributeCandies575;

import java.util.ArrayList;
import java.util.List;
/*
✅ Logic & Approach (Brute Force)

# Idea:

* Iterate through the list of candies.
* Maintain a `List<Integer>` to track which unique candy types Alice has already chosen.
* If a new type is encountered (not already in the list), and she hasn't reached her limit (`n / 2`), add it to the list.
* Stop once she’s either:

  * Reached `n / 2` different types (maximum allowed candies),
  * Or finished scanning the entire array.

This solution uses a linear scan + linear search to collect unique elements manually.


✅ Time and Space Complexity

# 🕒 Time Complexity: O(n \* k)

Where:

* `n` = length of the array,
* `k` = number of elements currently in the `chosen` list (in worst case, up to `n/2`)

 Why?

* The loop runs at most `n` times.
* On each iteration, the call to `chosen.contains()` is a linear search, which takes O(k) time.
* In the worst case, we search through up to `n/2` elements for each of `n` candies.

So, worst-case time:
👉 O(n × n/2) = O(n²)
---

# 🧠 Space Complexity: O(k) → where `k = n/2`

    * The `chosen` list stores at most `n/2` unique elements.
    * So auxiliary space = O(n/2) = O(n) in worst case.

---

 ✅ Summary

| Type             | Complexity         |
| ---------------- | ------------------ |
| Time Complexity  | O(n²) (worst case) |
| Space Complexity | O(n)               |

---

 ✅ Comparison with Optimized Version

| Approach    | Time Complexity | Space Complexity | Uses HashSet? |
| ----------- | --------------- | ---------------- | ------------- |
| Brute Force | O(n²)           | O(n)             | ❌             |
| Optimized   | O(n)            | O(n)             | ✅             |

So, the brute-force is less efficient due to the repeated linear searches in
`chosen.contains(...)`.


 */
public class BruteForce {

        // Brute-force implementation
        public static int distributeCandies(int[] candyType) {
            int n = candyType.length;

            // Alice can eat only half of the total candies
            int maxCandies = n / 2;

            // List to store unique candy types chosen by Alice
            List<Integer> chosen = new ArrayList<>();

            // Traverse the array
            for (int i = 0; i < n && chosen.size() < maxCandies; i++) {

                // If this candy type is not already chosen, add it
                if (!chosen.contains(candyType[i])) {
                    chosen.add(candyType[i]);
                }
            }

            // Return the number of different types Alice can eat
            return chosen.size();
    }

    public static void main(String[] args) {
        int[] candyType = {1, 1, 2, 3};
        System.out.println(distributeCandies(candyType)); // Output: 2
    }
}
