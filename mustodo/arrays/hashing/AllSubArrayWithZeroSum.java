package mustodo.arrays.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllSubArrayWithZeroSum {
    public static void main(String[] args) {
        //int a[] = {6,  -1, -3, 4 ,-2, 2, 4, 6, -12, -7};
        //int a[] = {0, 0, 5, 5, 0, 0};
        int a[] = {6, 3, -1, -3, 4, -2, 2,4, 6, -12, -7};


        printAllSubArrayWithZeroSum(a);

    }

    private static void printAllSubArrayWithZeroSum(int[] a) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int  sum=0;
        int totalCount =0;
        for(int i=0;i<a.length;i++){
            sum = sum+a[i];
            if(sum  == 0){

                for (int m=0;m<=i;m++){
                    System.out.print(a[m]+",");
                }
                System.out.println();
                totalCount++;
            }
            else if(map.get(sum) ==  null){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sum,list);
            }
            else{
                List<Integer> list = map.get(sum);

                list.add(i);
               // totalCount = totalCount+list.size();

            }
        }
       // System.out.println(totalCount);

        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size()>1){
                List<Integer> indexes = entry.getValue();
                for (int i=0;i<indexes.size();i++){
                    for(int j=i+1;j<indexes.size();j++){
                       // System.out.println(indexes.get(i)+"--"+indexes.get(j));
                        for(int k=indexes.get(i)+1;k<=indexes.get(j);k++){
                            System.out.print(a[k]+",");

                        }
                        totalCount++;
                        System.out.println();
                    }
                }
            }
        }


        System.out.println("totalCount : "+totalCount);
    }
}
