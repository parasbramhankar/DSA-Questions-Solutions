package String.Easy.AddStrings415;

import java.util.Scanner;

public class Solution {

    public static String addStrings(String num1,String num2){

        int len1=num1.length();
        int len2=num2.length();
        int carry=0;
        int ind=0;
        StringBuilder stringBuilder=new StringBuilder("");

        while(ind<len1 || ind <len2){
            int n1=(ind<len1) ?(num1.charAt(len1-1-ind)-'0'):0;
            int n2=(ind<len2) ?(num2.charAt(len2-1-ind)-'0'):0;

            int sum=n1+n2+carry;

            stringBuilder.append(sum%10);
            carry=sum/10;
            ind++;
        }
        if(carry>0){
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String num1= scanner.next();
        String num2= scanner.next();

        String ans=addStrings(num1,num2);

        System.out.println("The sum of two String: "+ans);
    }
}
