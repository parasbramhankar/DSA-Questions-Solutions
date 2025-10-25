package Recursion.Medium.CountGoodNumbers1922;

import java.util.Scanner;




public class IterativeSolution {

    public static final long MOD=1000000007;
    public static int findGoodNumbers(int n){

        long odd=n/2;
        long even=(n+1)/2;

        long evenPower=power(5,even);
        long oddPower=power(4,odd);

        return (int)((evenPower*oddPower)%MOD);
    }

    public static long power(int num,long expo){
        if(expo==0) return 1;

        long half=power(num,expo/2);

        if(expo % 2==0){
            return (half*half)%MOD;
        }else{
            return (half * half * num)%MOD;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the value of N");
        int N= scanner.nextInt();

        int ans=findGoodNumbers(N);

        System.out.println("The total number of good numbers are: "+ans);
    }
}
