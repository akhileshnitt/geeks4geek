package array;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SmallestString {


    public static void main(String[] args) {
        int weight = 730;


       Map<BigInteger, String> map = new TreeMap<>();


        map.put(new BigInteger("1"),"A");
        BigInteger pre = new BigInteger("1");
        for(int i=2;i<=26;i++){

            BigInteger nu = new BigInteger(String.valueOf(i)).multiply(pre).add(pre);

            map.put(nu,String.valueOf((char) (65+i-1)));

            pre = nu;
        }

        System.out.println(map);


        List<BigInteger> list = map.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(list);

      //  BigInteger number = findIndex(list,new BigInteger(String.valueOf(weight)));
      //  System.out.println(number);

        StringBuilder sb = new StringBuilder();
        BigInteger wt = new BigInteger(String.valueOf(weight));
        while(wt.compareTo(new BigInteger("0")) >0){

            BigInteger nu = findIndex(list,wt);
            sb.append(map.get(nu));


            wt = wt.subtract(nu);
         //   wt = wt.subtract(number);


        }


        System.out.println(sb.reverse());




    }

    private static BigInteger findIndex(List<BigInteger> list, BigInteger weight) {

        for(int i=0;i<list.size();i++){
            if(list.get(i).compareTo(new BigInteger(String.valueOf(weight))) >0){
                return list.get(i-1);
            }
        }
        return  list.get(list.size()-1);
    }

}

class Weight {

    String chr;
    int weight;

    public Weight(String chr, int weight) {
        this.chr = chr;
        this.weight = weight;
    }

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
