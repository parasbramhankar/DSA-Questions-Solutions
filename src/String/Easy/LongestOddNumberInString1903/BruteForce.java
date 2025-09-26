package String.Easy.LongestOddNumberInString1903;

import java.util.Scanner;

/***
 * This solution finds the largest odd number that can be formed by truncating the input string from the right, using a fast and greedy reverse traversal approach.[1][3][4]
 *
 * ### Core Intuition
 *
 * - An integer is odd if its last digit is odd (i.e., 1, 3, 5, 7, or 9).[1]
 * - Since the string represents a number, the largest possible substring is the one that is as long as possible and ends with an odd digit.[3][1]
 * - To maximize the value, keep all leftmost digits and only remove trailing even digits.
 *
 * ### Step-by-Step Approach
 *
 * 1. **Reverse Traversal**:
 *    Start from the rightmost digit and move left, checking each digit.[4][1]
 * 2. **Find the Last Odd Digit**:
 *    As soon as an odd digit is found, record its position. This is the furthest point at which the substring can end and still be odd.[7][3]
 * 3. **Generate the Answer**:
 *    Take the substring from the start of the string up to (and including) this last odd digit. This prefix ensures the number is as large as possible, while also ending with an odd digit.[8][1]
 * 4. **Handle Edge Case**:
 *    If no odd digit is found in the entire string, return an empty string.[3][4]
 *
 * ### Why This Works
 *
 * The main insight is that the prefix ending at the rightmost odd digit is always the largest possible odd-valued substring. Removing any left digits would yield a smaller number; extending further right would end on an even digit, which would not be odd.[1][3]
 *
 *
 */
public class BruteForce {

    public String largestOddNumber(String num) {
        StringBuilder str=new StringBuilder();
        int n=num.length();
        int pos=-1;
        for(int i=n-1;i>=0;i--){
            int ele=Integer.parseInt(String.valueOf(num.charAt(i)));

            if(ele%2!=0){
                pos=i;
                break;
            }

        }

        if(pos==-1){
            return "";
        }else{
            for(int i=0;i<=pos;i++){
                str.append(num.charAt(i));
            }
        }

        return new String(str);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the number: ");

        String num=scanner.next();

        String largestOddNumber=new BruteForce().largestOddNumber(num);
        System.out.println("The largest odd number in the String : "+largestOddNumber);
    }


}