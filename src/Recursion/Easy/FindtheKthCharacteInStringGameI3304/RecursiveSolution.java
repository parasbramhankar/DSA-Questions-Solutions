package Recursion.Easy.FindtheKthCharacteInStringGameI3304;

import java.util.Scanner;

public class RecursiveSolution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the value of K");
        int k=scanner.nextInt();

        char ch=findKthCharacter(k);
        System.out.println(ch);
    }


        static public char findKthCharacter(int k) {
            StringBuilder word = new StringBuilder("a");
            buildString(word, k);
            System.out.println(word);
            return word.charAt(k - 1);
        }

        static private void buildString(StringBuilder word, int k) {
            // Base case
            if (word.length() >= k) {
                return;
            }

            // Build temp using recursion
            StringBuilder temp = new StringBuilder();
            incrementChars(word, temp, 0);

            // Append and recurse
            word.append(temp);
            buildString(word, k);
        }

        // Recursive helper to increment characters
       static private void incrementChars(StringBuilder word, StringBuilder temp, int index) {
            // Base case: processed all characters
            if (index >= word.length()) {
                return;
            }

            // Increment current character and add to temp
            char c = (char)(word.charAt(index) + 1);
            temp.append(c);

            // Recurse for next character
            incrementChars(word, temp, index + 1);
        }
    }



