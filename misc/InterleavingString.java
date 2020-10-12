package misc;

public class InterleavingString {

    public static void main(String[] args) {

        test("XXY", "XXZ", "XXZXXXY");
        test("XY", "WZ", "WZXY");
        test("XY", "X", "XXY");
        test("YX", "X", "XXY");
        test("XXY", "XXZ", "XXXXZY");

    }

    private static void test(String s1, String s2, String r) {
        boolean isInterleaving = isInterleaving(s1,s2,r,0);
        System.out.println(isInterleaving);
    }

    private static boolean isInterleaving(String s1, String s2, String r, int index) {

        int s1Index =0;
        int s2Index =0;
        for(int i =0;i<r.length();i++){
            if(s1Index < s1.length() && r.charAt(i) == s1.charAt(s1Index)){
                s1Index++;
            }
            else if(s2Index<s2.length() && r.charAt(i) == s2.charAt(s2Index)){
                s2Index++;
            }
        }
        if(s1Index == s1.length() && s2Index == s2.length()) return true;
        return false;
    }

    /*private static boolean isInterleaving(String s1, String s2, String r,int index) {
        if(r.length() != s1.length()+s2.length()) return false;

        if(r.charAt(index) == s1.charAt(index)){

        }
    }*/

}
