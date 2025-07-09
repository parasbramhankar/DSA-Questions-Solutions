package String.Easy.ShuffleString1528;

import java.util.LinkedHashMap;
import java.util.Map;

public class BruteForce {
    public String restoreString(String s, int[] in) {
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


}
