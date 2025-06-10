package BitManipulation.Easy.CountTotalSetBit191;

import java.util.Scanner;

public class BruteForce {

    static int countSetBit(int n){
        int count=0;

        while(n>0){
            if((n&1)==1){
                count++;
            }
            n>>=1;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num= scanner.nextInt();

        int pos=countSetBit(num);

        System.out.println("The First set Bit from right side is at: "+pos);

    }
}

//Here the time complexity of the solution is the number of bits present in number
// Time Complexity: O(Total number of bits( set & unset both));
