package tree;

public class Node{
    int data;
    Node left;
    Node right;
    int label;



    public Node(int data) {
        this.data = data;
    }

    public Node(int data, int label) {
        this.data = data;
        this.label = label;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public Node setLeft(Node left) {
        this.left = left;
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node setRight(Node right) {
        this.right = right;
        return right;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }
}
