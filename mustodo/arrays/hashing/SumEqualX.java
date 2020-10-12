package mustodo.arrays.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumEqualX {

    public static void main(String[] args) {
        /*int a[] = {1 ,2, 4 ,5 ,7};
        int b [] = {5, 6, 3, 4, 8};
        int X=9;*/

        int a[] = {0 ,2};
        int b [] = {1, 3};
        int X=3;

        Set<Integer> set = new HashSet<>();
        Arrays.stream(a).forEach(e->set.add(e));
        //a+b = x
        // a = x-b;

        for(int i=0;i<b.length;i++){
            if(set.contains(X-b[i])){
                System.out.println(b[i]+","+(X-b[i]));

            }
        }
    }
}
