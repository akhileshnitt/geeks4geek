package mustodo.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class MInimumIndex {

    public static void main(String[] args) {
        /*String s="geeksforgeeks";
        String pattern = "set";*/

        String s="adcffaet";
        String pattern = "onkl";

        int index = minIndex(s,pattern);
        if(index == Integer.MAX_VALUE){
            System.out.println("$");
        }else{
            System.out.println(s.charAt(index));
        }

    }

    private static int minIndex(String s, String pattern) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == null){
                map.put(s.charAt(i),i);
            }else{
                int index =  map.get(s.charAt(i));
                if(i<index){
                    map.put(s.charAt(i),i);
                }
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<pattern.length();i++){
            if(map.get(pattern.charAt(i)) != null){
                if(map.get(pattern.charAt(i)) <minIndex){
                    minIndex = map.get(pattern.charAt(i));
                }
            }
        }
        return minIndex;
    }
}
