package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConnectedComponent {


    public static void main(String[] args) {

        GraphC g = new GraphC(5);


        VertexC v0 = new VertexC(0);
        VertexC v1 = new VertexC(1);
        VertexC v2 = new VertexC(2);




        VertexC v3 = new VertexC(3);
        VertexC v4 = new VertexC(4);

        g.addUndirectedEdge(v0,v1);
        g.addUndirectedEdge(v1,v2);

        g.addUndirectedEdge(v3,v4);

        findConnectedComponent(g,v0);


    }

    private static void findConnectedComponent(GraphC g, VertexC v0) {

        boolean [] visited = new boolean[g.graphSize()];
        List<VertexC> vertices = g.map.keySet().stream().collect(Collectors.toList());

        VertexC sourceVertex = v0;

        for(int i=0;i<visited.length;i++) {
            if(!visited[vertices.get(i).data]) {
                List<Integer> connectedComponent = new ArrayList<>();
                doDFS(g, vertices.get(i), visited, connectedComponent);
                System.out.println(connectedComponent);
            }
        }
    }

    private static void doDFS(GraphC g, VertexC v0, boolean[] visited, List<Integer> connectedComponent) {

        visited[v0.data] = true;
        connectedComponent.add(v0.data);
        List<VertexC> list = g.getMap().get(v0);
        for(VertexC vertex : list){
            if(!visited[vertex.data])
            doDFS(g,vertex,visited, connectedComponent);
        }
    }
}


class GraphC{
    
    private int noOfVertics =0;

    Map<VertexC,List<VertexC>> map;



    public GraphC(int noOfVertics) {
        this.noOfVertics = noOfVertics;
        map = new HashMap<VertexC,List<VertexC>>();
    }

    public void addUndirectedEdge(VertexC v1,VertexC v2){
        addDirectedEdge(v1,v2);
        addDirectedEdge(v2,v1);
    }

    public  void addDirectedEdge(VertexC v1,VertexC v2){
        if(map.get(v1) == null){
            List<VertexC> list = new ArrayList<>();
            list.add(v2);
            map.put(v1 , list);
        }
        else{
            List<VertexC> list = map.get(v1);
            list.add(v2);
            map.put(v1,list);
        }
    }

    public Map<VertexC, List<VertexC>> getMap() {
        return map;
    }

    public int graphSize (){
        return map.size();
    }
}
class VertexC{

    int data ;


    public VertexC(int data) {
        this.data = data;

    }
}
