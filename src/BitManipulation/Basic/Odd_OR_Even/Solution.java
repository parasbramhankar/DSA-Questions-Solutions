package BitManipulation.Basic.Odd_OR_Even;

import java.util.Scanner;

public class Solution {
    static boolean isEven(int n) {
//  Check the last digit is set or not

        if( (n&1)!=0){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        if(isEven(n)){
            System.out.println("This is the even number");
        }else{
            System.out.println("This is the odd number");
        }
    }
}
