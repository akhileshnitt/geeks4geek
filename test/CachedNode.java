package test;

public class CachedNode {

    int value;
    int key;

    public CachedNode(int value, int key) {
        this.value = value;
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
