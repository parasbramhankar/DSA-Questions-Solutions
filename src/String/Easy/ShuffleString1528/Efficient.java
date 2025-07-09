package String.Easy.ShuffleString1528;

public class Efficient {

    public String restoreString(String s, int[] indices) {

        StringBuilder sb=new StringBuilder (s);
        for(int i=0;i<s.length();i++){

            sb.setCharAt(indices[i],s.charAt(i));

        }

        return sb.toString();


    }



}
