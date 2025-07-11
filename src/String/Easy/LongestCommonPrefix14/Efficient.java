package String.Easy.LongestCommonPrefix14;

import java.util.Arrays;

public class Efficient {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder string = new StringBuilder();

        Arrays.sort(strs);

        String f = strs[0];
        String l = strs[strs.length - 1];

        for (int i = 0; i < Math.min(f.length(), l.length()); i++) {
            if (f.charAt(i) != l.charAt(i)) {
                return string.toString();
            }

            string.append(f.charAt(i));
        }

        return string.toString();
    }


    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};

        String s = longestCommonPrefix(str);

        System.out.println("Longest Common prefix: " + s);
    }
}
