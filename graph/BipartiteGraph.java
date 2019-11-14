package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {

    public static void main(String[] args) {

        System.out.println("isBipartite :"+doBfs(getGraph1()));


        System.out.println("isBipartite :"+doBfs(getGraph2()));
    }




    private static Vertex getGraph2() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);


        v1.addVertices(v2);
        v1.addVertices(v3);

        Vertex v4 = new Vertex(4);
        v2.addVertices(v4);

        Vertex v5 = new Vertex(5);
        v3.addVertices(v5);


        Vertex v6 = new Vertex(6);
        v5.addVertices(v6);
        v6.addVertices(v4);
        return v1;
    }



    private static Vertex getGraph1() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.addVertices(v2);
        v1.addVertices(v3);

        Vertex v4 = new Vertex(4);
        v2.addVertices(v4);

        Vertex v5 = new Vertex(5);
        v3.addVertices(v5);

        v4.addVertices(v5);
        return v1;
    }

    private static boolean doBfs(Vertex v1) {
        Queue<Vertex> queue = new LinkedList<>();
        v1.color = Color.RED.color;
        queue.add(v1);

        while(!queue.isEmpty()){

            Vertex temp = queue.poll();

            List<Vertex> adjList = temp.adjList;
            for(int i=0;i<adjList.size();i++){
                Vertex neighbour = adjList.get(i);

                if(neighbour.color != Color.NONE.color && neighbour.color == temp.color){
                    return false;
                }

                if(temp.color == 1){
                    neighbour.color = Color.BLACK.color;
                }
                if(temp.color == 0){
                    neighbour.color = Color.RED.color;
                }
                queue.add(neighbour);
            }
        }
        return true;
    }
}



 class Vertex {

    List<Vertex> adjList;
    int color;
    int data;

    public Vertex(int data) {
        this.data = data;
        adjList = new ArrayList<>();
        color = Color.NONE.color;
    }

    public void addVertices(Vertex v){
        adjList.add(v);
    }
}

enum Color{
    NONE(-1),
    RED(1),
    BLACK(0);

    int color;
    Color(int color) {
      this.color = color;

    }
}