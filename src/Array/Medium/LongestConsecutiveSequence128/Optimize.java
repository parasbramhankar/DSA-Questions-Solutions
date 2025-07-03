package Array.Medium.LongestConsecutiveSequence128;

import java.util.HashSet;
import java.util.Set;

public class Optimize {

    static int function(int []arr){

        int n=arr.length;

        Set<Integer>set=new HashSet<>();
        for(int i:arr){
            set.add(i);
        }
        int total=0;

        for(int it:set){
            if(!set.contains(it-1)){
                int x=it;
                int count=1;
                while(set.contains(x+1)){
                    count++;
                    x=x+1;
                }
                total=Math.max(total,count);
            }
        }
        return total;

    }

    public static void main(String[] args) {
        int[]arr=new int[]{100,4,50,1,3,2};

        int count=function(arr);
        System.out.println("Total number of consecutive number: "+count);
    }
}
