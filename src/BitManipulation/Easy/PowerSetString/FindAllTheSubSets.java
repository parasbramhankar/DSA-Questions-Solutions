package BitManipulation.Easy.PowerSetString;

import java.util.Arrays;
import java.util.Scanner;

public class FindAllTheSubSets {

    static String[] findSubset(String str){

        int n=str.length();
        int pSetSize=(int)Math.pow(2,n);

        String[]strings=new String[pSetSize];



        for(int i=0;i<pSetSize;i++){

        StringBuilder stringBuilder=new StringBuilder("");

            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0){
                    stringBuilder.append(str.charAt(j));
                }
            }
            strings[i]=stringBuilder.toString();
        }

        return strings;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String str=scanner.next();

        System.out.println(Arrays.toString(findSubset(str)));

        scanner.close();
    }
}
