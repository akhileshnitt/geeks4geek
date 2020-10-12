package mustodo.arrays.strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
    public static void main(String[] args) {
        String s = "geeks for geeks";

        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(set.add(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
