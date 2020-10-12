package mustodo.arrays.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSum {

    static  Set<String> set = new HashSet<>();
    public static void main(String[] args) {

       /* int [] arr = {10,1,2,7,6,1,5 };
        int add =8;*/

        int [] arr = {2,2,2 };
        int sum =4;
        Arrays.sort(arr);
        printCombination(arr,sum,new ArrayList<>(),0,0);
        set.forEach(e-> {
            for(int i=0;i<e.length();i++){
                System.out.print(e.charAt(i)+",");
            }
            System.out.println();
        });
    }

    private static void printCombination(int[] arr, int sum, List<Integer> list, int index, int tempSum) {

        if(tempSum >sum || index>arr.length) return;

        if(tempSum == sum){
            set.add(list.stream().map(String::valueOf).collect(Collectors.joining()));
            //list.forEach(e -> System.out.print(e + ","));
        //    System.out.println();
        }

        for(int i=index;i<arr.length;i++){
            tempSum += arr[i];
            list.add(arr[i]);
            index =  index+1;
            printCombination(arr,sum,list,index,tempSum);
            tempSum -=list.get(list.size()-1);
            list.remove(list.size()-1);
        }

    }


}
