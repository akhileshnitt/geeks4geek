package array;

import java.util.HashMap;
import java.util.Map;

public class PyramidDrop {

    public static void main(String[] args) {
        /**
         *        1
         *     2     3
         *   4    5    6
         *  7   8    9   10
         */

        double water = 9;
        int bucket =10;

        double waterInBucket = waterInBucket(water,bucket);
        System.out.println(waterInBucket);
    }

    private static double waterInBucket(double water, int buket) {

        Map<Integer,Double> map = populateMap();

        int level = 4;
        int bucketNo=1;
        double tempWater = 1.0;
        for(int i=1;i<=level;i++){
            if(water <= 0) break;
            int j=1;
            if(i <=water){
                tempWater =1.0;
            }
            else{
                tempWater = tempWater/i;
            }
            while(j<=i){
                map.put(bucketNo++,tempWater);
                water--;
                j++;
            }
        }

        return  map.get(buket);
    }

    private static Map<Integer, Double> populateMap() {

        Map<Integer,Double> map = new HashMap<>();
        map.put(1,0.0);
        map.put(2,0.0);
        map.put(3,0.0);
        map.put(4,0.0);
        map.put(5,0.0);
        map.put(6,0.0);
        map.put(7,0.0);
        map.put(8,0.0);
        map.put(9,0.0);
        map.put(10,0.0);
        return map;


    }
}
