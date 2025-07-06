package Array.Medium.ContainerWithMostWater11;

/**
 * ✅ Container With Most Water - Optimized Two Pointer Approach
 *
 * --------------------------------------------------------------------------------
 * 📚 PROBLEM STATEMENT
 * Given an array of integers `height` where each element represents the height
 * of a vertical line drawn at that index on the x-axis.
 *
 * Find two lines that together with the x-axis form a container, such that
 * the container contains the most water.
 *
 * --------------------------------------------------------------------------------
 * 🚀 APPROACH (Two Pointer Technique - O(n))
 *
 * 1️⃣ Place two pointers at the ends of the array (left = 0, right = n-1).
 * 2️⃣ Compute the area between the lines pointed by left and right:
 *     area = min(height[left], height[right]) * (right - left)
 * 3️⃣ Keep track of the maximum area found so far.
 * 4️⃣ Move the pointer pointing to the shorter line inward by 1 step:
 *     - This is because moving the taller line won't help — the area is limited by the shorter line.
 *     - By moving the shorter line, we hope to find a taller line and maybe increase the area.
 * 5️⃣ Repeat until left and right meet.
 *
 * --------------------------------------------------------------------------------
 * 💡 TIME COMPLEXITY: O(n)
 * 💡 SPACE COMPLEXITY: O(1)
 */
public class Optimize {

    /**
     * Calculates the maximum area of water a container can store.
     *
     * @param height Array representing the heights of lines.
     * @return The maximum water area the container can hold.
     */
    public int maxArea(int[] height) {
        int left = 0;                     // Pointer at the beginning
        int right = height.length - 1;    // Pointer at the end
        int maxArea = 0;                  // To store the maximum area found

        // Continue until pointers meet
        while (left < right) {
            // Calculate the area between lines at left and right
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = minHeight * width;

            // Update max area if this is larger
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;  // hope to find a taller line on the left
            } else {
                right--; // hope to find a taller line on the right
            }
        }

        return maxArea;
    }

    /**
     * Main method to test our solution with various inputs.
     */
    public static void main(String[] args) {
        Optimize sol = new Optimize();

        // Example 1
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max area (example 1): " + sol.maxArea(height1)); // Expected: 49

        // Example 2
        int[] height2 = {1,1};
        System.out.println("Max area (example 2): " + sol.maxArea(height2)); // Expected: 1

        // Additional examples
        int[] height3 = {4,3,2,1,4};
        System.out.println("Max area (example 3): " + sol.maxArea(height3)); // Expected: 16

        int[] height4 = {1,2,1};
        System.out.println("Max area (example 4): " + sol.maxArea(height4)); // Expected: 2

        // Large input stress test
        int[] height5 = new int[100000];
        for (int i = 0; i < height5.length; i++) {
            height5[i] = (i % 100) + 1;
        }
        System.out.println("Max area (large test): " + sol.maxArea(height5));
    }
}
