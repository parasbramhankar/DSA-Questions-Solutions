package BitManipulation.Easy.CountingBitsFrom1ToN338;

import java.util.Arrays;
import java.util.Scanner;

public class CountingBits {

        public static int[] countBits(int n) {

            int[]arr=new int[n+1];

            for(int i=0;i<=n;i++){
                int count=0;
                int num=i;

                while(num>0){
                    count++;
                    num=(num & (num-1));
                }
                arr[i]=count;
            }
            return arr;
        }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num= scanner.nextInt();

        int []pos=countBits(num);

        System.out.println("The number of bits in each number from 0 to " +num+" are " +Arrays.toString(pos));
    }

}
