package String.Easy.FindTheIndexOfTheFirstOccurrenceInAString28;

import java.util.Scanner;

public class BruteForce {

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        BruteForce sol = new BruteForce();

        // Sample test cases
        String haystack1 = "hello";
        String needle1 = "ll";
        System.out.println("Output 1: " + sol.strStr(haystack1, needle1)); // 2

        String haystack2 = "aaaaa";
        String needle2 = "bba";
        System.out.println("Output 2: " + sol.strStr(haystack2, needle2)); // -1

        String haystack3 = "mississippi";
        String needle3 = "issip";
        System.out.println("Output 3: " + sol.strStr(haystack3, needle3)); // 4

        String haystack4 = "leetcode";
        String needle4 = "";
        System.out.println("Output 4: " + sol.strStr(haystack4, needle4)); // 0
    }
}

