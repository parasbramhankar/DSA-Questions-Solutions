package Stack.Easy.NextSmallerElement;

import java.util.Arrays;

public class BruteForce {
   public static int[] nextSmallerEle(int[] arr) {
        // code here
        int n=arr.length;
        int[]result=new int[n];
        Arrays.fill(result,-1);

        for(int i=0; i < n; i++){

            for(int j = i+1; j < n; j++){

                if(arr[i] > arr[j]){
                    result[i]=arr[j];
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[]args) {
      int[]arr=new int[]{4, 8, 5, 2, 25};// Output: [2, 5, 2, -1, -1]

      int[]result= nextSmallerEle(arr) ;

        System.out.println(Arrays.toString(result));
    }
}