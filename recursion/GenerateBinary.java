package recursion;

import java.util.HashSet;
import java.util.Set;

public class GenerateBinary {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {

        int length =4;
        int zer0 =0;
        int one = 1;
        String result="";
        generateBinary(length,zer0,"",set);
        generateBinary(length,one,"",set);

        System.out.println(set);
    }

    private static void generateBinary(int length, int passed, String s, Set<String> set) {

        if(s.length() == length){
            set.add(s);
           // System.out.println(s);
            return;
        }
        if(passed ==0){
            generateBinary(length,0,s+0, set);
            generateBinary(length,1,s+1, set);
        }
        else{
            generateBinary(length,0,s+0, set);
        }
    }
}
