package array;

import java.util.Arrays;

public class BiggestNumber {

    public static void main(String[] args) {
        //Integer inout [] = new Integer[]{54,546,548,60};

        Integer inout [] = new Integer[]{1,34,3,98,9,76,45,4};



     //   Arrays.stream(inout).forEach(i-> System.out.println(i));

        //54546   , 54654

        StringBuffer largestNumber = new StringBuffer();



        Arrays.sort(inout, (o1, o2) -> {
            StringBuffer sb1 = new StringBuffer();
            String o11 = sb1.append(o1).append(o2).toString();

            StringBuffer sb2 = new StringBuffer();

            String o22 = sb2.append(o2).append(o1).toString();
          //  System.out.println(o11 +" ," +o22);
            if(Integer.parseInt(o22) > Integer.parseInt(o11)){
                return 1;
            }
            else
            {
                return -1;
            }


        });

        Arrays.stream(inout).forEach(i-> largestNumber.append(i));

        System.out.println(largestNumber);
    }

}
