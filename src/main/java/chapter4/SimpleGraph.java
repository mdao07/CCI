package chapter4;

import java.util.HashMap;
import java.util.Map;

public class SimpleGraph {
    int nextNumber;
    Map<Integer, SimpleVertex> vertices;

    SimpleGraph() {
        nextNumber = 0;
        vertices = new HashMap<>();
    }

    public SimpleVertex addVertex() {
        SimpleVertex vertex = new SimpleVertex(nextNumber++);
        vertices.put(vertex.number, vertex);

        return vertex;
    }

    public SimpleVertex getVertex(int number) {
        return vertices.get(number);
    }

    public void addSingleAdjacency(SimpleVertex src, SimpleVertex dest) {
        src.adjacencies.add(dest);
    }

    public void addDoubleAdjacency(SimpleVertex v1, SimpleVertex v2) {
        v1.adjacencies.add(v2);
        v2.adjacencies.add(v1);
    }
}
