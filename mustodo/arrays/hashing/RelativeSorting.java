package mustodo.arrays.hashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativeSorting {
    static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        /*Integer a[] = {2 ,1 ,2 ,5 ,7 ,1, 9, 3, 6 ,8 ,8};
        int b[] = {2 ,1, 8, 3};*/

        Integer a[] = {2 ,6, 7, 5, 2, 6, 8, 4};
        int b[] = {2 ,6 ,4 ,5};

        relative(a,b);
    }

    private static void relative(Integer a[] , int[] b) throws Exception {
        if(b.length >a.length) throw  new Exception("Invalid Input");

        for(int i=0;i<b.length;i++){
            map.put(b[i],i);
        }

        List<Integer> list = Arrays.asList(a);

        Collections.sort(list,( e1, e2)->{
            Integer index1 = map.get(e1);
            Integer  index2= map.get(e2);

            if(index1 == null || index2 == null){
                if(e1>e2) return 1;
                else return -1;
            }else{
                if(index1 <index2) return -1;
                else return 1;
            }
        });

        System.out.println(list);
    }
}
