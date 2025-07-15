package String.Easy.ValidWord3136;

public
    class Solution {

        // Helper method to check if a character is a vowel
        public static boolean isVowel(char ch) {
            return "aeiou".indexOf(ch) != -1;
        }

        public static boolean isValid(String word) {
            word = word.toLowerCase(); // convert to lowercase
            int n = word.length();

            if (n < 3) {
                return false; // word must be at least 3 characters long
            }

            boolean hasVowel = false;
            boolean hasConsonant = false;

            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);

                // Only allow letters and digits
                if (!Character.isLetterOrDigit(ch)) {
                    return false;
                }

                // Check vowels and consonants
                if (Character.isLetter(ch)) {
                    if (isVowel(ch)) {
                        hasVowel = true;
                    } else {
                        hasConsonant = true;
                    }
                }


            }

            return hasVowel && hasConsonant;
        }

    public static void main(String[] args) {
        String string="234Adas";

        if(isValid(string)){
            System.out.println("This is valid word");
        }else{
            System.out.println("This is not valid word");
        }
    }
    }




