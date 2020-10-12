package graph.cycle;

import java.util.Objects;

public class Vertex {

    private char charC;

    public Vertex(char charC) {
        this.charC = charC;
    }

    public char getCharC() {
        return charC;
    }

    public void setCharC(char charC) {
        this.charC = charC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return charC == vertex.charC;
    }

    @Override
    public int hashCode() {
        return Objects.hash(charC);
    }
}
