package String.Easy.ReverseStringII541;

import java.util.Scanner;

public class Solution {

    public static void swap(char[]ch,int start,int end){
        while(start<end){
            char c=ch[start];
            ch[start]=ch[end];
            ch[end]=c;
            start++;
            end--;
        }
    }

    public static String reverseStr(String s, int k) {
        char[]ch=s.toCharArray();
        int n=s.length();

        for(int i=0;i<n;i=2*k+i){

            int start=i;
            int end=Math.min(i+k-1,n-1);

            swap(ch,start,end);
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the String: ");
        String string=scanner.next();

        System.out.println("Enter the value of K");
        int k=scanner.nextInt();

        String str=reverseStr(string,k);

        System.out.println("The updated String "+str);

    }
}
