package Patterns;

import java.util.Scanner;

public class HalfDiamondStar {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();

        for(int i=1;i<=2*n-1;i++){
            int count=i;

            if(i>n){
                count=2*n-i;
            }

            for(int j=1;j<=count;j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
