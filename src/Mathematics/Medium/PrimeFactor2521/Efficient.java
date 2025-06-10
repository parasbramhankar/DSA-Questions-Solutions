package Mathematics.Medium.PrimeFactor2521;


//Our Intuitions here is, each number is present as the multiple of two numbers,
//i.e., Divisors of the number come in the pair form
//when we divide by the number by its one of prime factors then we get another prime factor or the number other than prime factor
//we need to find the factors only up to the sqrt(n)

import java.util.Scanner;

public class Efficient {

    static void printPrimeFactor(int num){
        if(num<=1) return;

        for(int i=2;i*i<=num;i++){

            while(num%i==0){
                System.out.print(i+" ");

                num/=i;
            }
        }

        if(num>1){
            System.out.print(num);
        }
    }

    public static void main(String[] args) {

            Scanner scanner=new Scanner(System.in);

            int num= scanner.nextInt();

            printPrimeFactor(num);

            scanner.close();
        }

}
