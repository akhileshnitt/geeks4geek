package greedy;

public class Vertex {
    private int label;
    private int distance;

    public Vertex(int label) {
        this.label = label;
        this.distance = Integer.MAX_VALUE;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
