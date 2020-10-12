package mustodo.arrays.strings;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "aaaabbaa";

        int largest = Integer.MIN_VALUE;
        String largestString = "";
        for(int i=0;i<=s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String temp = s.substring(i,j);
                if(isPalindrome(temp)){
                    if(temp.length() >largest){
                        largest = temp.length();
                        largestString = temp;
                    }

                }
            }
        }
        System.out.println(largestString);
    }

    private static boolean isPalindrome(String str) {
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        }
        return true;
    }
}
