package greedy;

public class Edge {

    private int weight;
    private Vertex source;
    private Vertex destination;


    public Edge( Vertex source, Vertex destination,int weight) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
