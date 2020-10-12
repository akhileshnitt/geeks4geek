package graph.cycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChainGraph {

    Map<Vertex, List<Vertex>> map = new HashMap<>();

    public Vertex addVertex(char charC) {
        Vertex tmp = new Vertex(charC);
        map.computeIfAbsent(tmp, k -> new ArrayList<Vertex>());
        return new Vertex(charC);
    }

    public void addDirectedEdge(Vertex source, Vertex dest) {
        if(map.get(source) != null && map.get(dest) != null){
            List<Vertex> adjList = map.get(source);
            adjList.add(dest);

        }


    }

    public Map<Vertex, List<Vertex>> getMap() {


        return map;
    }

    public void setMap(Map<Vertex, List<Vertex>> map) {
        this.map = map;
    }
}
