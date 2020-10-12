package mustodo.arrays.strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProcessProfile {

    public static void main(String[] args) {

        // phoneProfileMapping();

        sharedPhWithDiffName();
    }

    private static void phoneProfileMapping() {
        Map<String, Map<String,Integer>> map = new HashMap<>();

        int lineCount=0;
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/z002x5k/Downloads/untitled/src/mustodo/arrays/strings/temp.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;
                // process the line.
                String token  [] = line.split(",");
                if(map.get(token[0]) == null){
                    Map<String,Integer> map1 = new HashMap<>();
                    map1.put(token[2],1);
                    map.put(token[0],map1);
                }
                else{
                    Map<String,Integer> map1 =  map.get(token[0]);
                    if(map1.get(token[2]) == null){
                        Map<String,Integer> map2 = new HashMap<>();
                        map2.put(token[2],1);
                        map.put(token[0],map2);
                    }else{
                        Map<String,Integer> map2 = new HashMap<>();
                        map2.put(token[2],map1.get(token[2])+1);
                        map.put(token[0],map2);

                    }
                }
            }
            //     System.out.println(map);

            int count1=0;
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,Map<String,Integer>> entry = (Map.Entry<String, Map<String,Integer>>) iterator.next();

                Iterator itr1 =  entry.getValue().entrySet().iterator();
                while(itr1.hasNext()){
                    Map.Entry<String,Integer> entry1 = (Map.Entry<String, Integer>) itr1.next();
                    if(entry1.getValue() <=1) {
                        System.out.print(entry.getKey() + ",");
                        System.out.println(entry1.getKey() + "," + entry1.getValue());
                        count1 = count1+1;
                    }

                }

            }

            System.out.println(count1);

            System.out.println("totalLine : "+lineCount);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void sharedPhWithDiffName() {
        Map<String, Map<String,Integer>> map = new HashMap<>();

        int countLine=0;
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/z002x5k/Downloads/untitled/src/mustodo/arrays/strings/temp.txt"))) {
           String line;
           while ((line = br.readLine()) != null) {
               countLine++;
               // process the line.
               String token  [] = line.split(",");
               if(map.get(token[2]) == null){
                   Map<String,Integer> map1 = new HashMap<>();
                   map1.put(token[1],1);
                   map.put(token[2],map1);
               }
               else{
                   Map<String,Integer> map1 =  map.get(token[2]);
                   if(map1.get(token[1]) == null){
                       Map<String,Integer> map2 = new HashMap<>();
                       map2.put(token[1],1);
                       map.put(token[2],map2);
                   }else{
                       Map<String,Integer> map2 = new HashMap<>();
                       map2.put(token[1],map1.get(token[1])+1);
                       map.put(token[2],map2);

                   }
               }
           }
       //     System.out.println(map);

             int count1=0;
             Iterator iterator = map.entrySet().iterator();
             while(iterator.hasNext()){
                 Map.Entry<String,Map<String,Integer>> entry = (Map.Entry<String, Map<String,Integer>>) iterator.next();

                 Iterator itr1 =  entry.getValue().entrySet().iterator();
                 while(itr1.hasNext()){
                     Map.Entry<String,Integer> entry1 = (Map.Entry<String, Integer>) itr1.next();
                     if(entry1.getValue() <=1) {
                         System.out.print(entry.getKey() + ",");
                         System.out.println(entry1.getKey() + "," + entry1.getValue());
                         count1 = count1+1;
                     }

                 }

             }

            System.out.println(count1);

       }
       catch (Exception e){
           e.printStackTrace();
       }
    }
}
