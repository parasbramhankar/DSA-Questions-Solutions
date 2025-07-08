package String.Easy.ValidPalindrome125;

public class BruteForce {
        static boolean function(String str){
            int n=str.length();

            if(n==1){
                return true;
            }

            int start=0;
            int end=n-1;

            while(start<end){
                if(str.charAt(start)!=str.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }

            return true;


        }
        public static boolean isPalindrome(String s) {

            String str=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

            return function(str);

        }

    public static void main(String[] args) {
        String str="A man, a plan, a canal: Panama";

//      String str = "race a car"

        if(isPalindrome(str)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not palindrome");
        }


    }



}
