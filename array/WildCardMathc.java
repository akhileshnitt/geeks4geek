package array;

public class WildCardMathc {

    public static void main(String[] args) {
        String pattern = "*pqrs";
        String t = "pqrst";
      //  String t = "geeks"; // gks

       /* String pattern = "*?c*d";
        String t = "abcd";*/


        System.out.println(test("g*ks", "geeks")); // Yes
        System.out.println(test("ge?ks*", "geeksforgeeks")); // Yes
        System.out.println(test("g*k", "gee")); // No because 'k' is not in second
        System.out.println(test("*pqrs", "pqrst")); // No because 't' is not in first
        System.out.println(test("abc*bcd", "abcdhghgbcd")); // Yes
        System.out.println(test("abc*c?d", "abcd")); // No because second must have 2
        // instances of 'c'
        System.out.println(test("*c*d", "abcd")); // Yes
        System.out.println(test("*?c*d", "abcd")); // Yes


    }

    private static boolean test(String pattern, String t) {

        if(pattern.length() >t.length()) return false;
        int i=0, j=0;

        for(;i<pattern.length();i++){
            if(pattern.charAt(i) == '*'){
                if(i == pattern.length()-1){
                    return true;
                }
                else{
                    j = findIndex(pattern,t,i,j);
                    if(j==-1) return false;
                }
            }
            else if(pattern.charAt(i) == '?'){
                 j++;
            }
            else{
                if(pattern.charAt(i) != t.charAt(j)){
                    return false;
                }else{
                    j++;
                }
            }

        }
        //if(j!=t.length()-1) return false;
        return true;
    }

    private static int findIndex(String pattern, String t, int i, int j) {
        char c = pattern.charAt(i+1);
        if(c == '?') return j+1;
        for(int k=j;k<t.length();k++){
            if(t.charAt(k) == c){
                return k;
            }
        }
        return -1;
    }


}
