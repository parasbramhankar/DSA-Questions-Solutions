package Recursion.Easy.ValidPalindrome125;

import java.util.Scanner;

public class RecursiveSolution {

        public static boolean isPalindrome(String s) {
            int start=0;
            int end=s.length()-1;

            return check(s,start,end);
        }

        static boolean check(String s,int start,int end){
            if(start>=end){
                return true;
            }

            while(start<end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start<end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }

            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                return false;
            }

            return check(s,start+1,end-1);
        }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String string=scanner.nextLine();

        if(isPalindrome(string)){
            System.out.println("String is palindrome");
        }else{
            System.out.println("String is not palindrome");
        }

    }
}
