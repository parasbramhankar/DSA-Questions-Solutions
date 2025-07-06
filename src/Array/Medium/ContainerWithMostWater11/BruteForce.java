package Array.Medium.ContainerWithMostWater11;

 /**
 * 🚀 Approach & Logic (Brute Force)
 *
 * 1. Goal:
 *    Find two lines such that together with the x-axis they form a container that holds the most water.
 *
 * 2. Brute Force Strategy:
 *    - Try all possible pairs of lines (i, j) where i < j.
 *    - For each pair:
 *        - The height of the container is determined by the shorter line, i.e., min(height[i], height[j]).
 *        - The width of the container is simply the distance between lines, i.e., j - i.
 *        - So the area = height × width.
 *
 * 3. Maintain a maximum area:
 *    - For each pair, compute the area and compare it with the maxArea seen so far.
 *    - Update maxArea if a larger area is found.
 *
 * 4. Time Complexity:
 *    - O(n^2) because we have nested loops for all pairs (i, j).
 *
 * 5. Space Complexity:
 *    - O(1) since we only use a few variables.
 */

 public class BruteForce {

    /**
     * Finds the maximum area of water a container can store
     * by trying all possible pairs of lines.
     *
     * @param height an array representing heights of lines
     * @return the maximum area
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int n = height.length;

        // Iterate over all pairs of lines (i, j) with i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Height is limited by the shorter line
                int h = Math.min(height[i], height[j]);
                // Width is the distance between lines
                int w = j - i;
                // Area = height * width
                int area = h * w;

                // Update maximum area found so far
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    /**
     * Main method to test the maxArea function.
     */
    public static void main(String[] args) {
        BruteForce sol = new BruteForce();

        // Example 1
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max area (example 1): " + sol.maxArea(height1)); // Expected: 49

        // Example 2
        int[] height2 = {1,1};
        System.out.println("Max area (example 2): " + sol.maxArea(height2)); // Expected: 1

        // Additional example
        int[] height3 = {4,3,2,1,4};
        System.out.println("Max area (example 3): " + sol.maxArea(height3)); // Expected: 16

        // Another test
        int[] height4 = {1,2,1};
        System.out.println("Max area (example 4): " + sol.maxArea(height4)); // Expected: 2
    }
}
