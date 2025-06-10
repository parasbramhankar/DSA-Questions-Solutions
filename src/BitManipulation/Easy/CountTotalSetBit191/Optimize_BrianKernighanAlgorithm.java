package BitManipulation.Easy.CountTotalSetBit191;


import java.util.Scanner;
public class Optimize_BrianKernighanAlgorithm {

    static int countSetBit(int n){
        int count=0;

        while(n>0){
            count++;
            n&=(n-1);
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

//Here the total number of iterations is equals to the total number of set bits in the number
// Therefore, Time Complexity: O(total number of set bits)
