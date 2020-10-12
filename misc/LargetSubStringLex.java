package misc;

import java.util.Arrays;

public class LargetSubStringLex {

    public static void main(String[] args) {
        String s = "cfaxy";

       // String longest = findLongest(s);

        int length =longestString(s);
        System.out.println(length);
    }

    private static int longestString(String s) {

        int a[] = new int[s.length()];
        Arrays.fill(a,1);

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)>s.charAt(i-1)){
                a[i] = a[i-1]+1;
            }
        }
        return a[s.length()-1];
    }

    private static String findLongest(String s) {


        String temp = s.charAt(0)+"";
        int longest =1;
        for(int i=0;i<s.length();i++){
            int preV= s.charAt(i);
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(j) >preV){
                    if(j-i >longest){
                    longest = j-i;
                    temp = s.substring(i,j+1);
                    }
                    preV = s.charAt(j);
                }
                else{
                    break;
                }
            }

        }
        System.out.println(temp +" "+longest);
        return temp;
    }
}
