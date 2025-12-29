package String.Easy.FindTheIndexOfTheFirstOccurrenceInAString28;

import java.util.Scanner;

public class SimpleAndOptimize {

    public static int check(String str1, String str2){

        for(int i=0;i<=str1.length()-str2.length();i++){
            String substring=str1.substring(i,i+str2.length());

            if(substring.equals(str2)){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String haystack= scanner.next();
        String needle=scanner.next();

        int ind=check(haystack,needle);

        System.out.println("The Index of the First Occurrence in a String: "+ind);
    }
}
