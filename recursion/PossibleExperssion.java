package recursion;

public class PossibleExperssion {
    public static void main(String[] args) {
        /*String s = "123";
        int target= 6;*/
        int startIndex =1;

        String s = "125";
        int target = 7;


        for(int i=0;i<s.length();i++) {
            int tempComp = Integer.valueOf(s.substring(0,i+1));


            allPossibleExpressoin(s, s.substring(0,i+1) + "", target, i+1, tempComp);
         //   allPossibleExpressoin(s, s.substring(i+1) + "", target, i, tempComp);
        }
    }

    private static void allPossibleExpressoin(String input, String s,int target,int startIndex,int tempComp) {

        if(tempComp ==target){
            System.out.println(s);
        }
        if(startIndex >input.length()){

            return;
        }
        for(int i=startIndex;i<input.length();i++){
            String temp = input.charAt(i)+"";
            startIndex = i+1;
            allPossibleExpressoin(input,s+"+"+temp,target,startIndex,tempComp+Integer.valueOf(input.charAt(i)+""));
            allPossibleExpressoin(input,s+"-"+temp,target,startIndex,tempComp-Integer.valueOf(input.charAt(i)+""));
            allPossibleExpressoin(input,s+"*"+temp,target,startIndex,tempComp*Integer.valueOf(input.charAt(i)+""));
        }
    }
}
