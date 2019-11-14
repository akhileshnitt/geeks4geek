package recursion;

public class PrintSubString {


    public static void main(String[] args) {
        String s = "1234";
        int startIndex = 0;
        String result ="";
     //   printAlllSubString(s,startIndex,result);


       // printAlllSubString1(s,startIndex,result);
        printAllIterative(s);


    }

    private static void printAllIterative(String s) {

        for(int i=0;i<s.length();i++){
            for(int j=i;j<=s.length();j++){
                System.out.println(s.substring(i,j));
            }
        }
    }

    private static void printAlllSubString1(String s, int startIndex, String result) {

        System.out.println(result);
        if(startIndex == s.length()) return;




        printAlllSubString1(s,startIndex+1,result+s.charAt(startIndex));
        printAlllSubString1(s,startIndex+1,result);


    }

    private static void printAlllSubString(String s, int startIndex, String result) {

        if(s.length() ==0) return;

        for(int i=0;i<s.length();i++){
            String newS = result +s.charAt(i);
            System.out.println(newS);
            printAlllSubString(s.substring(i+1),0,newS);
        }
    }
}
