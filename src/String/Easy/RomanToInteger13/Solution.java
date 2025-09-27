package String.Easy.RomanToInteger13;

import java.util.Scanner;

class Solution {
    public static int romanToInt(String s) {
        int ans = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> num;
            };
            if (4 * num < ans)
                ans -= num;
            else
                ans += num;
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the Roman Number: ");
        String s=scanner.next();

        int number=romanToInt(s);

        System.out.println(s+" : "+number);
    }
}
