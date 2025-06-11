package BitManipulation.Easy.MinimumBitFlipsToConvertNumber2220;

import java.util.Scanner;

public class MinimumBitFlipsToConvert {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        int n= scanner.nextInt();
        int m= scanner.nextInt();

        int x=m^n;

        int count=0;

        while(x>0){
            count++;

            x=x&(x-1);
        }

        System.out.println(count+" times needs to flip the bits");
    }
}
