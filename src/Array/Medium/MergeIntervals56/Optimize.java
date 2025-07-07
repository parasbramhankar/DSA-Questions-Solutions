package Array.Medium.MergeIntervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Optimize {

    public static List<List<Integer>> function(int[][] arr) {
        // Sort based on start of interval
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int n = arr.length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<List<Integer>> ans = function(arr);

        System.out.println("After merging intervals: ");
        System.out.println(ans);
    }

}
