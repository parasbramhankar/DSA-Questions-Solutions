package BitManipulation.Easy.LongestConsecutiveOnes;

import java.util.Scanner;

public class BruteForce {

    static int function(int n){
        int count=0;
        int max=Integer.MIN_VALUE;

        while(n>0){

            if((n&1)==1){
                count++;
            }
            else{
                max=Math.max(max,count);
                count=0;
            }
            n>>=1;
        }

        return Math.max(count, max);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n= scanner.nextInt();

        System.out.println("The Consecutive 1's in binary representation: "+function(n));
    }
}
