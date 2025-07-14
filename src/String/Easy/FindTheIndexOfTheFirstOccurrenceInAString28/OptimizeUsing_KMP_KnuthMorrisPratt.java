package String.Easy.FindTheIndexOfTheFirstOccurrenceInAString28;

public class OptimizeUsing_KMP_KnuthMorrisPratt {

        // Main strStr() method using KMP algorithm
        public int strStr(String haystack, String needle) {
            if (needle.isEmpty()) return 0;

            int[] lps = computeLPSArray(needle); // Preprocess the needle (pattern)
            int i = 0; // pointer for haystack
            int j = 0; // pointer for needle

            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;

                    if (j == needle.length()) {
                        return i - j; // Full match found
                    }
                } else {
                    if (j != 0) {
                        j = lps[j - 1]; // Jump to the last known prefix index
                    } else {
                        i++; // Move forward in haystack
                    }
                }
            }

            return -1; // No match found
        }

        // Helper method to compute the LPS (Longest Prefix Suffix) array
        private int[] computeLPSArray(String pattern) {
            int[] lps = new int[pattern.length()];
            int len = 0; // Length of the previous longest prefix suffix
            int i = 1;

            while (i < pattern.length()) {
                if (pattern.charAt(i) == pattern.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {
                    if (len != 0) {
                        len = lps[len - 1]; // Fallback in pattern
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }

            return lps;
        }

        // Main method for testing
        public static void main(String[] args) {
            OptimizeUsing_KMP_KnuthMorrisPratt sol = new OptimizeUsing_KMP_KnuthMorrisPratt();

            System.out.println(sol.strStr("hello", "ll"));         // Output: 2
            System.out.println(sol.strStr("aaaaa", "bba"));        // Output: -1
            System.out.println(sol.strStr("mississippi", "issip"));// Output: 4
            System.out.println(sol.strStr("leetcode", ""));        // Output: 0
        }
    }

