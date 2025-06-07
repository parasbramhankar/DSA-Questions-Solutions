package Patterns;

import java.util.*;
public class HallowTriangle {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();

        for(int i=1;i<=n;i++){
            for(int space=1;space<=n-i;space++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                if(j==1||j==i||i==n){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
