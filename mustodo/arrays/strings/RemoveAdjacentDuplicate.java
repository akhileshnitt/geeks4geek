package mustodo.arrays.strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveAdjacentDuplicate {
    public static void main(String[] args) {

        String str1 = "geeksforgeeg";
        remove(str1);
        String str2 = "azxxxzy";
        remove(str2);

        String str3 = "caaabbbaac";
        remove(str3);

        String str4 = "gghhg";
        remove(str4);

        String str5 = "aaaacddddcappp";
        remove(str5);

        String str6 = "aaaaaaaaaa";
        remove(str6);

        String str7 = "qpaaaaadaaaaadprq";
        remove(str7);

        String str8 = "acaaabbbacdddd";
        remove(str8);




    }

    private static void remove(String s) {
        while (hasDuplicate(s)) {
            s = removeAdjacent(s, new StringBuffer()).toString();
            //System.out.println(s);
        }
        System.out.println( s);
    }

    private static boolean hasDuplicate(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                return true;
            }
        }
        return false;
    }

    private static StringBuffer removeAdjacent(String s, StringBuffer out) {


        while (s.length() > 1) {
            if (s.charAt(0) == s.charAt(1)) {
                while (s.length() > 1 && s.charAt(0) == s.charAt(1)) {
                    s = s.substring(1);
                }
                s = s.substring(1);
            } else {
                out.append(s.charAt(0));
                s = s.substring(1);
            }
            if(s.length() ==1){
                out.append(s.charAt(0));
                s = s.substring(1);
            }
        }
        return out;
    }
}
