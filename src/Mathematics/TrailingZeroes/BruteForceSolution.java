
package Mathematics.TrailingZeroes;

import java.util.Scanner;

public class BruteForceSolution {

    static long findFactorial(int n){
        long fact=1;

        for(int i=1;i<=n;i++){
            fact*=i;
        }

        return fact;
    }

    static long countTrailingZeroes(long fact){
        int count=0;

        while(true){

            if(fact%10==0) {
                count++;
            }
            else{
                break;
            }
            fact /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        long fact=findFactorial(n);

        long numOfZeroes=countTrailingZeroes(fact);

        System.out.println("The number of trailing Zeroes: "+numOfZeroes);
    }
}
