package Mathematics.Medium.PrimeFactor2521;

import java.util.Scanner;
import Mathematics.Easy.CheckPrime.Optimize;


public class NaiveSolution {

    static void printPrimeFactor(int num){

        for(int i=2;i<num;i++){

            if(Optimize.checkPrime(i)){
                int x=i;

                while (num%x==0){
                    System.out.print(i+" ");
                    x*=i;
                }
            }
        }
    }


    // First, we check the i is prime number no not, then use that number

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num= scanner.nextInt();

        printPrimeFactor(num);

        scanner.close();
    }
}
