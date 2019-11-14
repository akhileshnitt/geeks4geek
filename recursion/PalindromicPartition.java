package recursion;

public class PalindromicPartition {


    public static void main(String[] args) {
        String s = "geeks";

        palidromePartition(s);
    }

    private static void palidromePartition(String s) {
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.substring(i,j);
                boolean isPalin = isPalindrome(sub);
                if(isPalin) {
                    System.out.println(sub);
                }
            }
        }
    }

    private static boolean isPalindrome(String sub) {

        for(int i=0;i<sub.length()/2;i++){
            if(sub.charAt(i) != sub.charAt(sub.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}
