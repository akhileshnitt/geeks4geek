package graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bridge {
    public static void main(String[] args) {
      /*  int noOfVertices = 5;
        Graph graph = new Graph(noOfVertices);
        graph.addUndirectedEdge(2, 1);
        graph.addUndirectedEdge(2, 0);
        graph.addUndirectedEdge(1, 0);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(3, 4);*/


        int noOfVertices = 4;
        Graph graph = new Graph(noOfVertices);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(2, 3);



        Set<Map.Entry<Integer, List<Integer>> > entrySet = graph.getMap().entrySet();

        for(Map.Entry<Integer,List<Integer>> entry:entrySet){
            Integer source = entry.getKey();
            List<Integer> adjList = entry.getValue();

            for(Integer e: adjList){
               processBridgeFind(noOfVertices, graph, source,e);
            }
        }





       /* graph.getMap().entrySet().forEach(entry -> {
            List<Integer> adj = entry.getValue();

            adj.forEach(e -> {
                System.out.println("Dropping Edge :" + entry.getKey() + " <--->" + e);
                graph.dropEdge(entry.getKey(), e);

                boolean stillConnectedd = isGraphConnected(graph, findSource(noOfVertices, entry.getKey()));
                if (!stillConnectedd) {
                    System.out.println("Edge :" + entry.getKey() + " <--->" + e + " is a Bridge");
                }
                else{
                    System.out.println("Edge :" + entry.getKey() + " <--->" + e + " is Not a Bridge, can be removed");
                }
                //add back edge
                graph.addUndirectedEdge(entry.getKey(), e);

            });


        });*/


    }

    private static void processBridgeFind(int noOfVertices, Graph graph,  Integer source, Integer e) {
        //  System.out.println("Dropping Edge :" + source + " <--->" + e);
        graph.dropEdge(source, e);
        boolean stillConnectedd = isGraphConnected(graph, findSource(noOfVertices, source));
        if (!stillConnectedd) {
            System.out.println("Edge :" + source + " <--->" + e + " is a Bridge");
        }
        else{
           // System.out.println("Edge :" + source + " <--->" + e + " is Not a Bridge, can be removed");
        }

        //add back edge
        graph.addUndirectedEdge(source, e);
    }

    private static int findSource(int noOfVertices, Integer key) {
        for (int i = 0; i < noOfVertices; i++) {
            if (i != key) return i;
        }
        return -1;
    }

    private static boolean isGraphConnected(Graph graph, int source) {
        boolean visited[] = new boolean[graph.getMap().entrySet().size()];
        doDfs(graph, visited, source);
        return isGraphConnecte(visited);
    }

    private static boolean isGraphConnecte(boolean[] visited) {
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }

    private static void doDfs(Graph graph, boolean[] visited, int source) {

        if (!visited[source]) {
          //  System.out.println(source);
            visited[source] = true;
        }

        graph.getMap().get(source).forEach(i -> {
            if (!visited[i]) {
                doDfs(graph, visited, i);
            }

        });

    }
}
