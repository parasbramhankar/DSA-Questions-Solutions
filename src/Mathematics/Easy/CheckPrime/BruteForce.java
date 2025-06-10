package Mathematics.Easy.CheckPrime;

import java.util.Scanner;

public class BruteForce {

    static boolean checkPrime(int n){

        int c=0;

        for(int i=2;i<=(n-1);i++){
            if(n%i==0){
                c=1;
                break;
            }
        }

        if(c==1){
            return false;
        }
        return true;
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
