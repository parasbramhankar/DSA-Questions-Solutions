package String.Easy.JewelsAndStones771;

import java.util.Scanner;

public class Solution {
    public static int numJewelsInStones(String jewels, String stones) {
        int count=0;

        for(int i=0;i<stones.length();i++){
            if(jewels.indexOf(stones.charAt(i))!=-1){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String jewels="aAA";
        String stones="aAAbbbb";

        int count=numJewelsInStones(jewels,stones);

        System.out.println("The stones you have are also jewels: "+count);
    }
}