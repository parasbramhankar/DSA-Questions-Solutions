package Mathematics.Easy.Factorial.CountDigitInFactorial;

import java.util.Scanner;

public class Optimize{

    public static int digitsInFactorial(int N){

        // code here
        double sum=0;

        for(int i=1;i<=N;i++){
            sum+=Math.log10(i);
        }

        sum=Math.floor(sum)+1;

        return (int)(sum);

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println("Total Number of digits in "+n+"! : "+digitsInFactorial(n));
    }
}
