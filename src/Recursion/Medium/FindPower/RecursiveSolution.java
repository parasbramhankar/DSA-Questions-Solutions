package Recursion.Medium.FindPower;

import java.util.Scanner;

public class RecursiveSolution {

    public static double myPow(double base,int exponent){
        long N=(int)exponent;

        if(N<0){
            base=1/base;
            N=-exponent;
        }
        return power(base,N);
    }

    public static double power(double base,long n){
        if(n==0) {return 1.0;}

        double half=power(base,n/2);

        if(n%2==0){
            return half*half;
        }
        else{
            return half*half*base;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the base: ");
        double base= scanner.nextDouble();

        System.out.println("Enter the exponent: ");
        int exponent= scanner.nextInt();

        double baseToPowerExponent=myPow(base,exponent);

        System.out.println(base+ "^"+exponent+" = "+baseToPowerExponent);
    }
}
