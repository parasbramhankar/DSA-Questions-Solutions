package Patterns;

import java.util.Scanner;

public class BinaryNumber {
    public static void main(String[] args) {

        int n=new Scanner(System.in).nextInt();

        for(int i=1;i<=n;i++){

            int num=1;
            if(i%2==0){
                num=0;
            }

            for(int j=1;j<=i;j++){

                System.out.print(num+" ");
                num=1-num;

            }

            System.out.println();
        }
    }
}
