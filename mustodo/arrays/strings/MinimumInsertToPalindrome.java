package mustodo.arrays.strings;

public class MinimumInsertToPalindrome {

    public static void main(String[] args) {
        String s = "mbadm";

        int count = findMinimum(s);
        System.out.println(count);
    }

    private static int findMinimum(String s) {
        if(s.length() ==1){
            return 0;
        }
        if(isPalindrome(s)){
            return 0;
        }
        if(s.charAt(0) == s.charAt(s.length()-1)){
            return  findMinimum(s.substring(1,s.length()-1));
        }
        else{
            return 1+Math.min(findMinimum(s.substring(0,s.length()-1)),findMinimum(s.substring(1,s.length())));
        }
    }


    private static boolean isPalindrome(String s) {
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1)) return false;
        }
        return true;
    }
}
