package Array.Medium.KthLargestElementinanArray215;

import java.util.Collections;
import java.util.PriorityQueue;

class UsingPriorityQueue {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Add elements and then poll k times
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            maxHeap.add(nums[i]);
        }
        int kthLargest = 0;

        for (int i = 0; i < k; i++) {
            kthLargest = maxHeap.poll(); // O(log n) per poll
        }

        return kthLargest;


    }


}
