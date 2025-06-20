package Array.Easy.MoveZeroesToEnd283;
/*
Approach (Plain Steps):

* Create a temporary array of the same length as the original array
* Initialize a pointer to keep track of the position to insert non-zero elements
* Traverse the original array and copy all non-zero elements into the temporary array
* After copying all non-zero elements, fill the remaining positions in the temporary array with zeroes
* Finally, copy the contents of the temporary array back into the original array

 */
import java.util.Arrays;

public class BruteForce {

    public static void moveZeroes(int[] nums) {
        int n = nums.length;

        // Create a temporary array to store result
        int[] temp = new int[n];

        // Index to keep track of position in temp array
        int ind = 0;

        // Copy all non-zero elements to temp array
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[ind] = nums[i];
                ind++;
            }
        }

        // Fill remaining positions in temp with zeroes
        while (ind < n) {
            temp[ind] = 0;
            ind++;
        }

        // Copy back the result from temp to the original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }


    public static void main(String[] args) {
        int[]arr={0,1,0,3,12};

        System.out.println("Before: "+ Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println("After: "+Arrays.toString(arr));
    }
}
