package String.Easy.IsomorphicStrings205;


/**
 * /*
 * Approach (In-Depth Explanation):
 *
 * 1. Check if both strings have the same length.
 *    If lengths differ, they cannot be isomorphic.
 *
 * 2. Use a HashMap to store a mapping from characters in string s to characters in string t.
 *
 * 3. Traverse each character in strings s and t simultaneously:
 *    - Let the current characters be `key` from s and `val` from t.
 *
 * 4. If `key` is already in the map:
 *    - Check if it maps to the same `val` character.
 *    - If it maps to a different character, the strings are not isomorphic.
 *
 * 5. If `key` is NOT in the map:
 *    - Check if `val` is already mapped to by some other `key` by using `containsValue`.
 *    - If yes, return false because two different `key`s cannot map to the same `val`.
 *    - Otherwise, add the mapping from `key` to `val` in the HashMap.
 *
 * 6. If all characters validate successfully with no conflicts, return true.
 *-------------------------------------------------------------------------------------------
 * Note:
 * The use of `containsValue()` in each iteration makes this approach less efficient,
 * as searching values in a HashMap is O(n), causing the overall complexity to approach O(n²).
 *-------------------------------------------------------------------------------------------
 * Dry Run (Example):
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 *
 * - Initialize HashMap: {}
 * - i=0: key='e', val='a'
 *   - 'e' not in map, 'a' not in values -> Put ('e' -> 'a')
 *   - Map: {'e'='a'}
 * - i=1: key='g', val='d'
 *   - 'g' not in map, 'd' not in values -> Put ('g' -> 'd')
 *   - Map: {'e'='a', 'g'='d'}
 * - i=2: key='g', val='d'
 *   - 'g' in map, mapping is 'd' which equals current val, continue
 * - End: No conflicts found, return true
 *-------------------------------------------------------------------------------------------
 * Example 2 :
 *
 * Input: s = "foo", t = "bar"
 *
 * - Initialize HashMap: {}
 * - i=0: key='f', val='b'
 *   - 'f' not in map, 'b' not in values -> Put ('f' -> 'b')
 * - i=1: key='o', val='a'
 *   - 'o' not in map, 'a' not in values -> Put ('o' -> 'a')
 * - i=2: key='o', val='r'
 *   - 'o' in map, mapped to 'a' which is not 'r' -> Conflict, return false
 *
 * Output:
 * - "egg" and "add" are isomorphic (true).
 * - "foo" and "bar" are NOT isomorphic (false).
 *
 */
import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        // Step 1: Check length equality
        if (len1 != len2) {
            return false;
        }

        boolean check = true;
        HashMap<Character, Character> hashMap = new HashMap<>();

        // Step 2 & 3: Iterate through characters and check mappings
        for (int i = 0; i < len1; i++) {
            char key = s.charAt(i);
            char val = t.charAt(i);

            if (hashMap.containsKey(key)) {
                char ch = hashMap.get(key);

                // Check if current mapping matches
                if (ch != val) {
                    check = false;
                    break;
                }
            } else {
                // Check if val is already mapped
                if (hashMap.containsValue(val)) {
                    check = false;
                    break;
                } else {
                    hashMap.put(key, val);  // Create new mapping
                }
            }
        }

        return check;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "egg";
        String t1 = "add";

        String s2 = "foo";
        String t2 = "bar";

        System.out.println("Are \"" + s1 + "\" and \"" + t1 + "\" isomorphic? " + solution.isIsomorphic(s1, t1));
        System.out.println("Are \"" + s2 + "\" and \"" + t2 + "\" isomorphic? " + solution.isIsomorphic(s2, t2));
    }
}

