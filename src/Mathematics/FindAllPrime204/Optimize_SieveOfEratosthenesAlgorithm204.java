package Mathematics.FindAllPrime204;

import java.util.Arrays;
import java.util.Scanner;

public class Optimize_SieveOfEratosthenesAlgorithm204 {


    static void printPrime(int n){

        boolean[]prime=new boolean[n+1];
        Arrays.fill(prime,true);

        for(int i=2;i<=Math.sqrt(n);i++){

            if(prime[i]){

                for(int j=i*i; j<=n;j+=i){
                    prime[j]=false;
                }

            }

        }

        int count=0;

        for(int i=2;i<=n;i++){
            if(prime[i]){
                System.out.print(i+" ");
                count++;
            }
        }

        System.out.println("\nTotal number of prime number: "+count);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        printPrime(n);
    }
}
