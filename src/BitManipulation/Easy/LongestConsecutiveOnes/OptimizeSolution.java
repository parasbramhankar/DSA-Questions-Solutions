package BitManipulation.Easy.LongestConsecutiveOnes;

import java.util.Scanner;

public class OptimizeSolution {

    static int function(int n){

        int count=0;
        while(n>0){
            count++;

            n=n&(n>>1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n= scanner.nextInt();

        System.out.println("The Consecutive 1's in binary representation: "+function(n));
    }
}
