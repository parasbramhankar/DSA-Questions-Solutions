package Patterns;

import java.util.Scanner;

public class TheNumberPattern {

    public static void main(String[] args) {

        int n=new Scanner(System.in).nextInt();

        for(int i=1;i<=2*n-1;i++)
        {
            for(int j=1;j<=2*n-1;j++)
            {
                int left=j-1;
                int right=(2*n-1)-j;

                int top=i-1;
                int bottom=(2*n-1)-i;

                int num=n-Math.min(Math.min(left,right),Math.min(top,bottom));
                System.out.print(num);
            }

            System.out.println();
        }
    }
}
