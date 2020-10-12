package mustodo.arrays.strings;

public class StrStr {
    public static void main(String[] args) {
        String s1= "GeeksForGeeks";
        String s2 = "For";

        int strstrIndex = strstrIndex(s1,s2);
        System.out.println(strstrIndex);
    }

    private static int strstrIndex(String s1, String s2) {
         // locate the occurence of s2 in s1
        if(s2.length() >s1.length()) return -1;

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == s2.charAt(0)){
                if(isMatched(s1,s2,i)){
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean isMatched(String s1, String s2, int index) {
        int s2Index=1;
        for(int i=index+1;i<s1.length()&& s2Index<s2.length();i++){
            if(s1.charAt(i) != s2.charAt(s2Index++)){
                return false;
            }
        }
        return true;
    }
}
