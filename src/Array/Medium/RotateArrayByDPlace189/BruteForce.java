
/*
Here the process we follow
Objective:
 To the right rotate the elements of the array `k` times.
That means:
1. Each element in the array moves one step to the right.
2.  The last element wraps around to the front.
---
Approach:

1.Get the size of the array (`n = arr.length`).

2.Repeat the process `k` times:
     a. Store: the last element of the array in a temporary variable `num`.
     B. Shift: all elements one position to the right, starting from the end (`n - 1`) to index `1`.
        Each `arr[j]` is replaced by `arr[j - 1]`.
     C. Place the stored last element (`num`) at index 0.
---
🔍 Example:
Let’s say:
`arr = [1, 2, 3, 4, 5]`, `k = 2`

1st Rotation:
    Store `5`
    Shift: `[1, 2, 3, 4, 4] → [1, 2, 3, 3, 4] → [1, 2, 2, 3, 4] → [1, 1, 2, 3, 4]`
    Place `5` at index 0 → `[5, 1, 2, 3, 4]`
2nd Rotation:
    Store `4`
    Shift → `[5, 5, 1, 2, 3]`
    Place `4` → `[4, 5, 1, 2, 3]`

Final array: `[4, 5, 1, 2, 3]`
---
🕒 Time Complexity: O(k × n) → inefficient for large `k`
 */


package Array.Medium.RotateArrayByDPlace189;

import java.util.Arrays;
import java.util.Scanner;

public class BruteForce {

    static void rotateArray(int[]arr,int k){
        int n=arr.length;

        for(int i=0;i<k;i++){
            int num=arr[n-1];

            for(int j=n-1;j>0;j--){
                arr[j]=arr[j-1];
            }

            arr[0]=num;
        }

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        System.out.println("Enter the value of K");
        int k= scanner.nextInt();

        rotateArray(arr,k);

        System.out.println(Arrays.toString(arr));


    }
}
