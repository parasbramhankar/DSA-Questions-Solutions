package BitManipulation.Easy.SingleNumber136;

public class OptimizeUsingBitManipulation {


    public static void main(String[] args) {
        int[]arr=new int[]{10,20,10,1, 1,4,4};
        int n=arr.length;

        int xor=0;

        for(int i=0;i<n;i++){
            xor^=arr[i];
        }

        System.out.println(xor+" is present odd number of times");

    }

}
