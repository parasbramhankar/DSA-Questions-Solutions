package Patterns;

import java.util.Scanner;

public class KPattern {
    public static void main(String[] args) {

        int n=new Scanner(System.in).nextInt();

        int count=n;

        for(int i=1;i<=2*n-1;i++){

            for(int j=1;j<=count;j++)
            {
                System.out.print("* ");
            }

            if(i<n){
                count--;
            }
            else{
                count++;
            }

            System.out.println();
        }
    }
}
