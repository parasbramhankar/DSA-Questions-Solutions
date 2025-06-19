package Array.Easy.IntersectionOfTwoArrays349;

import java.util.HashSet;
import java.util.Set;

public class Optimize {

        public static int[] intersection(int[] nums1, int[] nums2) {
            // Store elements of nums1 in a set for O(1) lookup
            Set<Integer> set1 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }

            // Use a set to avoid duplicates in the result
            Set<Integer> resultSet = new HashSet<>();
            for (int num : nums2) {
                if (set1.contains(num)) {
                    resultSet.add(num);
                }
            }

            // Convert resultSet to int[] array
            int[] result = new int[resultSet.size()];
            int i = 0;
            for (int num : resultSet) {
                result[i++] = num;
            }

            return result;
        }

    public static void main(String[] args) {


        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);

        System.out.print("Intersection: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }


}
