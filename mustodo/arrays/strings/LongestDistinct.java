package mustodo.arrays.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestDistinct {
    public static void main(String[] args) {
        String s = "geeksforgeeks";

        int longest = findLongestDistinct(s);
        System.out.println(longest);
    }

    private static int findLongestDistinct(String s) {

        int longest = Integer.MIN_VALUE;
        for(int i=0;i<=s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String temp = s.substring(i,j);
                if(isDistinct(temp)){
                    if(temp.length() >longest){
                        longest = temp.length();
                    }
                }
            }
        }
        return longest;
    }

    private static boolean isDistinct(String temp) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<temp.length();i++){
            if(!set.add(temp.charAt(i))){
               return false;
            }
        }
        return true;
    }
}
