package Array.Medium.FindMinimuminRotatedSortedArray153;
/*
Approach: Brute Force using Java Stream

🔍 Logic Behind the Function

```java
Arrays.stream(arr).min().getAsInt();
```

* `Arrays.stream(arr)` – Converts the array to a stream of integers.
* `.min()` – Finds the minimum element in the stream.
* `.getAsInt()` – Gets the primitive `int` value from the optional result.

This is a brute force method because:

* It **checks every element** to find the minimum.
* Time complexity: **O(n)** (not optimal, but simple and reliable)


import java.util.Arrays;


Summary

| Aspect       | Value                      |
| ------------ | -------------------------- |
| Approach     | Brute-force                |
| Time         | O(n)                       |
| Space        | O(1)                       |
| Tools used   | Java Stream API            |
| Suitable for | Simple input, small arrays |

 */
import java.util.Arrays;

public class BruteForce {

    // Function to find the minimum element in the array using brute-force
    static int minimumElement(int[] arr) {
        // Convert the array into a stream, find the minimum element,
        // and return its int value
        return Arrays.stream(arr).min().getAsInt();
    }

    public static void main(String[] args) {
        // Example rotated sorted array
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};

        // Call the function and print the result
        System.out.println("Minimum element: " + minimumElement(arr));
    }
}
