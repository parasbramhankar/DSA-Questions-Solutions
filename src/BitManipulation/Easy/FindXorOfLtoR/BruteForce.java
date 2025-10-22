package BitManipulation.Easy.FindXorOfLtoR;

import java.util.Scanner;

public class BruteForce {
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
        int xor=0;

        for(int i=l;i<=r;i++){
            xor^=i;
        }

        return xor;
    }
}
