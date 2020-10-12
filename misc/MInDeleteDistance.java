package misc;

public class MInDeleteDistance {


    public static void main(String[] args) {
      /* String  word[] = {"ale", "apple", "monkey", "plea"};
        String t = "abpcplea";
*/

       String word[] = {"pintu", "geeksfor", "geeksgeeks"," forgeek"};

       String t = "geeksforgeeks";

   /*     String  s = "ab";
        String t = "ac";*/
         int maxLength = 0;
         String word1 = null;
        for(String s:word) {
            int count = subsequence(s, t);
            if(count >maxLength){
                maxLength = count;
                word1 = s;
            }

        }
        System.out.println(word1);
    }

    private static int findDeleteDistance(String s, String t,int sourceIndex,int destIndex) {

        if(sourceIndex >=s.length()) return destIndex-sourceIndex;
        if(destIndex>=t.length()) return sourceIndex-destIndex;

        if(s.charAt(sourceIndex) == t.charAt(destIndex) ){
            return findDeleteDistance(s,t,sourceIndex+1,destIndex+1);
        }
        else{
            return 1+findDeleteDistance(s,t,sourceIndex,destIndex+1);
        }
    }

    private static int subsequence(String s , String t){

        int i=0,j=0;

        int length = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                length++;
            }
            else{
                j++;
            }
        }

       return length;
    }
}
