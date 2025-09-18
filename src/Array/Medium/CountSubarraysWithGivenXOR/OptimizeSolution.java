package Array.Medium.CountSubarraysWithGivenXOR;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptimizeSolution {
    static int function(int[]arr,int k){
        int count=0;
        int n=arr.length;
        Map<Integer,Integer>map=new HashMap<>();

        map.put(0,1);
        int xr=0;
        for(int i=0;i<n;i++){
            xr^=arr[i];

            int x=xr^k;

            if(map.containsKey(x)){
                count+=map.get(x);
            }

            if(map.containsKey(xr)){
                map.put(xr, map.get(xr)+1);
            }else{
                map.put(xr,1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter the xor: ");
        int xor = scanner.nextInt();

        long count = function(arr, xor);

        System.out.println("The number of count of subarray with given xor: " + count);
        scanner.close();
    }
}
