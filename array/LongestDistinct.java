package array;

import java.util.HashSet;
import java.util.Set;

public class LongestDistinct {

    public static void main(String[] args) {
       // String s = "geeksforgeeks";
        String s = "abababcdefababcdab";
        int length = longest(s);
        System.out.println(length);
    }

    private static int longest(String s) {

        int longest = Integer.MIN_VALUE;
        boolean isDuplicate = false;
        for(int i=0;i<s.length();i++){
            Set<Character> set = new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(!set.add(s.charAt(j))|| j==s.length()-1){
                    isDuplicate = true;
                    if(set.size() >longest){
                        longest = set.size();
                    }
                    break;
                }

            }
        }
        if(!isDuplicate) return s.length();
        else return longest;
    }
}
