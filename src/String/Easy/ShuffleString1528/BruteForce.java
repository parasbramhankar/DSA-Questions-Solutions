package String.Easy.ShuffleString1528;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BruteForce {
    public static String restoreString(String s, int[] in) {
        String str="";
        Map<Integer,Character> map=new LinkedHashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],s.charAt(i));
        }
        for(int i=0;i<in.length;i++){
            str+=map.get(i);
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};

        String result = restoreString(s, indices);
        System.out.println("Restored string: " + result);
    }

}
