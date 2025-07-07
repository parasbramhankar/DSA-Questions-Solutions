package Array.Medium.MergeIntervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce {

    public static List<List<Integer>> function(int[][] arr) {
        // Sort based on start of interval
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int n = arr.length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            // Skip if current interval is already covered
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            // Extend interval by merging overlapping ones
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }

            // Add merged interval
            List<Integer> arrList = new ArrayList<>();
            arrList.add(start);
            arrList.add(end);
            ans.add(arrList);
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
