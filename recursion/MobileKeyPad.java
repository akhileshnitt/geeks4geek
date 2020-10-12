package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileKeyPad {

    public static void main(String[] args) {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('A','B','C'));
        map.put(3, Arrays.asList('D','E','F'));
        map.put(4, Arrays.asList('G','H','I'));
        map.put(5, Arrays.asList('J','K','L'));
        map.put(6, Arrays.asList('M','N','O'));
        map.put(7, Arrays.asList('P','Q','R','S'));
        map.put(8, Arrays.asList('T','U','V'));
        map.put(9, Arrays.asList('W','X','Y','Z'));

        StringBuffer input = new StringBuffer("23456789");

        char [] op = new char[input.length()];

        generateString(map,op,0,input,0);


    }

    private static void generateString(Map<Integer, List<Character>> map, char[] op, int index, StringBuffer input,int inputIndex) {

        if(inputIndex > input.length()) return;
        if(index == op.length){
            for (char c: op){
                System.out.print(c+",");
            }
            System.out.println();
            return;
        }

        List<Character> characters = map.get(Integer.valueOf(input.charAt(inputIndex)+""));
        for(int i=0;i<characters.size();i++) {
            op[index++]= characters.get(i);
            generateString(map,op,index,input,inputIndex+1);
            index--;
        }





    }
}
