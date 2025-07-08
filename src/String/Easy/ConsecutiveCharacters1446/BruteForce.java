package String.Easy.ConsecutiveCharacters1446;

/*
 🔹 Brute Force Logic:

 1. For each character in the string, start checking how long the consecutive sequence
    of the same character continues.
 2. Use a nested loop: the outer loop picks the starting index, the inner loop counts
    how far the same character repeats.
 3. Update the maximum length whenever a longer streak is found.
 4. Time complexity is O(n^2), not optimal but works for small strings.
*/
public class BruteForce {
    public int maxPower(String s) {
        int max = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int count = 1; // current character counts as 1
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }


    public static void main(String[] args) {
        Optimize obj = new Optimize();

        // Sample test cases
        String input1 = "leetcode";
        String input2 = "abbcccddddeeeeedcba";
        String input3 = "triplepillooooow";

        // Display results
        System.out.println("Max Power of \"" + input1 + "\": " + obj.maxPower(input1));       // Output: 2
        System.out.println("Max Power of \"" + input2 + "\": " + obj.maxPower(input2));       // Output: 5
        System.out.println("Max Power of \"" + input3 + "\": " + obj.maxPower(input3));       // Output: 5
    }
}
