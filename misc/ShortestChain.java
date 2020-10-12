package misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestChain {

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("POON");
        dictionary.add("PLEE");
        dictionary.add("SAME");
        dictionary.add("POIE");
        dictionary.add("PLEA");
        dictionary.add("PLIE");
        dictionary.add("POIN");

        String source = "TOON";
        String target = "PLEA";

        int lenght= findMinimumChain(dictionary,source,target);
        System.out.println(lenght);

    }

    private static int findMinimumChain(Set<String> dictionary, String source, String target) {
        if(!dictionary.contains(target)) return 0;

        int level =0;
        Queue<String> queue= new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()){

            level++;
             String s = queue.poll();
            System.out.print(s+"->");

             for(int i=0;i<s.length();i++){
                 char original_char = s.charAt(i);
                 for(char c='A';c<='Z';c++){
                     char [] words = s.toCharArray();
                     words[i] = c;
      //               System.out.println(words);

                     if(dictionary.contains(String.valueOf(words))){
                         dictionary.remove(String.valueOf(words));
                         queue.add(String.valueOf(words));
                         break;
                     }
                 }
                 s.toCharArray()[i] =original_char;
             }
        }
        return level;


    }
}
