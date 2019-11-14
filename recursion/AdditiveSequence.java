package recursion;

public class AdditiveSequence {

    public static void main(String[] args) {

        String s = "991100191";

        boolean isAdditiveSequence = isAdditiveSequence(s);
    }

    private static boolean isAdditiveSequence(String s) {

        int sLength = s.length();

        boolean isAdditive = false;
        for(int i=1;i<sLength/2;i++){
            for(int j=i+1;j<sLength/2;j++){
                isAdditive = isAdditiveSequenceRec(s.substring(0,i),s.substring(i,j),s.substring(j));
            }
        }
        return isAdditive;
    }

    private static boolean isAdditiveSequenceRec(String left, String right, String result) {

        if(left == null ||right == null||result == null){
            return false;
        }

        int leftN = Integer.valueOf(left);
        int rightN = Integer.valueOf(right);
        int resultT = Integer.valueOf(result);
        int noOfDigit = String.valueOf(resultT).length();

      //  String prefix = result.substring(0,String.valueOf(leftN+rightN).length());


        if(leftN+rightN == resultT|| result.startsWith(String.valueOf(leftN+rightN))){
            String remaining = result.substring(String.valueOf(leftN+rightN).length());
            isAdditiveSequenceRec(right,String.valueOf(leftN+rightN),remaining);
        }

        return false;
    }
}
