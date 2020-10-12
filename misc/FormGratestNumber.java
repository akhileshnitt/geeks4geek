package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FormGratestNumber {


    public static void main(String[] args) {
        int a [] = {54,546,548,60};


        //int a [] = {1,34,3,98,9,76,45,4};

        new ArrayList<>();
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());

        // 9 ,98
        Collections.sort(list, (o1, o2) -> {
            //append o1 to o2
            StringBuffer sb1 = new StringBuffer();
            sb1.append(o1);
            sb1.append(o2);

            StringBuffer sb2 = new StringBuffer();
            sb2.append(o2);
            sb2.append(o1);

            if(Integer.parseInt(sb1.toString())> Integer.parseInt(sb2.toString())){
                return -1;
            }
            else{
                return 1;
            }
        });

        System.out.println(list);
        String s = list.stream().map(String::valueOf).collect(Collectors.joining(""));
        System.out.println(s);
    }
}
