package mustodo.arrays.dp;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.List;

public class MaxLengthChain {
    public static void main(String[] args) {
       /* List<Pair<Integer,Integer>> pairs = Arrays.asList(new Pair<>(5  ,24),
                 new Pair<>(39  ,60),new Pair<>(15  ,28),new Pair<>(27  ,40),new Pair<>(50  ,90));
*/
        List<Pair<Integer,Integer>> pairs = Arrays.asList(new Pair<>(5  ,10),
                new Pair<>(1  ,11));

        pairs.sort((Pair<Integer,Integer> p1,Pair<Integer,Integer> p2)-> p1.snd > p2.snd?1:-1);
        int longestChanin = longestChanin(pairs);
        System.out.println(longestChanin);
    }

    private static int longestChanin(List<Pair<Integer, Integer>> pairs) {

        int size =0;

        for(int i=0;i<pairs.size();i++){
            Pair pair = pairs.get(i);
            int findLength = findLength(pairs,pair,i);
            if(findLength >size){
                size = findLength;
            }
        }
        return size;
    }

    private static int findLength(List<Pair<Integer, Integer>> pairs, Pair<Integer, Integer> pair, int index) {

        Pair<Integer,Integer> temp = pair;
        int size =1;
        for(int i=0;i<pairs.size();i++){
            if(i != index){
                if(temp.snd <pairs.get(i).fst){
                    size++;
                    temp = pairs.get(i);
                    index = i;
                }
            }
        }
        return size;
    }
}
