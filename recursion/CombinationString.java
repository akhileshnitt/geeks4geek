package recursion;

public class CombinationString {

    public static void main(String[] args) {
        String s = "123";

        printCombinatio(s,s.length(),"",0);
    }

    private static void printCombinatio(String s, int length,String result,int index) {
        if(s.length() ==0){
            System.out.println(result);
        }

        for(int i = 1;i<=s.length();i++){
            String p1 = s.substring(0,i);
            String p2 = s.substring(i);
            String result1 = result+" "+p1;
            printCombinatio(p2,length,result1,index+1);
         //   System.out.println(result1);
        }
    }


}
