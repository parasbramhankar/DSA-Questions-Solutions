package Array.Medium.Subsets78;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] arr) {

        List<List<Integer>>list=new ArrayList<>();

        int n=arr.length;
        int pSize=(int)Math.pow(2,n);

        for(int i=0;i<pSize;i++){
            List<Integer>arrList=new ArrayList<>();

            for(int j=0;j<n;j++){

                if((i & (1<<j))!=0){
                    arrList.add(arr[j]);
                }

            }

            list.add(arrList);

        }
        return list;
    }



}