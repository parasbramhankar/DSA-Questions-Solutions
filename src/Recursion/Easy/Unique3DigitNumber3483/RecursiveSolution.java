package Recursion.Easy.Unique3DigitNumber3483;



import java.util.HashSet;
import java.util.Set;

public class RecursiveSolution {

    public static int findUnique(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int []combo=new int[3];
        helper(arr, 0, 0,combo, set);

        return set.size();
    }

    static void helper(int[] arr, int start, int depth, int[] combo, Set<Integer> set) {
        if (depth == 3) {
            int num = combo[0]*100 + combo[1]*10 + combo[2];
            if (num % 2 == 0) {
                set.add(num);
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            combo[depth] = arr[i];
            helper(arr, i + 1, depth + 1, combo, set);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        int count = findUnique(arr);
        System.out.println(count);
    }
}
