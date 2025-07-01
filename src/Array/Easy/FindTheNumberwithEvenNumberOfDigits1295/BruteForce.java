package Array.Easy.FindTheNumberwithEvenNumberOfDigits1295;

public class BruteForce {

    public static int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            int digitCount = 0;
            int temp = num;

            // Count digits manually
            while (temp > 0) {
                digitCount++;
                temp = temp / 10;
            }

            if (digitCount % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {12, 345, 2, 6, 7896};
        System.out.println("The number of elements with even number of digits are: " + findNumbers(arr));
    }


}
