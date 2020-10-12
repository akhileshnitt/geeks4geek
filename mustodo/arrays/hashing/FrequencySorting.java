package mustodo.arrays.hashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySorting {

    static Map<Integer ,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        /*Integer a[] = {5, 5, 4, 6, 4};*/

        Integer a[] = {9 ,9, 9 ,2 ,5};

        sortByFrequency(a);
    }

    private static void sortByFrequency(Integer[] a) {
        for(int i=0;i<a.length;i++){
            if(map.get(a[i]) == null){
                map.put(a[i],1);
            }else{
                Integer count = map.get(a[i]);
                map.put(a[i],count+1);
            }
        }

        List<Integer> list = Arrays.asList(a);

        Collections.sort(list,( e1, e2)->{
            int f1 = map.get(e1);
            int f2 = map.get(e2);

            if(f1 == f2){
                if(e1>e2) return 1;
                else return -1;
             }
            else{
                if(f1>f2) return -1;
                else return 1;
            }

        });
        System.out.println(list);
    }
}
