package BinarySearch.Medium.FindFirstandLastPositionofElementinSortedArray34;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] pos = new int[]{-1, -1};
        if (nums.length == 0) return pos;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {

                int start = mid;
                int end = mid;

                // move left safely
                while (start - 1 >= 0 && nums[start - 1] == target) {
                    start--;
                }

                // move right safely
                while (end + 1 < nums.length && nums[end + 1] == target) {
                    end++;
                }

                pos[0] = start;
                pos[1] = end;
                break;

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        System.out.println("Enter the target element: ");
        int k= scanner.nextInt();

        int[]pos=searchRange(arr,k);

        System.out.println("The range : "+ Arrays.toString(pos));
    }
}