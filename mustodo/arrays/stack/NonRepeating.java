package mustodo.arrays.stack;

import java.util.HashSet;
import java.util.Set;

public class NonRepeating {
    /**
     * a a b c
     * 3
     * a a c
     *
     * Output:
     * a -1 b b
     * a -1 c
     */


    // a a b c b
    // a -1 b b c

    public static void main(String[] args) {
        String s = "aaa";
        nonRepeating(s);
    }

    private static void nonRepeating(String s) {
        Set<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(set.size() ==0){
                System.out.print( s.charAt(i)+",");
                set.add(s.charAt(i));
            }else{
                if(set.contains(s.charAt(i))){
                    set.remove(s.charAt(i));
                    if(set.size() ==0) {
                        System.out.print("-1" + ",");
                    }else{
                        System.out.print(set.iterator().next()+",");
                    }
                }else{

                    System.out.print(set.iterator().next()+",");
                    set.add(s.charAt(i));
                }
            }
        }

    }
}
