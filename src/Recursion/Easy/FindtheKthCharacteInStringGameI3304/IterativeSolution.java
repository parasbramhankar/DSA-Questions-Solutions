package Recursion.Easy.FindtheKthCharacteInStringGameI3304;

import java.util.Scanner;

public class IterativeSolution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the value of K");
        int k=scanner.nextInt();

        char ch=findKthCharacter(k);
        System.out.println(ch);
    }
    static char findKthCharacter(int k){
        StringBuilder word=new StringBuilder("a");

        while(word.length()<k){
            StringBuilder  temp=new StringBuilder("");
            int ind=0;

            while(ind<word.length()){
                char c=word.charAt(ind);
                c++;
                temp.append(c);
                ind++;
            }
            word.append(temp);
        }
        System.out.println(word);
        return word.charAt(k-1);
    }
}
