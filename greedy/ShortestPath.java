package greedy;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

//https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
public class ShortestPath {

    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex v0 = graph.addVertex(0);
        Vertex v1 = graph.addVertex(1);
        Vertex v7 = graph.addVertex(7);

        graph.addEdge(v0,v1,4);
        graph.addEdge(v0,v7,8);
        graph.addEdge(v1,v7,11);


        Vertex v2 = graph.addVertex(2);
        Vertex v8 = graph.addVertex(8);
        Vertex v6 = graph.addVertex(6);

        graph.addEdge(v1,v2,8);
        graph.addEdge(v7,v8,7);
        graph.addEdge(v7,v6,1);
        graph.addEdge(v2,v8,2);
        graph.addEdge(v8,v6,6);


        Vertex v3 = graph.addVertex(3);
        Vertex v5 = graph.addVertex(5);
        Vertex v4 = graph.addVertex(4);


        graph.addEdge(v2,v3,7);
        graph.addEdge(v2,v5,4);
        graph.addEdge(v6,v5,2);

        graph.addEdge(v3,v4,9);
        graph.addEdge(v3,v5,14);
        graph.addEdge(v5,v4,10);


        //shortest path
        Vertex sourceV = v0;
        shortestPath(graph,sourceV);

        printShortesPath(graph,sourceV);



    }

    private static void printShortesPath(Graph graph,Vertex source) {
        System.out.println("Shortest Path from Vertex : "+source.getLabel());
        graph.getGraph().keySet().forEach(e->{
            System.out.println("Source : "+source.getLabel() +" Destination: "+ e.getLabel()+"   distance : "+e.getDistance());
        });
    }

    private static void shortestPath(Graph graph,Vertex v0) {
        v0.setDistance(0);

        PriorityQueue<Vertex> pq = new PriorityQueue<>(graph.noOfVertices(), new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.getDistance()-o2.getDistance() >0 ?1:-1;
            }
        });

        graph.getGraph().keySet().forEach(e->pq.add(e));

        Set<Vertex> includedIn = new HashSet<>();
        while(!pq.isEmpty()){

            Vertex vertex = pq.poll();
            if(!includedIn.contains(vertex)) {
                includedIn.add(vertex);
                List<Edge> edgeList = graph.getGraph().get(vertex);

                for(Edge edge: edgeList){
                    int tempDestination = edge.getSource().getDistance()+edge.getWeight();
                    if(tempDestination<edge.getDestination().getDistance()){
                        pq.remove(edge.getDestination());
                        edge.getDestination().setDistance(tempDestination);
                        pq.add(edge.getDestination());
                    }
                }

            }
        }


    }
}
