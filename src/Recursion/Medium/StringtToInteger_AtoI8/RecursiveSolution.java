package Recursion.Medium.StringtToInteger_AtoI8;

import java.util.Scanner;

public class RecursiveSolution {

    public static int MyAtoI(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int i = 0;
        int sign = 1;
        int n = s.length() - 1;
        int num = 0;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        return recursionFunction(s, i, n, sign, num);
    }

    static int recursionFunction(String s, int i, int n, int sign, int num) {
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return sign * num;
        }
        int digit = s.charAt(i) - '0';
        if (num > (Integer.MAX_VALUE - digit) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return recursionFunction(s, i + 1, n, sign, ((num * 10) + digit));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        int number = MyAtoI(string);

        System.out.println("The number: " + number);
    }
}
