package Array.Medium.MajorityElement_II229;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Efficient {

    static int function(int[]arr){
        int n=arr.length;

        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){
          map.put(arr[i],(map.getOrDefault(arr[i],0)+1));
        }

        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            if(e.getValue()>n/3){
                return e.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        int element=function(arr);

        System.out.println("The majority element: "+element);

    }
}
