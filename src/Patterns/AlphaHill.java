package Patterns;

import java.util.Scanner;

public class AlphaHill {
    public static void main(String[] args) {

        int n=new Scanner(System.in).nextInt();

        for(int i=1;i<=n;i++){

            for(int sp=1;sp<=n-i;sp++){
                System.out.print(" ");
            }

            char ch='A';
            for(int j=1;j<=2*i-1;j++){

                System.out.print(ch);

                if(j<i){
                    ch++;
                }
                else {
                    ch--;
                }
            }

            System.out.println();
        }
    }
}
