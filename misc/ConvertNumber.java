package misc;

import java.util.HashMap;
import java.util.Map;

public class ConvertNumber {
    public static void main(String[] args) {
        int num = 122;



        Map<Integer,String> map = new HashMap<>();
        populateMap(map);
        String s = convertToWord(num,map);
        System.out.println(s);
    }

    private static void populateMap(Map<Integer, String> map) {
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(5,"five");
        map.put(6,"six");
        map.put(7,"seven");
        map.put(8,"eight");
        map.put(9,"nine");
        map.put(10,"ten");
        map.put(20,"twenty");
        map.put(30,"thirty");
        map.put(40,"fourty");
        map.put(50,"fifty");
        map.put(60,"sixty");
        map.put(70,"seventy");
        map.put(80,"eighty");
        map.put(90,"ninty");
        map.put(100,"hundred");
        map.put(1000,"thousand");

    }

    private static String convertToWord(int number,Map<Integer,String> map) {

        StringBuilder sb = new StringBuilder();

        int index=0;
        while(number>0){
            int n1 = number %10;
            double data = Math.pow(10,index++);
            int value = (int) data;
            int indexNumber = value*n1;
            number = number /10;
            if(indexNumber >0) {
                if (indexNumber >= 100 && indexNumber<1000) {
                    int temp = indexNumber / 100;
                  //  System.out.println("Temp :" + temp);
                    sb.append(map.get(100));
                    sb.append(" ");
                    sb.append(map.get(temp));
                    sb.append(" ");
                }
                else if(indexNumber >= 1000){
                    int temp = indexNumber / 1000;
                    //  System.out.println("Temp :" + temp);
                    sb.append(map.get(1000));
                    sb.append(" ");
                    sb.append(map.get(temp));
                    sb.append(" ");

                }else {
                    sb.append(map.get(indexNumber));
                    sb.append(" ");
                }

            }
         //   System.out.println("n1 :"+indexNumber+" num :"+number);
        }
        String [] tokens = sb.toString().split(" ");
        StringBuilder sb1 = new StringBuilder();
        for(int i=tokens.length-1;i>=0;i--){
            sb1.append(tokens[i]);
            sb1.append(" ");
        }
        return sb1.toString();

    }
}
