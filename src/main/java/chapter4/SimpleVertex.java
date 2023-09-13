package chapter4;

import java.util.HashSet;
import java.util.Set;

public class SimpleVertex {
    int number;
    Set<SimpleVertex> adjacencies;

    public SimpleVertex(int number) {
        this.number = number;
        adjacencies = new HashSet<>();
    }

    public int getNumber() {
        return number;
    }

    public Set<SimpleVertex> getAdjacencies() {
        return adjacencies;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof SimpleVertex)) {
            return false;
        }

        return number == ((SimpleVertex) o).number;
    }
}
