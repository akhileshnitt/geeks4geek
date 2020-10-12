package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Vertex, List<Edge>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public Vertex addVertex(int label) {
        Vertex vertex = new Vertex(label);
        graph.put(vertex,new ArrayList<>());
        return vertex;
    }

    public void addEdge(Vertex v0, Vertex v1, int edgeWeight) {
        Edge edge1 = new Edge(v0,v1,edgeWeight);
        graph.get(v0).add(edge1);


        Edge edge2 = new Edge(v1,v0,edgeWeight);
        graph.get(v1).add(edge2);
    }

    public  int noOfVertices(){
        return graph.entrySet().size();
    }

    public Map<Vertex, List<Edge>> getGraph() {
        return graph;
    }
}
