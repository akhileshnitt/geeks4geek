package misc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountNonUnique {

    public static void main(String[] args) {
       // int a[]= {1,3,3,4,4,4};

        int a[]= {8,1,3,1,4,5,6,3,2};

        Map<Integer,Integer> map = new HashMap();


        for(int i=0;i<a.length;i++){
            int count=0;
            if(map.get(a[i]) != null){
                 count = map.get(a[i]);
                map.put(a[i],count+1);
            }
            else{map.put(a[i],1);}
        }
         int nonUnique =0;

        Iterator<Integer>  itr= map.keySet().iterator();
        while(itr.hasNext()){
            int ab = itr.next();
            if(map.get(ab) >1){
                nonUnique = nonUnique+1;
            }
        }

        System.out.println(nonUnique);
    }
}
