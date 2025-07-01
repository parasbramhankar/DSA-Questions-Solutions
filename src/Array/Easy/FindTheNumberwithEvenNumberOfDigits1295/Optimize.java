package Array.Easy.FindTheNumberwithEvenNumberOfDigits1295;

public class Optimize {

    public static int findNumbers(int[] nums) {

        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int c = (int) Math.floor(Math.log10(nums[i])) + 1;

            if (c % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[]arr={12,345,2,6,7896};

        System.out.println("The number of elements with even number of digits are : "+findNumbers(arr));
    }

}
