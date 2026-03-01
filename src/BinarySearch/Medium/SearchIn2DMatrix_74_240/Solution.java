package BinarySearch.Medium.SearchIn2DMatrix_74_240;

public class Solution {

    public static boolean checkPresentOrNOt(int[][]matrix,int target){
        int i=0;
        int j=matrix[0].length-1;

        while(i< matrix.length && j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]<target){
                i++;
            }else{
                j--;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[][]matrix=new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        int target=3;

        boolean check=checkPresentOrNOt(matrix,target);

        if(check){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

}


//Note: search in 2d matrix solution is also same
//like we can copy paste this solution