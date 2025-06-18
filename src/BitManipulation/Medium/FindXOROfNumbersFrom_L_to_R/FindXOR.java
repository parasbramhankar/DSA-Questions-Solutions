package BitManipulation.Medium.FindXOROfNumbersFrom_L_to_R;

import java.util.Scanner;

public class FindXOR {

    private static int solve(int n){
            if(n%4==1) return 1;
            else if(n%4==2)return n+1;
            else if(n%4==3)return 0;
            return n;
        }
        public static int findXOR(int l, int r) {
            return solve(l-1)^solve(r);
        }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int l= scanner.nextInt();
        int r= scanner.nextInt();

        System.out.println(findXOR(l,r));
    }
}
