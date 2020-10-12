package misc;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class LongestLexicalPalindrome {

    public static void main(String[] args) {
        String s = "adskassda";

        Map<Character,Integer> map = new TreeMap<>();

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == null){
                map.put(s.charAt(i),1);
            }
            else{
                int conunt = map.get(s.charAt(i));
                map.put(s.charAt(i),conunt+1);
            }
        }

      //  System.out.println(map);

        StringBuffer f = new StringBuffer();
        StringBuffer l = new StringBuffer();

        Iterator<Map.Entry<Character, Integer>> itr = map.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Character, Integer> entry = itr.next();
            if(entry.getValue() >=2){
                f.append(entry.getKey());
                l.append(entry.getKey());
                map.put(entry.getKey(),entry.getValue()-2);
            }
        }

        int min = Integer.MAX_VALUE;
        itr = map.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Character, Integer> entry = itr.next();
            if(entry.getValue() >0 && entry.getKey() <min){
                min = entry.getKey();
            }
        }
        System.out.println(f.append((char)min).append(l.reverse()));
    }
}

