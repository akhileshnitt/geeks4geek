package recursion;

public class LongestPalindroString {


    public static void main(String[] args) {
        String s = "GEEKSFORGEEKS";

       // iterativeWay(s);
       int length =  recursive(s,0,s.length()-1,0);
        System.out.println(length);
    }

    private static int recursive(String s, int startIndex,int endIndex, int lenth) {

        if(startIndex == endIndex) {
            return 1;
        }
        if(s.length() == 0){
            return 0;
        }
       if(startIndex >= endIndex){

            return lenth;
       }

        if(s.charAt(startIndex) == s.charAt(endIndex)){
           return  2+recursive(s,startIndex+1,endIndex-1,lenth);
        }
        else{
            return Math.max(recursive(s,startIndex+1,endIndex,lenth),recursive(s,startIndex,endIndex-1,lenth));
        }
    }

    private static void iterativeWay(String s) {
        String ans =null;
        int length = Integer.MIN_VALUE;
        for(int i=0;i<=s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String temp = s.substring(i,j);
                if(isPalinDrome(temp)) {
                    if(temp.length() >length){
                        length = temp.length();
                        ans = temp;
                    }

                }
            }
        }

        System.out.println("ans : "+ans+" length "+length);
    }

    private static boolean isPalinDrome(String temp) {

        for(int i=0;i<temp.length()/2;i++){
            if(temp.charAt(i) != temp.charAt(temp.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
