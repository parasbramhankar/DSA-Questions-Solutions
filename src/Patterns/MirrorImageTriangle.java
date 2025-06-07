package Patterns;

import java.util.Scanner;

public class MirrorImageTriangle {
    public static void main(String[] args) {

        int n=new Scanner(System.in).nextInt();

        int count=1;
        int space=0;
        for(int i=1;i<=2*n-1;i++){

            for(int sp=1;sp<=space;sp++){
                System.out.print(" ");
            }

            for(int j=count;j<=n;j++){
                System.out.print(j+" ");
            }

            if(i<n){
                count++;
                space++;
            }
            else{
                count--;
                space--;
            }
            System.out.println();
        }
    }
}
