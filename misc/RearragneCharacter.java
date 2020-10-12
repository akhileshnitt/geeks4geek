package misc;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearragneCharacter {
    public static void main(String[] args) {
       // String s = "geeksforgeeks";

        String s = "bbababaaacd";

        String rearrangedChar = rearragneChar(s);
        System.out.println(rearrangedChar);

        if ((rearrangedChar.length() == s.length())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static String rearragneChar(String s) {

        Map<Character,Integer> map  = countFreq(s);

        PriorityQueue<Temp> pq = new PriorityQueue<>(map.keySet().size());

        map.entrySet().forEach(e->pq.add(new Temp(e.getKey(),e.getValue())));


        StringBuffer rearrangedChar = new StringBuffer();

        Temp previous = null;
        while(!pq.isEmpty()){
            Temp tempNode = pq.poll();
            rearrangedChar.append(tempNode.c);
            tempNode.freq = tempNode.freq-1;
            if(previous != null && previous.freq >0){
                pq.add(new Temp(previous.c,previous.freq));
            }
            previous = tempNode;
        }



        //System.out.println(pq.peek().freq);

        return rearrangedChar.toString();
    }

    private static Map<Character, Integer> countFreq(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.merge(c,1,Integer::sum);
        }
        return map;
    }
}

class Temp implements Comparable<Temp> {
    char c;
    int freq;

    public Temp(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }

    @Override
    public int compareTo(Temp o) {
        return this.freq >o.freq ?-1:1;
    }
}