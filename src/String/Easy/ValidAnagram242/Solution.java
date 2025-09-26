package String.Easy.ValidAnagram242;

import java.util.Arrays;

public class Solution {

    /*
    Approach and Logic for isAnagram1(String s, String t):

    1. First, check if the lengths of s and t are the same. If not, they cannot be anagrams.
    2. Create an integer array 'count' of size 26 to keep track of character frequencies for lowercase letters.
    3. Traverse both strings simultaneously:
       - Increment count for the character at position i in string s.
       - Decrement count for the character at position i in string t.
    4. After this, if the two strings are anagrams, all values in 'count' will be zero.
    5. If any value in the count array is not zero, return false; else, return true.

    Time Complexity: O(n) where n is the length of the strings (since we do single pass counting).
    Space Complexity: O(1) because the size of count array is fixed at 26.
    */

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }

        return true;
    }


    /*
    Approach and Logic for isAnagram2(String s, String t):

    1. Check if the lengths are equal; if not, return false.
    2. Convert both strings into character arrays.
    3. Sort both character arrays lexicographically.
    4. Compare the two sorted arrays.
       - If they are identical, the strings are anagrams.
       - Otherwise, they are not.

    Time Complexity: O(n log n) due to sorting.
    Space Complexity: O(n) for storing character arrays.
    */


    public static boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) return false;

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }


    public static void main(String[] args) {

        // Dry run Example for isAnagram1:
        // s = "anagram", t = "nagaram"
        // Count increments on 'a','n','a','g','r','a','m' and decrements on 'n','a','g','a','r','a','m'
        // All values balanced to zero, returns true

        String s = "anagram", t = "nagaram";

        if (isAnagram1(s, t)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        // Dry run Example for isAnagram2:
        // s = "listen", t = "silent"
        // Sorted ch1 = ['e','i','l','n','s','t'], ch2 = ['e','i','l','n','s','t']
        // Arrays are equal, returns true

        s = "listen";
        t = "silent";

        if (isAnagram2(s, t)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

}

