package chapter4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the second project is dependent on the first project). All of a project's dependencies
 * must be built before the project is. Find a build order that will allow the projects to be built. If there
 * is no valid build order, return an error.
 *
 * EXAMPLE
 *
 * Input:
 * Projects: a, b, c, d, e, f
 *
 * Dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 *
 * Output: f, e, a, b, d, c
 */
public class Ex7 {
/*
    static class Vertex {
        String name;
        int entries;
        Set<Vertex> adjs;

        Vertex(String name) {
            this.name = name;
            entries = 0;
            adjs = new HashSet<>();
        }

        public void addSingleAdj(Vertex other) {
            if (adjs.add(other)) {
                other.incrementEntries();
            }
        }

        public void addDoubleAdj(Vertex other) {
            addSingleAdj(other);
            other.addSingleAdj(this);
        }

        public void incrementEntries() {
            ++entries;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Vertex)) {
                return false;
            }

            return name.equals( ((Vertex)o).name );
        }
    }

    static class Graph {
        Map<String, Vertex> vertices;

        Graph(Set<String> verticesNames) {
            vertices = new HashMap<>();
            buildVertices(verticesNames);
        }

        private void buildVertices(Set<String> names) {
            names.forEach(n -> vertices.put(n, new Vertex(n)));
        }

        public void buildDependencies(List<List<String>> deps) {
            deps.forEach(list -> {
                Vertex src = vertices.get(list.get(0));
                Vertex tgt = vertices.get(list.get(1));

                src.addSingleAdj(tgt);
            });
        }

        public List<String> getTopology() {
            LinkedHashSet<Vertex> visited = new LinkedHashSet<>();
            LinkedList<Vertex> toVisit = vertices.values()
                                            .stream()
                                            .filter(v -> v.entries == 0)
                                            .sorted(Comparator.comparing(v -> v.name))
                                            .collect(Collectors.toCollection(LinkedList::new));

            while(!toVisit.isEmpty()) {
                Vertex curVertex = toVisit.removeFirst();
                visited.add(curVertex);
                curVertex.adjs.forEach(v -> {
                    --v.entries;
                    if (v.entries == 0) {
                        toVisit.add(v);
                    }
                });

            }

            if (visited.size() != vertices.size()) {
                throw new RuntimeException("Topology build is not possible");
            }

            return visited.stream().map(v -> v.name).toList();
        }
    }
*/

    static class Vertex {
        String name;
        int entries;
        Set<Vertex> adjs;

        Vertex(String name) {
            this.name = name;
            entries = 0;
            adjs = new HashSet<>();
        }

        void addAdj(Vertex other) {
            if (adjs.add(other)) {
                ++other.entries;
            }
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Vertex)) {
                return false;
            }

            return name.equals(((Vertex)o).name);
        }
    }

    static class Graph {
        Map<String, Vertex> vertices;

        Graph(Set<String> verticesNames) {
            vertices = new HashMap<>();
            buildVertices(verticesNames);
        }

        private void buildVertices(Set<String> verticesNames) {
            verticesNames.forEach(name -> vertices.put(name, new Vertex(name)));
        }

        public void buildDependencies(List<List<String>> deps) {
            deps.forEach(list -> {
                Vertex src = vertices.get(list.get(0));
                Vertex tgt = vertices.get(list.get(1));

                if (src == null || tgt == null) {
                    throw new RuntimeException("Vertex not found");
                }

                src.addAdj(tgt);
            });
        }

        public List<String> getTopology() {
            LinkedHashSet<Vertex> visited = new LinkedHashSet<>();
            LinkedList<Vertex> toVisit = vertices.values().stream()
                    .filter(v -> v.entries == 0)
                    .collect(Collectors.toCollection(LinkedList::new));

            while(!toVisit.isEmpty()) {
                Vertex vertex = toVisit.removeFirst();
                visited.add(vertex);

                vertex.adjs.forEach(v -> {
                    --v.entries;

                    if (v.entries == 0) {
                        toVisit.add(v);
                    }
                });
            }

            if (visited.size() != vertices.size()) {
                throw new RuntimeException("Topology build is not possible");
            }

            return visited.stream().map(v -> v.name).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        Set<String> vertices = Set.of("a", "b", "c", "d", "e", "f", "1", "2", "3", "4");
        List<List<String>> deps = List.of(
                List.of("a", "d"),
                List.of("f", "b"),
                List.of("b", "d"),
                List.of("f", "a"),
                List.of("d", "c"),
                List.of("1", "2"),
                List.of("2", "3"),
                List.of("3", "4"),
                List.of("4", "b")
        );

        Graph graph = new Graph(vertices);
        graph.buildDependencies(deps);
        var result = graph.getTopology();

        System.out.println(result);
    }
}
