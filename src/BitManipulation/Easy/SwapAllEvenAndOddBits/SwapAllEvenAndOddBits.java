package BitManipulation.Easy.SwapAllEvenAndOddBits;

import java.util.Scanner;

public class SwapAllEvenAndOddBits {


    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();

        int num=((n&0xAAAAAAAA)>>1 | (n&0x55555555)<<1);

        System.out.println("The number after Swaping even and odd bits : "+num);

    }
}
