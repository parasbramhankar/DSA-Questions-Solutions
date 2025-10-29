package Recursion.Medium.CheckIfThereExistASubsequenceWithSumK;

public class RecursiveSolution {
    static boolean helper(int[] arr, int k, int ind, int sum) {
        // If the sum equals target, and we've picked at least one element
        if(sum == k && ind > 0) {
            return true;
        }
        // If we've gone through all elements
        if (ind == arr.length) {
            return false;
        }
        // Include current element
        if(helper(arr, k, ind+1, sum + arr[ind])) {
            return true;
        }
        // Exclude current element
        if(helper(arr, k, ind+1, sum)) {
            return true;
        }
        return false;
    }
    static boolean function(int []arr){

    }

    public static void main(String[] args) {
      int[]arr=new int[]{1,2,3,4};

      boolean check=function(arr);

    }
}
