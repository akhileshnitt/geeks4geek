package mustodo.arrays.hashing;

import java.util.ArrayList;
import java.util.List;

public class CombinationFromNArray {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        //list2.add(2);
        list2.add(3);
        list2.add(4);

        /*List<Integer> list3 = new ArrayList<>();
        list3.add(5);
*/
        list.add(list1);
        list.add(list2);
       // list.add(list3);

        printCombination(list,0,new ArrayList<>());

    }

    private static void printCombination(List<List<Integer>> list, int index, List<Integer> out) {

        if(index>list.size()) return;

        if(out.size() == list.size()){
            System.out.println(out);
            return;
        }
        for(int i=0;i<list.get(index).size();i++){
            out.add(list.get(index).get(i));
            printCombination(list,index+1,out);
            out.remove(list.get(index).get(i));
        }
    }
}
