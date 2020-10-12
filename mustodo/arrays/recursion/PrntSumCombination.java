package mustodo.arrays.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrntSumCombination{

    public static void main(String[] args) {
        int sum =8;

        int numbers [] = {1,2,3,4};

        List<Integer> list = new ArrayList<>();

        printCombination(numbers,sum,0,list,0);
    }

    private static void printCombination(int[] numbers, int sum, int index, List<Integer> list,int tempSum) {

        if(tempSum >sum) return;

        if(tempSum == sum){
            list.forEach(e-> System.out.print(e+","));
            System.out.println();
            return;
        }

        for(int i=index;i<numbers.length;i++){
            tempSum += numbers[i];
            list.add(numbers[i]);
            printCombination(numbers,sum,i,list,tempSum);
            tempSum -= list.get(list.size()-1);
            list.remove(list.size()-1);
        }
    }

}
