package Stack.Easy.NextGreaterElement_1_496;

public class BruteForce{

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int []ans =new int[nums1.length];
        int index=0;

        for(int i=0;i<nums1.length;i++){
            int check=0;
            int ele=-1;
            int ind=0;

            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    ind=j;
                    break;
                }
            }

            for(int k=ind;k<nums2.length;k++){
                if(nums1[i]<nums2[k]){
                    check=1;
                    ans[index]=nums2[k];
                    index++;
                    break;
                }
            }

            if(check==0){
                ans[index]=-1;
                index++;
            }
        }

        return ans;
    }
}
