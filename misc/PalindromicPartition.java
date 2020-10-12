package misc;

public class PalindromicPartition {
    public static void main(String[] args) {
       // String s = "ababbbabbababa";

        String s = "ababbbabbababa";

       // String s = "aba";
        
        int minCut = findMinCut(s);
        System.out.println(minCut);
    }


    private static int findMinCut(String input) {

        if(isPalindrome(input,0,input.length()-1)) {
            return 0;
        }
        if(input.length()==1){
            return 0;
        }

        int minCut = Integer.MAX_VALUE;

        for(int k=0;k<input.length()-1;k++){

            String s1 = input.substring(0,k+1);
            String s2 = input.substring(k+1);
           // System.out.println(s1+"  , "+s2);


            int cut = findMinCut(s1)+1+findMinCut(s2);
          //  System.out.println(cut);
            if(cut<minCut){
                minCut = cut;
             //   System.out.println(minCut);
            }


        }
        return minCut;
    }

/*
    private static int findMinCut1(char[] input,int startIndex , int endIndex) {
        
        if(isPalindrome(input,startIndex,endIndex)){
            return 0;
        }
        if(startIndex ==endIndex){
            return 0;
        }

        int cutM = Integer.MAX_VALUE;
        for(int k=startIndex;k<=endIndex;k++){
            int cut = findMinCut(input,startIndex,startIndex+k)+1+findMinCut(input,startIndex+k+1,endIndex);
            System.out.println("cut :"+cut);
            if(cut<cutM){
                cutM = cut;
            }
        }
        return cutM;
    }*/

    private static boolean isPalindrome(String input,int startIndex , int endIndex) {
        for(int i=startIndex;i<=endIndex/2;i++){
            if(input.charAt(i) != input.charAt(endIndex)) return false;
            else {
                endIndex--;
                startIndex++;
            }

        }
        return true;
    }
}
