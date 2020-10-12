package graph.cycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CircleOfString {

    public static void main(String[] args) {
        String [] words = { "rig","geek","for",  "kaf"};

        //String [] words = {"abc", "bcd", "cdf"};

        //chains(words);

        chainsGraph(words);

    }

    private static void chainsGraph(String[] words) {

        ChainGraph graph = new ChainGraph();
        Vertex source = null;
        for(int i=0;i<words.length;i++){
            source = graph.addVertex(words[i].charAt(0));
            Vertex dest = graph.addVertex(words[i].charAt(words[i].length()-1));
            graph.addDirectedEdge(source,dest);

        }

        System.out.println(graph);

        // do dfs
        Map<Vertex,Boolean> map1 = graph.map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,e->false));
        doDFS(source,graph,map1);

        System.out.println(map1);

    }

    private static void doDFS(Vertex source, ChainGraph graph, Map<Vertex, Boolean> map1) {

        if(!map1.get(source)){
            map1.put(source,true);
        }

        List<Vertex> list = graph.getMap().get(source);
        for(Vertex vertex: list){
            if(!map1.get(vertex)){
                doDFS(vertex,graph,map1);
            }
        }

    }


    private static void chains(String[] words) {
        int initIndex = 0, startIndex =0;
        String initWord = words[initIndex];
        int count =1;
        List<String> chains = new ArrayList();
        chains.add(words[initIndex]);
        while(true) {

            initIndex = findNextIndex(words, initIndex);
        //    System.out.println(initIndex);
            if(initIndex ==-1 ||  chains.size() == words.length || startIndex== initIndex) break;
            else{
                chains.add(words[initIndex]);
            }

        }

        if(chains.size() == words.length){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }

    private static int findNextIndex(String[] words, int initIndex) {
        String initWord = words[initIndex];
        char charTOSearch = initWord.charAt(initWord.length()-1);

        for(int i=0;i<words.length;i++){
            if(i != initIndex){
                if(words[i].charAt(0) == charTOSearch){
                    return i;
                }
            }
        }
        return  -1;
    }



}
