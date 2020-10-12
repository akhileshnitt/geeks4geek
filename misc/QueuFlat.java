package misc;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class QueuFlat {

    public static void main(String[] args) {
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(Arrays.asList(1,2,3));
        queue.add(Arrays.asList(4,5,6));
        queue.add(Arrays.asList(-7));
        queue.add(Arrays.asList(8,9));

        List<Integer> list = queue.stream().flatMap(Collection::stream).collect(Collectors.toList());
    //    System.out.println(list);

        for (Integer e : list) {
            System.out.println(e);
            if (e < 0) break;

        }


    }

    private static boolean accept(Integer integer) {
        System.out.println(integer);
       if(integer <0) return false;
       return true;
    }
}
