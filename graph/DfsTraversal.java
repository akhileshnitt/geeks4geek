package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DfsTraversal {

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addDirectedEdge(0,1);
        graph.addDirectedEdge(0,2);
        graph.addDirectedEdge(1,2);
        graph.addDirectedEdge(2,0);
        graph.addDirectedEdge(2,3);
        graph.addDirectedEdge(3,3);


        doDfs(graph,2);
    }

    private static void doDfs(Graph graph, int root) {

        Map<Integer, List<Integer>> map = graph.getMap();

        boolean visited [] = new boolean[map.keySet().size()];

        List<Integer> dfsList = new ArrayList<>();

        dfs(map,visited,root,dfsList);

        dfsList.forEach(e-> System.out.print(e+","));

    }

    private static void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int root,List<Integer> dfsList ) {

        if(map.get(root) == null) {
            return;
        }

        List<Integer> adjList = map.get(root);
        visited[root] = true;
        dfsList.add(root);
        for(int i=0;i<adjList.size();i++){
             if(!visited[adjList.get(i)] ){
                 dfs(map,visited,adjList.get(i),dfsList);
             }
        }


    }

}
