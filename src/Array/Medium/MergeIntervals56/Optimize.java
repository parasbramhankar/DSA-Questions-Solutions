
/*
=========================================
LEETCODE 56 - MERGE INTERVALS
=========================================

PROBLEM:
Given an array of intervals where intervals[i] = [start, end],
merge all overlapping intervals and return an array of the non-overlapping intervals.

-----------------------------------------
APPROACH:
-----------------------------------------

1️⃣  Sort the intervals based on starting time.
    Why?
    Because overlapping intervals will always be adjacent after sorting.

2️⃣  Initialize:
        start = intervals[0][0]
        end   = intervals[0][1]

3️⃣  Traverse remaining intervals:
        For each interval [s, e]:

        ✔ If s <= end:
              → Overlapping interval
              → Merge by updating:
                    end = max(end, e)

        ✘ Else:
              → No overlap
              → Add previous interval [start, end] to list
              → Update start = s
              → Update end = e

4️⃣  After loop ends:
        Add the last interval to the list.

5️⃣  Convert List<int[]> to int[][] using:
        list.toArray(new int[list.size()][])

-----------------------------------------
WHY SORTING IS REQUIRED?
-----------------------------------------
Without sorting, overlapping intervals may not be adjacent.
Sorting ensures all possible overlapping intervals are next to each other.

-----------------------------------------
DRY RUN EXAMPLE:
-----------------------------------------

Input:
intervals = [[1,3], [2,6], [8,10], [15,18]]

After sorting:
[[1,3], [2,6], [8,10], [15,18]]

Initialize:
start = 1
end   = 3

Loop:

i = 1 → [2,6]
2 <= 3 → overlap
end = max(3,6) = 6

i = 2 → [8,10]
8 > 6 → no overlap
Add [1,6] to list
start = 8
end = 10

i = 3 → [15,18]
15 > 10 → no overlap
Add [8,10] to list
start = 15
end = 18

After loop:
Add [15,18]

Final Output:
[[1,6], [8,10], [15,18]]

-----------------------------------------
TIME COMPLEXITY:
-----------------------------------------
O(n log n)  → Due to sorting

-----------------------------------------
SPACE COMPLEXITY:
-----------------------------------------
O(n) → For storing merged intervals

=========================================
INTERVIEW THINKING PATTERN:
=========================================
Whenever you see:
    - Intervals
    - Overlapping ranges
    - Meeting rooms
    - Scheduling problems

Think:
    👉 Sort first
    👉 Compare current with previous
=========================================
*/

package Array.Medium.MergeIntervals56;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Optimize {

    public static int[][] merge(int [][]intervals){
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n= intervals.length;
        int start=intervals[0][0];
        int end=intervals[0][1];

        List<int[]>ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            int s=intervals[i][0];
            int e=intervals[i][1];

            if(s<=end){
                end=Math.max(e,end);
            }
            else{
                ans.add(new int[]{start,end});
                start=s;
                end=e;
            }
        }

        ans.add(new int[]{start,end});

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};


        int[][]mergeIntervals=merge(intervals);

        System.out.println(Arrays.deepToString(mergeIntervals));

    }

}
