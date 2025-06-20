package Array.Easy.FindTheUnion;

import java.util.*;
/*
Approach:

* Create an empty set to store unique elements
* Loop through the first array and add each element to the set
* Loop through the second array and add each element to the same set
* Since sets do not allow duplicates, only unique elements from both arrays will be stored
* Convert the set into a list and return it

*/

class Solution{

        public static List<Integer> doUnion(int a[], int n, int b[], int m)
        {
            Set<Integer> set=new HashSet<>();

            for(int i=0;i<n;i++){
                set.add(a[i]);
            }
            for(int j=0;j<m;j++){
                set.add(b[j]);
            }

            return new ArrayList<>(set);

        }

        public static void main(String[] args) {
            int[]arr1=new int[]{85, 25, 1, 32, 54, 6};
            int[]arr2=new int[]{85, 2};

            int n=arr1.length;
            int m=arr2.length;

            List<Integer>arrList=doUnion(arr1,n,arr2,m);

            System.out.println("Union of Arrays: "+arrList);

        }



    }


