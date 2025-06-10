package Mathematics.Easy.CheckPrime;

import java.util.Scanner;

public class Optimize {

    public static boolean checkPrime(int n){

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

        if(checkPrime(n)){
            System.out.println(n+" is Prime");
        }
        else{
            System.out.println(n+" is not Prime");
        }


    }
}
