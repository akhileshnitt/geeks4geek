package mustodo.arrays.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySubSet {

    public static void main(String[] args) {
        /*int a [] ={11 ,1 ,13, 21, 3, 7};
        int b[] = {11, 3 ,7 ,8};*/

        int a [] ={10 ,5 ,2 ,23, 19};
        int b[] = {19 ,5 ,2};

        System.out.println(isBSubSetofA(a,b));
    }

    private static boolean isBSubSetofA(int[] a, int[] b) {
        if(b.length>a.length) return false;

        Set<Integer> set = new HashSet<>();
        Arrays.stream(a).forEach(e->set.add(e));

        for(int i=0;i<b.length;i++){
            if(!set.contains(b[i])){
                return false;
            }
        }
        return true;
    }
}
