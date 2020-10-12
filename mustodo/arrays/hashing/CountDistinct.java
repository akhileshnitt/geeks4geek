package mustodo.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class CountDistinct {

    public static void main(String[] args) {
       /* int a [] = {1, 2, 1, 3, 4, 2, 3};
        int window= 4;*/

        int a [] = {4,1,1};
        int window= 2;

        for(int i=0;i<=a.length-window;i++){
            System.out.print(printDistinct(a,i,window)+",");
        }
    }

    private static int printDistinct(int[] a, int index, int window) {

        Set<Integer> set = new HashSet<>();
        for(int i=index;i<index+window;i++){
            set.add(a[i]);
        }

        return set.size();
    }
}
