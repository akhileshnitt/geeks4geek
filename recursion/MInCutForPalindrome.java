package recursion;

public class MInCutForPalindrome {

    public static void main(String[] args) {
        String s = "bababcbadcd";


        int minCut = findMinCut(s,0,s.length()-1);
        System.out.println(minCut);
    }

    private static int findMinCut(String s,int i,int j) {

        if(isPalindrome(s,i,j) || (i==j)){
            return 0;
        }


        int micCut= Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
            int count =  1+findMinCut(s,i,k)+findMinCut(s,k+1,j);
            if(count<micCut){
                micCut =count;
            }
        }

      return micCut;
    }


    private static boolean isPalindrome(String sub, int i, int j) {

        while(i<=j){
            if(sub.charAt(i) != sub.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;

            }
        }
        return true;
    }


}
