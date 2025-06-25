package Array.Easy.FindTheMissingAndRepeatingNumber2965;

import java.util.HashMap;
import java.util.Map;

/*
Approach:

1. Consider a for-loop for representing the row of matrix
2. Consider another loop for representing the column of the row of matrix
    a. Map all the elements with its frequency in the Hashmap using the
       map.put(arr[i][j],map.getOrDefault(arr[i][j],0)+1)
3. let
    x <-- missing number
    y <--repeating number
4. Run a for-loop to check the current index i is present or not in the HashMap
   a. If i present in the hashmap, check the frequency of that element
      * If the frequency==2 then this is the repeating element, store it into x
      * otherwise skip this if statement
   b.if i not present in the hashmap, then this number is the missing number, store it into y
5. Return x and y using an array
 */
public class BruteForce {

        public static int[] findMissingAndRepeating(int[][] grid) {
            Map<Integer,Integer> map=new HashMap<>();
            int n=grid.length;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    map.put(grid[i][j],(map.getOrDefault(grid[i][j],0)+1));
                }
            }

            int rep=0,mis=0;
// finding the numbers

            for(int i=1;i<=Math.pow(n,2);i++){
                if(map.containsKey(i)){
                    if(map.get(i)==2){
                        rep=i;
                    }
                }else{
                    mis=i;
                }
            }
            return new int[]{rep,mis};
        }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 3, 6},{ 2, 1, 1}};

        int[]result=findMissingAndRepeating(arr);
        System.out.println("Missing Number = " + result[0]);
        System.out.println("Repeating Number = " + result[1]);
    }
}
