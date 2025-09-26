package String.Easy.LongestOddNumberInString1903;

import java.util.Scanner;

public class Optimize {

    String largestOddNumber(String num){
        for(int i=num.length()-1;i>=0;i--){
            int ele=num.charAt(i)-'0';
            if(ele%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the number: ");

        String num=scanner.next();

        String largestOddNumber=new BruteForce().largestOddNumber(num);
        System.out.println("The largest odd number in the String : "+largestOddNumber);
    }
}
