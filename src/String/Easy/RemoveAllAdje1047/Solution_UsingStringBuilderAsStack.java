package String.Easy.RemoveAllAdje1047;

public class Solution_UsingStringBuilderAsStack {
        public String removeDuplicates(String s) {
            StringBuilder sb = new StringBuilder();

            for (char ch : s.toCharArray()) {
                int len = sb.length();
                if (len > 0 && sb.charAt(len - 1) == ch) {
                    sb.deleteCharAt(len - 1);  // Simulate stack pop
                } else {
                    sb.append(ch);  // Simulate stack push
                }
            }

            return sb.toString();
        }

}
