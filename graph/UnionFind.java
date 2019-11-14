package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionFind {

    public static void main(String[] args) {

        Graph graph = new Graph(3);

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(0,1));
        edgeList.add(new Edge(1,2));
        edgeList.add(new Edge(2,0));

        int parent [] = new int [3];
        Arrays.fill(parent,-1);

        boolean cycleFound = false;
        for(Edge edge:edgeList){
            int s = find(parent,edge.source);
            int d = find(parent,edge.destination);
            if(s== d){
                cycleFound = true;
                break;
            }
            else{
                //merge
                parent[d] = s;
            }
        }

        System.out.println("Cycle found : "+cycleFound);

    }

    private static int find(int[] parent, int source) {
        if(parent[source] == -1){
            return source;
        }
        else{
            return find(parent,parent[source]);
        }
    }


}

class Edge{
    int source;
    int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
}
