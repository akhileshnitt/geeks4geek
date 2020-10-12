package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {


    private Map<Integer, List<Integer>> map;

    public Graph(int v){
        map = new HashMap<>();
        for(int i=0;i<v;i++){
         map.put(i,new ArrayList<>());
        }
    }

    public Graph() {
    }

    public void addUndirectedEdge(int source, int destination){
        addDirectedEdge(source,destination);
        addDirectedEdge(destination,source);

    }

    public void addDirectedEdge(int source, int destination){
        List<Integer> adjList =  map.get(source);
        adjList.add(destination);

    }


    public Map<Integer, List<Integer>> getMap() {
        return map;
    }

    public void setMap(Map<Integer, List<Integer>> map) {
        this.map = map;
    }

    public void dropEdge(Integer source, Integer dest ) {

        map.put(source,newEdges(source,dest));
        map.put(dest,newEdges(dest,source));

    }

    private List<Integer>  newEdges(Integer source,Integer dest) {
        List<Integer> sourceList = map.get(source);
        List<Integer> sourceTemp = new ArrayList<>();
        sourceList.forEach(e->{
            if(e!= dest){
                sourceTemp.add(e);
            }
        });

        return sourceTemp;
    }
}
