package String.Medium.ReverseWordsInString151;

public class BruteForce {

        public static String reverseWords(String s) {

            String []words=s.trim().split("\\s+");
            int n=words.length;
            StringBuilder sb=new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {
                sb.append(words[i]).append(" ");
            }

            return sb.toString().trim();
        }
    public static void main(String[] args) {
        String input = "  the   sky  is blue  ";
        String result = reverseWords(input);
        System.out.println("🔁 Reversed Words: " + result); // Output: "blue is sky the"
    }
}
