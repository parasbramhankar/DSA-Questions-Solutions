package String.Easy.ValidAnagram242;


import java.util.Arrays;

public class Solution {
    public static boolean isAnagram(String s, String t) {
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


    public boolean isAnagram2(String s, String t) {

        char[] ch1 = s.toCharArray();

        char[] ch2 = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }


    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        if (isAnagram(s, t)) {
            System.out.println("true");
        } else {
            System.out.println("False");
        }

    }


}
