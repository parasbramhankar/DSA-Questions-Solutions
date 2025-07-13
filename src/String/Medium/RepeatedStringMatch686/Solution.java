package String.Medium.RepeatedStringMatch686;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int repeatedStringMatch(String a, String b) {
        // Step 1: Early exit - check if all characters in b exist in a
        Set<Character> set = new HashSet<>();
        for (char c : a.toCharArray()) {
            set.add(c);
        }
        for (char c : b.toCharArray()) {
            if (!set.contains(c)) {
                return -1; // impossible to form b from repeated a
            }
        }

        // Step 2: Repeat a until it becomes longer than b
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Step 3: Check if b is now a substring
        if (sb.toString().contains(b)) return count;

        // Step 4: Append one more time (b could be across boundary)
        sb.append(a);
        count++;

        if (sb.toString().contains(b)) return count;

        return -1;
    }
}

