package Array.Easy.MissingNumber268;

public class Optimize {
        public static int missingNumber(int[] nums) {
            int n=nums.length;

            int sum=n*(n+1)/2;

            for(int i=0;i<n;i++){
                sum-=nums[i];
            }

            return sum;
        }

    public static void main(String[] args){
        int[]arr={3,0,1};

        System.out.println("Missing Number: "+missingNumber(arr));
    }
}
