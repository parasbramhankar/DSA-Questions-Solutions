package Patterns;

import java.util.Scanner;

public class PalindromeRectangle {
    public static void main(String[] args) {

        int n=new Scanner(System.in).nextInt();

        for(int i=1;i<=n;i++){

            int count=i;
            for(int space=1;space<=n-i;space++){
                System.out.print(" ");
            }

            for(int j=1;j<=2*i-1;j++){
                System.out.print(count);

                if(j<i){
                    count--;
                }
                else{
                    count++;
                }
            }
            System.out.println();
        }
    }
}
