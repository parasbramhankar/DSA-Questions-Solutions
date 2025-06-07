package Patterns;

import java.util.Scanner;

public class IncreasingNumberTriangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();

        int count=1;
        for(int i=1;i<=n;i++){

            for(int j=1;j<=i;j++){
                System.out.print(count+" ");
                count++;
            }

            System.out.println();
        }
    }
}
