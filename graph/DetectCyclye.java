package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DetectCyclye {
    public static void main(String[] args) {
        graph graph = new graph();
        vertex v0 = graph.addVertex(0);
        vertex v1 =graph.addVertex(1);
        vertex v2 =graph.addVertex(2);

        graph.addEdge(v0,v1);
        graph.addEdge(v1,v2);
     //   graph.addEdge(v2,v0);


        System.out.println(graph);

        boolean isCycleExist = detectCycle(graph);
        System.out.println("Cycle Exist : "+ isCycleExist);


    }

    private static boolean detectCycle(graph graph) {

        int parent [] = new int[graph.getVertices().size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }


        Iterator<vertex> itr = graph.getVertices().iterator();
        while(itr.hasNext()){
            vertex source = itr.next();
            for(vertex des : source.getEdges()){
                System.out.println("edge : "+source.getLabel() +" -- "+des.getLabel());
                int s = find(parent,source.getLabel());
                int t = find(parent,des.getLabel());
                if(s == t){
                    return true;
                }
                else{
                    union(parent,s,t);
                }
            }
        }

        return false;
    }

    private static void union(int[] parent, int s, int t) {
        if(s>t) {
            parent[t] = s;
        } else{
            parent[s] = t;
        }

    }

    private static int find(int[] parent, int label) {

        if(parent[label] ==label){
            return parent[label];
        }
        return  find(parent,parent[label]);
    }
}

class graph{

    private  int noOfVertices;

    private Set<vertex> vertices;

    public graph() {
        this.vertices = new HashSet<vertex>();
    }

    public vertex addVertex(int label){
        vertex tmpV = new vertex(label);
        this.vertices.add(tmpV);
        return tmpV;
    }


    public void addEdge(vertex source, vertex destination) {
        source.getEdges().add(destination);
        //destination.getEdges().add(source);
    }

    public int getNoOfVertices() {
        return noOfVertices;
    }

    public Set<vertex> getVertices() {
        return vertices;
    }
}
class vertex{

    private int label;
    private List<vertex> edges;

    public vertex(int label) {
        this.label = label;
        this.edges = new ArrayList<>();
    }

    public int getLabel() {
        return label;
    }

    public List<vertex> getEdges() {
        return edges;
    }
}