package BitManipulation.Medium.TwoOddAppearingNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;





public class OptimizeSolution {

    static List<Integer> findNumber(int[]arr){

        int xor=0;
        int n=arr.length;

        for(int i=0;i<n;i++){
            xor=xor^arr[i];
        }

        int k=(xor & (-xor));
        int res1=0;
        int res2=0;
        for(int i=0;i<n;i++){
            if((arr[i] & k)!=0){
                res1^=arr[i];
            }else{
                res2^=arr[i];
            }
        }

        return new ArrayList<>(Arrays.asList(res1,res2));
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        List<Integer>ans=findNumber(arr);

        System.out.println("Two odd appearing number: "+ ans);
    }


}
