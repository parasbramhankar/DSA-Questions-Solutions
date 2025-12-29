package SlidingWindow.Medium.LongestSubstringWithoutRepeatingCharacters03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {


    static int function(String string){
        int left=0;
        int right=0;
        int maxCount=0;
        HashSet<Character>hashSet=new HashSet<>();

        while (right<string.length()){

            while(hashSet.contains(string.charAt(right))){
                hashSet.remove(string.charAt(left));
                left++;
            }

            hashSet.add(string.charAt(right));
            maxCount=Math.max(maxCount,right-left+1);
            right++;

        }

        return maxCount;
    }

/*
    public static int function(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

*/

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String string= scanner.next();

        int count=function(string);
        System.out.println("Longest Substring Without Repeating Characters: "+count);
    }
}
