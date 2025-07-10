package String.Easy.ShuffleString1528;

public class Optimize {


    public static String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }

        return new String(result);
    }
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};

        String result = restoreString(s, indices);
        System.out.println("Restored string: " + result);
    }


}
