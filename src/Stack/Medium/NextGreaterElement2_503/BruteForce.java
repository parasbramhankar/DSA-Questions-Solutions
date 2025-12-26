package Stack.Medium.NextGreaterElement2_503;

import java.util.Arrays;

public class BruteForce {

    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int []result=new int[n];

        Arrays.fill(result,-1);

        for(int i=0;i<n;i++){
            int ele=nums[i];
            for(int j=1;j<n;j++){
                int ind=(i+j)%n;

                if(nums[ind]>nums[i]){
                    result[i]=nums[ind];
                    break;
                }
            }
        }
        return result;
    }
}