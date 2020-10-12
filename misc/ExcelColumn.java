package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelColumn {

    public static void main(String[] args) {

        Map<Integer,Character> map = new HashMap<>();
        for(int i=1;i<=26;i++){
            map.put(i, (char) ((char)i+64));
        }

        List<Integer> list = Arrays.asList(26,51,52,80,676,702,705);
        list.forEach(e->printColumn(e,map));



    }

    private static void printColumn(int input, Map<Integer, Character> map) {
        if(input <=26){
            System.out.println(map.get(input));
        }
        else{


            StringBuffer sb = new StringBuffer();
            while (input >26) {
                int num = input / 26;
                int rem = input % 26;

                if(rem ==0){
                    num = num-1;
                    rem = 26;
                }

                sb.append(map.get(rem));
                if(num<=26)
                sb.append(map.get(num));
                input = num;
            }

            System.out.println(sb.reverse().toString());
        }
    }
}
