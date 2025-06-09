package Mathematics.TrailingZeroes172;

import java.util.Scanner;

public class OptimizeSolution {

    static int countZeroes(int n){
        int count=0;

        for(int i=5;i<=n;i=i*5){
            count+=(int)Math.floor(n/i);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int count=countZeroes(n);


        System.out.println("The number of trailing Zeroes: "+count);
    }



}
