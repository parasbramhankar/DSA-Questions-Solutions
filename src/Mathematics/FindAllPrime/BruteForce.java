package Mathematics.FindAllPrime;

import java.util.Scanner;

public class BruteForce {


    static boolean isPrime(int n){

        if(n<=1){
            return false;
        }
        if(n==2||n==3){
            return true;
        }
        if(n%2==0 || n%3==0){
            return false;
        }
        for(int i=5;i<=(int)Math.sqrt(n);i+=5){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return  true;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        for (int i=2;i<=n;i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }

    }
}
