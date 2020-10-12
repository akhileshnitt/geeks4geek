package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {

    public static void main(String[] args) {
        //String[] words = {"baa", "abcd", "abca", "cab", "cad"};

        //String[] words = { "caa", "aaa", "aab" };
        String [] words = {"aba", "bba", "aaa"};

        Set<Character> set = new HashSet<>();

        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
        }

        System.out.println(set);

        Graph graph = new Graph(set.size());

        set.forEach(e -> {
            graph.addNode(e);
        });


        Set<Holder> holderSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() != 0 && words[j].length() != 0) {

                    Holder hodlder = firstMismatching(words[i], words[j]);
  //                  System.out.println(hodlder.source + " ," + hodlder.destination);
                    holderSet.add(hodlder);
                }
            }
        }


        holderSet.forEach(e -> {
            Node sourceNode = graph.getNode(e.source);
            Node destNode = graph.getNode(e.destination);
            if (sourceNode != null && destNode != null) {
                sourceNode.addDirectedEdge(destNode);
            }
        });


        System.out.println(graph);



        Stack<Node> topo = new Stack<>();
        for(Node n: graph.getNodesList()){
            if(!n.isVisited)
                doDFS(n,topo);
        }

        System.out.println("alphabet order ");


        while(!topo.isEmpty()){
            System.out.print(topo.pop().data+",");
        }
    }

    private static void doDFS(Node source, Stack<Node> topo) {
        source.isVisited = true;

        List<Node> childrens = source.getNodes();
        for(Node node : childrens){
            if(!node.isVisited)
            doDFS(node, topo);
        }
        topo.push(source);

    }

    private static Holder firstMismatching(String word1, String word2) {
        int i = 0, j = 0;
        Holder holder = null;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) != word2.charAt(j)) {
                return new Holder(word1.charAt(i), word2.charAt(j));
            } else {
                i++;
                j++;
            }
        }
        return holder;
    }


    static class Holder {
        char source;
        char destination;

        public Holder(char source, char destination) {
            this.source = source;
            this.destination = destination;
        }

        public char getSource() {
            return source;
        }

        public char getDestination() {
            return destination;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Holder holder = (Holder) o;
            return source == holder.source &&
                    destination == holder.destination;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination);
        }
    }

    static class Graph {
        List<Node> nodesList;
        int noOfVertices;

        public Graph(int noOfVertices) {
            this.noOfVertices = noOfVertices;
            nodesList = new ArrayList<>();
        }

        public Node addNode(char data) {
            Node temp = new Node(data);
            nodesList.add(temp);
            return temp;
        }

        public List<Node> getNodesList() {
            return nodesList;
        }

        public int getNoOfVertices() {
            return noOfVertices;
        }

        public Node getNode(char source) {
            for (Node node : nodesList) {
                if (node.data == source) {
                    return node;
                }
            }
            return null;
        }
    }

    static class Node {
        char data;
        List<Node> nodes;
        boolean isVisited;

        public Node(char data) {
            this.data = data;
            this.nodes = new ArrayList<>();
            this.isVisited = false;
        }

        public void addDirectedEdge(Node destination) {
            this.nodes.add(destination);
        }

        public char getData() {
            return data;
        }

        public List<Node> getNodes() {
            return nodes;
        }

        public boolean isVisited() {
            return isVisited;
        }
    }
}
