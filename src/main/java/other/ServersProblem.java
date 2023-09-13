package other;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ServersProblem {

    static class Agent implements Comparable<Agent> {
        final int pos;
        int time;

        Agent(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Agent o) {
            int comp = time - o.time;
            return (comp == 0) ? pos - o.pos : comp;
        }

        @Override
        public String toString() {
            return String.format("[Pos: %d, Time: %d]", pos, time);
        }
    }

    private static <T extends Comparable<T>> void sort(T[] array) {
        T aux;

        for (int i = 1; i < array.length; ++i) {
            if (array[i - 1].compareTo(array[i]) > 0) {
              aux = array[i - 1];
              array[i - 1] = array[i];
              array[i] = aux;
            } else {
                break;
            }
        }
    }
    public static int howMuchTime (int N, int times[]) {
        if (times.length < N) {
            return 0;
        }

        var agents = IntStream.range(0, N)
                .mapToObj(i -> new Agent(i + 1, times[i]))
                .sorted()
                .toArray(k -> new Agent[N]);

        for (int i = N; i < times.length; ++i) {
            agents[0].time += times[i];
            sort(agents);
        }

        return agents[0].time;
    }

    public static int howMuchTime2 (int N, int times[]) {
        if (times.length < N) {
            return 0;
        }

        var agents = IntStream.range(0, N)
                .mapToObj(i -> new Agent(i + 1, times[i]))
                .collect(Collectors.toCollection(TreeSet::new));

        for (int i = N; i < times.length; ++i) {
            Agent curAgent = agents.pollFirst();
            curAgent.time += times[i];
            agents.add(curAgent);
        }

        return agents.first().time;
    }

    public static void main(String [] args) {
        int n = 3;
        int times[] = {1, 2, 3, 4, 5, 6};
        int time = howMuchTime2(n, times);

        System.out.println("Time: " + time);
    }
}
