package String.Easy.LongestCommonPrefix14;

/**
 * 
 * Approach (In Simple Language):
 *
 * 1. Pick the first word as the starting "prefix".
 * 2. For each next word in the list:
 *    - Check if the current word begins with the current prefix.
 *    - If not, cut off the last letter of the prefix and try again.
 *    - Repeat until the word starts with the prefix, or prefix becomes empty.
 * 3. After checking all words, the final prefix that is left is the answer.
 * 4. If at any time the prefix becomes empty, return an empty string.
 *--------------------------------------------------------------------------------------------------
 *--------------------------------------------------------------------------------------------------
 * Dry Run (Example):
 *--------------------------------------------------------------------------------------------------
 * 
 * Input: ["flower", "flow", "flight"]
 *
 * Step 1: Start with prefix = "flower"
 * Step 2: Check "flow":
 *     - "flow" does NOT start with "flower"
 *     - Cut one letter: "flowe". Still NO.
 *     - Cut one letter: "flow". YES ("flow" starts with "flow")
 * Step 3: Check "flight":
 *     - "flight" does NOT start with "flow"
 *     - Cut one letter: "flo". Still NO.
 *     - Cut one letter: "fl". YES ("flight" starts with "fl")
 * Step 4: All words checked. Final prefix is: "fl"
 *
 * Output: "Longest Common prefix: fl"
 * 
 */

public class Optimize {
        public static String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";

            String prefix = strs[0];

            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            }

            return prefix;
        }
    public static void main(String[] args) {
        String []str={"flower","flow","flight"};

        String s=longestCommonPrefix(str);

        System.out.println("Longest Common prefix: "+s);
    }
}
