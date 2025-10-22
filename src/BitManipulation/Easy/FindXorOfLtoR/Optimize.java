package BitManipulation.Easy.FindXorOfLtoR;

import java.util.Scanner;

public class Optimize {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter Lower element: ");
        int l=scanner.nextInt();

        System.out.println("Enter Upper element");
        int r= scanner.nextInt();

        int xorFromLtoR=findXORRange(l,r);

        System.out.println("The xor from "+l+" to "+r+" :"+xorFromLtoR);
    }
    static int findXORRange(int l,int r){
        return xorTillN(l-1)+xorTillN(r);
    }

    static int xorTillN(int n){
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        if(n%4==3) return 0;

        return n;
    }
}
